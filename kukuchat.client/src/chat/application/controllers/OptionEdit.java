package chat.application.controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OptionEdit {
    public TextField edNickname;

    private String userName;

    public void setUserName(String nickname){
        this.userName = nickname;
        edNickname.setText(nickname);
    }

    public String getUserName(){
        return this.userName;
    }

    public void btCansel(ActionEvent actionEvent) {
        Node source = (Node)actionEvent.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.hide();
    }

    public void btOK(ActionEvent actionEvent) {
        userName = edNickname.getText();
        btCansel(actionEvent);
    }
}
