// Title : Media Player Unified Adapter Pattern
// Author : sheetal
public class MediaPlayerUnified {
    public static void main(String[] args) {
        // OldMediaPlayer oPlayer = new OldMediaPlayer();
        MediaPlay mPlay = new UnifiedPlayer();
        mPlay.play("mp3", "xyz.mp3");
        mPlay.play("mp4", "video.mp4");
        mPlay.play("xyz", "video.mp4");
        
    }
}

class OldMediaPlayer {
    public void playmp3(String type, String name) {
        System.out.println("\nPlaying" + type + " file. Name: " + name);
    }
}


interface MediaPlay {
    void play(String type, String name);
}

class UnifiedPlayer implements MediaPlay {
    
    @Override
    public void play(String type, String name) {
        if (type.equalsIgnoreCase("mp3")) {
            OldMediaPlayer op = new OldMediaPlayer();
            op.playmp3(type, name);
        } 
        else if(type.equalsIgnoreCase("mp4")){
            AdvanceMediaPlayer ap = new Mp4player();
            ap.playmp4(type, name);
        }
        else{
         System.out.println("mediaplayer does not supports");

        }
    }

}

