package com.npcmaker;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton;

import java.io.File;
import java.io.IOException;

public class PdfMigration {


    private Karaktar karaktar;
    private PDDocument _pdfDocument;
    private PDDocument _pdfDocument2;
    String pdfPath = "/NPCmaker/";
    String originalPdfPath = "/NPCmaker/fullstandigpdfv1.PDF";
    String targetPdfPath;
    File pdf = new File(originalPdfPath);

    public PdfMigration (Karaktar karaktar){
        this.karaktar = karaktar;
    }

    public void setField(String fieldName, String value ) throws IOException {
        PDDocumentCatalog docCatalog = this.get_pdfDocument2().getDocumentCatalog();
        PDAcroForm acroForm = docCatalog.getAcroForm();
        PDField field = acroForm.getField( fieldName );
        if( field != null ) {
            field.setValue(value);
        }
        else {
            System.err.println( "No field found with name:" + fieldName );
        }
    }

    public void checkBox(String fieldName){
        PDDocumentCatalog documentCatalog = this.get_pdfDocument2().getDocumentCatalog();
        PDAcroForm acroForm = documentCatalog.getAcroForm();
        PDField field = acroForm.getField(fieldName);
        ((PDRadioButton) field).setPushButton(true);
    }
    public void exportToPdf ()  {
        String targetPdf = this.pdfPath + this.karaktar.getFornamn()+" "+ this.karaktar.getEfternamn()+".PDF";
        try {
            _pdfDocument = PDDocument.load(new File(originalPdfPath));
            _pdfDocument2 = _pdfDocument;
        } catch (IOException e) {
            e.printStackTrace();
        }
        _pdfDocument2.getNumberOfPages();

        try {
            setField("fornamnText", this.getKaraktar().getFornamn());
            setField("efternamnText", this.getKaraktar().getEfternamn());
            setField("folkslagText", this.getKaraktar().getFolkslag());
            setField("provinsTotemText", this.getKaraktar().getProvTotem());
            setField("konText", this.getKaraktar().getKon());
            setField("alderText", this.getKaraktar().getAlderText());
            setField("religionText", this.getKaraktar().getReligion());
            setField("varvText", this.getKaraktar().getVarv());
            setField("langdText", this.getKaraktar().getLangdText());
            setField("viktText", this.getKaraktar().getViktText());
            setField("primKaraktarText", this.getKaraktar().getPrimarKaraktarsdrag());
            setField("vapenArmText", this.getKaraktar().getVapenArm());
            setField("sekKaraktarText", this.getKaraktar().getSekundarKaraktarsdrag());

            if (karaktar.getAvtrubbV() != 0){
                checkBox("avtrubbV"+karaktar.getAvtrubbV());
            }
            if (karaktar.getAvtrubbU() != 0) {
                checkBox("avtrubbU" + karaktar.getAvtrubbU());
            }
            if (karaktar.getAvtrubbO() != 0) {
                checkBox("avtrubbO" + karaktar.getAvtrubbO());
            }

            setField("styrkaText", this.getKaraktar().getGrundAttributsArrayList().get(0).valueToString());
            setField("rorlighetText", this.getKaraktar().getGrundAttributsArrayList().get(2).valueToString());
            setField("talighetText", this.getKaraktar().getGrundAttributsArrayList().get(1).valueToString());
            setField("uppfattningText", this.getKaraktar().getGrundAttributsArrayList().get(3).valueToString());
            setField("viljaText", this.getKaraktar().getGrundAttributsArrayList().get(7).valueToString());
            setField("psykeText", this.getKaraktar().getGrundAttributsArrayList().get(4).valueToString());
            setField("visdomText", this.getKaraktar().getGrundAttributsArrayList().get(5).valueToString());
            setField("utstralningText", this.getKaraktar().getGrundAttributsArrayList().get(6).valueToString());

            setField("forflyttningText", this.getKaraktar().getHarleddaAttributsArrayList().get(0).valueToString());
            setField("intryckText", this.getKaraktar().getHarleddaAttributsArrayList().get(2).valueToString());
            setField("kroppsbyggnadText", this.getKaraktar().getHarleddaAttributsArrayList().get(5).valueToString());
            setField("reaktionText", this.getKaraktar().getHarleddaAttributsArrayList().get(1).valueToString());
            setField("sjalvkontrollText", this.getKaraktar().getHarleddaAttributsArrayList().get(4).valueToString());
            setField("vaksamhetText", this.getKaraktar().getHarleddaAttributsArrayList().get(3).valueToString());
            setField("livskraftText", this.getKaraktar().getHarleddaAttributsArrayList().get(6).valueToString());
            setField("grundskadaText", this.getKaraktar().getHarleddaAttributsArrayList().get(7).valueToString());
            setField("grundpansarText", this.getKaraktar().getHarleddaAttributsArrayList().get(8).tModToString());

            setField("armborstText", this.getKaraktar().getStridFardighetArrayList().get(0).valueToString());
            setField("bageText", this.getKaraktar().getStridFardighetArrayList().get(1).valueToString());
            setField("dolkText", this.getKaraktar().getStridFardighetArrayList().get(2).valueToString());
            setField("kastvapenText", this.getKaraktar().getStridFardighetArrayList().get(3).valueToString());
            setField("klubbaText", this.getKaraktar().getStridFardighetArrayList().get(4).valueToString());
            setField("kedjevapenText", this.getKaraktar().getStridFardighetArrayList().get(5).valueToString());
            setField("skoldText", this.getKaraktar().getStridFardighetArrayList().get(6).valueToString());
            setField("slagsmalText", this.getKaraktar().getStridFardighetArrayList().get(7).valueToString());
            setField("spjutText", this.getKaraktar().getStridFardighetArrayList().get(8).valueToString());
            setField("stavText", this.getKaraktar().getStridFardighetArrayList().get(9).valueToString());
            setField("svardText", this.getKaraktar().getStridFardighetArrayList().get(10).valueToString());
            setField("yxaText", this.getKaraktar().getStridFardighetArrayList().get(11).valueToString());

            setField("dansaText", this.getKaraktar().getRorFardighetArrayList().get(0).valueToString());
            setField("fingerText", this.getKaraktar().getRorFardighetArrayList().get(1).valueToString());
            setField("gommaText", this.getKaraktar().getRorFardighetArrayList().get(2).valueToString());
            setField("hoppaText", this.getKaraktar().getRorFardighetArrayList().get(3).valueToString());
            setField("klattraText", this.getKaraktar().getRorFardighetArrayList().get(4).valueToString());
            setField("lasdyrkningText", this.getKaraktar().getRorFardighetArrayList().get(5).valueToString());
            setField("simmaText", this.getKaraktar().getRorFardighetArrayList().get(6).valueToString());
            setField("smygaText", this.getKaraktar().getRorFardighetArrayList().get(7).valueToString());
            setField("undvikaText", this.getKaraktar().getRorFardighetArrayList().get(8).valueToString());

            setField("ceremoniText", this.getKaraktar().getMysFardighetArrayList().get(0).valueToString());
            setField("fornimmaText", this.getKaraktar().getMysFardighetArrayList().get(1).valueToString());
            setField("forvrangaText", this.getKaraktar().getMysFardighetArrayList().get(2).valueToString());
            setField("harmoniseraText", this.getKaraktar().getMysFardighetArrayList().get(4).valueToString());
            setField("kanaliseraText", this.getKaraktar().getMysFardighetArrayList().get(3).valueToString());

            setField("argumenteraText", this.getKaraktar().getSocFardighetArrayList().get(0).valueToString());
            setField("berattarkonstText", this.getKaraktar().getSocFardighetArrayList().get(1).valueToString());
            setField("charmText", this.getKaraktar().getSocFardighetArrayList().get(2).valueToString());
            setField("duperaText", this.getKaraktar().getSocFardighetArrayList().get(3).valueToString());
            setField("genomskadaText", this.getKaraktar().getSocFardighetArrayList().get(4).valueToString());
            setField("hovlivText", this.getKaraktar().getSocFardighetArrayList().get(5).valueToString());
            setField("injagaText", this.getKaraktar().getSocFardighetArrayList().get(6).valueToString());
            setField("ledarskapText", this.getKaraktar().getSocFardighetArrayList().get(7).valueToString());
            setField("skumraskText", this.getKaraktar().getSocFardighetArrayList().get(8).valueToString());
            setField("spelText", this.getKaraktar().getSocFardighetArrayList().get(9).valueToString());
            setField("sangText", this.getKaraktar().getSocFardighetArrayList().get(10).valueToString());

            setField("genomsokaText", this.getKaraktar().getVildFardighetArrayList().get(0).valueToString());
            setField("jaktText", this.getKaraktar().getVildFardighetArrayList().get(1).valueToString());
            setField("koravagnText", this.getKaraktar().getVildFardighetArrayList().get(2).valueToString());
            setField("marschText", this.getKaraktar().getVildFardighetArrayList().get(3).valueToString());
            setField("naturlaraText", this.getKaraktar().getVildFardighetArrayList().get(4).valueToString());
            setField("navigationText", this.getKaraktar().getVildFardighetArrayList().get(5).valueToString());
            setField("orienteringText", this.getKaraktar().getVildFardighetArrayList().get(6).valueToString());
            setField("ridaText", this.getKaraktar().getVildFardighetArrayList().get(7).valueToString());
            setField("sjomannaskapText", this.getKaraktar().getVildFardighetArrayList().get(8).valueToString());
            setField("spejaText", this.getKaraktar().getVildFardighetArrayList().get(9).valueToString());
            setField("sparaText", this.getKaraktar().getVildFardighetArrayList().get(10).valueToString());
            setField("vildmarksvanaText", this.getKaraktar().getVildFardighetArrayList().get(11).valueToString());

            setField("filosofiText", this.getKaraktar().getKunFardighetArrayList().get(0).valueToString());
            setField("geografiText", this.getKaraktar().getKunFardighetArrayList().get(1).valueToString());
            setField("giftText", this.getKaraktar().getKunFardighetArrayList().get(2).valueToString());
            setField("handelText", this.getKaraktar().getKunFardighetArrayList().get(3).valueToString());
            setField("historiaText", this.getKaraktar().getKunFardighetArrayList().get(4).valueToString());
            setField("kalkyleraText", this.getKaraktar().getKunFardighetArrayList().get(5).valueToString());
            setField("kirurgiText", this.getKaraktar().getKunFardighetArrayList().get(6).valueToString());
            setField("krigsforingText", this.getKaraktar().getKunFardighetArrayList().get(7).valueToString());
            setField("kulturkannedomText", this.getKaraktar().getKunFardighetArrayList().get(8).valueToString());
            setField("lagkunskapText", this.getKaraktar().getKunFardighetArrayList().get(9).valueToString());
            setField("lakekonstText", this.getKaraktar().getKunFardighetArrayList().get(10).valueToString());
            setField("ockultismText", this.getKaraktar().getKunFardighetArrayList().get(11).valueToString());
            setField("teologiText", this.getKaraktar().getKunFardighetArrayList().get(12).valueToString());
            setField("teoretiskText", this.getKaraktar().getKunFardighetArrayList().get(13).valueToString());
            setField("undervisaText", this.getKaraktar().getKunFardighetArrayList().get(14).valueToString());

            for (int i = 0; i < this.getKaraktar().getExpertisTeckenArrayList().size(); i++) {
                setField("expertisNamnText"+i, this.getKaraktar().getExpertisTeckenArrayList().get(i).getName());
                setField("expertisVardeText"+i, this.getKaraktar().getExpertisTeckenArrayList().get(i).valueToString());
            }
            for (int i = 0; i < this.getKaraktar().getHantverkTeckenArrayList().size(); i++) {
                setField("hantverkNamnText"+i, this.getKaraktar().getHantverkTeckenArrayList().get(i).getName());
                setField("hantverkVardeText"+i, this.getKaraktar().getHantverkTeckenArrayList().get(i).valueToString());
            }
            for (int i = 0; i < this.getKaraktar().getKanneTeckenArrayList().size(); i++) {
                setField("kanneteckenNamnText"+i, this.getKaraktar().getKanneTeckenArrayList().get(i).getName());
                setField("kanneteckenVardeText"+i, this.getKaraktar().getKanneTeckenArrayList().get(i).valueToString());
            }

            for (int i = 0; i < this.getKaraktar().getSprakArrayList().size(); i++){
                setField("sprakText"+i, this.getKaraktar().getSprakArrayList().get(i));
            }

            if (this.getKaraktar().getSkriftArrayList().size() != 0){
                for (int i = 0; i < this.getKaraktar().getSkriftArrayList().size(); i++){
                    setField("skriftText"+i, this.getKaraktar().getSkriftArrayList().get(i));
                }
            }


            if (this.getKaraktar().getLattLardaFardigheterArrayList().size() != 0) {
                for (int i = 0; i < this.getKaraktar().getLattLardaFardigheterArrayList().size(); i++){
                    setField("lattlard"+i, this.getKaraktar().getLattLardaFardigheterArrayList().get(i));
                }
            }


            if (this.getKaraktar().getSvarLardaFardigheterArrayList().size() != 0) {
                for (int i = 0; i < this.getKaraktar().getSvarLardaFardigheterArrayList().size(); i++){
                    setField("svarlard"+i, this.getKaraktar().getSvarLardaFardigheterArrayList().get(i));
                }
            }




            for (int i = 0; i < this.getKaraktar().getHandelseArrayList().size(); i++){
                setField("handelse"+i, this.getKaraktar().getHandelseArrayList().get(i));
            }

            if (this.getKaraktar().getSpeciellaEgenskaperArrayList().size() != 0) {
                for (int i = 0; i < this.getKaraktar().getSpeciellaEgenskaperArrayList().size(); i++){
                    setField("egenskap"+i, this.getKaraktar().getSpeciellaEgenskaperArrayList().get(i));
                }
            }


            for (int i = 0; i < this.getKaraktar().getUtrustningArrayList().size(); i++){
                setField("utrustning"+i, this.getKaraktar().getUtrustningArrayList().get(i));
            }

            setField("startkapital", this.getKaraktar().startkapString());






        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            _pdfDocument2.save(new File(targetPdf));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            _pdfDocument2.close();
            _pdfDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PDDocument get_pdfDocument() {
        return _pdfDocument;
    }

    public void set_pdfDocument(PDDocument _pdfDocument) {
        this._pdfDocument = _pdfDocument;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

    public String getOriginalPdfPath() {
        return originalPdfPath;
    }

    public void setOriginalPdfPath(String originalPdfPath) {
        this.originalPdfPath = originalPdfPath;
    }

    public File getPdf() {
        return pdf;
    }

    public void setPdf(File pdf) {
        this.pdf = pdf;
    }

    public Karaktar getKaraktar() {
        return karaktar;
    }

    public String getTargetPdfPath() {
        return targetPdfPath;
    }

    public PDDocument get_pdfDocument2() {
        return _pdfDocument2;
    }

    public void set_pdfDocument2(PDDocument _pdfDocument2) {
        this._pdfDocument2 = _pdfDocument2;
    }

    public void setKaraktar(Karaktar karaktar) {
        this.karaktar = karaktar;
    }
}
