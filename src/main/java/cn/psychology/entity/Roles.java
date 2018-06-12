package cn.psychology.entity;


import javax.persistence.*;

@Entity
@Table(name="Roles")
public class Roles {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;
    String roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
