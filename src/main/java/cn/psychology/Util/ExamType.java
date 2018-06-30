package cn.psychology.Util;

public enum ExamType {

    Depression("抑郁症类型试题",1),
    anxious("焦虑症类型试题",2);
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

    ExamType(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
