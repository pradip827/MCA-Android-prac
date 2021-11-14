package com.imcostmca.wmtpracticals;

public class ListItem {

    private String name;
    private String desc;
    private String img;
    private String category;
    private int nID;
    public ListItem(String name, String desc, String img,int nID,String category) {
        this.name = name;
        this.desc = desc;
        this.img = img;
        this.nID=nID;
        this.category=category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getnID() {
        return nID;
    }

    public void setnID(int nID) {
        this.nID = nID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
