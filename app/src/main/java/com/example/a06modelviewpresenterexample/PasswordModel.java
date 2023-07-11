package com.example.a06modelviewpresenterexample;

public class PasswordModel {

    public static final int EMPTY = 0;
    public static final int WEAK = 1;
    public static final int MEDIUM = 2;
    public static final int STRONG = 3;

    public int validatePassword(String password) {
       if (password.isEmpty())  {
           return EMPTY;

         }else if (password.length() < 5) {
            return WEAK;

        } else if (password.equals(password.toLowerCase())) {
            return MEDIUM;

        } else {
            return STRONG;
        }
    }
}
