package cn.psychology.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Document(collection = "readtable")
public class ReadTable {
    @Id
    // 读物ID
    private Integer readId;
    @Field("readType")
    // 读物类型
    private Boolean readType;
    @Field("readTitle")
    // 读物题目
    private String readTitle;
    @Field("readAuthor")
    // 读物作者
    private String readAuthor;
    @Field("readImage")
    // 读物图片
    private String readImage;
    @Field("readContext")
    // 读物内容
    private String readContext;

    public Integer getReadId() {
        return readId;
    }

    public void setReadId(Integer readId) {
        this.readId = readId;
    }

    public String getReadTitle() {
        return readTitle;
    }

    public void setReadTitle(String readTitle) {
        this.readTitle = readTitle;
    }

    public String getReadAuthor() {
        return readAuthor;
    }

    public void setReadAuthor(String readAuthor) {
        this.readAuthor = readAuthor;
    }

    public String getReadImage() {
        return readImage;
    }

    public void setReadImage(String readImage) {
        this.readImage = readImage;
    }

    public String getReadContext() {
        return readContext;
    }

    public void setReadContext(String readContext) {
        this.readContext = readContext;
    }

    public Boolean getReadType() { return readType; }

    public void setReadType(Boolean readType) { this.readType = readType; }
}
