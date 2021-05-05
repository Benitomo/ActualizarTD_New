
package com.benitomo.td;

import java.sql.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

import java.util.ArrayList;

import net.sf.sevenzipjbinding.IInArchive;
import net.sf.sevenzipjbinding.ISequentialOutStream;
import net.sf.sevenzipjbinding.SevenZip;
import net.sf.sevenzipjbinding.SevenZipException;
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream;
import net.sf.sevenzipjbinding.simple.ISimpleInArchive;
import net.sf.sevenzipjbinding.simple.ISimpleInArchiveItem;


public class ImagenesTD {

    Connection cnt;
    String path = null;

    public ImagenesTD(Connection cnt, String path) {
        super();
        try {
            this.cnt = cnt;
            SevenZip.initSevenZipFromPlatformJAR();

            this.path = path;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void indizarArchivos() {
        try {

            File[] carpetas = new File[] {
                    new File(path + "/PICDELTA_FILES/"),
                    new File(path + "/PIC_FILES/")
            };

            Statement exe = cnt.createStatement();

            exe.execute("delete from TOF_IMAGE_INDEX");

            PreparedStatement ps = cnt.prepareStatement(
                    "insert into TOF_IMAGE_INDEX(IIN_FOLDER, IIN_7Z, IIN_NAME)"
                            + " values(?, ?, ?)"
            );

            for (File carpeta : carpetas) {

                for (File archivo : carpeta.listFiles()) {
                    if (!archivo.getName().contains(".7z")) {
                        continue;
                    }

                    System.out.println("Abriendo: " + archivo.getName());

                    try (
                            RandomAccessFile raf = new RandomAccessFile(archivo, "r");
                            IInArchive ar = SevenZip.openInArchive(null, new RandomAccessFileInStream(raf));
                    ) {
                        ISimpleInArchive a = ar.getSimpleInterface();

                        for (ISimpleInArchiveItem item : a.getArchiveItems()) {

                            ps.setString(1, carpeta.getName());
                            ps.setString(2, archivo.getName());
                            ps.setString(3, new File(item.getPath()).getName());
                            ps.execute();

                        }

                        //a.close();

                        System.out.println();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            exe.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> procesarArchivos(String bildNrs) {
        try {

            Statement exe = cnt.createStatement();
            ResultSet rs = exe.executeQuery(
                    "select distinct c.*"
                            + " from TOF_231 a, TOF_014 b, TOF_IMAGE_INDEX c"
                            + " where BildNr in(" + bildNrs + ")"
                            + " and b.DokumentenArt = a.DokumentenArt"
                            + " and c.IIN_NAME = concat(a.Bildname, '.', b.Extension)"
            );

            ArrayList<String> salidas = new ArrayList<>();
            ArrayList<Archivo> archivos = new ArrayList<>();

            while (rs.next()) {

                Archivo archivo = new Archivo(rs.getString(1), rs.getString(2), rs.getString(3));
                File salida = new File("/tmp/" + archivo.getCarpeta() + "/" + archivo.getArchivo());

                if (salida.exists()) {
                    salidas.add(salida.getAbsolutePath());

                    continue;
                }

                archivos.add(archivo);

            }

            rs.close();

            exe.close();

            int num = 0;

            System.out.println(archivos);

            for (Archivo archivo : archivos) {

                File zip = new File(path + "/" + archivo.getCarpeta() + "/" + archivo.getZip());

                if (!zip.exists()) {
                    System.out.println("Archivo 7z no existe: " + zip.getAbsolutePath());
                }

                System.out.println("Abriendo: " + zip.getName());

                try (
                        RandomAccessFile raf = new RandomAccessFile(zip, "r");
                        IInArchive ar = SevenZip.openInArchive(null, new RandomAccessFileInStream(raf));
                ) {
                    ISimpleInArchive a = ar.getSimpleInterface();
                    for (ISimpleInArchiveItem item : a.getArchiveItems()) {

                        if (archivo.getArchivo().equalsIgnoreCase(item.getPath())) {

                            String carpetaSalida = "/tmp/" + archivo.getCarpeta() + "/";

                            new File(carpetaSalida).mkdir();

                            final File outputFile = new File(carpetaSalida + archivo.getArchivo());

                            final FileOutputStream output = new FileOutputStream(outputFile);

                            System.out.print("\rProcesando archivo: " + item.getPath());
                            num++;

                            item.extractSlow(new ISequentialOutStream() {
                                @Override
                                public int write(byte[] b) throws SevenZipException {
                                    try {
                                        output.write(b);
                                        output.flush();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    return b.length;
                                }
                            });

                            salidas.add(outputFile.getAbsolutePath());

                            System.out.println("Extraje: " + outputFile.getAbsolutePath());
                        }
                    }

                    //a.close();

                    System.out.println();
                    //a.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            System.out.println("Finalmente: " + num);

            return salidas;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public class Archivo {
        public String carpeta;
        public String zip;
        public String archivo;

        public Archivo(String carpeta, String zip, String archivo) {
            this.carpeta = carpeta;
            this.zip = zip;
            this.archivo = archivo;
        }

        public String getCarpeta() {
            return carpeta;
        }

        public String getZip() {
            return zip;
        }

        public String getArchivo() {
            return archivo;
        }
    }

    public static void main(String[] args) {
        try {

            String db = args[0];
            String path = args[1];

            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt = DriverManager.getConnection("jdbc:mysql://localhost/" + db, "root", "root*123");

            ImagenesTD imagenesTD = new ImagenesTD(cnt, path);
            imagenesTD.indizarArchivos();

            /*if (args[0].equals("indizar")) {

                System.out.println("Indizando archivos");

                imagenesTD.indizarArchivos();
            } else {
                imagenesTD.procesarArchivos(args[0]);
            }*/

            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

