package com.npcmaker;

import java.util.ArrayList;

public class Karaktar {

    private String arketyp;
    private String bakgrund;
    private String miljo;
    private String folkslag;
    private String provTotem = "";
    private String fornamn;
    private String efternamn;
    private String religion;
    private String varv;
    private String primarKaraktarsdrag;
    private String sekundarKaraktarsdrag;
    private String kon;
    private int alder;
    private int langd;
    private int vikt;
    private String vapenArm;



    private int valmaende = 10;





    private int enhetExpertis = 0;
    private int enhetKannetecken = 0;
    private int lattlarda = 0;
    private int avtrubbV = 0;
    private int avtrubbU = 0;
    private int avtrubbO = 0;
    private int enhetRor = 0;
    private int enhetStrid = 0;
    private int enhetVild = 0;
    private int enhetKunskap = 0;
    private int enhetMyst = 0;
    private int enhetSociala = 0;
    private int enhetOvriga = 0;
    private int enhetSprak = 0;
    private int enhetHantverk = 0;
    private int mysterier = 0;
    private int startKapS = 0;
    private int fardSlag = 0;
    private int kunskapSlag = 0;
    private int stridSlag = 0;
    private int intrigSlag = 0;

    private int valfriHandelse = 0;
    private int belastningMod = 0;



    private ArrayList<String> speciellaEgenskaperArrayList = new ArrayList<>();
    private ArrayList<String> lattLardaFardigheterArrayList = new ArrayList<>();
    private ArrayList<String> svarLardaFardigheterArrayList = new ArrayList<>();
    private ArrayList<String> handelseArrayList = new ArrayList<>();
    private ArrayList<HarleddaAttribut> harleddaAttributsArrayList = new ArrayList<>();
    private ArrayList<GrundAttribut> grundAttributsArrayList = new ArrayList<>();
    private ArrayList<Fardighet> rorFardighetArrayList = new ArrayList<>();
    private ArrayList<Fardighet> stridFardighetArrayList = new ArrayList<>();
    private ArrayList<Fardighet> vildFardighetArrayList = new ArrayList<>();
    private ArrayList<Fardighet> kunFardighetArrayList = new ArrayList<>();
    private ArrayList<Fardighet> mysFardighetArrayList = new ArrayList<>();
    private ArrayList<Fardighet> socFardighetArrayList = new ArrayList<>();
    private ArrayList<Startkapital> startkapitalArrayList = new ArrayList<>();
    private ArrayList<String> sprakArrayList = new ArrayList<>();
    private ArrayList<String> skriftArrayList = new ArrayList<>();
    private ArrayList<String> utrustningArrayList = new ArrayList<>();
    private ArrayList<Kannetecken> kanneTeckenArrayList = new ArrayList<>();
    private ArrayList<Expertis> expertisTeckenArrayList = new ArrayList<>();
    private ArrayList<Hantverk> hantverkTeckenArrayList = new ArrayList<>();

    public Karaktar() {

        grundAttributsArrayList.add(new GrundAttribut("Styrka"));
        grundAttributsArrayList.add(new GrundAttribut("Tålighet"));
        grundAttributsArrayList.add(new GrundAttribut("Rörlighet"));
        grundAttributsArrayList.add(new GrundAttribut("Uppfattning"));
        grundAttributsArrayList.add(new GrundAttribut("Psyke"));
        grundAttributsArrayList.add(new GrundAttribut("Visdom"));
        grundAttributsArrayList.add(new GrundAttribut("Utstrålning"));
        grundAttributsArrayList.add(new GrundAttribut("Vilja"));


        harleddaAttributsArrayList.add(new HarleddaAttribut("FörFlyttning"));
        harleddaAttributsArrayList.add(new HarleddaAttribut("Reaktion"));
        harleddaAttributsArrayList.add(new HarleddaAttribut("Intryck"));
        harleddaAttributsArrayList.add(new HarleddaAttribut("Vaksamhet"));
        harleddaAttributsArrayList.add(new HarleddaAttribut("Självkontroll"));
        harleddaAttributsArrayList.add(new HarleddaAttribut("Kroppsbyggnad"));
        harleddaAttributsArrayList.add(new HarleddaAttribut("Livskraft"));
        harleddaAttributsArrayList.add(new HarleddaAttribut("Grundskada"));
        harleddaAttributsArrayList.add(new HarleddaAttribut("Grundrustning"));




        rorFardighetArrayList.add(new Fardighet("Dansa",2));
        rorFardighetArrayList.add(new Fardighet("Fingerfärdighet",2));
        rorFardighetArrayList.add(new Fardighet("Gömma",2));
        rorFardighetArrayList.add(new Fardighet("Hoppa",2));
        rorFardighetArrayList.add(new Fardighet("Klättra",2));
        rorFardighetArrayList.add(new Fardighet("Låsdyrkning",0));
        rorFardighetArrayList.add(new Fardighet("Simma",0));
        rorFardighetArrayList.add(new Fardighet("Smyga",2));
        rorFardighetArrayList.add(new Fardighet("Undvika",2));

        stridFardighetArrayList.add(new Fardighet("Armborst",2));
        stridFardighetArrayList.add(new Fardighet("Båge",2));
        stridFardighetArrayList.add(new Fardighet("Dolk",2));
        stridFardighetArrayList.add(new Fardighet("Kastvapen",2));
        stridFardighetArrayList.add(new Fardighet("Klubba",2));
        stridFardighetArrayList.add(new Fardighet("Kedjevapen",2));
        stridFardighetArrayList.add(new Fardighet("Sköld",2));
        stridFardighetArrayList.add(new Fardighet("Slagsmål",2));
        stridFardighetArrayList.add(new Fardighet("Spjut",2));
        stridFardighetArrayList.add(new Fardighet("Stav",2));
        stridFardighetArrayList.add(new Fardighet("Svärd",2));
        stridFardighetArrayList.add(new Fardighet("Yxa",2));

        socFardighetArrayList.add(new Fardighet("Argumentera",2));
        socFardighetArrayList.add(new Fardighet("Berättarkonst",2));
        socFardighetArrayList.add(new Fardighet("Charm",2));
        socFardighetArrayList.add(new Fardighet("Dupera",2));
        socFardighetArrayList.add(new Fardighet("Genomskåda",2));
        socFardighetArrayList.add(new Fardighet("Hovliv",0));
        socFardighetArrayList.add(new Fardighet("Injaga fruktan",2));
        socFardighetArrayList.add(new Fardighet("Ledarskap",2));
        socFardighetArrayList.add(new Fardighet("Skumraskaffärer",0));
        socFardighetArrayList.add(new Fardighet("Spel & Dobbel",2));
        socFardighetArrayList.add(new Fardighet("Sång & Musik",2));

        mysFardighetArrayList.add(new Fardighet("Ceremoni",0));
        mysFardighetArrayList.add(new Fardighet("Förnimma",0));
        mysFardighetArrayList.add(new Fardighet("Förvränga",0));
        mysFardighetArrayList.add(new Fardighet("Kanalisera",0));
        mysFardighetArrayList.add(new Fardighet("Harmonisera", 0));

        kunFardighetArrayList.add(new Fardighet("Filosofi",0));
        kunFardighetArrayList.add(new Fardighet("Geografi",0));
        kunFardighetArrayList.add(new Fardighet("Gifter & Droger",0));
        kunFardighetArrayList.add(new Fardighet("Handel",2));
        kunFardighetArrayList.add(new Fardighet("Historia",0));
        kunFardighetArrayList.add(new Fardighet("Kalkylera",0));
        kunFardighetArrayList.add(new Fardighet("Kirurgi",0));
        kunFardighetArrayList.add(new Fardighet("Krigsföring",0));
        kunFardighetArrayList.add(new Fardighet("Kulturkännedom",0));
        kunFardighetArrayList.add(new Fardighet("Lagkunskap",0));
        kunFardighetArrayList.add(new Fardighet("Läkekonst",0));
        kunFardighetArrayList.add(new Fardighet("Ockultism",0));
        kunFardighetArrayList.add(new Fardighet("Teologi",0));
        kunFardighetArrayList.add(new Fardighet("Teoretisk magi",0));
        kunFardighetArrayList.add(new Fardighet("Undervisa",0));

        vildFardighetArrayList.add(new Fardighet("Genomsöka",2));
        vildFardighetArrayList.add(new Fardighet("Jakt & Fiske",0));
        vildFardighetArrayList.add(new Fardighet("Köra vagn",2));
        vildFardighetArrayList.add(new Fardighet("Marsch",2));
        vildFardighetArrayList.add(new Fardighet("Naturlära",0));
        vildFardighetArrayList.add(new Fardighet("Navigation",0));
        vildFardighetArrayList.add(new Fardighet("Orientering",2));
        vildFardighetArrayList.add(new Fardighet("Rida",2));
        vildFardighetArrayList.add(new Fardighet("Sjömannaskap",0));
        vildFardighetArrayList.add(new Fardighet("Speja",2));
        vildFardighetArrayList.add(new Fardighet("Spåra",2));
        vildFardighetArrayList.add(new Fardighet("Vildmarksvana",0));

    }



    public static void manipList(ArrayList list, int index, int number){


    }

    public void setArketyp(String arketyp) {
        this.arketyp = arketyp;
    }

    public void setBakgrund(String bakgrund) {
        this.bakgrund = bakgrund;
    }

    public void setMiljo(String miljo) {
        this.miljo = miljo;
    }

    public void setFolkslag(String folkslag) {
        this.folkslag = folkslag;
    }



    public void setEnhetExpertis(int enhetExpertis) {
        this.enhetExpertis += enhetExpertis;
    }

    public void setEnhetKannetecken(int enhetKannetecken) {
        this.enhetKannetecken += enhetKannetecken;
    }

    public void setLattlarda(int lattlarda) {
        this.lattlarda += lattlarda;
    }


    public void changeAvtrubbV(int avtrubbV) {
        this.avtrubbV = avtrubbV;
    }

    public void changeAvtrubbO(int avtrubbO) {
        this.avtrubbO = avtrubbO;
    }

    public void changeAvtrubbU(int avtrubbU) {
        this.avtrubbU = avtrubbU;
    }

    public void setAvtrubbV(int avtrubbV) {
        this.avtrubbV += avtrubbV;
    }

    public void setAvtrubbU(int avtrubbU) {
        this.avtrubbU += avtrubbU;
    }

    public void setAvtrubbO(int avtrubbO) {
        this.avtrubbO += avtrubbO;
    }

    public void setEnhetRor(int enhetRor) {
        this.enhetRor += enhetRor;
    }

    public void setEnhetStrid(int enhetStrid) {
        this.enhetStrid += enhetStrid;
    }

    public void setEnhetVild(int enhetVild) {
        this.enhetVild += enhetVild;
    }

    public void setEnhetKunskap(int enhetKunskap) {
        this.enhetKunskap += enhetKunskap;
    }

    public void setEnhetMyst(int enhetMyst) {
        this.enhetMyst += enhetMyst;
    }

    public void setEnhetSociala(int enhetSociala) {
        this.enhetSociala += enhetSociala;
    }

    public void setEnhetOvriga(int enhetOvriga) {
        this.enhetOvriga += enhetOvriga;
    }

    public void setEnhetSprak(int enhetSprak) {
        this.enhetSprak += enhetSprak;
    }

    public void setEnhetHantverk(int enhetHantverk) {
        this.enhetHantverk += enhetHantverk;
    }

    public void setMysterier(int mysterier) {
        this.mysterier += mysterier;
    }

    public void setStartKapS(int startKapS) {
        this.startKapS += startKapS;
    }

    public void setFardSlag(int fardSlag) {
        this.fardSlag += fardSlag;
    }

    public void setKunskapSlag(int kunskapSlag) {
        this.kunskapSlag += kunskapSlag;
    }

    public void setStridSlag(int stridSlag) {
        this.stridSlag += stridSlag;
    }

    public void setIntrigSlag(int intrigSlag) {
        this.intrigSlag += intrigSlag;
    }

    public void setValfriHandelse(int valfriHandelse) {
        this.valfriHandelse += valfriHandelse;
    }

    public void setBelastningMod(int belastningMod) {
        this.belastningMod += belastningMod;
    }

    public String getArketyp() {
        return arketyp;
    }

    public String getBakgrund() {
        return bakgrund;
    }

    public String getMiljo() {
        return miljo;
    }

    public String getFolkslag() {
        return folkslag;
    }



    public int getEnhetExpertis() {
        return enhetExpertis;
    }

    public int getEnhetKannetecken() {
        return enhetKannetecken;
    }

    public int getLattlarda() {
        return lattlarda;
    }

    public int getAvtrubbV() {
        return avtrubbV;
    }

    public int getAvtrubbU() {
        return avtrubbU;
    }

    public int getAvtrubbO() {
        return avtrubbO;
    }

    public int getEnhetRor() {
        return enhetRor;
    }

    public int getEnhetStrid() {
        return enhetStrid;
    }

    public int getEnhetVild() {
        return enhetVild;
    }

    public int getEnhetKunskap() {
        return enhetKunskap;
    }

    public int getEnhetMyst() {
        return enhetMyst;
    }

    public int getEnhetSociala() {
        return enhetSociala;
    }

    public int getEnhetOvriga() {
        return enhetOvriga;
    }

    public int getEnhetSprak() {
        return enhetSprak;
    }

    public int getEnhetHantverk() {
        return enhetHantverk;
    }

    public int getMysterier() {
        return mysterier;
    }

    public int getStartKapS() {
        return startKapS;
    }
    public String startkapString() {
        return ""+ this.getStartKapS();
    }

    public int getFardSlag() {
        return fardSlag;
    }

    public int getKunskapSlag() {
        return kunskapSlag;
    }

    public int getStridSlag() {
        return stridSlag;
    }

    public int getIntrigSlag() {
        return intrigSlag;
    }

    public int getValfriHandelse() {
        return valfriHandelse;
    }

    public int getBelastningMod() {
        return belastningMod;
    }

    public ArrayList<String> getSpeciellaEgenskaperArrayList() {
        return speciellaEgenskaperArrayList;
    }

    public ArrayList<String> getLattLardaFardigheterArrayList() {
        return lattLardaFardigheterArrayList;
    }

    public ArrayList<String> getSvarLardaFardigheterArrayList() {
        return svarLardaFardigheterArrayList;
    }

    public ArrayList<String> getHandelseArrayList() {
        return handelseArrayList;
    }

    public ArrayList<HarleddaAttribut> getHarleddaAttributsArrayList() {
        return harleddaAttributsArrayList;
    }

    public ArrayList<GrundAttribut> getGrundAttributsArrayList() {
        return grundAttributsArrayList;
    }

    public ArrayList<Fardighet> getRorFardighetArrayList() {
        return rorFardighetArrayList;
    }

    public ArrayList<Fardighet> getStridFardighetArrayList() {
        return stridFardighetArrayList;
    }

    public ArrayList<Fardighet> getVildFardighetArrayList() {
        return vildFardighetArrayList;
    }

    public ArrayList<Fardighet> getKunFardighetArrayList() {
        return kunFardighetArrayList;
    }

    public ArrayList<Fardighet> getMysFardighetArrayList() {
        return mysFardighetArrayList;
    }

    public ArrayList<Fardighet> getSocFardighetArrayList() {
        return socFardighetArrayList;
    }

    public ArrayList<String> getSprakArrayList() {
        return sprakArrayList;
    }

    public ArrayList<String> getUtrustningArrayList() {
        return utrustningArrayList;
    }

    public ArrayList<Kannetecken> getKanneTeckenArrayList() {
        return kanneTeckenArrayList;
    }

    public ArrayList<Expertis> getExpertisTeckenArrayList() {
        return expertisTeckenArrayList;
    }

    public ArrayList<Hantverk> getHantverkTeckenArrayList() {
        return hantverkTeckenArrayList;
    }

    public ArrayList<String> getSkriftArrayList() {
        return skriftArrayList;
    }

    public ArrayList<Startkapital> getStartkapitalArrayList() {
        return startkapitalArrayList;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        temp.append("arketyp: "+this.arketyp + "\n");
        temp.append("miljö: " + this.miljo + "\n");
        temp.append("folkslag: " + this.folkslag + "\n");
        temp.append("Bakgrund: " + this.bakgrund + "\n");
        temp.append("förnamn: " + this.getFornamn() + "\n");
        temp.append("efternamn: " + this.getEfternamn() + "\n");
        temp.append("religion: " + this.getReligion() + "\n");
        temp.append("värv: " + this.getVarv() + "\n");
        temp.append("välmående: " + this.getValmaende() + "\n");
        temp.append("primärt karaktärsdrag: " + this.getPrimarKaraktarsdrag() + "\n");
        temp.append("sekundärt karaktärsdrag: " + this.getSekundarKaraktarsdrag() + "\n");

        temp.append("avtrubbV: " + this.getAvtrubbV() + "\n" );
        temp.append("avtrubbU: " + this.getAvtrubbU() + "\n" );
        temp.append("avtrubbO: " + this.getAvtrubbO() + "\n" );

        temp.append("Grundattribut:\n");
        for (int i = 0; i<this.getGrundAttributsArrayList().size();i++ ) {
            temp.append(this.getGrundAttributsArrayList().get(i).getNamn() + " " +
                    "" + this.getGrundAttributsArrayList().get(i).getT() + "D6+" +
                    "" + this.getGrundAttributsArrayList().get(i).getTMod() + "\n");
        }
        temp.append("Härledda Attribut:\n");
        for (int i = 0; i<this.getHarleddaAttributsArrayList().size();i++ ) {
            temp.append(this.getHarleddaAttributsArrayList().get(i).getName() + " " +
                    "" + this.getHarleddaAttributsArrayList().get(i).getT() + "D6+" +
                    "" + this.getHarleddaAttributsArrayList().get(i).getTMod() + "\n");
        }
        temp.append("Expertiser:\n");
        for (int i = 0; i< this.getExpertisTeckenArrayList().size(); i++) {
            temp.append(this.getExpertisTeckenArrayList().get(i).getName() + " " +
                    this.getExpertisTeckenArrayList().get(i).getT() + "D6\n");
        }

        temp.append("Kännetecken:\n");
        for (int i = 0; i< this.getKanneTeckenArrayList().size(); i++) {
            temp.append(this.getKanneTeckenArrayList().get(i).getName() + " " +
                    this.getKanneTeckenArrayList().get(i).getT() + "D6\n");
        }

        temp.append("Hantverk:\n");
        for (int i = 0; i< this.getHantverkTeckenArrayList().size(); i++) {
            temp.append(this.getHantverkTeckenArrayList().get(i).getName() + " " +
                    this.getHantverkTeckenArrayList().get(i).getT() + "D6\n");
        }

        temp.append("Färdslag: "+this.getFardSlag() + "\n");
        temp.append("Intrigslag: "+this.getIntrigSlag() + "\n");
        temp.append("StridSlag: "+this.getStridSlag() + "\n");
        temp.append("KunskapsSlag: "+this.getKunskapSlag() + "\n");

        temp.append("enhet övriga: " +this.getEnhetOvriga() + "\n");
        temp.append("enhet rörliga: " +this.getEnhetRor() + "\n");
        temp.append("enhet strid: " +this.getEnhetStrid() + "\n");
        temp.append("enhet kunskap: " +this.getEnhetKunskap() + "\n");
        temp.append("enhet vildmark: " +this.getEnhetVild() + "\n");
        temp.append("enhet mystik: " +this.getEnhetMyst() + "\n");
        temp.append("enhet sociala: " +this.getEnhetSociala() + "\n");

        for (int i = 0; i < this.getHandelseArrayList().size(); i++) {
            temp.append(this.getHandelseArrayList().get(i) + "\n");
        }

        for (Startkapital element:this.getStartkapitalArrayList()) {
            temp.append("Startkapitalslag: " + element.getT() + "D6*" + element.getTMod()+"\n");
        }
        temp.append("Startkapital = " + this.getStartKapS());

        String result = temp.toString();

        return result;



    }

    public String getFornamn() {
        return fornamn;
    }

    public void setFornamn(String fornamn) {
        this.fornamn = fornamn;
    }

    public String getEfternamn() {
        return efternamn;
    }

    public void setEfternamn(String efternamn) {
        this.efternamn = efternamn;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getVarv() {
        return varv;
    }

    public void setVarv(String varv) {
        this.varv = varv;
    }

    public int getValmaende() {
        return valmaende;
    }

    public String getValmaendeText() {
        String str = ""+this.getValmaende();
        return str;
    }

    public void setValmaende(int valmaende) {
        this.valmaende = valmaende;
    }

    public String getProvTotem() {
        return provTotem;
    }

    public void setProvTotem(String provTotem) {
        this.provTotem = provTotem;
    }

    public String getPrimarKaraktarsdrag() {
        return primarKaraktarsdrag;
    }

    public void setPrimarKaraktarsdrag(String primarKaraktarsdrag) {
        this.primarKaraktarsdrag = primarKaraktarsdrag;
    }

    public String getSekundarKaraktarsdrag() {
        return sekundarKaraktarsdrag;
    }

    public void setSekundarKaraktarsdrag(String sekundarKaraktarsdrag) {
        this.sekundarKaraktarsdrag = sekundarKaraktarsdrag;
    }

    public String getKon() {
        return kon;
    }

    public void setKon(String kon) {
        this.kon = kon;
    }

    public int getAlder() {
        return alder;
    }

    public String getAlderText() {
        String str = ""+this.getAlder();
        return str;
    }


    public void setAlder(int alder) {
        this.alder = alder;
    }

    public int getLangd() {
        return langd;
    }

    public String getLangdText() {
        String str = ""+this.getLangd();
        return str;
    }

    public void setLangd(int langd) {
        this.langd = langd;
    }

    public int getVikt() {
        return vikt;
    }

    public String getViktText() {
        String str = ""+this.getVikt();
        return str;
    }

    public void setVikt(int vikt) {
        this.vikt = vikt;
    }

    public String getVapenArm() {
        return vapenArm;
    }

    public void setVapenArm(String vapenArm) {
        this.vapenArm = vapenArm;
    }


}
