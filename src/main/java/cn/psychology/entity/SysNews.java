package cn.psychology.entity;


import javax.persistence.*;

@Entity
@Table(name="systemnews")
public class SysNews {
    /*
     * ------------------------------------------------------------------------------------------------------------------
     * 系统信息，存储在MySQl中。
     * ------------------------------------------------------------------------------------------------------------------
     * */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    //系统消息内容
    private String  context;
    //系统消息时间
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
