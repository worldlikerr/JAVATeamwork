package work.entity;

import java.util.ArrayList;
import java.util.Objects;

//选手列表
public class PlayerList {
    public ArrayList<Player> playerArrayList;

    //单例模式
    //提供全局唯一访问点
    public static PlayerList instance;
    public static synchronized PlayerList getInstance(){
        if(instance==null){
            instance=new PlayerList();
        }
        return instance;
    }
    public PlayerList(){
        this.playerArrayList=new ArrayList<>();
    }

    //增
    public void addPlayer(Player player){
        playerArrayList.add(player);
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
}
