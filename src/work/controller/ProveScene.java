package work.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import work.MainAPP;

import java.util.Objects;
//验证界面控制器
public class ProveScene {
    //输入的密码
    public PasswordField inputWord;
    //设置的密码
    private final String password="114514";

    //确定
    public void confirm(ActionEvent actionEvent) throws Exception {
        if (Objects.equals(inputWord.getText(), password)){
            switch (MainScene.sceneIndex){
                case 0->MainAPP.setRoot("view/MarkScene1.fxml","评分界面");
                case 1->MainAPP.setSpecialRoot("view/PlayerListScene.fxml","报名选手名单");
            }
        }
        else
            MainAPP.toRemindScene("密码错误");
    }

    public String getPassword() {
        return password;
    }

    public void back(ActionEvent actionEvent) throws Exception {
        MainAPP.setRoot("view/MainScene.fxml","主界面");
    }
}
