package com.concepts.solid.liskovsubstitution;

public class JacketItem extends ClothingItem {
    @Override
    String getItemName() {
        return ("jacket item");
    }

    @Override
    Double getItemPrice() {
        return 0.1;
    }
}
