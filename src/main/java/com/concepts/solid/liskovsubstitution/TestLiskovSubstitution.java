package com.concepts.solid.liskovsubstitution;

public class TestLiskovSubstitution {
    public static void main(String[] args) {
        JacketItem jacketItem = new JacketItem();
        ShirtItem shirtItem = new ShirtItem();

        checkout(jacketItem);
        checkout(shirtItem);
    }

    static void checkout(ClothingItem clothingItem) {
        System.out.println("Checkout: " + clothingItem.getItemName() + " price: " + clothingItem.getItemPrice());
    }
}
