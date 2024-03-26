package com.concepts.solid.liskovsubstitution;

public class ShirtItem extends ClothingItem{
    @Override
    String getItemName() {
        return "shirt item";
    }

    @Override
    Double getItemPrice() {
        return 25.9;
    }
}
