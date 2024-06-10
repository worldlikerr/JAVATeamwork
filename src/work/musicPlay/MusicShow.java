package work.musicPlay;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Objects;

public class MusicShow
{
   private Media music;
   private MediaPlayer mediaPlayer;

   public MusicShow(String selectedMusic)
   {
       String path=setPath(selectedMusic);
        music=new Media(Objects.requireNonNull(getClass().getResource(path)).toExternalForm());
        mediaPlayer=new MediaPlayer(music);
   }

   //播放音乐
   public void play() {
       mediaPlayer.play();
   }

   //停止
    public void pause() {
        mediaPlayer.pause();
    }

    public Media getMusic() {
        return music;
    }

    public void setMusic(Media music) {
        this.music = music;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    //根据被选择的歌曲设置对应的歌曲路径
    public String setPath(String select)
    {
        String result;
       switch (select)
       {
           case "Catch my breath"-> result="/work/resource/music/Catch my breath.m4a";
           case "Fool for you"-> result="/work/resource/music/Fool for you.m4a";
           case "Lost control"-> result="/work/resource/music/Lost control.m4a";
           case "PayPhone(纯音乐)"-> result="/work/resource/music/PayPhone（纯音乐）.m4a";
           case "Remember our Summer"-> result="/work/resource/music/Remember our Summer.m4a";
           case "Sound of walking away"-> result="/work/resource/music/Sound of walking away.m4a";
           case "Touch"-> result="/work/resource/music/Touch.mp3";
           case "声音" -> result="/work/resource/music/声音.m4a";
           case "失眠飞行"-> result="/work/resource/music/失眠飞行.m4a";
           case "山海皆可平"-> result="/work/resource/music/山海皆可平.m4a";
           case "这世界有很多爱你的人"-> result="/work/resource/music/这世界有很多爱你的人.m4a";
           default ->  result="/work/resource/music/飞云之下.m4a";
       }
       return result;
    }
}
