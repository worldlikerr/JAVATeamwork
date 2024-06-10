package work.entity;

import java.time.LocalDate;

public class Judge
{
    private String name;
    private int sumGrade;
    private int singGrade;
    private int performGrade;
    private int faceGrade;
    private String tip;
    private LocalDate judgeTime;

    public Judge(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSumGrade() {
        return (singGrade+performGrade+faceGrade)/3;
    }


    public int getSingGrade() {
        return singGrade;
    }

    public void setSingGrade(int singGrade) {
        this.singGrade = singGrade;
    }

    public int getPerformGrade() {
        return performGrade;
    }

    public void setPerformGrade(int performGrade) {
        this.performGrade = performGrade;
    }

    public int getFaceGrade() {
        return faceGrade;
    }

    public void setFaceGrade(int faceGrade) {
        this.faceGrade = faceGrade;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public LocalDate getJudgeTime() {
        return judgeTime;
    }

    public void setJudgeTime(LocalDate judgeTime) {
        this.judgeTime = judgeTime;
    }
}
