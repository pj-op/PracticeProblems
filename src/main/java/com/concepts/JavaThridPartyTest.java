package com.concepts;

import com.concepts.impl.Baking_thrid_party_impl;

public class JavaThridPartyTest {
    public static void main(String[] args) {
        Baking baking_java = new Baking_thrid_party_impl();
        baking_java.baked(12);
    }
}
