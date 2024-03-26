package com.concepts.solid.liskovsubstitution;

public abstract class ClothingItem {
    abstract String getItemName();

    abstract Double getItemPrice();

    String dummyMethod() {
        return "this is dummy method";
    }
}
