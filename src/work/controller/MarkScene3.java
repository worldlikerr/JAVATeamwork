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


    //查看打分细则
    @FXML
    public void inquiryRule() throws Exception {
        MainAPP.setRoot("view/Rule.fxml","比赛规则");
    }


    //打分
    @FXML
    public void mark()
    {
        List<Integer> theGrade=new ArrayList<>();
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
            Judges.getJudgeList().get(i).setSingGrade(Integer.parseInt(temp[0]));
            Judges.getJudgeList().get(i).setPerformGrade(Integer.parseInt(temp[1]));
            Judges.getJudgeList().get(i).setFaceGrade(Integer.parseInt(temp[2]));
            switch (i)
            {
                case 1:Grade1.setText(STR."\{Judges.getJudgeList().get(i).getSumGrade()}"); theGrade.add(Judges.getJudgeList().get(i).getSumGrade()); break;
                case 2:Grade2.setText(STR."\{Judges.getJudgeList().get(i).getSumGrade()}"); theGrade.add(Judges.getJudgeList().get(i).getSumGrade()); break;
                case 3:Grade3.setText(STR."\{Judges.getJudgeList().get(i).getSumGrade()}"); theGrade.add(Judges.getJudgeList().get(i).getSumGrade()); break;
                case 4:Grade4.setText(STR."\{Judges.getJudgeList().get(i).getSumGrade()}"); theGrade.add(Judges.getJudgeList().get(i).getSumGrade()); break;
                case 5:Grade5.setText(STR."\{Judges.getJudgeList().get(i).getSumGrade()}"); theGrade.add(Judges.getJudgeList().get(i).getSumGrade()); break;
            }
        }
        theGrade.sort((a,b)->a-b);
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
        currentCompetitor=1;
        PlayerList.getInstance().getPlayerArrayList().get(currentCompetitor-1).getMusicShow().play();
    }
    //第二个选手
    @FXML
    public void theSecond()
    {
        currentCompetitor=2;
        PlayerList.getInstance().getPlayerArrayList().get(currentCompetitor-2).getMusicShow().pause();
        PlayerList.getInstance().getPlayerArrayList().get(currentCompetitor-1).getMusicShow().play();
    }



    //得出最终胜利者
    @FXML
    public void getWinner()
    {
        PlayerList.getInstance().getPlayerArrayList().sort(Comparator.comparing(Player::getGrade));

    }
    //初始化
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        currentCompetitor=1;
    }
}