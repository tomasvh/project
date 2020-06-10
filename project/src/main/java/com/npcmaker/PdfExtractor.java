package com.npcmaker;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class PdfExtractor {
    public PdfExtractor(){}

    public void extractPDF() {
        String dbDir = "/NPCmaker/";
        File f = new File(dbDir);
        if (!f.exists()){
            f.mkdir();
        }
        String fName = "fullstandigpdfv1.pdf";
        String fPath = dbDir + "\\" + fName;
        File f2 = new File(fPath);
        if (!f2.exists()){
            InputStream iStream = DbConnector.class.getResourceAsStream("/pdfTemplate/"+fName);
            try {
                Files.copy(iStream, f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
