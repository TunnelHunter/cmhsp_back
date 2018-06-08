package cn.psychology.Util;

public enum SysnewsStatus {
    hasnotRead("未读",0),  hasRead("已读",1) ;
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

    SysnewsStatus(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
