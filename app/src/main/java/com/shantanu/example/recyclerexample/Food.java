package com.shantanu.example.recyclerexample;

public class Food {

    public static final int TEXT_TYPE=0;
    public static final int IMAGE_TYPE=1;
    public static final int AUDIO_TYPE=2;

    private int type;
    private String description;
    private String name;
    private int imgId;
    public Food(int type,String name,String description) {
        this.type=type;
        this.name=name;
        this.description = description;
    }

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type=type;
    }

    public String getName() {
        return name;
    }
    public void setName(String Name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getImgId() {
        return imgId;
    }
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
