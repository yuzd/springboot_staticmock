package com.example.demo.service;

public class FinalValidator {
    private static final String PSF_FIEID_A = "A";
    private String data;

    public FinalValidator(String data) {
        this.data = data;
    }

    public FinalValidator() {
    }

    public final String getFinalValue() {
        return data == null ? PSF_FIEID_A : data;
    }

    public static String testStatic() {
        return "hello";
    }
}
