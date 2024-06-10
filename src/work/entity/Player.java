package work.entity;

import work.musicPlay.MusicShow;

//选手类，记录选手的基本属性
public class Player {
    //选手的基本属性
    //姓名
    private String name;
    //学号
    private String player_id;
    //性别
    private Gender gender;
    //学院名
    private String college_name;
    //出生日期设为String便于打印输出
    private String birthday;
    //所选曲目
    private String music_name;
    //报名时间
    private String registration_time;
    //是否被淘汰
    private double grade;
    private MusicShow musicShow;

    public Player(String name, String player_id, Gender gender, String college_name, String birthday, String music_name, String registration_time)
    {
        this.name = name;
        this.player_id = player_id;
        this.gender = gender;
        this.college_name = college_name;
        this.birthday = birthday;
        this.music_name = music_name;
        this.registration_time = registration_time;
        this.musicShow=new MusicShow(music_name);
    }

    public Player()
    {
        this.name="dream";
        this.player_id="123123";
        this.gender=Gender.M;
        this.college_name="数计学院";
        this.birthday="2001-9-2";
        this.music_name="声音.m4a";
        this.registration_time="2024-5-27";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(String player_id) {
        this.player_id = player_id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public String getRegistration_time() {
        return registration_time;
    }

    public void setRegistration_time(String registration_time) {
        this.registration_time = registration_time;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public MusicShow getMusicShow() {
        return musicShow;
    }

    @Override
    public String toString()
    {
        return "Player{" +
                "name='" + name + '\'' +
                ", player_id='" + player_id + '\'' +
                ", gender=" + gender +
                ", college_name='" + college_name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", music_name='" + music_name + '\'' +
                ", registration_time='" + registration_time + '\'' +
                '}';
    }


}
