package com.criss.passwordstrenginclass.model;

import androidx.annotation.VisibleForTesting;

public class Verifier {

    public static final int MIN_LENGTH = 5;
    public static final int WEAK_PASS = 1;
    public static final int MEDIUM_PASS = 2;
    public static final int STRONG_PASS = 3;
    public static final int VERY_STRONG_PASS = 4;

    @VisibleForTesting
    protected boolean evaluateLength(String password) {
        return password.length() >= MIN_LENGTH;
    }

    @VisibleForTesting
    protected boolean evaluateUpperCase(String password) {
        return !password.toLowerCase().equals(password);
    }

    @VisibleForTesting
    protected boolean evaluateNumber(String password) {
        for(int i = 0; i < password.length(); i++) {
            if(Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    public int evaluatePassword(String password) {
        if (evaluateLength(password) && evaluateUpperCase(password) && evaluateNumber(password)) return VERY_STRONG_PASS;
        if (evaluateUpperCase(password) && evaluateLength(password)) return  STRONG_PASS;
        if (evaluateLength(password)) return MEDIUM_PASS;
        return WEAK_PASS;
    }



}
