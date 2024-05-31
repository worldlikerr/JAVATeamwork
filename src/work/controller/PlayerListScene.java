package work.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import work.MainAPP;
import work.entity.PlayerList;

import java.util.ArrayList;
import java.util.Objects;

import static java.lang.StringTemplate.STR;

public class PlayerListScene {
    public ListView<String> textList;
    public ComboBox<String> sortChoice;
    public ComboBox<String> sortBoolChoice;
    public TextField player_id;
    public PlayerList playerList=PlayerList.getInstance();

    //初始化
    @FXML
    private void initialize(){
        sortChoice.getItems().addAll("学号","学院","报名时间","性别");
        sortChoice.setValue("学号");

        sortBoolChoice.getItems().addAll("正序","逆序");
        sortBoolChoice.setValue("正序");
    }

    //排序
    public void confirmForSort(ActionEvent actionEvent) {
        String s=sortChoice.getValue();
        boolean b=(Objects.equals(sortBoolChoice.getValue(), "正序"));
        sort(s,b);
        update();
    }
    private void sort(String s,boolean b){
        switch (s){
            case "学号"->playerList.sortByID(b);
            case "学院"->playerList.sortByCollageName(b);
            case "报名时间"->playerList.sortByRegistrationTime(b);
            case "性别"->playerList.sortByGender(b);
        }
    }

    //更新列表
    public void update(){
        ArrayList<String> arrayList=new ArrayList<>();
        for(var v:playerList.playerArrayList){
            arrayList.add(STR."\{v.getName()} \{v.getPlayer_id()} \{v.getGender().getGender()} \{v.getCollege_name()} \{v.getBirthday()} \{v.getMusic_name()} \{v.getRegistration_time()}");
        }

        ObservableList<String> observableList = FXCollections.observableArrayList(arrayList);
        textList.setItems(observableList);
    }

    //删除对应选手
    public void confirmForDelete(ActionEvent actionEvent) {
        playerList.deletePlayer(player_id.getText());
        update();
    }

    //返回主界面
    public void back(ActionEvent actionEvent) throws Exception {
        MainAPP.setRoot("view/MainScene.fxml","主界面");
    }
}
