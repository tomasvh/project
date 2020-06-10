package com.npcmaker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConfigFullFXMLcontroller implements Initializable {


    @FXML
    public Button buttonReturn;

    @FXML
    public Button buttonGenerera;

    @FXML
    public ComboBox<String> comboFolkslag;

    public ComboBox<String> comboMiljo;

    public ComboBox<String> comboArketyp;


    public void changeScreen(ActionEvent event){
        try {

            TransportedData data = new TransportedData();

            data.setFolkslag(comboFolkslag.getValue().toString());
            data.setMiljo(comboMiljo.getValue().toString());
            data.setArketyp(comboArketyp.getValue().toString());


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/PreviewFullFXML.fxml"));

            Parent tableViewParent = loader.load();

            PreviewFullFXMLcontroller controller = loader.getController();
            controller.initializeData(data);

            Scene tableViewScene = new Scene(tableViewParent);


            //Get stage info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void changeReturn(ActionEvent event){
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("../../../resources/EntryFullFXML.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //Get stage info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void changeDataFolkslag(ActionEvent event, TransportedData data) {
        String temp = comboFolkslag.getSelectionModel().getSelectedItem().toString();
        data.setFolkslag(temp);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> folkslagList = FXCollections.observableArrayList();
        ObservableList<String> miljoList = FXCollections.observableArrayList();
        ObservableList<String> arketypList = FXCollections.observableArrayList();

        folkslagList.addAll("Slumpa","Adasier", "Cirefalier", "Fedaki", "Genver", "Jahann", "Jargier", "Kamorian", "Marnakh-Tirak", "Missla", "Pyar-Alv", "Taup", "Zolod-Dvärg");
        miljoList.addAll("Slumpa","Hav", "Hov", "Landsbygd", "Lärosäte", "Stad", "Undre världen", "Vildmark");
        arketypList.addAll("Slumpa","Donare", "Krigare", "Ledare", "Lärd", "Mystiker", "Skugga", "Underhållare");

        comboFolkslag.setItems(folkslagList);
        comboMiljo.setItems(miljoList);
        comboArketyp.setItems(arketypList);

        comboFolkslag.getSelectionModel().selectFirst();
        comboMiljo.getSelectionModel().selectFirst();
        comboArketyp.getSelectionModel().selectFirst();











    }
}