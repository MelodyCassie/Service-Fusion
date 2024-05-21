package com.serviceFusion.Capstone.utils;


public class Verification {

    public static boolean verifyEmail(String email) {
        String regex = "[a-zA-Z0-9!#$%^&():;.*_~`+{}]+@[a-z]+[.][a-z]{2,3}";
        return email.matches(regex);

    }

    public static boolean verifyPassword(String password) {
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}\\S";
        return password.matches(regex);
    }
}
