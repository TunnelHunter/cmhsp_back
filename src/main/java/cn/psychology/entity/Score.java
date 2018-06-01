package cn.psychology.entity;


import javax.persistence.*;

@Entity
@Table(name="testresult")
public class Score {

    /*
     * ------------------------------------------------------------------------------------------------------------------
     * 成绩表，存储在Mysql中。
     * 分别有，id（主键），userid，examid，score，summary，sonslusion
     * ------------------------------------------------------------------------------------------------------------------
     * */
    @Id
    @GeneratedValue
    private Integer scoreId;
    // 用户ID
    private String userId;
    // 题ID
    private String examId;
    // 此次得分
    private String score;
    //时间戳
    private long testTime;
    //总结
    private String  summary;

    private String conclusion;

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public long getTestTime() {
        return testTime;
    }

    public void setTestTime(long testTime) {
        this.testTime = testTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
