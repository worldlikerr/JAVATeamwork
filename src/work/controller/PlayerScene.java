package work.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import work.MainAPP;
import work.entity.Gender;
import work.entity.Player;
import work.entity.PlayerList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
//报名界面控制器
public class PlayerScene {
    public TextField name;
    public TextField player_id;
    public TextField college_name;
    public TextField music_name;
    public ComboBox<String> gender;
    public TextField year;
    public TextField month;
    public TextField day;
    public PlayerList playerList=PlayerList.getInstance();
    //初始化
    @FXML
    private void initialize(){
        gender.getItems().addAll("男","女");
    }
    public void confirm(ActionEvent actionEvent)
    {
        try {
            Player player=new Player(name.getText(),
                    player_id.getText(),
                    Objects.equals(gender.getValue(), "男") ?Gender.M:Gender.W,
                    college_name.getText(),String.format("%d-%02d-%02d",Integer.parseInt(year.getText()),
                    Integer.parseInt(month.getText()),
                    Integer.parseInt(day.getText())),
                    music_name.getText(),
                    getTime());
            MainAPP.toRemindScene(playerList.addPlayer(player)?"报名成功":"您已报名或人数已达上限");
        }catch (Exception e){
            MainAPP.toRemindScene("请检查是否有信息未输入");
        }
    }
    private String getTime(){
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();
        // 格式化日期
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return currentDate.format(formatter);
    }

    public void back(ActionEvent actionEvent) throws Exception {
        MainAPP.setRoot("view/MainScene.fxml","主界面");
    }
}
