package com.practice;

class Phone {
    Phone() {
        System.out.println("Phone Class constructor");
    }
    Phone(int a) {
        System.out.println("Phone with a " + a);
    }
}
/*
    public void on() {
        System.out.println("Turning on phone in base class");
    }

    public void call() {
        System.out.println("Calling from phone in base class");
    }
}*/

class SmartPhone extends Phone {
    SmartPhone() {
        System.out.println("SmartPhone Class constructor");
    }

    SmartPhone(int a, int b) {
        System.out.println("SmartPhone with a " + a + " and b" + b);
    }

    /*public void on() {
        System.out.println("Turning on Smartphone in child class");
    }

    public void call() {
        System.out.println("Calling from Smartphone in child class");
    }*/
}

class UltraSmartPhone extends SmartPhone {
    UltraSmartPhone() {
        System.out.println("UltraSmartPhone Class constructor");
    }

    UltraSmartPhone(int a, int b, int c) {
        System.out.println("UltraSmartPhone with a" + a + " b " + b + " and c " + c);
    }

    /*public void on() {
        System.out.println("Turning on UltraSmartphone in child - child class");
    }

    public void call() {
        System.out.println("Calling from UltraSmartphone in child - child class");
    }*/
}

public class ConstructorConcept {
    public static void main(String[] args) {
        Phone phone = new Phone();
        System.out.println("========================");
        Phone phone1 = new SmartPhone();
        System.out.println("========================");
        /*SmartPhone smartPhone = new Phone();*/ // Not Allowed
        SmartPhone smartPhone1 = new SmartPhone();
        System.out.println("========================");
        SmartPhone smartPhone2 = new UltraSmartPhone();
        System.out.println("========================");
        //Not Allowed
        /*UltraSmartPhone ultraSmartPhone = new SmartPhone();
        UltraSmartPhone ultraSmartPhone1 = new Phone();*/


    }
}
