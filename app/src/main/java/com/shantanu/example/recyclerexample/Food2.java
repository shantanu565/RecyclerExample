package com.shantanu.example.recyclerexample;

public class Food2 {
    public enum ItemType {
        TEXTIMAGE_TYPE, TEXT_TYPE,IMAGE_TYPE;
    }
    private String description;
    private String name;
    private ItemType itemType;

    public Food2(ItemType itemType,String name,String description) {
        this.itemType=itemType;
        this.name=name;
        this.description = description;
    }

    public ItemType getType() {
        return itemType;
    }
    public void setType(int itemitem) {
        this.itemType=itemType;
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


}
