package work.controller;

import javafx.fxml.FXML;
import work.MainAPP;

public class Rule
{
    @FXML
    public void startCompetition() throws Exception {
        MainAPP.setRoot("view/MarkScene1.fxml","第一轮比赛");
    }
}
