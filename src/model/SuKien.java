/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class SuKien {

    private String name;
    private String place;
    private String time;
    private String content;
    private int id;

    public SuKien() {

    }

    public SuKien(int id, String name, String place, String time, String content) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.time = time;
        this.content = content;
    }

    public SuKien(String name, String place, String time) {
        this.name = name;
        this.place = place;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }
}
