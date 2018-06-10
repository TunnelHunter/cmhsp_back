
package cn.psychology.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    /*
     * ------------------------------------------------------------------------------------------------------------------
     * 用户表
     * ------------------------------------------------------------------------------------------------------------------
     * */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int userId;
    //用户名
    private String username;
    //密码
    private String userpwd;
    //用户昵称
    private String usernickname;
    //性别
    private String sex;
    //地区
    private String region;
    //个性签名
    private String signature;
    //头像图片地址
    private String imageAddre;
    //用户注册时间
    private String userRegTime;

    //权限
    private String roles;





    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernickname() {
        return usernickname;
    }

    public void setUsernickname(String usernickname) {
        this.usernickname = usernickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getImageAddre() {
        return imageAddre;
    }

    public void setImageAddre(String imageAddre) {
        this.imageAddre = imageAddre;
    }

    public String getUserRegTime() {
        return userRegTime;
    }

    public void setUserRegTime(String userRegTime) {
        this.userRegTime = userRegTime;
    }



    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

//    //此构造器用于回应前台字段据该情况。 当传入一个username，则给每一个属性都赋值："无修改"。
//    public User(String username) {
//        this.username = username;
//        this.region = "无修改";
//        this.userpwd = "无修改";
//        this.imageAddre = "无修改";
//        this.sex = "无修改";
//        this.usernickname = "无修改";
//        this.signature = "无修改";
//    }

    public User() {
    }
}

