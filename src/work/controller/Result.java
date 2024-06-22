package work.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import work.MainAPP;
import work.entity.Player;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Result implements Initializable {
    @FXML
    private TableColumn<Player,String> name;
    @FXML
    private TableColumn<Player,String> id;
    @FXML
    private TableColumn<Player,String> music;
    @FXML
    private TableView<Player> playerTableView;
    private List<Player> PlayerList;
    private ObservableList<Player> PlayertObservableList;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        PlayerList=new ArrayList<>();
        PlayerList.addAll(MarkScene3.getOutPlayer());
        PlayerList.addAll(MarkScene2.getOutPlayer());
        PlayerList.addAll(MarkScene1.getOutPlayer());
        PlayertObservableList= FXCollections.observableArrayList(PlayerList);
        playerTableView.setItems(PlayertObservableList);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        id.setCellValueFactory(new PropertyValueFactory<>("player_id"));
        music.setCellValueFactory(new PropertyValueFactory<>("music_name"));
    }

    @FXML
    public void back() throws Exception {
        MainAPP.setRoot("view/MainScene.fxml","主界面");
    }
}
