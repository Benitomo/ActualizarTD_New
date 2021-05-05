package com.benitomo.td;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.Map;

import net.sf.sevenzipjbinding.IInArchive;
import net.sf.sevenzipjbinding.ISequentialOutStream;
import net.sf.sevenzipjbinding.SevenZip;
import net.sf.sevenzipjbinding.SevenZipException;
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream;
import net.sf.sevenzipjbinding.simple.ISimpleInArchive;
import net.sf.sevenzipjbinding.simple.ISimpleInArchiveItem;

public class Process7z {
    
    private String folderr = null;
    private String folderd = null;
    private Map status;
    
    public Process7z(String home, Map status) {
        super();

        folderr = home + "/R_TAF24/";
        folderd = home + "/D_TAF24/";
        this.status = status;

    }
    
    public File processTable(String prefix) {
        try {
            final File file = new File("/tmp/" + prefix + ".csv");
            final FileOutputStream output = new FileOutputStream(file);
            SevenZip.initSevenZipFromPlatformJAR();
            File carpetar = new File(folderr);
            File carpetad = new File(folderd);
            int num = 0;
            
            for (File archivo : carpetar.listFiles()) {
                if (!archivo.getName().endsWith(".7z")) {
                    continue;
                }
                //System.out.println("Opening: " + archivo.getName());
                try (
                RandomAccessFile raf = new RandomAccessFile(archivo, "r");
                IInArchive ar = SevenZip.openInArchive(
                        null,
                        new RandomAccessFileInStream(raf)
                )) {
                    ISimpleInArchive a = ar.getSimpleInterface();

                    for (ISimpleInArchiveItem item : a.getArchiveItems()) {
                        if (item.getPath().startsWith(prefix + ".") && item.getPath().endsWith(".dat")) {

                            status.put("status", "Procesando archivo: " + item.getPath());

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

                        }
                    }

                    //System.out.println();
                    //a.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            //System.out.println("R: " + num);
            
            output.write("\r\n".getBytes());
            output.flush();
            
            for (File archivo : carpetad.listFiles()) {
                if (!archivo.getName().endsWith(".7z")) {
                    continue;
                }
                //System.out.println("Opening: " + archivo.getName());
                try (
                RandomAccessFile raf = new RandomAccessFile(archivo, "r");
                IInArchive ar = SevenZip.openInArchive(null, new RandomAccessFileInStream(raf));
                ) {
                    ISimpleInArchive a = ar.getSimpleInterface();
                    for (ISimpleInArchiveItem item : a.getArchiveItems()) {
                        if (item.getPath().startsWith(prefix + ".") && !item.getPath().endsWith(".csv")) {
                            //System.out.print("\rProcesando archivo: " + item.getPath());
                            status.put("status", "Procesando archivo: " + item.getPath());
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
                        }
                    }
                    //a.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            //System.out.println("Finalmente: " + num);
            output.close();
            
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        //Process7z process7z = new Process7z(null);
    }
}
