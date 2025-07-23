//Title : Media Player Adapter Pattern
// Author : sheetal
public class MediaPlayer {
    public static void main(String[] args) {
        OldMediaPlayer oPlayer = new OldMediaPlayer();
        MediaPlay mPlay = new OldMediaPlayerAdapter(oPlayer);
        mPlay.play("mp3", "xyz.mp3");
        
        AdvanceMediaPlayer mp4 = new Mp4player();
MediaPlay mp4Adapter = new AdvanceMediaPlayerAdapter(mp4);
mp4Adapter.play("mp4", "video.mp4");

    }
}

class OldMediaPlayer {
    public void playmp3(String type, String name) {
        System.out.println("Playing" + type + " file. Name: " + name);
    }
}

interface AdvanceMediaPlayer {
    void playmp4(String type, String name);
}

class Mp4player implements AdvanceMediaPlayer {
    @Override
    public void playmp4(String type, String name) {
        System.out.println("Playing" + type + " file. Name: " + name);
    }
}

interface MediaPlay {
    void play(String type, String name);
}

class OldMediaPlayerAdapter implements MediaPlay {
    OldMediaPlayer op;

    public OldMediaPlayerAdapter(OldMediaPlayer op) {
        this.op = op;
    }

    @Override
    public void play(String type, String name) {
        if (type.equalsIgnoreCase("mp3")) {
            op.playmp3(type, name);
        } else {
            System.out.println("OldMediaPlayer supports only MP3");
        }
    }

}

class AdvanceMediaPlayerAdapter implements MediaPlay {
    AdvanceMediaPlayer ap;

    public AdvanceMediaPlayerAdapter(AdvanceMediaPlayer ap) {
        this.ap = ap;
    }

    @Override
    public void play(String type, String name) {
        if (type.equalsIgnoreCase("mp4")) {
            ap.playmp4(type, name);
        } else {
            System.out.println("AdvancedMediaPlayer supports only MP4");
        }
    }

}
