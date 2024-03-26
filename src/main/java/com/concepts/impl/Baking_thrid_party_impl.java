package com.concepts.impl;

import com.concepts.Baking;

public class Baking_thrid_party_impl implements Baking {
    @Override
    public void baked(int flour) {
        System.out.println("this is 3rd Party implementation of baked method");
    }
}
