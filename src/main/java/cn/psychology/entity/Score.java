package cn.psychology.entity;


import javax.persistence.*;

@Entity
@Table(name="score")
public class Score {
    @Id
    @GeneratedValue
    private Integer scoreId;
    // 用户ID
    private String userId;
    // 题ID
    private String tiId;
    // 此次得分
    private String currScore;
    //时间戳
    private long currenTime;

    public Integer getScoreid() {
        return scoreId;
    }

    public void setScoreid(Integer scoreid) {
        this.scoreId = scoreid;
    }

    public String getUserid() {
        return userId;
    }

    public void setUserid(String userid) {
        this.userId = userid;
    }

    public String getTiid() {
        return tiId;
    }

    public void setTiid(String tiid) {
        this.tiId = tiid;
    }

    public String getCurrscore() {
        return currScore;
    }

    public void setCurrscore(String currscore) {
        this.currScore = currscore;
    }

    public long getCurrentime() {
        return currenTime;
    }

    public void setCurrentime(long currentime) {
        this.currenTime = currentime;
    }
}
