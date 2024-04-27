package com.new_problems;

public class RawSignal {
    private String vin;

    public RawSignal(String vin) {
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "RawSignal{" +
                "vin='" + vin + '\'' +
                '}';
    }
}
