package com.example.gittest_1;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Memo implements Serializable {
    String title;
    public Memo(String title, Date date) {
        this.title = title;

    }

    public Memo(String title) {
        this.title = title;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    }
