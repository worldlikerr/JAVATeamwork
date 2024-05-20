package work;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Test extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane= FXMLLoader.load(getClass().getResource("view/TestScene.fxml"));
        Scene scene=new Scene(pane,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
        System.out.println("dream6好帅啊！");
    }
}
