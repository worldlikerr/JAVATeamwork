package work.entity;

import java.util.Arrays;
import java.util.List;

public class Judges
{
    private final static Judge[] judges={new Judge("Mr.Li"),new Judge("Mr.Wang"),new Judge("Mr.Zhang"),new Judge("Mr.Liu"),new Judge("Mr.Huang")};
    private static List<Judge> judgeList= Arrays.stream(judges).toList();

    public static List<Judge> getJudgeList() {
        return judgeList;
    }
}
