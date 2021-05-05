package com.benitomo.td;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Arrays;

public class ExtraerImagenes {

    public ExtraerImagenes() {

    }

    public void crearBash(String path, String destPath) throws Exception {
        File carpeta = new File(path);

        File[] files = carpeta.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {

                if (name.contains("PIC") && name.contains("7z")) {
                    return true;
                }

                return false;
            }
        });

        escribir(files, destPath, "7ze.sh");
    }

    public void crearBashDoc(String path, String destPath, String sh) throws Exception {
        File carpeta = new File(path);

        File[] files = carpeta.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {

                if (name.contains("DOC") && name.contains("7z")) {
                    return true;
                }

                return false;
            }
        });

        escribir(files, destPath, sh);
    }

    public void escribir(File[] files, String destPath, String sh) {

        try {

            FileOutputStream output = new FileOutputStream(System.getProperty("user.home") + "/" + sh);
            PrintStream print = new PrintStream(output);

            print.println("#!/bin/bash");

            for (File zip : files) {

                String name = zip.getName();

                File destFolder = new File(
                        destPath + "/" + zip.getParentFile().getName() + "/" + name.substring(0, name.indexOf("_"))
                );

                if (!destFolder.exists()) {
                    destFolder.mkdirs();
                }

                print.println("7za e -aos \"" + zip.getAbsolutePath() + "\" -o" + destFolder.getAbsolutePath() + "/");

            }

            output.flush();
            output.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void indizarCarpeta(String carpeta) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection cnt = DriverManager.getConnection("jdbc:mysql://localhost/tecdoc2018_01", "root", "root*123");
            Statement exe = cnt.createStatement();

            //exe.execute("delete from TOF_IMAGE_INDEX");

            cnt.setAutoCommit(false);

            PreparedStatement ps = cnt.prepareStatement(
                    "insert into TOF_IMAGE_INDEX(IIN_FOLDER, IIN_7Z, IIN_NAME) values(?, ?, ?)"
            );

            File folder = new File(carpeta);
            File[] files = folder.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {

                    if (pathname.isDirectory()) {
                        return true;
                    }

                    return false;
                }
            });

            int count = 0;

            for (File file : files) {

                if (file.isDirectory()) {
                    String[] subfiles = file.list();

                    for (String subfile : subfiles) {

                        ps.setString(1, folder.getName());
                        ps.setString(2, file.getName());
                        ps.setString(3, subfile);
                        ps.addBatch();

                        if (count % 10000 == 0) {
                            try {
                                ps.executeBatch();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            cnt.commit();
                        }

                        count++;
                    }
                }
            }

            try {
                ps.executeBatch();
            } catch (Exception e) {
                e.printStackTrace();
            }

            cnt.commit();

            exe.close();
            ps.close();
            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {

            if (args[0].equals("img")) {
                File picFiles = new File(args[1] + "/PIC_FILES");
                File picDelta = new File(args[1] + "/PICDELTA_FILES");

                if (!picFiles.exists() || picDelta.exists()) {
                    System.out.println("ERROR NO EXISTEN");
                    return;
                }

                new ExtraerImagenes().crearBash(args[1], args[2]);
            } else if (args[0].equals("doc")) {
                File picFiles = new File(args[1] + "/PIC_FILES");
                File picDelta = new File(args[1] + "/PICDELTA_FILES");

                if (!picFiles.exists() || picDelta.exists()) {
                    System.out.println("ERROR NO EXISTEN " + picFiles.getAbsolutePath());
                    return;
                }

                new ExtraerImagenes().crearBashDoc(picFiles.getAbsolutePath(), args[2], "7zd1.sh");
                new ExtraerImagenes().crearBashDoc(picDelta.getAbsolutePath(), args[2], "7zd2.sh");
            } else if (args[0].equals("indizar")) {

                new ExtraerImagenes().indizarCarpeta(args[1] + "/PIC_FILES/");
                new ExtraerImagenes().indizarCarpeta(args[1] + "/PICDELTA_FILES/");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

