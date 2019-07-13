package chat.application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import models.ChatAppication;
import javafx.stage.Modality;

import java.io.*;

public class Controller {
    public TextField tbMessage;
    public static ChatAppication chatAppication;
    public Button btOption;

    public String userName = "anonim";

    private FXMLLoader loader = new FXMLLoader();
    private OptionEdit optionDialog ;
    public Parent optionDialogParent;
    private Stage optionDialogStage;

    @FXML
    private void initialize(){
        try{
            loader.setLocation(getClass().getResource("../fxmlwindow/optionwindow.fxml"));
            optionDialogParent = loader.load();
            optionDialog = loader.getController();
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public void btSendMessage(ActionEvent actionEvent) {
        if (!tbMessage.getText().equals("")){
            chatAppication.appendMessage(tbMessage.getText());
            tbMessage.setText("");
        }
    }

    public void edSendMessage(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER){
            if (!tbMessage.getText().equals("")){
                chatAppication.appendMessage(tbMessage.getText());
            }
            tbMessage.setText("");
        }
    }

    public void tbOption(ActionEvent actionEvent) throws Exception {
        if (optionDialogStage == null){
            optionDialogStage = new Stage();
            optionDialogStage.setTitle("Options");
            optionDialogStage.setResizable(false);
            optionDialogStage.setScene(new Scene(optionDialogParent, 300,200));
            optionDialogStage.initModality(Modality.WINDOW_MODAL);
            optionDialogStage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
        }
        optionDialog.setUserName(userName);
        optionDialogStage.showAndWait();
        Node source = (Node)actionEvent.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.setTitle(optionDialog.getUserName());
        userName = optionDialog.getUserName();
        chatAppication.setNickname(optionDialog.getUserName());
    }
}
