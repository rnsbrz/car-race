package com.spring.porscheRace.model;

import jakarta.persistence.*;


public enum Car {

    CAR1("718 Cayman", 300, 4.9, 275),
    CAR2("911 GT3 RS", 525, 3.2, 296),
    CAR3("911 Carrera", 385, 4.2, 293),
    CAR4("911 S/T", 525, 3.7, 300),
    CAR5("Panamera", 353, 5.3, 272),
    CAR6("Taycan", 408, 4.8, 230),
    CAR7("Taycan Turbo GT", 1032, 2.3, 250),
    CAR8("911 Turbo S", 650, 2.7, 330),
    CAR9("911 Sport Classic", 550, 4.1, 315),
    CAR10("718 Cayman GT4 RS", 500, 3.4, 315);


    private final String model;
    private final int horsePower;
    private final double acceleration;
    private final int topSpeed;


    Car(String model, int horsePower, double acceleration, int topSpeed) {
        this.model = model;
        this.horsePower = horsePower;
        this.acceleration = acceleration;
        this.topSpeed = topSpeed;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public int getTopSpeed() {
        return topSpeed;
    }
}
