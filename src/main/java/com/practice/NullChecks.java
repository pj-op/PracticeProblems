package com.practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Data
@AllArgsConstructor
class Car {
    private int carNumber;
    private Engine engine;
}

@Data
@AllArgsConstructor
class Engine {
    private int chessyNumber;
    private Piston piston;
}

@Data
@AllArgsConstructor
class Piston {
    private int numberOfPiston;
    private String name;
}

public class NullChecks {
    public static void main(String[] args) {
        Car car = new Car(11, new Engine(12, new Piston(2, "x")));
//        System.out.println(car.getEngine().getPiston().getName().toString());
        System.out.println(Optional.of(car).map(Car::getEngine).map(Engine::getPiston).map(Piston::getName).orElse(" other String "));

    }
}
