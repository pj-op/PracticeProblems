package com.new_problems;

import java.util.List;

public class MainSignal {
    private String signalId;
    private List<RawSignal> rawSignals;


    public MainSignal(String signalId, List<RawSignal> rawSignals) {
        this.signalId = signalId;
        this.rawSignals = rawSignals;
    }

    public String getSignalId() {
        return signalId;
    }

    public void setSignalId(String signalId) {
        this.signalId = signalId;
    }

    public List<RawSignal> getRawSignals() {
        return rawSignals;
    }

    public void setRawSignals(List<RawSignal> rawSignals) {
        this.rawSignals = rawSignals;
    }

    @Override
    public String toString() {
        return "MainSignal{" +
                "signalId='" + signalId + '\'' +
                ", rawSignals=" + rawSignals +
                '}';
    }
}
