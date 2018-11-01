package com.example.mertaydayanc.ihome;

public class User {

    private String userEmail;
    private String password;
    private boolean light;
    private boolean door;
    private int livingRoom;
    private int bedRoom;
    private String name;

    public User()
    {
        userEmail = "";
        password = "";
        name = "";
        light = false;
        door = false;
    }

    public User(String email, String pass)
    {
        userEmail = email;
        password = pass;
        light = false;
        door = false;
    }

    public User(User copied)
    {
        userEmail = copied.userEmail;
        password = copied.password;
        light = copied.light;
        door = copied.door;
    }

    public int getBedRoom() {
        return bedRoom;
    }

    public int getLivingRoom() {
        return livingRoom;
    }

    public void setBedRoom(int bedRoom) {
        this.bedRoom = bedRoom;
    }

    public void setLivingRoom(int livingRoom) {
        this.livingRoom = livingRoom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDoor(boolean door) {
        this.door = door;
    }

    public void setLight(boolean light) {
        this.light = light;
    }

    public boolean isDoor() {
        return door;
    }

    public boolean isLight() {
        return light;
    }

    public String getPassword() {
        return password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean checkPassword(String pass)
    {
        return password.equals(pass);
    }
}
