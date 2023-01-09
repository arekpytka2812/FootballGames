package com.fg.footballgames.AppComponents;

public class PasswordChecker {

    private static boolean containsLowerCase = false;
    private static boolean containsUpperCase = false;
    private static boolean containsNumber = false;

    public static boolean isValid(String value) {

        containsLowerCase = false;
        containsUpperCase = false;
        containsNumber = false;

        return value.length() > 7 && checkRequirements(value);
    }

    private static boolean checkRequirements(String value){

        for(int i = 0; i < value.length(); i++){
            if(Character.isLowerCase(value.charAt(i))){
                containsLowerCase = true;
                continue;
            }

            if(Character.isUpperCase(value.charAt(i))){
                containsUpperCase = true;
                continue;
            }

            if(Character.isDigit(value.charAt(i))){
                containsNumber = true;
            }
        }

        return containsNumber && containsUpperCase && containsLowerCase;
    }

}
