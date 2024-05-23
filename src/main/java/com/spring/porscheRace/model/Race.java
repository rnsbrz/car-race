package com.spring.porscheRace.model;

import jakarta.persistence.*;

@Entity
@Table(name = "races")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String car1;
    private String car2;
    private String location;
    private String result;

    public Race(int id, String car1, String car2, String location, String result) {
        this.id = id;
        this.car1 = car1;
        this.car2 = car2;
        this.location = location;
        this.result = result;
    }

    public Race(String car1, String car2, String location, String result) {
        this.car1 = car1;
        this.car2 = car2;
        this.location = location;
        this.result = result;
    }

    public Race() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCar1() {
        return car1;
    }

    public void setCar1(String car1) {
        this.car1 = car1;
    }

    public String getCar2() {
        return car2;
    }

    public void setCar2(String car2) {
        this.car2 = car2;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
