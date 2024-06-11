package work;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Objects;

//程序入口
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



    /**
     *界面跳转
     * @param address
     * 控制器地址
     * @param title
     * 界面标题
     * @throws Exception
     */
    public static void setRoot(String address,String title) throws Exception{
        Pane root=FXMLLoader.load(MainAPP.class.getResource(address));
        Scene scene=new Scene(root,600,400);
        mainStage.setTitle(title);
        mainStage.setScene(scene);
        mainStage.show();
    }
    public static void setSpecialRoot(String address,String title) throws Exception{
        //使用SplitPane界面使用该方法
        SplitPane root=FXMLLoader.load(MainAPP.class.getResource(address));
        Scene scene=new Scene(root,600,400);
        mainStage.setTitle(title);
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     * 另外弹出的的提示界面
     * @param text
     * 弹出界面内显示的文本
     */
    public static void toRemindScene(String text){
        Stage primaryStage = new Stage();
        Pane root = new Pane();
        //设置输出信息
        Label label=new Label(text);
        label.setTranslateY(60);
        label.setTranslateX(50);
        label.setFont(Font.font(20));
        //添加输出信息
        root.getChildren().add(label);

        //设置图片
        Image image=new Image("work/resource/image/Snipaste_2024-06-10_14-40-54.png");
        ImageView imageView=new ImageView(image);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        imageView.setY(60);
        //添加图片
        if (!Objects.equals(text, "报名成功"))
            root.getChildren().add(imageView);

        Scene scene = new Scene(root, 300, 150);
        primaryStage.setTitle("错误");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
