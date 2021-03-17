package com.example.otplogin;

import android.widget.RadioButton;

public class UserDB {

    //private String phoneNumber;
    private String uname;
    private int age;
    private String genderU;

    public UserDB(){
    }


    public UserDB( String name, int age) {
        //this.phoneNumber = phoneNumber;
        this.uname = name;
        this.age = age;

    }

    public UserDB( String name, int age, String gender) {
        //this.phoneNumber = phoneNumber;
        this.uname = name;
        this.age = age;
        this.genderU = gender;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGenderU() {
        return genderU;
    }

    public void setGenderU(String genderU) {
        this.genderU = genderU;
    }
}
