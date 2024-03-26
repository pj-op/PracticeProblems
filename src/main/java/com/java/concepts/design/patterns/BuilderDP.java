package com.java.concepts.design.patterns;

public class BuilderDP {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilder();
        Car car = carBuilder
                .setCarName("Mercedese")
                .setChesyNo("Ch001")
                .setFuelType("Petrol")
                .setPrice("2300$").build();
        System.out.println(car);
    }
}

class Car {
    private String carName;
    private String chesyNo;
    private String fuelType;
    private String price;

    Car(CarBuilder carBuilder) {
        this.carName = carBuilder.carName;
        this.chesyNo = carBuilder.chesyNo;
        this.fuelType = carBuilder.fuelType;
        this.price = carBuilder.price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", chesyNo='" + chesyNo + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

class CarBuilder {
    public String carName;
    public String chesyNo;
    public String fuelType;
    public String price;

    public CarBuilder setCarName(String carName) {
        this.carName = carName;
        return this;
    }

    public CarBuilder setChesyNo(String chesyNo) {
        this.chesyNo = chesyNo;
        return this;
    }

    public CarBuilder setFuelType(String fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public CarBuilder setPrice(String price) {
        this.price = price;
        return this;
    }

    public Car build() {
        return new Car(this);
    }

}
