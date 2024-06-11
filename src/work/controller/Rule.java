package work.controller;

import javafx.fxml.FXML;
import work.MainAPP;

public class Rule
{
    @FXML
    public void return1() throws Exception {
        MainAPP.setRoot("view/MarkScene1.fxml","第一轮比赛");
    }

    @FXML
    public void return2() throws Exception {
        MainAPP.setRoot("view/MarkScene2.fxml","半决赛");
    }

    @FXML
    public void return3() throws Exception {
        MainAPP.setRoot("view/MarkScene3.fxml","决赛");
    }
}
