package work.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import work.MainAPP;

public class MainScene {
    //比赛进行阶段
    public static int gameStage;
    //
    public static int sceneIndex;

    //初始化
    @FXML
    private void initialize(){
        sceneIndex=0;
        gameStage=1;
    }

    //前往报名界面
    public void ToApplyScene(ActionEvent actionEvent) throws Exception {
        if (gameStage==0){
            MainAPP.setRoot("view/PlayerScene.fxml","报名界面");
        }else {
            MainAPP.toRemindScene("报名截止");
        }
    }

    //前往打分界面
    public void ToMarkScene(ActionEvent actionEvent) throws Exception {
        if (gameStage==1){
            MainScene.sceneIndex=0;
            MainAPP.setRoot("view/ProveScene.fxml","验证界面");
        }else{
            MainAPP.toRemindScene("打分结束或未开始");
        }
    }

    //获取比赛结果
    public void GetResult(ActionEvent actionEvent) {
    }

    public void ToPlayerListScene(ActionEvent actionEvent) throws Exception {
//        MainAPP.setSpecialRoot("view/PlayerListScene.fxml","报名选手名单");
        MainScene.sceneIndex=1;
        MainAPP.setRoot("view/ProveScene.fxml","验证界面");
    }
}
