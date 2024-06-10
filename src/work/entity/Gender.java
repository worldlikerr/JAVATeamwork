package work.entity;
//性别枚举类
public enum Gender {
    M("男"),
    W("女");
    private String gender;
    Gender(String gender){
        this.gender=gender;
    }

    public String getGender() {
        return gender;
    }
}
