package work.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

//选手集合类
public class PlayerList
{
    public ArrayList<Player> playerArrayList;
    //限制报名人数
    public final static int PLAYER_NUMBER=9;
    public int getPLAYER_NUMBER() {
        return PLAYER_NUMBER;
    }

    //单例模式
    //提供全局唯一访问点
    public static PlayerList instance;
    public static synchronized PlayerList getInstance(){
        if(instance==null){
            instance=new PlayerList();
        }
        return instance;
    }

    //为简化输入过程自动生成十名选手
    public PlayerList()
    {
        this.playerArrayList=new ArrayList<>();
        Random random=new Random();
        for(int i=0;i<8;i++)
        {
            Player player=new Player(generateRandomChineseName(random,3),
                    String.valueOf(random.nextInt(100000,999999)),
                    i%2==0?Gender.M:Gender.W,
                    getRandomCollegeName(random),
                    String.format("%d-%02d-%02d", 2000 + random.nextInt(6), 1 + random.nextInt(12), 1 + random.nextInt(28)),
                    getRandomMusic(random),
                    String.format("%d-%02d-%02d", 2024, 1 + random.nextInt(12), 1 + random.nextInt(28)));
            playerArrayList.add(player);
        }
    }


    // 生成随机中文名字
    private String generateRandomChineseName(Random random, int length) {
        String COMMON_CHINESE_CHARACTERS="赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董";
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(COMMON_CHINESE_CHARACTERS.length());
            char ch = COMMON_CHINESE_CHARACTERS.charAt(index);
            name.append(ch);
        }
        return name.toString();
    }


    //随机生成学院
    private String getRandomCollegeName(Random random){
        String[] collegeName={"数学与计算机学院","舞蹈学院","经济管理学院","外国语学院","体育学院","生命科学学院"};
        return collegeName[random.nextInt(0,collegeName.length-1)];
    }


    //随机生成曲目
    private String getRandomMusic(Random random)
    {
        String[] collegeName={"Catch my breath",
        "Fool for you",
        "Lost control",
        "PayPhone(纯音乐)",
        "Remember our Summer",
        "Sound of walking away",
        "DreamHeaven",
        "Touch",
        "声音",
        "失眠飞行",
        "这世界有很多爱你的人",
        "飞云之下",};
        return collegeName[random.nextInt(0,collegeName.length-1)];
    }


    //增
    public boolean addPlayer(Player player){
        if(findPlayer(player.getPlayer_id())==null&&playerArrayList.size()<PLAYER_NUMBER){
            playerArrayList.add(player);
            return true;
        }
        return false;
    }


    //查
    //以学号为唯一依据
    public Player findPlayer(String player_id){
        for(var v:playerArrayList){
            if (Objects.equals(v.getPlayer_id(), player_id))
                return v;
        }
        return null;
    }


    //删
    //以学号为唯一依据
    public void deletePlayer(String player_id){
        Player player=findPlayer(player_id);
        if (player!=null)
            playerArrayList.remove(player);
    }

    //打印
    public void print(){
        for(var v:playerArrayList){
            System.out.println(v.toString());
        }
    }


    /**
     * 按照学号排序
     * @param flag
     * true为升序
     * false为降序
     */
    public void sortByID(boolean flag){
        playerArrayList.sort(flag
                ? Comparator.comparing(Player::getPlayer_id)
                : Comparator.comparing(Player::getPlayer_id).reversed());
    }


    //按照学院排序
    public void sortByCollageName(boolean flag){
        playerArrayList.sort(flag
                ? Comparator.comparing(Player::getCollege_name)
                : Comparator.comparing(Player::getCollege_name).reversed());
    }


    //按照报名时间排序
    public void sortByRegistrationTime(boolean flag){
        playerArrayList.sort(flag
                ? Comparator.comparing(Player::getRegistration_time)
                : Comparator.comparing(Player::getRegistration_time).reversed());
    }


    //按照性别排序
    public void sortByGender(boolean flag){
        playerArrayList.sort(flag
                ? Comparator.comparing(Player::getGender)
                : Comparator.comparing(Player::getGender).reversed());
    }

    public ArrayList<Player> getPlayerArrayList() {
        return playerArrayList;
    }
}
