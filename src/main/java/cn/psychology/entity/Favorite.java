package cn.psychology.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "favorite")
public class Favorite {
    @Id
    private String Id;



    private Integer type;
    private Integer userid;
    private String sourceid;
    private String image;
    private String title;
    private String context;

    public String getId() {
        return Id;
    }

    public Integer getUserid() {
        return userid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setId(String id) {
        Id = id;
    }


    public String getSourceid() {
        return sourceid;
    }

    public void setSourceid(String sourceid) {
        this.sourceid = sourceid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
