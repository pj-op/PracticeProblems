package com.new_problems;

public sealed class Shape permits Triangle, Square {

    public String commonMethod(String message) {
        return "ShapeClass " + message;
    }

}
