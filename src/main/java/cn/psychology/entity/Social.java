package cn.psychology.entity;


import org.bson.types.ObjectId;
import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import java.io.Serializable;
import java.util.*;


@Document(collection = "Scoialcollection")
public class Social implements Serializable {
    /*
     * ------------------------------------------------------------------------------------------------------------------
     * 动态信息，存储在MongoDB中。
     * 分别有，等
     * ------------------------------------------------------------------------------------------------------------------
     * */

    @Id
    private String id;

}
