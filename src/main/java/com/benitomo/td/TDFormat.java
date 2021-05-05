package com.benitomo.td;

import com.google.common.collect.Lists;

import java.io.*;

import java.math.BigDecimal;

import java.nio.charset.Charset;
import java.nio.file.Files;

import java.nio.file.Path;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import java.text.SimpleDateFormat;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*import jxl.Sheet;
import jxl.Workbook;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;*/

public class TDFormat {
    
    private Connection cnt = null;
    volatile List<Map> threads = new ArrayList<>();
    
    public TDFormat() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            cnt = DriverManager.getConnection(
                    "jdbc:mysql://localhost/?continueBatchOnError=true",
                    "root",
                    "root*123"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void procesar(String[] args) {

        try {

            if (args.length < 2) {
                System.out.println("Error, envie al menos 2 parametros");
                return;
            }

            String path = args[0];
            String db = args[1];
            boolean cargarDatos = true;

            if (args.length > 2) {
                cargarDatos = args[2].equals("true");
            }

            if (!path.endsWith("/")) {
                path += "/";
            }

            if (!new File(path).exists()) {
                System.out.println("Error, la ruta: " + path + " no existe.");
                return;
            }

            if (!new File(path + "R_TAF24").exists()) {
                System.out.println("Error, la carpeta R_TAF24 no existe en la ruta indicada.");
                return;
            }

            if (!new File(path + "D_TAF24").exists()) {
                System.out.println("Error, la carpeta D_TAF24 no existe en la ruta indicada.");
                return;
            }

            Class.forName("com.mysql.jdbc.Driver");
            cnt = DriverManager.getConnection("jdbc:mysql://localhost/?continueBatchOnError=true", "root", "root*123");

            Statement gExe = cnt.createStatement();

            try {

                gExe.execute("create database if not exists " + db);
                gExe.execute("use " + db);

                /*llenar(db);

                if (true) {
                    return;
                }*/

                ArrayList<String> tablas = new ArrayList<>(
                        Arrays.asList(
                        "001"
                        , "010"
                        , "012"
                        , "014"
                        , "020"
                        , "030"
                        , "035"
                        , "042"
                        , "050"
                        , "051"
                        , "052"
                        , "100"
                        , "110"
                        , "120"
                        , "125"
                        , "140"
                        , "143"
                        , "144"
                        , "145"
                        , "146"
                        , "147"
                        , "155"
                        , "200"
                        , "203"
                        , "204"
                        , "205"
                        , "207"
                        , "209"
                        , "210"
                        , "211"
                        , "231"
                        , "232"
                        , "301"
                        , "302"
                        , "320"
                        , "323"
                        , "327"
                        , "400"
                        , "432"
                ));

                if (!cargarDatos) {
                    tablas = new ArrayList<>();
                }

                //tablas.add("432");

                Esquemas es = new Esquemas();
                int grupos = tablas.size() / Runtime.getRuntime().availableProcessors();
                List<List<String>> listas = Lists.partition(tablas, grupos);

                for (final List<String> lista : listas) {

                    final Map status = new HashMap();
                    threads.add(status);

                    Thread t = new Thread(() -> {

                        try {

                            Connection cnt = DriverManager.getConnection(
                                    "jdbc:mysql://localhost/" + db + "?continueBatchOnError=true",
                                    "root",
                                    "root*123"
                            );
                            Statement exe = cnt.createStatement();

                            for (String tabla : lista) {
                                String table = "TOF_" + tabla;
                                String prefix = tabla;
                                ArrayList<Esquemas.CDT> esquema = es.esquemas.get(tabla);
                                String create = "";

                                boolean dlnr = false;
                                boolean deleted = false;
                                boolean search = false;
                                String index = null;

                                for (int i = 0; i < esquema.size(); i++) {

                                    Esquemas.CDT cd = esquema.get(i);

                                    if (cd.nombre.equalsIgnoreCase("dlnr")) {
                                        dlnr = true;
                                    } else if (cd.nombre.equalsIgnoreCase("deleted")) {
                                        deleted = true;
                                    } else if (cd.nombre.equalsIgnoreCase("search_number")) {
                                        search = true;
                                    } else if (cd.tipo.equalsIgnoreCase("index")) {
                                        index = cd.nombre;

                                        continue;
                                    }

                                    if (!create.isEmpty()) {
                                        create += ", ";
                                    }

                                    if (cd.length == 0) {

                                        String primaryKey = "primary key(";

                                        if (dlnr) {

                                            if (!cd.nombre.contains("DLNr")) {
                                                primaryKey += "DLNr, ";
                                            }
                                        }

                                        primaryKey += cd.nombre;

                                        if (deleted) {
                                            primaryKey += ", deleted";
                                        }
                                        primaryKey += ")";

                                        create += primaryKey;

                                    } else {

                                        create += cd.nombre + " ";

                                        if (cd.tipo.equals("C")) {
                                            create += "varchar(" + cd.length + ")";
                                        } else if (search) {
                                            create += "varchar(50)";
                                        } else {
                                            create += "int";
                                        }

                                    }

                                }

                                exe.execute("drop table if exists TOF_" + tabla);
                                exe.execute("create table TOF_" + tabla + " (" + create + ")");

                                if (index != null) {
                                    exe.execute(
                                            "create index index_" + tabla + " on TOF_" + tabla + "(" + index + ")"
                                    );
                                }

                                Process7z z7 = new Process7z(args[0], status);
                                File data = z7.processTable(prefix);

                                parse(cnt, data, es.esquemas.get(tabla), table, prefix, status);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            System.exit(0);
                        }

                    });

                    t.start();

                }

                //cleanNumber(db);
                //llenar(db);

            } catch (Exception e) {
                //cnt.rollback();
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void llenar(String dbFuente) {
        try {
            
            Statement exe = cnt.createStatement();
            
            exe.execute("use " + dbFuente);

            InputStream input = getClass().getResourceAsStream("/llenar.sql");
            byte[] bytes = new byte[input.available()];

            input.read(bytes);
            input.close();

            String string = new String(bytes);
            String[] comandos = string.split(";");
            
            for (String cmd : comandos) {

                cmd = cmd.replace("${FUENTE}", dbFuente);

                if (cmd.trim().startsWith("#CONTINUE#")) {

                    cmd = cmd.trim().replace("#CONTINUE#", "");

                    try {

                        System.out.println("-------------COMANDO-------------");
                        System.out.print(cmd);
                        System.out.println(" = " + exe.executeUpdate(cmd));
                        System.out.println();

                    } catch (Exception e) {
                        System.out.println(" = " + e.getMessage());
                        System.out.println();
                    }

                } else {

                    System.out.println("-------------COMANDO-------------");
                    System.out.print(cmd);
                    System.out.println(" = " + exe.executeUpdate(cmd));
                    System.out.println();

                }
            }
            
            exe.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cleanNumber(String dbFuente) {
        try {
            Statement exe = cnt.createStatement();

            exe.execute("use " + dbFuente);

            InputStream input = getClass().getResourceAsStream("/clean_number.sql");
            byte[] bytes = new byte[input.available()];

            input.read(bytes);
            input.close();

            File dest = File.createTempFile("clean_number", ".sql");
            FileOutputStream fo = new FileOutputStream(dest);

            fo.write(bytes);
            fo.flush();
            fo.close();

            Runtime runtime = Runtime.getRuntime();

            System.out.println("Executing: /usr/bin/mysql -uroot -proot*123 " + dbFuente + " < " + dest.getAbsolutePath());

            Process p = runtime.exec(new String[]{"/usr/bin/mysql", "-uroot", "-proot*123", dbFuente, "<", dest.getAbsolutePath()});

            //Process p = runtime.exec(" -uroot -proot*123 " + dbFuente + " < " + dest.getAbsolutePath());

            int status = p.waitFor();

            InputStream is = p.getInputStream();
            byte[] b = new byte[is.available()];

            is.read(b);
            is.close();

            System.out.println("CLEAN_NUMBER: = " + status);
            System.out.println(new String(b));

            exe.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*public void marcas() throws Exception {
        Workbook workbook = Workbook.getWorkbook(new File("/root/Desktop/M1.xls"));
        Sheet sheet = workbook.getSheet(0);
        
        WritableWorkbook ww = Workbook.createWorkbook(new File("/root/Desktop/MARCAS_DATA_RELEASE.xls"));
        WritableSheet ws = ww.createSheet("MARCAS", 0);
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection cnt = DriverManager.getConnection("jdbc:mysql://192.168.100.11/tecdoc2016", "root", "root*123");
        PreparedStatement ps = cnt.prepareStatement("select * from TOF_040 where DLNr = ?");
        
        int row = 0;
        
        for (int i = 2, i2 = 0; i < sheet.getRows(); i++) {
            String dlnr = sheet.getCell(0, i).getContents();
            String name = sheet.getCell(1, i).getContents();
            String desc = sheet.getCell(2, i).getContents();
            String mark = sheet.getCell(3, i).getContents();
            
            if (name.trim().isEmpty()) {
                continue;
            }
            
            ps.setString(1, dlnr);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ws.addCell(new Label(1, row, dlnr));
                ws.addCell(new Label(2, row, mark));
                ws.addCell(new Label(2, row, name));
                ws.addCell(new Label(3, row, desc));
                row++;
            }
            rs.close();
        }
        
        ps.close();
        cnt.close();
        
        ww.write();
        ww.close();
        
    }
    
    public void compararMarcas() throws Exception {
        WritableWorkbook ww = Workbook.createWorkbook(new File("/root/Desktop/MFH.xls"));
        WritableSheet ws = ww.createSheet("MARCAS FALTANTES DATA PACKAGE", 0);
        WritableSheet ws2 = ww.createSheet("MARCAS HABIDAS DATA PACKAGE", 1);
        
        Workbook workbook = Workbook.getWorkbook(new File("/root/Desktop/M1.xls"));
        Sheet sheet = workbook.getSheet(0);
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection cnt = DriverManager.getConnection("jdbc:mysql://192.168.100.11/tecdoc2016", "root", "root*123");
        PreparedStatement ps = cnt.prepareStatement("select * from TOF_040 where DLNr = ?");
        int count = 0;
        int count2 = 0;
        int repetidas = 0;
        int total = 0;
        Map map = new HashMap();
        for (int i = 2, i2 = 0; i < sheet.getRows(); i++) {
            String dlnr = sheet.getCell(0, i).getContents();
            String name = sheet.getCell(1, i).getContents();
            String desc = sheet.getCell(2, i).getContents();
            String mark = sheet.getCell(3, i).getContents();
            
            if (dlnr.isEmpty() || mark.isEmpty()) {
                continue;
            }
            if (map.get(dlnr) != null) {
                System.out.println(name);
                repetidas++;
            }
            total++;
            map.put(dlnr, true);
            
            ps.setInt(1, Integer.parseInt(dlnr.trim()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //ws2.addCell(new Label(0, i2, dlnr.trim()));
                //ws2.addCell(new Label(1, i2, name));
                //ws2.addCell(new Label(2, i2, desc));
                //i2++;
                count++;
            } else {
                //ws.addCell(new Label(0, i2, dlnr.trim()));
                //ws.addCell(new Label(1, i2, name));
                //ws.addCell(new Label(2, i2, desc));
                //i2++;
                System.out.println("Faltante: " + name);
                count2++;
            }
            rs.close();
        }
        
        System.out.println("COUNT: " + map.size());
        System.out.println("REPETIDAS: " + repetidas);
        System.out.println("HABIDAS: " + count);
        System.out.println("NO HABIDAS: " + count2);
        System.out.println("TOTAL: " + total);
        
        ww.write();
        ww.close();
        
    }*/
    
    public void parse(Connection cnt, File file, ArrayList<Esquemas.CDT> cdt, String table, String prefix, Map status) {
        if (prefix == null || table == null) {
            System.out.println("Variables null");
            return;
        }

        //System.out.println("Prefix: " + prefix + ", Tabla: " + table);
        //status.put("status", );

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Statement exe = cnt.createStatement();

            exe.execute("delete from " + table);

            ResultSet rs = exe.executeQuery("select * from " + table);
            ResultSetMetaData meta = rs.getMetaData();
            String columnNames = "";
            String params = "";

            for (int i = 1; i <= meta.getColumnCount(); i++) {
                if (!columnNames.isEmpty()) {
                    columnNames += ", ";
                    params += ", ";
                }
                columnNames += meta.getColumnName(i);
                params += "?";
            }

            PreparedStatement psi = cnt.prepareStatement("insert into " + table + "(" + columnNames + ") values(" + params + ")");
            Campos campos = new Campos(file);

            int rowsFallidos = 0;
            int count = 0;

            cnt.setAutoCommit(false);

            while (campos.next()) {

                try {
                    
                    int pos = 0;

                    for (int i = 0; i < cdt.size(); i++) {
                        
                        Esquemas.CDT r = cdt.get(i);
                        
                        r.tipo = r.tipo.toUpperCase();
                        
                        if (r.length > 0) {
                            
                            if (r.tipo.equals("C")) {
                                psi.setString(i + 1, campos.parseString(pos, r.length));
                            } else if (r.tipo.equals("N")) {
                                psi.setObject(i + 1, campos.parseInt(pos, r.length));
                            }
                            
                            pos += r.length;
                        }
                    }

                    psi.addBatch();

                } catch (Exception e) {
                    e.printStackTrace();
                    rowsFallidos++;
                }

                try {

                    if (count % 100_000 == 0) {

                        try {
                            psi.executeBatch();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        cnt.commit();

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                count++;
            }

            try {
                psi.executeBatch();
            } catch (Exception e) {
                e.printStackTrace();
            }

            cnt.commit();

            campos.close();
            System.out.println("Rows fallidos: " + rowsFallidos);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void processString(String subfolder, String table, String prefix) throws Exception {
        FileInputStream input = new FileInputStream("/root/TECALLIANCE/JAVA/string.txt");
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(isr);
        Pattern pattern = Pattern.compile(" [0-9]");
        String tabla = br.readLine();

        subfolder = br.readLine();

        String linea = null;
        String create = "";

        while ((linea = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(linea);
            if (!matcher.find()) {
                System.out.println("Error f");
                return;
            }
            String nombre = linea.substring(0, matcher.start());
            nombre = nombre.replace("-", "_").replace(" ", "_");
            int length = Integer.parseInt(linea.substring(matcher.start()).trim().split(" ")[1]);
            if (!create.isEmpty()) {
                create += ", ";
            } else {
                create += "  ";
            }
            nombre = nombre.replace("Delete", "deleted");
            create += "\r" + nombre + " varchar(" + length + ")\n";
        }
        create = "create table if not exists TOF_" + tabla + " (\n" + create + "\n)";
        Class.forName("com.mysql.jdbc.Driver");
        Connection cnt = DriverManager.getConnection("jdbc:mysql://192.168.100.11/tecdoc2016", "root", "root*123");
        Statement exe = cnt.createStatement();
        exe.execute(create);
        prefix = tabla + ".";
        table = "TOF_" + tabla;
        //parse();
    }

    public static void main(String[] args) {
        TDFormat tdFormat = new TDFormat();

        if (args.length > 0) {
            if (args[0].equals("llenar")) {
                //tdFormat.cleanNumber(args[1]);
                tdFormat.llenar(args[1]);
            } else {
                tdFormat.procesar(args);
            }
        } else {
            System.out.println("Envie parametros");
        }

    }
    
    public class Campos {
        
        FileInputStream input = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        
        String linea = null;
        
        int num = 0;
        
        public Campos(File file) throws Exception {
            input = new FileInputStream(file);
            isr = new InputStreamReader(input);
            br = new BufferedReader(isr);
        }
        
        public boolean next() {
            
            num++;
            //System.out.print("\rProcesando linea: " + num);
            
            try {
                while ((linea = br.readLine()) != null) {
                    
                    if (linea.trim().isEmpty()) {
                        continue;
                    }
                    
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println();

            return false;
        }
        
        public String parseString(int pos, int length) {
            return linea.substring(pos, pos + length).trim();
        }
        
        public Integer parseInt(int pos, int length) {
            String valor = parseString(pos, length);

            if (valor == null) {
                return null;
            } else if (valor.trim().isEmpty()) {
                return null;
            }

            try {
                return new BigDecimal(valor).intValue();
            } catch (Exception e) {}

            return null;
        }
        
        public Date parseDate(int pos, int length, String format) throws Exception {
            SimpleDateFormat sdf = new SimpleDateFormat(format);

            return sdf.parse(parseString(pos, length));
        }
        
        public void close() {
            try {
                br.close();
                isr.close();
                input.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
}
