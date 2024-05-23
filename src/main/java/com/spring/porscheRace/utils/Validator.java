package com.spring.porscheRace.utils;

public class Validator {
    public static boolean pwValidCheck(String password){
        return password != null && password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8," +
                "12}$");
    }
}
