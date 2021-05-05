package com.benitomo.td;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Esquemas {
    
    Map<String, ArrayList<CDT>> esquemas = new LinkedHashMap<>();
    
    public Esquemas() {
        esquemas.put("001", new ArrayList<>(Arrays.asList(
              new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("DataRelease", 4, "N")
            , new CDT("Datum", 8, "N")
            , new CDT("KZVoll", 1, "N")
            , new CDT("KHerNr", 6, "N")
            , new CDT("Marke", 20, "C")
            , new CDT("Referenzdaten", 4, "N")
            , new CDT("Vorversion", 4, "N")
            , new CDT("Format", 3, "C")
            , new CDT("deleted", 1, "N")
            , new CDT("DLNr", "primary key")
        )));
        esquemas.put("010", new ArrayList<>(Arrays.asList(
              new CDT("Reserviert", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("LKZ", 3, "C")
            , new CDT("BezNr", 9, "N")
            , new CDT("Verkehr", 1, "C")
            , new CDT("WarNr", 3, "N")
            , new CDT("WKZ", 3, "C")
            , new CDT("WarBezNr", 9, "N")
            , new CDT("Vorwahl", 5, "C")
            , new CDT("IstGruppe", 1, "N")
            , new CDT("ISOCode2", 2, "C")
            , new CDT("ISOCode3", 3, "C")
            , new CDT("ISOCodeNr", 3, "N")
            , new CDT("LKZ", "primary_key")
        )));
        esquemas.put("012", new ArrayList<>(Arrays.asList(
              new CDT("Reserviert", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("LBezNr", 9, "N")
            , new CDT("LKZ", 3, "C")
            , new CDT("SprachNr", 3, "N")
            , new CDT("Bez", 60, "C")
            , new CDT("LBezNr, SprachNr, LKZ", "primary_key")
        )));
        esquemas.put("014", new ArrayList<>(Arrays.asList(
              new CDT("Reserviert", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("DokumentenArt", 2, "N")
            , new CDT("BezNr", 9, "N")
            , new CDT("Extension", 3, "C")
            , new CDT("DokumentenArt", "primary_key")
        )));
        esquemas.put("020", new ArrayList<>(Arrays.asList(
              new CDT("Reserviert", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("SprachNr", 3, "N")
            , new CDT("BezNr", 9, "N")
            , new CDT("ISO_Code", 2, "C")
            , new CDT("Codepage", 4, "N")
            , new CDT("SprachNr", "primary_key")
        )));
        esquemas.put("030", new ArrayList<>(Arrays.asList(
              new CDT("Reserviert", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("BezNr", 9, "N")
            , new CDT("SprachNr", 3, "N")
            , new CDT("Bez", 60, "C")
            , new CDT("deleted", 1, "N")
            , new CDT("BezNr, SprachNr", "primary_key")
        )));
        esquemas.put("035", new ArrayList<>(Arrays.asList(
              new CDT("Reserviert", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("TBSNr", 6, "C")
            , new CDT("SprachNr", 3, "N")
            , new CDT("Fixed", 1, "N")
            , new CDT("LfdNr", 3, "N")
            , new CDT("Text", 60, "C")
            , new CDT("deleted", 1, "N")
            , new CDT("TBSNr, SprachNr, LfdNr", "primary_key")
        )));
        esquemas.put("042", new ArrayList<>(Arrays.asList(
              new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("LKZ", 3, "C")
            , new CDT("BildNr", 9, "N")
            , new CDT("DokumentenArt", 2, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("DLNr, LKZ, BildNr", "primary_key")
        )));
        esquemas.put("050", new ArrayList<>(Arrays.asList(
              new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("KritNr", 4, "N")
            , new CDT("BezNr", 9, "N")
            , new CDT("Typ", 1, "C")
            , new CDT("MaxLen", 2, "N")
            , new CDT("OK_Artikel", 1, "N")
            , new CDT("TabNr", 3, "N")
            /*, new CDT("OK_NKW", 1, "N")
            , new CDT("OK_PKW", 1, "N")
            , new CDT("OK_Motor", 1, "N")
            , new CDT("OK_Fahrerhaus", 1, "N")
            , new CDT("Stucklisten", 1, "N")
            , new CDT("Zubehor_Criterion", 1, "N")
            , new CDT("Mehrfach_verwendung", 1, "N")
            , new CDT("BezNrAbk", 9, "N")
            , new CDT("BezNrEinheit", 9, "N")
            , new CDT("Intervall_Criterion", 1, "N")
            , new CDT("Nachfolge_Criterion", 1, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("OK_Achse", 1, "N")*/
            , new CDT("KritNr, BezNr", "primary_key")
        )));
        esquemas.put("051", new ArrayList<>(Arrays.asList(
              new CDT("Reserviert", 22, "C")
            , new CDT("DLNr", 3, "N")
            , new CDT("TabNr", 3, "N")
            , new CDT("BezNr", 9, "N")
            , new CDT("TabTyp", 1, "C")
            , new CDT("deleted", 1, "N")
            , new CDT("TabNr, BezNr, TabTyp", "primary_key")
        )));
        esquemas.put("052", new ArrayList<>(Arrays.asList(
              new CDT("Reserviert", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("TabNr", 3, "N")
            , new CDT("KKey", 3, "C")
            , new CDT("BezNr", 9, "N")
            , new CDT("SortNr", 3, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("TabNr, KKey", "primary_key")
        )));
        esquemas.put("100", new ArrayList<>(Arrays.asList(
              new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("HerNr", 6, "N")
            , new CDT("HKZ", 10, "C")
            , new CDT("LBezNr", 9, "N")
            , new CDT("PKW", 1, "N")
            , new CDT("NKW", 1, "N")
            , new CDT("VGL", 1, "N")
            , new CDT("Achse", 1, "N")
            , new CDT("Motor", 1, "N")
            , new CDT("Getriebe", 1, "N")
            , new CDT("Transporter", 1, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("HerNr", "primary_key")
        )));
        esquemas.put("110", new ArrayList<>(Arrays.asList(
              new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("KModNr", 5, "N")
            , new CDT("LBezNr", 9, "N")
            , new CDT("HerNr", 6, "N")
            , new CDT("SortNr", 3, "N")
            , new CDT("Bjvon", 6, "N")
            , new CDT("BJBis", 6, "N")
            , new CDT("PKW", 1, "N")
            , new CDT("NKW", 1, "N")
            , new CDT("Achse", 1, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("Transporter", 1, "N")
            , new CDT("KModNr", "primary_key")
        )));
        esquemas.put("120", new ArrayList<>(Arrays.asList(
              new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("KTypNr", 9, "N")
            , new CDT("LbezNr", 9, "N")
            , new CDT("KModNr", 5, "N")
            , new CDT("SortNr", 2, "N")
            , new CDT("Bjvon", 6, "N")
            , new CDT("Bjbis", 6, "N")
            , new CDT("KW", 4, "N")
            , new CDT("PS", 4, "N")
            , new CDT("ccmSteuer", 5, "N")
            , new CDT("ccmTech", 5, "N")
            , new CDT("Lit", 4, "N")
            , new CDT("Zyl", 2, "N")
            , new CDT("Tueren", 1, "N")
            , new CDT("TankInhalt", 4, "N")
            , new CDT("Spannung", 2, "N")
            , new CDT("ABS", 1, "N")
            , new CDT("ASR", 1, "N")
            , new CDT("MotArt", 3, "N")
            , new CDT("Kraftstoffauf", 3, "N")
            , new CDT("AntrArt", 3, "N")
            , new CDT("BremsArt", 3, "N")
            , new CDT("BremsSys", 3, "N")
            , new CDT("Ventile", 2, "N")
            , new CDT("KrStoffArt", 3, "N")
            , new CDT("KatArt", 3, "N")
            , new CDT("GetrArt", 3, "N")
            , new CDT("AufbauArt", 3, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("KTypNr", "primary_key")
        )));
        esquemas.put("125", new ArrayList<>(Arrays.asList(
              new CDT("Reserviert", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("KTypNr", 9, "N")
            , new CDT("LfdNr", 3, "N")
            , new CDT("MotNr", 5, "N")
            , new CDT("Bjvon", 6, "N")
            , new CDT("Bjbis", 6, "N")
            , new CDT("LKZ", 3, "C")
            , new CDT("Exclude", 1, "N")
            , new CDT("KTypNr, LfdNr", "primary_key")
        )));
        esquemas.put("140", new ArrayList<>(Arrays.asList(
              new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("KModNr", 5, "N")
            , new CDT("LbezNr1", 9, "N")
            , new CDT("LbezNr2", 9, "N")
            , new CDT("KmodNr", "primary_key")
        )));
        esquemas.put("143", new ArrayList<>(Arrays.asList(
              new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("KmodNr", 5, "N")
            , new CDT("LKZ", 3, "C")
            , new CDT("SortNr", 4, "N")
            , new CDT("Muster", 10, "C")
            , new CDT("KmodNr, LKZ, Muster", "primary_key")
        )));
        esquemas.put("144", new ArrayList<>(Arrays.asList(
              new CDT("Reserviert", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("KTypNr", 9, "N")
            , new CDT("LbezNr1", 9, "N")
            , new CDT("LbezNr2", 9, "N")
            , new CDT("KTypNr", "primary_key")
        )));
        esquemas.put("145", new ArrayList<>(Arrays.asList(
              new CDT("Reserviert", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("KTypNr", 9, "N")
            , new CDT("LKZ", 3, "C")
            , new CDT("SortNr", 4, "N")
            , new CDT("Muster", 10, "C")
            , new CDT("KTypNr, LKZ, Muster", "primary_key")
        )));
        esquemas.put("146", new ArrayList<>(Arrays.asList(
              new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("AufbauArt", 3, "N")
            , new CDT("KmodNr", 5, "N")
            , new CDT("LbezNr", 9, "N")
            , new CDT("AufbauArt, KmodNr", "primary_key")
        )));
        esquemas.put("147", new ArrayList<>(Arrays.asList(
              new CDT("Reserviert", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("AntrArt", 3, "N")
            , new CDT("KTypNr", 9, "N")
            , new CDT("LbezNr", 9, "N")
            , new CDT("AntrArt, KTypNr", "primary_key")
        )));
        esquemas.put("155", new ArrayList<>(Arrays.asList(
              new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("HerNr", 6, "N")
            , new CDT("MotNr", 5, "N")
            , new CDT("MCode", 60, "C")
            , new CDT("BJvon", 6, "N")
            , new CDT("BJbis", 6, "N")
            , new CDT("kWvon", 4, "N")
            , new CDT("kWbis", 4, "N")
            , new CDT("PSvon", 4, "N")
            , new CDT("PSbis", 4, "N")
            , new CDT("Ventile", 2, "N")
            , new CDT("Zyl", 2, "N")
            , new CDT("VerdichtV", 4, "N")
            , new CDT("VerdichtB", 5, "N")
            , new CDT("DrehmV", 4, "N")
            , new CDT("DrehmB", 5, "N")
            , new CDT("ccmSteuerV", 5, "N")
            , new CDT("ccmSteuerB", 5, "N")
            , new CDT("ccmTechV", 5, "N")
            , new CDT("ccmTechB", 5, "N")
            , new CDT("LitSteuerV", 4, "N")
            , new CDT("LitSteuerB", 4, "N")
            , new CDT("LitTechV", 4, "N")
            , new CDT("LitTechB", 4, "N")
            , new CDT("MotVerw", 3, "N")
            , new CDT("MotBauForm", 3, "N")
            , new CDT("KrStoffArt", 3, "N")
            , new CDT("KrStoffAuf", 3, "N")
            , new CDT("MotBeatm", 3, "N")
            , new CDT("UminKwV", 5, "N")
            , new CDT("UminKwB", 5, "N")
            , new CDT("UminDrehmV", 5, "N")
            , new CDT("UminDrehmB", 5, "N")
            , new CDT("Kurbel", 2, "N")
            , new CDT("Bohrung", 6, "N")
            , new CDT("Hub", 6, "N")
            , new CDT("Motorart", 3, "N")
            , new CDT("Abgasnorm", 3, "N")
            , new CDT("ZylBauForm", 3, "N")
            , new CDT("MotSteuer", 3, "N")
            , new CDT("VentilSteuer", 3, "N")
            , new CDT("KuehlArt", 3, "N")
            , new CDT("VkBez", 30, "C")
            , new CDT("Exclude", 1, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("MotNr", "primary_key")
        )));
        esquemas.put("200", new ArrayList<>(Arrays.asList(
              new CDT("ArtNr", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("BezNr", 9, "N")
            , new CDT("KZSB", 1, "N")
            , new CDT("KZMat", 1, "N")
            , new CDT("KZAT", 1, "N")
            , new CDT("KZZub", 1, "N")
            , new CDT("LosGr1", 5, "N")
            , new CDT("LosGr2", 5, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("ArtNr, DLNr", "index")
        )));
        esquemas.put("203", new ArrayList<>(Arrays.asList(
              new CDT("ArtNr", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("KHerNr", 6, "N")
            , new CDT("LKZ", 3, "C")
            , new CDT("RefNr", 22, "C")
            , new CDT("Exclude", 1, "N")
            , new CDT("Sort", 5, "N")
            , new CDT("Additiv", 1, "N")
            , new CDT("ReferenzInfo", 3, "C")
            , new CDT("deleted", 1, "N")
            , new CDT("ArtNr, DLNr, KHerNr, Sort, LKZ", "primary_key")
        )));
        esquemas.put("204", new ArrayList<>(Arrays.asList(
              new CDT("ArtNr", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("LKZ", 3, "C")
            , new CDT("ErsatzNr", 22, "C")
            , new CDT("Exclude", 1, "N")
            , new CDT("Sort", 5, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("ArtNr, DLNr, ErsatzNr, LKZ", "primary_key")
        )));
        esquemas.put("205", new ArrayList<>(Arrays.asList(
              new CDT("ArtNr", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("PartGenArtNr", 5, "N")
            , new CDT("LfdNr", 3, "N")
            , new CDT("PartNr", 22, "C")
            , new CDT("Menge", 3, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("ArtNr, DLNr, LfdNr", "primary_key")
        )));
        esquemas.put("207", new ArrayList<>(Arrays.asList(
              new CDT("ArtNr", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("LKZ", 3, "C")
            , new CDT("GebrNr", 35, "C")
            , new CDT("Exclude", 1, "N")
            , new CDT("AnzSofort", 1, "N")
            , new CDT("Sort", 5, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("ArtNr, DLNr, GebrNr, LKZ", "primary_key")
        )));
        esquemas.put("208", new ArrayList<>(Arrays.asList(
              new CDT("ArtNr", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("Reserved", 3, "C")
            , new CDT("", 0, "")
            , new CDT("", 0, "")
            , new CDT("", 0, "")
            , new CDT("", 0, "")
            , new CDT("", 0, "")
            , new CDT("", 0, "")
            , new CDT("", 0, "")
        )));
        esquemas.put("209", new ArrayList<>(Arrays.asList(
              new CDT("ArtNr", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("LKZ", 3, "C")
            , new CDT("EANNr", 13, "C")
            , new CDT("Exclude", 1, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("ArtNr, DLNr, EANNr, LKZ", "primary_key")
        )));
        esquemas.put("210", new ArrayList<>(Arrays.asList(
              new CDT("ArtNr", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("Reserviert", 5, "N")
            , new CDT("LKZ", 3, "C")
            , new CDT("SortNr", 3, "N")
            , new CDT("KritNr", 4, "N")
            , new CDT("KritWert", 20, "C")
            , new CDT("AnzSofort", 1, "N")
            , new CDT("Exclude", 1, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("ArtNr, DLNr, SortNr, LKZ, KritNr", "primary_key")
        )));
        esquemas.put("211", new ArrayList<>(Arrays.asList(
              new CDT("ArtNr", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("GenArtNr", 5, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("ArtNr, DLNr, GenArtNr", "primary_key")
            , new CDT("GenArtNr", "index")
        )));
        
        esquemas.put("231", new ArrayList<>(Arrays.asList(
              new CDT("Reserviert", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("BildNr", 9, "N")
            , new CDT("SprachNr", 3, "N")
            , new CDT("Bildname", 30, "C")
            , new CDT("BildType", 3, "N")
            , new CDT("BezNorm", 3, "N")
            , new CDT("Breit", 4, "N")
            , new CDT("Hoch", 4, "N")
            , new CDT("Farben", 3, "N")
            , new CDT("DokumentenArt", 2, "N")
            , new CDT("BezNr", 9, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("URL", 300, "C")
            , new CDT("BildNr, Dokumentenart, SprachNr", "primary_key")
            , new CDT("BildNr, BildType", "index")
        )));
        
        esquemas.put("232", new ArrayList<>(Arrays.asList(
              new CDT("ArtNr", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("SortNr", 2, "N")
            , new CDT("LKZ", 3, "C")
            , new CDT("Exclude", 1, "N")
            , new CDT("BildNr", 9, "N")
            , new CDT("DokumentenArt", 2, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("ArtNr, DLNr, LKZ, Exclude, BildNr, DokumentenArt", "primary_key")
        )));
        
        esquemas.put("301", new ArrayList<>(Arrays.asList(
              new CDT("Reserviert", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("Node_ID", 7, "N")
            , new CDT("TreeTypNr", 3, "N")
            , new CDT("Stufe", 2, "N")
            , new CDT("Node_Parent_ID", 7, "N")
            , new CDT("SortNr", 2, "N")
            , new CDT("BezNr", 9, "N")
            , new CDT("WertOK", 1, "N")
        )));
        esquemas.put("302", new ArrayList<>(Arrays.asList(
              new CDT("Reserviert", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("Node_ID", 7, "N")
            , new CDT("SortNr", 2, "N")
            , new CDT("GenArtNr", 5, "N")
            , new CDT("Node_ID, GenArtNr", "primary_key")
        )));
        esquemas.put("320", new ArrayList<>(Arrays.asList(
              new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("GenArtNr", 5, "N")
            , new CDT("NartNr", 5, "N")
            , new CDT("BgNr", 4, "N")
            , new CDT("VerwNr", 4, "N")
            , new CDT("BezNr", 9, "N")
            , new CDT("OK_PKW", 1, "N")
            , new CDT("OK_NKW", 1, "N")
            , new CDT("OK_Motor", 1, "N")
            , new CDT("OK_Universal", 1, "N")
            , new CDT("OK_FZGUnab", 1, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("OK_Achse", 1, "N")
            , new CDT("GenArtNr", "primary_key")
        )));
        esquemas.put("323", new ArrayList<>(Arrays.asList(
              new CDT("Reserviert", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("NartNr", 5, "N")
            , new CDT("BezNr", 9, "N")
            , new CDT("NartNr", "primary_key")
        )));
        esquemas.put("327", new ArrayList<>(Arrays.asList(
              new CDT("Reserviert", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("GenArtNr", 5, "N")
            , new CDT("LfdNr", 3, "N")
            , new CDT("SprachNr", 3, "N")
            , new CDT("Bez", 60, "C")
            , new CDT("GenArtNr, LfdNr, SprachNr", "primary_key")
        )));
        esquemas.put("400", new ArrayList<>(Arrays.asList(
              new CDT("ArtNr", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("GenArtNr", 5, "N")
            , new CDT("VknZielArt", 3, "N")
            , new CDT("VknZielNr", 9, "N")
            , new CDT("LfdNr", 9, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("ArtNr, DLNr, VknZielArt, VknZielNr, GenArtNr, LfdNr", "primary_key")
            , new CDT("VknZielArt, VknZielNr, GenArtNr", "index")
        )));
        esquemas.put("432", new ArrayList<>(Arrays.asList(
              new CDT("ArtNr", 22, "C")
            , new CDT("DLNr", 4, "N")
            , new CDT("SA", 3, "N")
            , new CDT("GenArtNr", 5, "N")
            , new CDT("VknZielArt", 3, "N")
            , new CDT("VknZielNr", 9, "N")
            , new CDT("LfdNr", 9, "N")
            , new CDT("LKZ", 3, "C")
            , new CDT("SortNr", 2, "N")
            , new CDT("BildNr", 9, "N")
            , new CDT("DokumentenArt", 2, "N")
            , new CDT("Exclude", 1, "N")
            , new CDT("deleted", 1, "N")
            , new CDT("VknZielArt, VknZielNr, GenArtNr, ArtNr, LfdNr, SortNr","primary_key")
        )));
        esquemas.put("", new ArrayList<>(Arrays.asList(
                new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
        )));
        esquemas.put("", new ArrayList<>(Arrays.asList(
                new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
        )));
        esquemas.put("", new ArrayList<>(Arrays.asList(
                new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
                , new CDT("", 0, "")
        )));
        
    }
    
    public class CDT {
        public String prefix = "";
        public String nombre;
        public int length;
        public String tipo;
        
        public CDT(String nombre, int length, String tipo) {
            this.nombre = nombre;
            this.length = length;
            this.tipo = tipo;
        }
        public CDT(String nombre, String tipo) {
            this.nombre = nombre;
            this.tipo = tipo;
        }
    }
}
