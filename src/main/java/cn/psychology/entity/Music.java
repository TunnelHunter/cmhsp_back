package cn.psychology.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "musicdetail")
public class Music {
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }



    @Id
    private String Id;

    public String getMusicsceneId() {
        return musicsceneId;
    }

    public void setMusicsceneId(String musicsceneId) {
        this.musicsceneId = musicsceneId;
    }

    public String getMusicsceneName() {
        return musicsceneName;
    }

    public void setMusicsceneName(String musicsceneName) {
        this.musicsceneName = musicsceneName;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongAuthor() {
        return songAuthor;
    }

    public void setSongAuthor(String songAuthor) {
        this.songAuthor = songAuthor;
    }

    public String getSongContext() {
        return songContext;
    }

    public void setSongContext(String songContext) {
        this.songContext = songContext;
    }

    private String musicsceneId;
    private String musicsceneName;
    private String songId;
    private String songName;
    private String songAuthor;
    private String songContext;

}
