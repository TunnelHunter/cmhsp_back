package cn.psychology.entity;


import javax.persistence.*;

@Entity
@Table(name="CombRoleandUser")
public class CombineRU {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;
    Integer userid;
    Integer roleid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}
