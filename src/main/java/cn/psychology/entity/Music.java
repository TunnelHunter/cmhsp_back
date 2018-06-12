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

    public String getSongid() {
        return songid;
    }

    public void setSongid(String songid) {
        this.songid = songid;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getSongauthor() {
        return songauthor;
    }

    public void setSongauthor(String songauthor) {
        this.songauthor = songauthor;
    }

    public String getSongcontext() {
        return songcontext;
    }

    public void setSongcontext(String songcontext) {
        this.songcontext = songcontext;
    }

    private String musicsceneId;
    private String musicsceneName;
    private String songid;
    private String songname;
    private String songauthor;
    private String songcontext;

}
