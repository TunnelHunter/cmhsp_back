package cn.psychology.entity;


import org.bson.types.ObjectId;
import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import java.io.Serializable;
import java.util.*;
import java.util.ArrayList;


@Document(collection = "Social")
public class Social {
    @Id
    private String Id;



    private Integer socialid;
    private Integer userid;
    private String socialaddtime;
    private String imagedata;
    private String textdata;

    private ArrayList<Comments> comments;

    public ArrayList<Comments> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comments> comments) {
        this.comments = comments;
    }

    public class Comments{
        public Integer getCuserid() {
            return cuserid;
        }

        public void setCuserid(Integer cuserid) {
            this.cuserid = cuserid;
        }

        public String getCommentData() {
            return commentData;
        }

        public void setCommentData(String commentData) {
            this.commentData = commentData;
        }

        public String getCommenttime() {
            return commenttime;
        }

        public void setCommenttime(String commenttime) {
            this.commenttime = commenttime;
        }
        @Field("cuserid")
        Integer cuserid;
        @Field("commentData")
        String commentData;
        @Field("commenttime")
        String commenttime;
        @Field("commenttype")
        Integer commenttype;

        public Integer getCommenttype() {
            return commenttype;
        }

        public void setCommenttype(Integer commenttype) {
            this.commenttype = commenttype;
        }
    }


//
//    public String getId() {
//        return Id;
//    }
//
//    public void setId(String id) {
//        Id = id;
//    }


    public Integer getSocialid() {
        return socialid;
    }

    public void setSocialid(Integer socialid) {
        this.socialid = socialid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getSocialaddtime() {
        return socialaddtime;
    }

    public void setSocialaddtime(String socialaddtime) {
        this.socialaddtime = socialaddtime;
    }

    public String getImagedata() {
        return imagedata;
    }

    public void setImagedata(String imagedata) {
        this.imagedata = imagedata;
    }

    public String getTextdata() {
        return textdata;
    }

    public void setTextdata(String textdata) {
        this.textdata = textdata;
    }


}
