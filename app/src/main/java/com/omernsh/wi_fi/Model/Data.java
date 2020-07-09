package com.omernsh.wi_fi.Model;

public class Data {

    private String name;
    private String mac;
    private String streght;
    private String speed;

    public Data(String name, String mac, String streght, String speed) {
        this.name = name;
        this.mac = mac;
        this.streght = streght;
        this.speed = speed;
    }

    public Data() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getStreght() {
        return streght;
    }

    public void setStreght(String streght) {
        this.streght = streght;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
