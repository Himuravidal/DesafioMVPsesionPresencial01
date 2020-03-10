package com.criss.passwordstrenginclass.model;

import com.criss.passwordstrenginclass.model.Verifier;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestVerifier {

    private Verifier verifier;

    @Before
    public void setUp() {
        verifier = new Verifier();
    }

    @Test
    public void evaluate_length_pass_ok() {
        String pass = "abcdsdsdsdssd";
        assertTrue(verifier.evaluateLength(pass));
    }

    @Test
    public void evaluate_Length_short() {
        String pass = "abc";
        assertFalse(verifier.evaluateLength(pass));
    }

    @Test
    public void evaluateUpper_upper() {
        String pass = "UppeR";
        assertTrue(verifier.evaluateUpperCase(pass));
    }

    @Test
    public void evaluateUpper_normal() {
        String pass = "upper";
        assertFalse(verifier.evaluateUpperCase(pass));
    }

    @Test
    public void evaluate_number_ok() {
        String pass = "Ad12dsdsd";
        assertTrue(verifier.evaluateNumber(pass));
    }

    @Test
    public void evaluate_no_number() {
        String pass = "fdsgsd";
        assertFalse(verifier.evaluateNumber(pass));
    }


    @Test
    public void evaluatePass_weak() {
        String pass = "abc";
        int eval = verifier.evaluatePassword(pass);
        assertEquals(eval, Verifier.WEAK_PASS);
    }

    @Test
    public void evaluatePass_medium() {
        String pass = "abcde";
        int eval = verifier.evaluatePassword(pass);
        assertEquals(eval, Verifier.MEDIUM_PASS);
    }

    @Test
    public void evaluatePass_strong() {
        String pass = "Abcde";
        int eval = verifier.evaluatePassword(pass);
        assertEquals(eval, Verifier.STRONG_PASS);
    }

    @Test
    public void evaluatePass_very_strong() {
        String pass = "Abcde1";
        int eval = verifier.evaluatePassword(pass);
        assertEquals(eval, Verifier.VERY_STRONG_PASS);
    }

}
