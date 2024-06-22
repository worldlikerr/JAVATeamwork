package work.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import work.MainAPP;
import work.entity.Judges;
import work.entity.Player;
import work.entity.PlayerList;

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class MarkScene3 implements Initializable {
    @FXML
    private TextField judgeOne;
    @FXML
    private TextField judgeTwo;
    @FXML
    private TextField judgeThree;
    @FXML
    private TextField judgeFour;
    @FXML
    private TextField judgeFive;
    @FXML
    private TextField Grade1;
    @FXML
    private TextField Grade2;
    @FXML
    private TextField Grade3;
    @FXML
    private TextField Grade4;
    @FXML
    private TextField Grade5;
    private int currentCompetitor;
    public static boolean END=false;

    //获取最终的选手
    private static List<Player> outPlayer=new ArrayList<>();

    public static List<Player> getOutPlayer() {
        return outPlayer;
    }

    //打分
    @FXML
    public void mark()
    {
        List<Double> theGrade=new ArrayList<>();
        for(int i=1;i<=5;i++)
        {
            String[] temp=switch (i)   //读取五个框内的数据，然后赋值给对应的评委
            {
                case 1->judgeOne.getText().split("[ ,，]");
                case 2->judgeTwo.getText().split("[ ,，]");
                case 3->judgeThree.getText().split("[ ,，]");
                case 4->judgeFour.getText().split("[ ,，]");
                default -> judgeFive.getText().split("[ ,，]");
            };
            System.out.print(i);
            Judges.getJudgeList().get(i-1).setSingGrade(Integer.parseInt(temp[0]));
            Judges.getJudgeList().get(i-1).setPerformGrade(Integer.parseInt(temp[1]));
            Judges.getJudgeList().get(i-1).setFaceGrade(Integer.parseInt(temp[2]));
            switch (i)
            {
                case 1:Grade1.setText(STR."\{Judges.getJudgeList().get(i-1).getSumGrade()}"); theGrade.add(Judges.getJudgeList().get(i-1).getSumGrade()); break;
                case 2:Grade2.setText(STR."\{Judges.getJudgeList().get(i-1).getSumGrade()}"); theGrade.add(Judges.getJudgeList().get(i-1).getSumGrade()); break;
                case 3:Grade3.setText(STR."\{Judges.getJudgeList().get(i-1).getSumGrade()}"); theGrade.add(Judges.getJudgeList().get(i-1).getSumGrade()); break;
                case 4:Grade4.setText(STR."\{Judges.getJudgeList().get(i-1).getSumGrade()}"); theGrade.add(Judges.getJudgeList().get(i-1).getSumGrade()); break;
                case 5:Grade5.setText(STR."\{Judges.getJudgeList().get(i-1).getSumGrade()}"); theGrade.add(Judges.getJudgeList().get(i-1).getSumGrade()); break;
            }
        }
        theGrade.sort((a,b)-> (int) (a-b));
        //去掉最大值和最小值
        theGrade.removeFirst();
        theGrade.removeLast();
        //给选手统计最终成绩
        double result = 0;
        for(var v:theGrade){
            result+=v;
        }
        PlayerList.getInstance().getPlayerArrayList().get(currentCompetitor-1).setGrade(result);
    }



    //指向对应的选手
    //第一个选手
    @FXML
    public void theFirst()
    {
        clear();
        currentCompetitor=1;
        PlayerList.getInstance().getPlayerArrayList().get(currentCompetitor-1).getMusicShow().play();
    }
    //第二个选手
    @FXML
    public void theSecond()
    {
        clear();
        currentCompetitor=2;
        PlayerList.getInstance().getPlayerArrayList().get(currentCompetitor-2).getMusicShow().pause();
        PlayerList.getInstance().getPlayerArrayList().get(currentCompetitor-1).getMusicShow().play();
    }

    //清空打分框
    public void clear()
    {
        judgeOne.clear();
        judgeTwo.clear();
        judgeThree.clear();
        judgeFour.clear();
        judgeFive.clear();
        Grade1.clear();
        Grade2.clear();
        Grade3.clear();
        Grade4.clear();
        Grade5.clear();
    }



    //得出最终胜利者
    @FXML
    public void getWinner() throws Exception
    {
        PlayerList.getInstance().getPlayerArrayList().sort(Comparator.comparing(Player::getGrade));
        clear();
        PlayerList.getInstance().getPlayerArrayList().get(currentCompetitor-1).getMusicShow().pause();
        PlayerList.getInstance().getPlayerArrayList().sort(Comparator.comparing(Player::getGrade));
        for(int i=0;i<2;i++)
        {
            outPlayer.add(PlayerList.getInstance().getPlayerArrayList().get(i));
            PlayerList.getInstance().getPlayerArrayList().remove(i);
        }
        outPlayer.sort(Comparator.comparing(Player::getGrade));
        //结束评分
        END=true;

        //跳转到主界面
        MainAPP.setRoot("view/MainScene.fxml","主界面");

    }
    //初始化
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        currentCompetitor=1;

        END=false;
    }
}
