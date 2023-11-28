package com.example.pfi.classes;

import java.io.Serializable;

public class User implements Serializable {
    private String uName;
    private String uPassword;
    private int money;
    public String getuName() {
        return uName;
    }
    public void setuName(String uName) {
        this.uName = uName;
    }
    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public boolean validPword(String uPassword){
        if(this.uPassword.equals(uPassword))
            return true;
        return false;
    }

    public User(String uName, String uPassword, int money){
        setMoney(money);
        setuName(uName);
        setuPassword(uPassword);
    }
}
