package ru.netology.demo.model;

import java.io.Serializable;

public class JwtResponce implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;


    private final String jwtRespoce;

    public JwtResponce(String jwtRespoce) {
        this.jwtRespoce = jwtRespoce;
    }

    public String getToken() {
        return this.jwtRespoce;
    }

}
