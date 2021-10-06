package com.devaditya.multiplerv.model;

import androidx.annotation.NonNull;

public class HorizontalModel
{
    String name, description;

    public String getName(){
        return name;
    }

    @NonNull
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String Description) {
        this.description = description;
    }

    @NonNull
    public String getDescription() {
        return description;
    }
}
