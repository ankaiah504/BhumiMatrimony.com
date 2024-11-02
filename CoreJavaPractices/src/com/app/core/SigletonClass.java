package com.app.core;

public class SigletonClass {

	private static final SigletonClass instance = new SigletonClass();

    // private constructor to avoid client applications using the constructor
    private SigletonClass(){}

    public static SigletonClass getInstance() {
        return instance;
    }

}
