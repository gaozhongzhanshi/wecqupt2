package com.cqupt;


/**
 * 父类失物类
 */
public class Lost {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 丢失物品
     */

    /**
     * 丢失时间
     */
    private String dsTime;

    public String getDsTime() {
        return dsTime;
    }

    public void setDsTime(String dsTime) {
        this.dsTime = dsTime;
    }

    @Override
    public String toString() {
        return  "name=‘" + name + '\'' + ", dsTime='" + dsTime + '\'';
    }
}
