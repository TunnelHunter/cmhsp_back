package cn.psychology.Util;

public enum ReadType {
    BOOK("书籍",1),
    ESSAY("文章",0);
    private String name;
    private int index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    ReadType(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
