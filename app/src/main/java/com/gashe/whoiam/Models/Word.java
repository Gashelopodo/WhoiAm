package com.gashe.whoiam.Models;

import java.io.Serializable;

/**
 * Created by Gashe on 20/3/17.
 */

public class Word implements Serializable {

    private int num;
    private String name;
    private boolean success;

    public Word(int num, String name, boolean success) {
        this.num = num;
        this.name = name;
        this.success = success;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
