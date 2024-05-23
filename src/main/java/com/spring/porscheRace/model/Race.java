package com.spring.porscheRace.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "races")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Cannot be blank")
    @Size(max = 30, message = "Name up to 30 characters")
    private String car1;

    @NotBlank(message = "Cannot be blank")
    @Size(max = 30, message = "Name up to 30 characters")
    private String car2;
    @NotNull
    @Min(value = 1, message = "Cannot be less than 1")
    private int car1Hp;
    @NotNull
    @Min(value = 1, message = "Cannot be less than 1")
    private int car2Hp;
    private String result;

    public Race(int id, String car1, String car2, int car1Hp, int car2Hp, String result) {
        this.id = id;
        this.car1 = car1;
        this.car2 = car2;
        this.car1Hp = car1Hp;
        this.car2Hp = car2Hp;
        this.result = result;
    }

    public Race(String car1, String car2, int car1Hp, int car2Hp, String result) {
        this.car1 = car1;
        this.car2 = car2;
        this.car1Hp = car1Hp;
        this.car2Hp = car2Hp;
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

    public int getCar1Hp() {
        return car1Hp;
    }

    public void setCar1Hp(int car1Hp) {
        this.car1Hp = car1Hp;
    }

    public int getCar2Hp() {
        return car2Hp;
    }

    public void setCar2Hp(int car2Hp) {
        this.car2Hp = car2Hp;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
