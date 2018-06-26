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



    private Integer socialId;
    private Integer userId;
    private String socialAddTime;
    private String imageData;
    private String textData;

    private ArrayList<Comments> comments;

    public ArrayList<Comments> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comments> comments) {
        this.comments = comments;
    }

    public class Comments{
        public Integer getCuserId() {
            return cuserId;
        }

        public void setCuserId(Integer cuserId) {
            this.cuserId = cuserId;
        }

        public String getCommentData() {
            return commentData;
        }

        public void setCommentData(String commentData) {
            this.commentData = commentData;
        }

        public String getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(String commentTime) {
            this.commentTime = commentTime;
        }
        @Field("cuserId")
        Integer cuserId;
        @Field("commentData")
        String commentData;
        @Field("commentTime")
        String commentTime;
        @Field("commentType")
        Integer commentType;

        public Integer getCommentType() {
            return commentType;
        }

        public void setCommentType(Integer commentType) {
            this.commentType = commentType;
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


    public Integer getsocialId() {
        return socialId;
    }

    public void setsocialId(Integer socialId) {
        this.socialId = socialId;
    }

    public Integer getuserId() {
        return userId;
    }

    public void setuserId(Integer userId) {
        this.userId = userId;
    }

    public String getsocialAddTime() {
        return socialAddTime;
    }

    public void setsocialAddTime(String socialAddTime) {
        this.socialAddTime = socialAddTime;
    }

    public String getimageData() {
        return imageData;
    }

    public void setimageData(String imageData) {
        this.imageData = imageData;
    }

    public String gettextData() {
        return textData;
    }

    public void settextData(String textData) {
        this.textData = textData;
    }


}
