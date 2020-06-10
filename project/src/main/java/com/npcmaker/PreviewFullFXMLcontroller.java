package com.npcmaker;


import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;

public class PreviewFullFXMLcontroller implements Initializable {

private JavaFXTableData currentSelection = new JavaFXTableData();

private final HashMap<Integer, JavaFXTableData> selectionMap = new HashMap<>();

private Karaktar karaktar;

    private ObservableList<JavaFXTableData> gAList = FXCollections.observableArrayList();
    private    ObservableList<JavaFXTableData> hAList = FXCollections.observableArrayList();
    private    ObservableList<JavaFXTableData> fSList = FXCollections.observableArrayList();
    private   ObservableList<JavaFXTableData> fRList = FXCollections.observableArrayList();
    private   ObservableList<JavaFXTableData> fMList = FXCollections.observableArrayList();
    private   ObservableList<JavaFXTableData> fSocList = FXCollections.observableArrayList();
    private   ObservableList<JavaFXTableData> fKList = FXCollections.observableArrayList();
    private   ObservableList<JavaFXTableData> fVList = FXCollections.observableArrayList();

Integer lastID = 0;





    @FXML public Button buttonConfig;

    @FXML public Button buttonReturn;

    @FXML public TextField fornamnText;
    @FXML public TextField efternamnText;
    @FXML public TextField folkslagText;
    @FXML public TextField provTotemText;
    @FXML public TextField konText;
    @FXML public TextField religionText;
    @FXML public TextField varvText;
    @FXML public TextField arketypText;
    @FXML public TextField miljoText;
    @FXML public TextField bakgrundText;
    @FXML public Spinner<Integer> valmaendeSpinner;


    @FXML public Spinner<Integer> avtrubbVSpinner;
    @FXML public Spinner<Integer> avtrubbUSpinner;
    @FXML public Spinner<Integer> avtrubbOSpinner;

    @FXML public Button uppdateraTextFalt;

    @FXML public TextField primKarText;
    @FXML public CheckBox primKarLastCheck;
    @FXML public TextField sekKarText;
    @FXML public CheckBox sekKarLastCheck;



    @FXML public TableView<JavaFXTableData> grundAttributTable;
    @FXML public TableColumn<JavaFXTableData, String> grundAttributNamn;
    @FXML public TableColumn<JavaFXTableData, Integer> grundAttributT;
    @FXML public TableColumn<JavaFXTableData, Integer> grundAttributMod;

    @FXML public TableView<JavaFXTableData> harleddaAttributTable;
    @FXML public TableColumn<JavaFXTableData, String> harleddAttribut;
    @FXML public TableColumn<JavaFXTableData, Integer> harleddT;
    @FXML public TableColumn<JavaFXTableData, Integer> harleddMod;

    @FXML public TableView<JavaFXTableData> stridsFardigheterTable;
    @FXML public TableColumn<JavaFXTableData, String> sFardighet;
    @FXML public TableColumn<JavaFXTableData, Integer> sFardighetT;
    @FXML public TableColumn<JavaFXTableData, Integer> sFardighetMod;

    @FXML public TableView<JavaFXTableData> rorelseFardigheterTable;
    @FXML public TableColumn<JavaFXTableData, String> rFardighet;
    @FXML public TableColumn<JavaFXTableData, Integer> rFardighetT;
    @FXML public TableColumn<JavaFXTableData, Integer> rFardighetMod;

    @FXML public TableView<JavaFXTableData> mystikFardighetTable;
    @FXML public TableColumn<JavaFXTableData, String> mFardighet;
    @FXML public TableColumn<JavaFXTableData, Integer> mFardighetT;
    @FXML public TableColumn<JavaFXTableData, Integer> mFardighetMod;

    @FXML public TableView<JavaFXTableData> socialFardighetTable;
    @FXML public TableColumn<JavaFXTableData, String> socFardighet;
    @FXML public TableColumn<JavaFXTableData, Integer> socFardighetT;
    @FXML public TableColumn<JavaFXTableData, Integer> socFardighetMod;

    @FXML public TableView<JavaFXTableData> kunskapsFardighetTable;
    @FXML public TableColumn<JavaFXTableData, String> kFardighet;
    @FXML public TableColumn<JavaFXTableData, Integer> kFardighetT;
    @FXML public TableColumn<JavaFXTableData, Integer> kFardighetMod;

    @FXML public TableView<JavaFXTableData> vildmarksFardighetTable;
    @FXML public TableColumn<JavaFXTableData, String> vFardighet;
    @FXML public TableColumn<JavaFXTableData, Integer> vFardighetT;
    @FXML public TableColumn<JavaFXTableData, Integer> vFardighetMod;

    @FXML public TextField editEgenskap;
    @FXML public Spinner<Integer> editTMod;
    @FXML public Spinner<Integer> editMod;
    @FXML public Button uppdateraTableRow;
    @FXML public Button dropTableRow;

    @FXML public Button fullToPdf;
    @FXML public Button mediumToPdf;
    @FXML public Button kompaktToPdf;



    public void changeScreenVal(ActionEvent event){
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/ConfigFullFXML.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void changeScreenReturn(ActionEvent event){
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/EntryFullFXML.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static int randomNumber (int max) {
        Random random = new Random();
        return random.nextInt(max)+1;

    }
    public static void populateKunMys (Karaktar karaktar, int number){
        switch (randomNumber(2)){
            case 1:
                karaktar.setEnhetKunskap(number);
                break;
            case 2:
                karaktar.setEnhetMyst(number);
                break;
        }
    }

    public static void calcValfriaFardighetsEnheter (Karaktar karaktar) {
        while (karaktar.getEnhetOvriga() != 0) {
            int selection = randomNumber(6);
            switch (selection){
                case 1:
                    karaktar.setEnhetRor(1);
                    break;
                case 2:
                    karaktar.setEnhetStrid(1);
                    break;
                case 3:
                    karaktar.setEnhetKunskap(1);
                    break;
                case 4:
                    karaktar.setEnhetMyst(1);
                    break;
                case 5:
                    karaktar.setEnhetVild(1);
                    break;
                case 6:
                    karaktar.setEnhetSociala(1);
                    break;
            }
            karaktar.setEnhetOvriga(-1);
        }
    }

    public void dbKamorianInteract(Karaktar karaktar, Connection conn, String tableName, int id){
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + tableName + " where ID = " + id);
            while (rs.next()) {
                dbTableInteract(karaktar,conn,"kamorian", id);
                if (id == 10){
                    dbTableInteract(karaktar,conn,"kamorian", randomNumber(9));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void specialTable(Karaktar karaktar, Connection conn, String tableName, int id){
        switch (tableName){
            case "folkslag":
                switch (id){
                    case 6:
                        dbTableInteract(karaktar,conn,"jargier", randomNumber(10));
                        break;
                    case 7:
                        dbKamorianInteract(karaktar, conn, "kamorian", randomNumber(10));

                        break;
                }
            case "farderaventyr":
                switch (id){
                    case 1:
                        dbTableInteract(karaktar,conn,"allvarligolycka", randomNumber(16));
                        break;
                    case 19:
                        dbTableInteract(karaktar,conn,"feltidfelplats", randomNumber(3));
                        break;
                    case 22:
                        switch (randomNumber(2)) {
                            case 1:
                                karaktar.setEnhetExpertis(1);
                                karaktar.getHandelseArrayList().add("Lämnat främlingen");
                                break;
                            case 2:
                                dbTableInteract(karaktar,conn,"framlingifara", randomNumber(30));
                                break;
                        }
                        break;
                    case 25 :
                        dbTableInteract(karaktar, conn, "randomgrundattribut", randomNumber(8));
                        break;
                    case 34:
                        dbTableInteract(karaktar, conn, "dubbelbakgrund", randomNumber(10));
                        break;
                    case 35:
                        dbTableInteract(karaktar, conn, "hittatkropp", randomNumber(2));
                        break;
                    case 53:
                        dbTableInteract(karaktar, conn, "randomgrundattribut", randomNumber(8));
                        break;
                    case 62:
                        dbTableInteract(karaktar, conn, "resaovermundana", randomNumber(3));
                        break;
                    case 65:
                        dbTableInteract(karaktar, conn, "ratttidrattplats", randomNumber(3));
                        break;
                    case 82:
                        dbTableInteract(karaktar, conn, "storupptackt", randomNumber(3));
                        break;
                    case 87:
                        switch (randomNumber(2)){
                            case 1:
                                karaktar.setEnhetVild(4);
                                break;
                            case 2:
                                karaktar.setEnhetRor(4);
                                break;
                        }
                        break;

                }
                break;
            case "intrigerillgarningar":
                switch (id){
                    case 3:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 4:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 8:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 13:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 14:
                        dbTableInteract(karaktar, conn, "dubbelbakgrund", randomNumber(10));
                        break;
                    case 19:
                        dbTableInteract(karaktar, conn, "erbjudengemal", randomNumber(2));
                        break;
                    case 22:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 23:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 24:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 28:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 30:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 31:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 33:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 36:
                        dbTableInteract(karaktar, conn, "dubbelbakgrund", randomNumber(10));
                        break;
                    case 44:
                        dbTableInteract(karaktar, conn, "randomgrundattribut", randomNumber(8));
                        break;
                    case 48:
                        switch (randomNumber(3)){
                            case 1:
                                karaktar.setSekundarKaraktarsdrag("Makt");
                                break;
                            case 2:
                                karaktar.setSekundarKaraktarsdrag("Sex");
                                break;
                            case 3:
                                karaktar.setSekundarKaraktarsdrag("Rikedom");
                                break;
                        }
                        break;
                    case 49:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 57:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 59:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 64:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 65:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 66:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 72:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 73:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 83:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 85:
                        dbTableInteract(karaktar, conn, "svartmoralisktbeslut", randomNumber(3));
                        break;
                    case 86:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 92:
                        dbTableInteract(karaktar, conn, "randomgrundattribut", randomNumber(8));
                        break;
                    case 95:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 97:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 98:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;


                }
                break;
            case "kunskapmysterier":
                switch (id){
                    case 6:
                        populateKunMys(karaktar, 2);
                        break;
                    case 8:
                        switch (randomNumber(2)){
                            case 1:
                                karaktar.setEnhetKunskap(4);
                                break;
                            case 2:
                                karaktar.setEnhetMyst(4);
                                break;
                        }
                        break;
                    case 9:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 11:
                        populateKunMys(karaktar, 4);
                        break;
                    case 19:
                        dbBakgrundInteract(karaktar, conn, "experiment", randomNumber(6));
                        break;
                    case 25:
                        populateKunMys(karaktar, 4);
                        break;
                    case 26:
                        populateKunMys(karaktar, 2);
                        break;
                    case 27:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 28:
                        populateKunMys(karaktar, 2);
                        break;
                    case 32:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 37:
                        populateKunMys(karaktar, 4);
                        break;
                    case 38:
                        dbTableInteract(karaktar, conn, "randomgrundattribut", randomNumber(8));
                        break;
                    case 40:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 46:
                        populateKunMys(karaktar, 4);
                        break;
                    case 50:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 54:
                        dbTableInteract(karaktar, conn, "kanslokall", randomNumber(9));
                        break;
                    case 62:
                        dbTableInteract(karaktar, conn, "dubbelbakgrund", randomNumber(10));
                        break;
                    case 65:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 67:
                        dbTableInteract(karaktar, conn, "randomgrundattribut", randomNumber(8));
                        break;
                    case 68:
                        dbTableInteract(karaktar, conn, "mottspakvinna", randomNumber(2));
                        break;
                    case 69:
                        dbTableInteract(karaktar, conn, "mottsvartkonstnar", randomNumber(2));
                        break;
                    case 73:
                        switch (randomNumber(2)){
                            case 1:
                                karaktar.setMysterier(4);
                                break;
                            case 2:
                                karaktar.setEnhetOvriga(3);
                                break;
                        }
                        break;
                    case 75:
                        dbTableInteract(karaktar, conn, "provatunderligadroger", randomNumber(4));
                        break;
                    case 80:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 84:
                        populateKunMys(karaktar, 6);
                        break;
                    case 96:
                        populateKunMys(karaktar, 4);
                        break;

                }
                break;
            case "striderdrabbningar":
                switch (id){
                    case 11:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 26:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 36:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 41:
                        switch (randomNumber(2)){
                            case 1:
                                karaktar.getGrundAttributsArrayList().get(0).settMod(-2);
                                break;
                            case 2:
                                karaktar.getGrundAttributsArrayList().get(1).settMod(-2);
                                break;
                        }
                        break;
                    case 56:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 67:
                        switch (randomNumber(2)){
                            case 1:
                                karaktar.getGrundAttributsArrayList().get(0).settMod(-2);
                                break;
                            case 2:
                                karaktar.getGrundAttributsArrayList().get(2).settMod(-2);
                                break;
                        }
                        break;
                    case 68:
                        switch (randomNumber(2)){
                            case 1:
                                karaktar.getGrundAttributsArrayList().get(1).settMod(-2);
                                break;
                            case 2:
                                karaktar.getGrundAttributsArrayList().get(2).settMod(-2);
                                break;
                        }
                        break;
                    case 86:
                        dbBakgrundInteract(karaktar, conn, "bakgrundstabell", randomNumber(100));
                        break;
                    case 92:
                        dbTableInteract(karaktar, conn, "uppror", randomNumber(2));
                        break;

                }
                break;
        }
    }

    public void dbBakgrundInteract (Karaktar karaktar, Connection conn, String tableName, int id) {
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + tableName + " where ID = " + id);
            while (rs.next()) {
                karaktar.getHandelseArrayList().add(rs.getString("happening"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void calcRandomGrundAttribut(Karaktar karaktar) {
        int tPoints = 10;
        while (tPoints != 0) {
            int rNumber = randomNumber(8)-1;
            if (karaktar.getGrundAttributsArrayList().get(rNumber).getT() < 5){
                karaktar.getGrundAttributsArrayList().get(rNumber).setT(1);
                tPoints--;
            }

        }
    }

    public void calcValfriBakgrund(Karaktar karaktar) {
        while (karaktar.getValfriHandelse() != 0) {
            switch (randomNumber(4)){
                case 1:
                    karaktar.setIntrigSlag(1);
                    break;
                case 2:
                    karaktar.setStridSlag(1);
                    break;
                case 3:
                    karaktar.setKunskapSlag(1);
                    break;
                case 4:
                    karaktar.setFardSlag(1);
                    break;
            }
            karaktar.setValfriHandelse(-1);
        }
    }

    public int randomNumber0Start (int max) {
        Random random = new Random();
        return random.nextInt(max);
    }


    public void kopaFardigheter(Karaktar karaktar) {

        while (karaktar.getEnhetKunskap() > 0) {
            int rNumber = randomNumber0Start(karaktar.getKunFardighetArrayList().size());
            switch (karaktar.getKunFardighetArrayList().get(rNumber).getT()){
                case 0:
                    karaktar.getKunFardighetArrayList().get(rNumber).setT(2);
                    karaktar.setEnhetKunskap(-1);
                    break;
                case 2:
                    karaktar.getKunFardighetArrayList().get(rNumber).setT(1);
                    karaktar.setEnhetKunskap(-1);
                    break;
                case 3:
                    if (karaktar.getEnhetKunskap() >= 2){
                        karaktar.getKunFardighetArrayList().get(rNumber).setT(1);
                        karaktar.setEnhetKunskap(-2);
                    }
                    break;
                case 4:
                    if (karaktar.getEnhetKunskap() >= 4){
                        karaktar.getKunFardighetArrayList().get(rNumber).setT(1);
                        karaktar.setEnhetKunskap(-4);
                    }
                    break;
                case 5:
                    break;

            }
        }

        while (karaktar.getEnhetMyst() > 0) {
            int rNumber = randomNumber0Start(karaktar.getMysFardighetArrayList().size()+1);
            if (karaktar.getMysFardighetArrayList().size() == rNumber && karaktar.getEnhetMyst() > 1){
                if (karaktar.getAvtrubbO() <5 ) {
                    karaktar.setAvtrubbO(1);
                    karaktar.setEnhetMyst(-2);
                }
            } else {
                rNumber = randomNumber0Start(karaktar.getMysFardighetArrayList().size());
                switch (karaktar.getMysFardighetArrayList().get(rNumber).getT()){
                    case 0:
                        karaktar.getMysFardighetArrayList().get(rNumber).setT(2);
                        karaktar.setEnhetMyst(-1);
                        break;
                    case 2:
                        karaktar.getMysFardighetArrayList().get(rNumber).setT(1);
                        karaktar.setEnhetMyst(-1);
                        break;
                    case 3:
                        if (karaktar.getEnhetMyst() >= 2){
                            karaktar.getMysFardighetArrayList().get(rNumber).setT(1);
                            karaktar.setEnhetMyst(-2);
                        }
                        break;
                    case 4:
                        if (karaktar.getEnhetMyst() >= 4){
                            karaktar.getMysFardighetArrayList().get(rNumber).setT(1);
                            karaktar.setEnhetMyst(-4);
                        }
                        break;
                    case 5:
                        break;

                }

            }

        }

        while (karaktar.getEnhetRor() > 0) {
            int rNumber = randomNumber0Start(karaktar.getRorFardighetArrayList().size());
            switch (karaktar.getRorFardighetArrayList().get(rNumber).getT()){
                case 0:
                    karaktar.getRorFardighetArrayList().get(rNumber).setT(2);
                    karaktar.setEnhetRor(-1);
                    break;
                case 2:
                    karaktar.getRorFardighetArrayList().get(rNumber).setT(1);
                    karaktar.setEnhetRor(-1);
                    break;
                case 3:
                    if (karaktar.getEnhetRor() >= 2){
                        karaktar.getRorFardighetArrayList().get(rNumber).setT(1);
                        karaktar.setEnhetRor(-2);
                    }
                    break;
                case 4:
                    if (karaktar.getEnhetRor() >= 4){
                        karaktar.getRorFardighetArrayList().get(rNumber).setT(1);
                        karaktar.setEnhetRor(-4);
                    }
                    break;
                case 5:
                    break;

            }
        }

        while (karaktar.getEnhetSociala() > 0) {
            int rNumber = randomNumber0Start(karaktar.getSocFardighetArrayList().size()+1);
            if (karaktar.getSocFardighetArrayList().size() == rNumber && karaktar.getEnhetSociala() > 1) {
                if (karaktar.getAvtrubbU() < 5) {
                    karaktar.setAvtrubbU(1);
                    karaktar.setEnhetSociala(-2);
                }
            } else {
                rNumber = randomNumber0Start(karaktar.getSocFardighetArrayList().size());
                switch (karaktar.getSocFardighetArrayList().get(rNumber).getT()){
                    case 0:
                        karaktar.getSocFardighetArrayList().get(rNumber).setT(2);
                        karaktar.setEnhetSociala(-1);
                        break;
                    case 2:
                        karaktar.getSocFardighetArrayList().get(rNumber).setT(1);
                        karaktar.setEnhetSociala(-1);
                        break;
                    case 3:
                        if (karaktar.getEnhetSociala() >= 2){
                            karaktar.getSocFardighetArrayList().get(rNumber).setT(1);
                            karaktar.setEnhetSociala(-2);
                        }
                        break;
                    case 4:
                        if (karaktar.getEnhetSociala() >= 4){
                            karaktar.getSocFardighetArrayList().get(rNumber).setT(1);
                            karaktar.setEnhetSociala(-4);
                        }
                    case 5:
                        break;

                }
            }

        }

        while (karaktar.getEnhetStrid() > 0) {
            int rNumber = randomNumber0Start(karaktar.getStridFardighetArrayList().size()+1);
            if (karaktar.getStridFardighetArrayList().size() == rNumber && karaktar.getEnhetStrid() > 1){
                if (karaktar.getAvtrubbV() < 5) {
                    karaktar.setAvtrubbV(1);
                    karaktar.setEnhetStrid(-2);
                }

            } else {
                rNumber = randomNumber0Start(karaktar.getStridFardighetArrayList().size());
                switch (karaktar.getStridFardighetArrayList().get(rNumber).getT()){
                    case 0:
                        karaktar.getStridFardighetArrayList().get(rNumber).setT(2);
                        karaktar.setEnhetStrid(-1);
                        break;
                    case 2:
                        karaktar.getStridFardighetArrayList().get(rNumber).setT(1);
                        karaktar.setEnhetStrid(-1);
                        break;
                    case 3:
                        if (karaktar.getEnhetStrid() >= 2){
                            karaktar.getStridFardighetArrayList().get(rNumber).setT(1);
                            karaktar.setEnhetStrid(-2);
                        }
                        break;
                    case 4:
                        if (karaktar.getEnhetStrid() >= 4){
                            karaktar.getStridFardighetArrayList().get(rNumber).setT(1);
                            karaktar.setEnhetStrid(-4);
                        }
                    case 5:
                        break;

                }

            }

        }

        while (karaktar.getEnhetVild() > 0) {
            int rNumber = randomNumber0Start(karaktar.getVildFardighetArrayList().size()+1);
            if (karaktar.getVildFardighetArrayList().size() == rNumber && karaktar.getEnhetVild() > 1){
                if (karaktar.getAvtrubbU() < 5) {
                    karaktar.setAvtrubbU(1);
                    karaktar.setEnhetVild(-2);
                }
            } else {
                rNumber = randomNumber0Start(karaktar.getVildFardighetArrayList().size());
                switch (karaktar.getVildFardighetArrayList().get(rNumber).getT()){
                    case 0:
                        karaktar.getVildFardighetArrayList().get(rNumber).setT(2);
                        karaktar.setEnhetVild(-1);
                        break;
                    case 2:
                        karaktar.getVildFardighetArrayList().get(rNumber).setT(1);
                        karaktar.setEnhetVild(-1);
                        break;
                    case 3:
                        if (karaktar.getEnhetVild() >= 2){
                            karaktar.getVildFardighetArrayList().get(rNumber).setT(1);
                            karaktar.setEnhetVild(-2);
                        }
                        break;
                    case 4:
                        if (karaktar.getEnhetVild() >= 4){
                            karaktar.getVildFardighetArrayList().get(rNumber).setT(1);
                            karaktar.setEnhetVild(-4);
                        }
                    case 5:
                        break;

                }
            }

        }
    }
    public void rollEventTables (Karaktar karaktar, Connection conn){
        while (karaktar.getFardSlag() != 0) {
            dbTableInteract(karaktar, conn, "farderaventyr", randomNumber(100));
            karaktar.setFardSlag(-1);
        }
        while (karaktar.getKunskapSlag() != 0) {
            dbTableInteract(karaktar, conn, "kunskapmysterier", randomNumber(100));
            karaktar.setKunskapSlag(-1);
        }
        while (karaktar.getStridSlag() != 0) {
            dbTableInteract(karaktar, conn, "striderdrabbningar", randomNumber(100));
            karaktar.setStridSlag(-1);
        }
        while (karaktar.getIntrigSlag() != 0) {
            dbTableInteract(karaktar, conn, "intrigerillgarningar", randomNumber(100));
            karaktar.setIntrigSlag(-1);
        }
    }


        public void dbTableInteract (Karaktar karaktar, Connection conn, String tableName, int id) {
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM "+tableName+" where ID = "+id);
            while (rs.next()){

                switch (tableName){
                    case "arketyp":
                        karaktar.setArketyp(rs.getString("happening"));
                        break;
                    case "folkslag":
                        karaktar.setFolkslag(rs.getString("happening"));
                        break;
                    case "miljo":
                        karaktar.setMiljo(rs.getString("happening"));
                        break;
                    case "bakgrundstabell":
                        karaktar.setBakgrund(rs.getString("happening"));
                        break;
                    case "kamorian":
                        karaktar.setProvTotem(rs.getString("happening"));
                        break;
                    case "jargier":
                        karaktar.setProvTotem(rs.getString("happening"));
                        break;
                    default:
                        if (rs.getString("happening") != null ) {
                            karaktar.getHandelseArrayList().add(rs.getString("happening"));
                        }
                        break;

                }

                karaktar.getGrundAttributsArrayList().get(0).setT(rs.getInt("styrkaTMod"));
                karaktar.getGrundAttributsArrayList().get(0).settMod(rs.getInt("styrkaMod"));
                karaktar.getGrundAttributsArrayList().get(1).setT(rs.getInt("talighetTMod"));
                karaktar.getGrundAttributsArrayList().get(1).settMod(rs.getInt("talighetMod"));
                karaktar.getGrundAttributsArrayList().get(2).setT(rs.getInt("rorlighetTMod"));
                karaktar.getGrundAttributsArrayList().get(2).settMod(rs.getInt("rorlighetMod"));
                karaktar.getGrundAttributsArrayList().get(3).setT(rs.getInt("uppfattningTMod"));
                karaktar.getGrundAttributsArrayList().get(3).settMod(rs.getInt("uppfattningMod"));
                karaktar.getGrundAttributsArrayList().get(4).setT(rs.getInt("psykeTMod"));
                karaktar.getGrundAttributsArrayList().get(4).settMod(rs.getInt("psykeMod"));
                karaktar.getGrundAttributsArrayList().get(5).setT(rs.getInt("visdomTMod"));
                karaktar.getGrundAttributsArrayList().get(5).settMod(rs.getInt("visdomMod"));
                karaktar.getGrundAttributsArrayList().get(6).setT(rs.getInt("utstralningTMod"));
                karaktar.getGrundAttributsArrayList().get(6).settMod(rs.getInt("utstralningMod"));
                karaktar.getGrundAttributsArrayList().get(7).setT(rs.getInt("viljaTMod"));
                karaktar.getGrundAttributsArrayList().get(7).settMod(rs.getInt("viljaMod"));

                karaktar.getHarleddaAttributsArrayList().get(0).setT(rs.getInt("forflyttningTMod"));
                karaktar.getHarleddaAttributsArrayList().get(0).settMod(rs.getInt("forflyttningMod"));
                karaktar.getHarleddaAttributsArrayList().get(1).setT(rs.getInt("reaktionTMod"));
                karaktar.getHarleddaAttributsArrayList().get(1).settMod(rs.getInt("reaktionMod"));
                karaktar.getHarleddaAttributsArrayList().get(2).setT(rs.getInt("intryckTMod"));
                karaktar.getHarleddaAttributsArrayList().get(2).settMod(rs.getInt("intryckMod"));
                karaktar.getHarleddaAttributsArrayList().get(3).setT(rs.getInt("vaksamhetTMod"));
                karaktar.getHarleddaAttributsArrayList().get(3).settMod(rs.getInt("vaksamhetMod"));
                karaktar.getHarleddaAttributsArrayList().get(4).setT(rs.getInt("sjalvkontrollTMod"));
                karaktar.getHarleddaAttributsArrayList().get(4).settMod(rs.getInt("sjalvkontrollMod"));
                karaktar.getHarleddaAttributsArrayList().get(5).setT(rs.getInt("kroppTMod"));
                karaktar.getHarleddaAttributsArrayList().get(5).settMod(rs.getInt("kroppMod"));
                karaktar.getHarleddaAttributsArrayList().get(6).settMod(rs.getInt("livsKraftMod"));
                karaktar.getHarleddaAttributsArrayList().get(7).settMod(rs.getInt("grundSkadaMod"));
                karaktar.getHarleddaAttributsArrayList().get(8).settMod(rs.getInt("grundPansarMod"));



                if (rs.getString("kannetecken1") != null){
                    karaktar.getKanneTeckenArrayList().add(new Kannetecken(rs.getString("kannetecken1"), rs.getInt("kannetecken1Varde"),0));
                }
                if (rs.getString("kannetecken2") != null){
                    karaktar.getKanneTeckenArrayList().add(new Kannetecken(rs.getString("kannetecken2"), rs.getInt("kannetecken2Varde"),0));
                }
                if (rs.getString("kannetecken3") != null){
                    karaktar.getKanneTeckenArrayList().add(new Kannetecken(rs.getString("kannetecken3"), rs.getInt("kannetecken3Varde"),0));
                }
                karaktar.setEnhetKannetecken(rs.getInt("kanneteckenValfri"));
                karaktar.setEnhetExpertis(rs.getInt("expertiserValfri"));

                if (rs.getString("expertis1") != null){
                    karaktar.getExpertisTeckenArrayList().add(new Expertis(rs.getString("expertis1"), rs.getInt("expertis1Varde"),0));
                }
                if (rs.getString("expertis2") != null){
                    karaktar.getExpertisTeckenArrayList().add(new Expertis(rs.getString("expertis2"), rs.getInt("expertis2Varde"),0));
                }

                karaktar.setLattlarda(rs.getInt("lattlarda"));

                if(rs.getString("lattlard1") != null) {
                    karaktar.getLattLardaFardigheterArrayList().add(rs.getString("lattlard1"));
                }
                if(rs.getString("lattlard2") != null) {
                    karaktar.getLattLardaFardigheterArrayList().add(rs.getString("lattlard2"));
                }
                if(rs.getString("lattlard3") != null) {
                    karaktar.getLattLardaFardigheterArrayList().add(rs.getString("lattlard3"));
                }
                if(rs.getString("lattlard4") != null) {
                    karaktar.getLattLardaFardigheterArrayList().add(rs.getString("lattlard4"));
                }

                if(rs.getString("svarlard1") != null) {
                    karaktar.getSvarLardaFardigheterArrayList().add(rs.getString("svarlard1"));
                }
                if(rs.getString("svarlard2") != null) {
                    karaktar.getSvarLardaFardigheterArrayList().add(rs.getString("svarlard2"));
                }
                if (rs.getString("karaktarsdragSekundar") != null) {
                  karaktar.setSekundarKaraktarsdrag(rs.getString("karaktarsdragSekundar"));
                }

                karaktar.setAvtrubbV(rs.getInt("avtrubbVald"));
                karaktar.setAvtrubbU(rs.getInt("avtrubbUtsatt"));
                karaktar.setAvtrubbO(rs.getInt("avtrubbOver"));

                karaktar.setEnhetRor(rs.getInt("enhetRorelse"));
                karaktar.setEnhetStrid(rs.getInt("enhetStrid"));
                karaktar.setEnhetVild(rs.getInt("enhetVild"));
                karaktar.setEnhetKunskap(rs.getInt("enhetKunskap"));
                karaktar.setEnhetMyst(rs.getInt("enhetMystik"));
                karaktar.setEnhetSociala(rs.getInt("enhetSociala"));
                karaktar.setEnhetOvriga(rs.getInt("enhetOvriga"));
                karaktar.setEnhetSprak(rs.getInt("enhetSprak"));

                if (rs.getString("sprak1") != null) {
                    karaktar.getSprakArrayList().add(rs.getString("sprak1"));
                }
                if (rs.getString("sprak2") != null) {
                    karaktar.getSprakArrayList().add(rs.getString("sprak2"));
                }
                if (rs.getString("skrift1") != null) {
                    karaktar.getSkriftArrayList().add(rs.getString("skrift1"));
                }
                if (rs.getString("skrift2") != null) {
                    karaktar.getSkriftArrayList().add(rs.getString("skrift2"));
                }

                karaktar.setEnhetHantverk(rs.getInt("enhetHantverk"));

                if (rs.getString("hantverk1") != null) {
                    karaktar.getHantverkTeckenArrayList().add(new Hantverk((rs.getString("hantverk1")), rs.getInt("hantverk1Varde"),0));
                }
                if (rs.getString("hantverk2") != null) {
                    karaktar.getHantverkTeckenArrayList().add(new Hantverk((rs.getString("hantverk2")), rs.getInt("hantverk2Varde"),0));
                }

                karaktar.setMysterier(rs.getInt("mysterier"));

                if (rs.getString("utrustning1") != null) {
                    karaktar.getUtrustningArrayList().add(rs.getString("utrustning1"));
                }
                if (rs.getString("utrustning2") != null) {
                    karaktar.getUtrustningArrayList().add(rs.getString("utrustning2"));
                }

                karaktar.setStartKapS(rs.getInt("startKapitalS"));

                if (rs.getInt("startKapitalTMod") != 0) {
                    karaktar.getStartkapitalArrayList().add(new Startkapital(rs.getInt("startKapitalTMod"), rs.getInt("startKapitalMod")));
                }

                karaktar.setFardSlag(rs.getInt("fardslag"));
                karaktar.setKunskapSlag(rs.getInt("kunskapSlag"));
                karaktar.setStridSlag(rs.getInt("stridSlag"));
                karaktar.setIntrigSlag(rs.getInt("intrigslag"));
                karaktar.setValfriHandelse(rs.getInt("valfriBakgrund"));
                karaktar.setBelastningMod(rs.getInt("belastning"));

                if (rs.getString("egenskapstext") != null) {
                    karaktar.getSpeciellaEgenskaperArrayList().add(rs.getString("egenskapsText"));
                }
                specialTable(karaktar, conn, tableName, id);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        }




    public void calcHarleddAttribut (HarleddaAttribut harleddaAttribut, GrundAttribut grund1, GrundAttribut grund2) {
        harleddaAttribut.setT((grund1.getT()+grund2.getT())/2);
        harleddaAttribut.settMod((grund1.getTMod() + grund2.getTMod())/2);
    }

    public void calcLivskraft(HarleddaAttribut harleddaAttribut, GrundAttribut tal, GrundAttribut vil){
        int temp = tal.getT() + vil.getT();
        int temp2 = tal.getTMod() + vil.getTMod();
        GrundAttribut tempGrund = new GrundAttribut("temp");
        tempGrund.setT(temp);
        tempGrund.settMod(temp2);
        tempGrund.reCountValue();
        if (tempGrund.getT() < 5) {
            harleddaAttribut.setT(3);
        } else {
            switch (tempGrund.getT()){
                case 5:
                    harleddaAttribut.setT(3);
                    harleddaAttribut.settMod(1);
                    break;
                case 6:
                    harleddaAttribut.setT(3);
                    harleddaAttribut.settMod(2);
                    break;
                case 7:
                    harleddaAttribut.setT(3);
                    harleddaAttribut.settMod(3);
                    break;
                case 8:
                    harleddaAttribut.setT(4);

                    break;
                case 9:
                    harleddaAttribut.setT(4);
                    harleddaAttribut.settMod(1);
                    break;
                case 10:
                    harleddaAttribut.setT(4);
                    harleddaAttribut.settMod(2);
                    break;
                case 11:
                    harleddaAttribut.setT(4);
                    harleddaAttribut.settMod(3);
                    break;
                case 12:
                    harleddaAttribut.setT(5);
                    break;


            }
        }
    }

    public void calcGrundrustning(HarleddaAttribut harleddaAttribut, GrundAttribut tal, GrundAttribut vil){
        int temp = tal.getT() + vil.getT();
        int temp2 = tal.getTMod() + vil.getTMod();
        GrundAttribut tempGrund = new GrundAttribut("temp");
        tempGrund.setT(temp);
        tempGrund.settMod(temp2);
        tempGrund.reCountValue();
        if (tempGrund.getT() < 5) {
            harleddaAttribut.settMod(0);
        } else {
            switch (tempGrund.getT()){
                case 5:

                    harleddaAttribut.settMod(1);
                    break;
                case 6:

                    harleddaAttribut.settMod(2);
                    break;
                case 7:

                    harleddaAttribut.settMod(3);
                    break;
                case 8:
                    harleddaAttribut.settMod(4);

                    break;
                case 9:

                    harleddaAttribut.settMod(5);
                    break;
                case 10:

                    harleddaAttribut.settMod(6);
                    break;
                case 11:

                    harleddaAttribut.settMod(7);
                    break;
                case 12:
                    harleddaAttribut.settMod(8);
                    break;


            }
        }
    }

    public void checkBonuses(Karaktar karaktar){
        for (GrundAttribut element:karaktar.getGrundAttributsArrayList()) {
            element.reCountValue();
        }

        for (int i = 0; i < karaktar.getHarleddaAttributsArrayList().size()-1;i++) {
            karaktar.getHarleddaAttributsArrayList().get(i).reCountValue();
        }

        for (Fardighet element:karaktar.getRorFardighetArrayList()) {
            element.reCountValue();
        }

        for (Fardighet element:karaktar.getSocFardighetArrayList()) {
            element.reCountValue();
        }

        for (Fardighet element:karaktar.getMysFardighetArrayList()) {
            element.reCountValue();
        }

        for (Fardighet element:karaktar.getKunFardighetArrayList()) {
            element.reCountValue();
        }

        for (Fardighet element:karaktar.getVildFardighetArrayList()) {
            element.reCountValue();
        }

        for (Fardighet element:karaktar.getStridFardighetArrayList()) {
            element.reCountValue();
        }
    }



    public void populateBonuses (Karaktar karaktar, int bonus) {
        for (int i = 0;i < 3;i++) {
            switch (randomNumber(6)){
                case 1:
                    int random = randomNumber(karaktar.getStridFardighetArrayList().size())-1;
                    if (karaktar.getStridFardighetArrayList().get(random).getTMod() + bonus < 4 && karaktar.getStridFardighetArrayList().get(random).getT() != 0) {
                        karaktar.getStridFardighetArrayList().get(random).settMod(bonus);
                    }
                    break;
                case 2:
                    int random2 = randomNumber(karaktar.getRorFardighetArrayList().size())-1;
                    if (karaktar.getRorFardighetArrayList().get(random2).getTMod() + bonus < 4 && karaktar.getRorFardighetArrayList().get(random2).getT() != 0) {
                        karaktar.getRorFardighetArrayList().get(random2).settMod(bonus);
                    }
                    break;
                case 3:
                    int random3 = randomNumber(karaktar.getSocFardighetArrayList().size())-1;
                    if (karaktar.getSocFardighetArrayList().get(random3).getTMod() + bonus < 4 && karaktar.getSocFardighetArrayList().get(random3).getT() != 0) {
                        karaktar.getSocFardighetArrayList().get(random3).settMod(bonus);
                    }
                    break;
                case 4:
                    int random4 = randomNumber(karaktar.getMysFardighetArrayList().size())-1;
                    if (karaktar.getMysFardighetArrayList().get(random4).getTMod() + bonus < 4 && karaktar.getMysFardighetArrayList().get(random4).getT() != 0) {
                        karaktar.getMysFardighetArrayList().get(random4).settMod(bonus);
                    }
                    break;
                case 5:
                    int random5 = randomNumber(karaktar.getKunFardighetArrayList().size())-1;
                    if (karaktar.getKunFardighetArrayList().get(random5).getTMod() + bonus < 4 && karaktar.getKunFardighetArrayList().get(random5).getT() != 0) {
                        karaktar.getKunFardighetArrayList().get(random5).settMod(bonus);
                    }
                    break;
                case 6:
                    int random6 = randomNumber(karaktar.getVildFardighetArrayList().size())-1;
                    if (karaktar.getVildFardighetArrayList().get(random6).getTMod() + bonus < 4 && karaktar.getVildFardighetArrayList().get(random6).getT() != 0) {
                        karaktar.getVildFardighetArrayList().get(random6).settMod(bonus);
                    }
                    break;
            }
        }
    }

    public void calcGrundskada(HarleddaAttribut harleddaAttribut, GrundAttribut grund) {
        int temp = (grund.getT()*4 + grund.getTMod())/2;
        while (temp > 3){
            harleddaAttribut.setT(1);
            temp += -4;
        }
        harleddaAttribut.setT(1);
        harleddaAttribut.settMod(temp);

    }


    public void populateObservableGrund (ArrayList<GrundAttribut> grundAttributArray, ObservableList<JavaFXTableData> data){
        for (GrundAttribut grundAttribut : grundAttributArray) {

            data.add(new JavaFXTableData(grundAttribut.getNamn(), grundAttribut.getT(), grundAttribut.getTMod(), lastID));
            lastID++;
        }
    }

    public void populateObservableHarledd (ArrayList<HarleddaAttribut> harleddaAttributArrayList, ObservableList<JavaFXTableData> data) {
        for (HarleddaAttribut harleddaAttribut : harleddaAttributArrayList) {
            data.add(new JavaFXTableData(harleddaAttribut.getName(), harleddaAttribut.getT(), harleddaAttribut.getTMod(), lastID));
            lastID++;
        }
    }
    public void populateObservableFardighet (ArrayList<Fardighet> fardighetArrayList, ObservableList<JavaFXTableData> data){
        for (Fardighet fardighet : fardighetArrayList) {
            data.add(new JavaFXTableData(fardighet.getName(), fardighet.getT(), fardighet.getTMod(), lastID));
            lastID++;
        }
    }



    public void checkPreset (Karaktar karaktar, Connection conn) {
        if (folkslagText.getText().isEmpty()){
            dbTableInteract(karaktar,conn, "folkslag", randomNumber(12));
        } else {
            switch (folkslagText.getText()){
                case "Adasier":
                    dbTableInteract(karaktar,conn, "folkslag", 1);
                    break;
                case "Cirefalier":
                    dbTableInteract(karaktar,conn, "folkslag", 2);
                    break;
                case "Fedaki":
                    dbTableInteract(karaktar,conn, "folkslag", 3);
                    break;
                case "Genver":
                    dbTableInteract(karaktar,conn, "folkslag", 4);
                    break;
                case "Jahann":
                    dbTableInteract(karaktar,conn, "folkslag", 5);
                    break;
                case "Jargier":
                    dbTableInteract(karaktar,conn, "folkslag", 6);
                    break;
                case "Kamorian":
                    dbTableInteract(karaktar,conn, "folkslag", 7);
                    break;
                case "Marnakh-Tirak":
                    dbTableInteract(karaktar,conn, "folkslag", 8);
                    break;
                case "Missla":
                    dbTableInteract(karaktar,conn, "folkslag", 9);
                    break;
                case "Pyar-Alv":
                    dbTableInteract(karaktar,conn, "folkslag", 10);
                    break;
                case "Taup":
                    dbTableInteract(karaktar,conn, "folkslag", 11);
                    break;
                case "Zolod-Dvärg":
                    dbTableInteract(karaktar,conn, "folkslag", 12);
                    break;

            }
        }

        if (miljoText.getText().isEmpty()){
            dbTableInteract(karaktar,conn, "miljo", randomNumber(7));
        } else {
            switch (miljoText.getText()) {
                case "Hav":
                    dbTableInteract(karaktar,conn, "miljo", 1);
                    break;
                case "Hov":
                    dbTableInteract(karaktar,conn, "miljo", 2);
                    break;
                case "Landsbygd":
                    dbTableInteract(karaktar,conn, "miljo", 3);
                    break;
                case "Lärosäte":
                    dbTableInteract(karaktar,conn, "miljo", 4);
                    break;
                case "Stad":
                    dbTableInteract(karaktar,conn, "miljo", 5);
                    break;
                case "Undre världen":
                    dbTableInteract(karaktar,conn, "miljo", 6);
                    break;
                case "Vildmark":
                    dbTableInteract(karaktar,conn, "miljo", 7);
                    break;
            }
        }

        if (arketypText.getText().isEmpty()){
            dbTableInteract(karaktar,conn, "arketyp", randomNumber(7));
        } else {
            switch (arketypText.getText()) {
                case "Donare":
                    dbTableInteract(karaktar,conn, "arketyp", 1);
                    break;
                case "Krigare":
                    dbTableInteract(karaktar,conn, "arketyp", 2);
                    break;
                case "Ledare":
                    dbTableInteract(karaktar,conn, "arketyp", 3);
                    break;
                case "Lärd":
                    dbTableInteract(karaktar,conn, "arketyp", 4);
                    break;
                case "Mystiker":
                    dbTableInteract(karaktar,conn, "arketyp", 5);
                    break;
                case "Skugga":
                    dbTableInteract(karaktar,conn, "arketyp", 6);
                    break;
                case "Underhållare":
                    dbTableInteract(karaktar,conn, "arketyp", 7);
                    break;
            }
        }

    }

    @FXML
    void ignoreraClicked(ActionEvent event) {
        System.out.println("Ignorera clicked");
        setCurrentSelection(null);
        grundAttributTable.getSelectionModel().clearSelection();
        harleddaAttributTable.getSelectionModel().clearSelection();
        stridsFardigheterTable.getSelectionModel().clearSelection();
        rorelseFardigheterTable.getSelectionModel().clearSelection();
        mystikFardighetTable.getSelectionModel().clearSelection();
        socialFardighetTable.getSelectionModel().clearSelection();
        kunskapsFardighetTable.getSelectionModel().clearSelection();
        vildmarksFardighetTable.getSelectionModel().clearSelection();





    }


    @FXML
    void uppdateraTableClicked(ActionEvent event) {
        JavaFXTableData data = selectionMap.get(currentSelection.getId());
        data.setName(currentSelection.getName());
        data.setT(currentSelection.getT());
        data.setTmod(currentSelection.getTmod());
        data.setId(currentSelection.getId());
        setCurrentSelection(null);
    }


    private void setCurrentSelection (JavaFXTableData selection) {
        if (selection != null) {
            currentSelection.setId(selection.getId());
            currentSelection.setName(selection.getName());
            currentSelection.setT(selection.getT());
            currentSelection.setTmod(selection.getTmod());
        } else {
            currentSelection.setId(null);
            currentSelection.setName("");
            currentSelection.setT(0);
            currentSelection.setTmod(0);
        }

    }


    public void populateHash (ObservableList<JavaFXTableData> data, HashMap<Integer, JavaFXTableData> selectionMap) {
        for (JavaFXTableData element:data
             ) { selectionMap.put(element.getId(), element);

        }
    }


    
    public void calculateStartKapital (Karaktar karaktar) {
        for (Startkapital element:karaktar.getStartkapitalArrayList()) {

            while (element.getT() != 0){
                int temp = randomNumber(6);
                if (temp == 6) {
                    element.setT(1);
                } else {
                    karaktar.setStartKapS(randomNumber(6) * element.getTMod());
                    element.setT(-1);

                }

            }


        }
    }

    public void valfriaSpecial (Karaktar karaktar, Connection conn) {
        if (karaktar.getEnhetExpertis() != 0){
            while (karaktar.getEnhetExpertis() > 0){
                dbTableInteract(karaktar,conn, "expertiser", randomNumber(100));
                karaktar.setEnhetExpertis(-1);
            }
        }

        if (karaktar.getEnhetHantverk() != 0){
            while (karaktar.getEnhetHantverk() > 0) {
                dbTableInteract(karaktar,conn, "hantverk", randomNumber(74));
                karaktar.setEnhetHantverk(-1);

            }
        }

        if (karaktar.getEnhetKannetecken() != 0) {
            while (karaktar.getEnhetKannetecken() > 0){
                dbTableInteract(karaktar,conn, "kannetecken", randomNumber(50));
                karaktar.setEnhetKannetecken(-1);
            }
        }


    }



    @FXML
    void uppdateraFaltClicked (ActionEvent event) {

        karaktar.setFornamn(fornamnText.getText());
        karaktar.setEfternamn(efternamnText.getText());
        karaktar.setVarv(varvText.getText());
        karaktar.setReligion(religionText.getText());
        karaktar.setKon(konText.getText());
        karaktar.setValmaende(valmaendeSpinner.getValue());
        karaktar.changeAvtrubbV(avtrubbVSpinner.getValue());
        karaktar.changeAvtrubbU(avtrubbUSpinner.getValue());
        karaktar.changeAvtrubbO(avtrubbOSpinner.getValue());
        System.out.println(karaktar.toString());
    }

    @FXML
    void printToPdfFull (ActionEvent event) {
        transportDataToKaraktar();
        PdfMigration mig = new PdfMigration(karaktar);
        mig.exportToPdf();
    }

    public void transportDataToKaraktar () {
        for (int i = 0; i < fKList.size();i++) {
            karaktar.getKunFardighetArrayList().get(i).changeT(fKList.get(i).getT());
            karaktar.getKunFardighetArrayList().get(i).changeTMod(fKList.get(i).getTmod());
        }

        for (int i = 0; i < fMList.size();i++) {
            karaktar.getMysFardighetArrayList().get(i).changeT(fMList.get(i).getT());
            karaktar.getMysFardighetArrayList().get(i).changeTMod(fMList.get(i).getTmod());
        }

        for (int i = 0; i < fRList.size();i++) {
            karaktar.getRorFardighetArrayList().get(i).changeT(fRList.get(i).getT());
            karaktar.getRorFardighetArrayList().get(i).changeTMod(fRList.get(i).getTmod());
        }

        for (int i = 0; i < fSList.size();i++) {
            karaktar.getStridFardighetArrayList().get(i).changeT(fSList.get(i).getT());
            karaktar.getStridFardighetArrayList().get(i).changeTMod(fSList.get(i).getTmod());
        }

        for (int i = 0; i < fSocList.size();i++) {
            karaktar.getSocFardighetArrayList().get(i).changeT(fSocList.get(i).getT());
            karaktar.getSocFardighetArrayList().get(i).changeTMod(fSocList.get(i).getTmod());
        }

        for (int i = 0; i < fVList.size();i++) {
            karaktar.getVildFardighetArrayList().get(i).changeT(fVList.get(i).getT());
            karaktar.getVildFardighetArrayList().get(i).changeTMod(fVList.get(i).getTmod());
        }
        for (int i = 0; i < gAList.size();i++) {
            karaktar.getGrundAttributsArrayList().get(i).changeT(gAList.get(i).getT());
            karaktar.getGrundAttributsArrayList().get(i).changeTMod(gAList.get(i).getTmod());
        }
        for (int i = 0; i < hAList.size();i++) {
            karaktar.getHarleddaAttributsArrayList().get(i).changeT(hAList.get(i).getT());
            karaktar.getHarleddaAttributsArrayList().get(i).changeTMod(hAList.get(i).getTmod());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void initializeData(TransportedData data) {

        if (!data.getFolkslag().equals("Slumpa")) {
            folkslagText.setText(data.getFolkslag());
        }
        if (!data.getMiljo().equals("Slumpa")) {
            miljoText.setText(data.getMiljo());
        }
        if (!data.getArketyp().equals("Slumpa")) {
            arketypText.setText(data.getArketyp());
        }


        karaktar = new Karaktar();
        DbConnector dbConnector = new DbConnector();
        Connection conn = dbConnector.connect();
        checkPreset(karaktar, conn);

        dbTableInteract(karaktar,conn, "bakgrundstabell", randomNumber(100));


        calcValfriBakgrund(karaktar);

        rollEventTables(karaktar, conn);

        calcValfriaFardighetsEnheter(karaktar);
        checkBonuses(karaktar);
        calcRandomGrundAttribut(karaktar);
        kopaFardigheter(karaktar);

        calcHarleddAttribut(karaktar.getHarleddaAttributsArrayList().get(0),karaktar.getGrundAttributsArrayList().get(2),karaktar.getGrundAttributsArrayList().get(1));
        calcHarleddAttribut(karaktar.getHarleddaAttributsArrayList().get(2),karaktar.getGrundAttributsArrayList().get(6),karaktar.getGrundAttributsArrayList().get(5));
        calcHarleddAttribut(karaktar.getHarleddaAttributsArrayList().get(5),karaktar.getGrundAttributsArrayList().get(0),karaktar.getGrundAttributsArrayList().get(1));
        calcHarleddAttribut(karaktar.getHarleddaAttributsArrayList().get(1),karaktar.getGrundAttributsArrayList().get(2),karaktar.getGrundAttributsArrayList().get(3));
        calcHarleddAttribut(karaktar.getHarleddaAttributsArrayList().get(4),karaktar.getGrundAttributsArrayList().get(4),karaktar.getGrundAttributsArrayList().get(7));
        calcHarleddAttribut(karaktar.getHarleddaAttributsArrayList().get(3),karaktar.getGrundAttributsArrayList().get(4),karaktar.getGrundAttributsArrayList().get(3));
        calcLivskraft(karaktar.getHarleddaAttributsArrayList().get(6), karaktar.getGrundAttributsArrayList().get(1), karaktar.getGrundAttributsArrayList().get(7));
        calcGrundrustning(karaktar.getHarleddaAttributsArrayList().get(8), karaktar.getGrundAttributsArrayList().get(0), karaktar.getGrundAttributsArrayList().get(1));
        calcGrundskada(karaktar.getHarleddaAttributsArrayList().get(7), karaktar.getGrundAttributsArrayList().get(0));

        populateBonuses(karaktar, 1);
        populateBonuses(karaktar, 2);
        populateBonuses(karaktar, 3);

        checkBonuses(karaktar);
        calculateStartKapital(karaktar);
        valfriaSpecial(karaktar, conn);


        //Population of fields
        folkslagText.setText(karaktar.getFolkslag());
        arketypText.setText(karaktar.getArketyp());
        bakgrundText.setText(karaktar.getBakgrund());
        miljoText.setText(karaktar.getMiljo());

        if (karaktar.getSekundarKaraktarsdrag() != null) {
            sekKarText.setText(karaktar.getSekundarKaraktarsdrag());
        }


        provTotemText.setText(karaktar.getProvTotem());

        valmaendeSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,karaktar.getValmaende()));
        avtrubbVSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,karaktar.getAvtrubbV()));
        avtrubbUSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,karaktar.getAvtrubbU()));
        avtrubbOSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,karaktar.getAvtrubbO()));



        editMod.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,3,0));
        editTMod.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,0));




        populateObservableGrund(karaktar.getGrundAttributsArrayList(), gAList);
        populateHash(gAList, selectionMap);
        populateObservableHarledd(karaktar.getHarleddaAttributsArrayList(), hAList);
        populateHash(hAList, selectionMap);
        populateObservableFardighet(karaktar.getStridFardighetArrayList(),fSList);
        populateHash(fSList, selectionMap);
        populateObservableFardighet(karaktar.getRorFardighetArrayList(),fRList);
        populateHash(fRList, selectionMap);
        populateObservableFardighet(karaktar.getMysFardighetArrayList(),fMList);
        populateHash(fMList, selectionMap);
        populateObservableFardighet(karaktar.getSocFardighetArrayList(),fSocList);
        populateHash(fSocList, selectionMap);
        populateObservableFardighet(karaktar.getKunFardighetArrayList(),fKList);
        populateHash(fKList, selectionMap);
        populateObservableFardighet(karaktar.getVildFardighetArrayList(),fVList);
        populateHash(fVList, selectionMap);


        grundAttributTable.setItems(gAList);
        grundAttributNamn.setCellValueFactory(rowData -> rowData.getValue().nameProperty());
        grundAttributT.setCellValueFactory(rowData -> rowData.getValue().tProperty());
        grundAttributMod.setCellValueFactory(rowData -> rowData.getValue().tmodProperty());

        harleddaAttributTable.setItems(hAList);
        harleddAttribut.setCellValueFactory(rowData -> rowData.getValue().nameProperty());
        harleddT.setCellValueFactory(rowData -> rowData.getValue().tProperty());
        harleddMod.setCellValueFactory(rowData -> rowData.getValue().tmodProperty());

        stridsFardigheterTable.setItems(fSList);
        sFardighet.setCellValueFactory(rowData -> rowData.getValue().nameProperty());
        sFardighetT.setCellValueFactory(rowData -> rowData.getValue().tProperty());
        sFardighetMod.setCellValueFactory(rowData -> rowData.getValue().tmodProperty());

        rorelseFardigheterTable.setItems(fRList);
        rFardighet.setCellValueFactory(rowData -> rowData.getValue().nameProperty());
        rFardighetT.setCellValueFactory(rowData -> rowData.getValue().tProperty());
        rFardighetMod.setCellValueFactory(rowData -> rowData.getValue().tmodProperty());

        mystikFardighetTable.setItems(fMList);
        mFardighet.setCellValueFactory(rowData -> rowData.getValue().nameProperty());
        mFardighetT.setCellValueFactory(rowData -> rowData.getValue().tProperty());
        mFardighetMod.setCellValueFactory(rowData -> rowData.getValue().tmodProperty());

        socialFardighetTable.setItems(fSocList);
        socFardighet.setCellValueFactory(rowData -> rowData.getValue().nameProperty());
        socFardighetT.setCellValueFactory(rowData -> rowData.getValue().tProperty());
        socFardighetMod.setCellValueFactory(rowData -> rowData.getValue().tmodProperty());

        kunskapsFardighetTable.setItems(fKList);
        kFardighet.setCellValueFactory(rowData -> rowData.getValue().nameProperty());
        kFardighetT.setCellValueFactory(rowData -> rowData.getValue().tProperty());
        kFardighetMod.setCellValueFactory(rowData -> rowData.getValue().tmodProperty());

        vildmarksFardighetTable.setItems(fVList);
        vFardighet.setCellValueFactory(rowData -> rowData.getValue().nameProperty());
        vFardighetT.setCellValueFactory(rowData -> rowData.getValue().tProperty());
        vFardighetMod.setCellValueFactory(rowData -> rowData.getValue().tmodProperty());





        editEgenskap.textProperty().bindBidirectional(currentSelection.nameProperty());
        editMod.getValueFactory().valueProperty().bindBidirectional(currentSelection.tmodProperty());
        editTMod.getValueFactory().valueProperty().bindBidirectional(currentSelection.tProperty());


        grundAttributTable.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends JavaFXTableData> observable, JavaFXTableData oldValue, JavaFXTableData newValue) -> {
            setCurrentSelection(newValue);
        });
        harleddaAttributTable.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends JavaFXTableData> observable, JavaFXTableData oldValue, JavaFXTableData newValue) -> {
            setCurrentSelection(newValue);
        });
        stridsFardigheterTable.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends JavaFXTableData> observable, JavaFXTableData oldValue, JavaFXTableData newValue) -> {
            setCurrentSelection(newValue);
        });
        rorelseFardigheterTable.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends JavaFXTableData> observable, JavaFXTableData oldValue, JavaFXTableData newValue) -> {
            setCurrentSelection(newValue);
        });
        mystikFardighetTable.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends JavaFXTableData> observable, JavaFXTableData oldValue, JavaFXTableData newValue) -> {
            setCurrentSelection(newValue);
        });
        socialFardighetTable.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends JavaFXTableData> observable, JavaFXTableData oldValue, JavaFXTableData newValue) -> {
            setCurrentSelection(newValue);
        });
        kunskapsFardighetTable.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends JavaFXTableData> observable, JavaFXTableData oldValue, JavaFXTableData newValue) -> {
            setCurrentSelection(newValue);
        });
        vildmarksFardighetTable.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends JavaFXTableData> observable, JavaFXTableData oldValue, JavaFXTableData newValue) -> {
        });

        System.out.println(karaktar.toString());

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}