package work.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import work.MainAPP;

import java.util.Objects;

public class ProveScene {
    //输入的密码
    public PasswordField inputWord;
    //设置的密码
    private final String password="114514";

    //确定
    public void confirm(ActionEvent actionEvent) throws Exception {
        if (Objects.equals(inputWord.getText(), password))
            MainAPP.setRoot("view/MarkScene.fxml");
        else
            MainAPP.toRemindScene("密码错误");
    }

    public String getPassword() {
        return password;
    }
}
