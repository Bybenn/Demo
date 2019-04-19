package com.example.demoproject.AboutYourMedicine;

import java.io.Serializable;

public class MedList implements Serializable {
    private int id;
    private String medNameText;
    private String medInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedNameText() {
        return medNameText;
    }

    public void setMedNameText(String medNameText) {
        this.medNameText = medNameText;
    }

    public String getMedInfo() {
        return medInfo;
    }

    public void setMedInfo(String medInfo) {
        this.medInfo = medInfo;
    }
}
