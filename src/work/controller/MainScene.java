package work.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import work.MainAPP;

public class MainScene {
    //比骚进行阶段
    public static int gameStage;

    //初始化
    @FXML
    private void initialize(){
        gameStage=1;
    }

    //前往报名界面
    public void ToApplyScene(ActionEvent actionEvent) throws Exception {
        if (gameStage==0){
            MainAPP.setRoot("view/PlayerScene.fxml");
        }else {
            MainAPP.toRemindScene("报名截止");
        }
    }

    //前往打分界面
    public void ToMarkScene(ActionEvent actionEvent) throws Exception {
        if (gameStage==1){
            MainAPP.setRoot("view/ProveScene.fxml");
        }else{
            MainAPP.toRemindScene("打分结束或未开始");
        }
    }

    //获取比赛结果
    public void GetResult(ActionEvent actionEvent) {
    }
}
