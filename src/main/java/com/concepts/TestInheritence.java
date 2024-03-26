package com.concepts;

class BakingConcrete {
    private int flour;

    BakingConcrete(int flour) {
        System.out.println("this is parent constructor");
    }

    public int getFlour() {
        System.out.println("this is getter in parent class");
        return flour;
    }

    public void setFlour(int flour) {
        System.out.println("this is setter in parent class");
        this.flour = flour;
    }

    @Override
    public String toString() {
        return "BakingConcrete{" +
                "flour=" + flour +
                '}';
    }
}

class BakingConcreteExtending extends BakingConcrete {


    BakingConcreteExtending(int flour) {
        super(flour);
    }

    public int getFlour() {
        super.getFlour();
        System.out.println("this is getter in child class");
        return 0;
    }

    public void setFlour(int flour) {
        System.out.println("this is setter in child class");
    }
}

public class TestInheritence {
    public static void main(String[] args) {
        BakingConcreteExtending bakingConcrete = new BakingConcreteExtending(21);
        System.out.println(bakingConcrete.getFlour());
    }
}