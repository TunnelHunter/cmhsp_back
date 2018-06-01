package cn.psychology.entity;


import javax.persistence.*;

@Entity
@Table(name="conusersysnews")
public class ConUserSysnews {

    /*
    * 系统信息与用户关联表
    * ------------------------------------------------------------------------------------------------------------------
    * 字段分别为id，userid，status。
    * 表   什么鬼。晚上再讨论。
    *
    *
    *
    *
    *
    *
    * */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer userId;

    private int status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
