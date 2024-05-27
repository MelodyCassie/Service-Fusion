package com.serviceFusion.Capstone.utils;


import com.serviceFusion.Capstone.exceptions.ServiceFusionException;
import org.springframework.stereotype.Component;

@Component
public class Verification {
        public static boolean verifyEmail(String email) {
            String regex = "[a-zA-Z0-9!#$%^&():;.*_~`+{}]+@[a-z]+[.][a-z]{2,3}";
            return !email.matches(regex);

        }

        public static boolean verifyPassword(String password) {
            String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}\\S";
            return !password.matches(regex);
        }

        public static boolean verifyUserName(String request) throws ServiceFusionException {
            if (request.length() < 6) throw new ServiceFusionException("Username must be at least 6 characters");
            return false;
        }
        public static boolean verifyName(String request) throws ServiceFusionException {
            if (request.length() < 5) throw new ServiceFusionException("Full name must be at least 5 characters");
            return false;
        }

        public static boolean verifyPhoneNumber(String request) throws ServiceFusionException {
            if (request.length() < 11) throw new ServiceFusionException("Phone number must not be less than 11 characters");
            String regex = "^(0)([789])([01])[0-9]{8}$";

            return !request.matches(regex);
        }

        public static boolean verifyAddress(String request) throws ServiceFusionException {
            if (request.length() < 5) throw new ServiceFusionException("Address must be at least 5 characters");
            return false;
        }

}
