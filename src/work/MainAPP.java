package work;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainAPP extends Application {
    public static Stage mainStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage=primaryStage;
        Pane root= FXMLLoader.load(getClass().getResource("view/MainScene.fxml"));
        Scene scene=new Scene(root,600,400);
        primaryStage.setTitle("简易歌唱比赛系统");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //界面跳转
    public static void setRoot(String address) throws Exception{
        Pane root=FXMLLoader.load(MainAPP.class.getResource(address));
        Scene scene=new Scene(root,600,400);
        mainStage.setScene(scene);
        mainStage.show();
    }

    //提示界面
    public static void toRemindScene(String text){
        Stage primaryStage = new Stage();
        Pane root = new Pane();
        Label label=new Label(text);
        label.setTranslateY(60);
        label.setFont(Font.font(20));
        // 将 TextField 添加到 Pane 中
        root.getChildren().add(label);

        Scene scene = new Scene(root, 300, 150);
        primaryStage.setTitle("提示信息");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
