package work;

import work.entity.PlayerList;

public class Test2 {
    public static void main(String[] args) {
        PlayerList playerList=PlayerList.getInstance();
        playerList.print();
    }
}
