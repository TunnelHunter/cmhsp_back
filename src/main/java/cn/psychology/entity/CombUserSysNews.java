package cn.psychology.entity;


import javax.persistence.*;

@Entity
@Table(name = "combUsersysnews")
public class CombUserSysNews {

    /*
     * ------------------------------------------------------------------------------------------------------------------
     * 系统信息用户关联表，存储在Mysql中。
     * 分别有，系统消息ID，用户ID 状态。
     * ------------------------------------------------------------------------------------------------------------------
     * */

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private long sysId;

    private Integer userId;

    //是否已读   0 未读  1  已读。
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getSysId() {
        return sysId;
    }

    public void setSysId(long sysId) {
        this.sysId = sysId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
