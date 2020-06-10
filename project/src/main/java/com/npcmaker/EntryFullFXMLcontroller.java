package com.npcmaker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class EntryFullFXMLcontroller implements Initializable {


    @FXML
    public Button buttonFullstandig;


    public void changeScreen(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ConfigFullFXML.fxml"));

            Parent tableViewParent = loader.load();
            Scene tableViewScene = new Scene(tableViewParent);

            //Access the controller and call a method
            ConfigFullFXMLcontroller controller = loader.getController();


            //Get stage info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DbConnector dbConnector = new DbConnector();
        Connection conn = dbConnector.connect();
        PdfExtractor pdf = new PdfExtractor();
        pdf.extractPDF();




    }
}
