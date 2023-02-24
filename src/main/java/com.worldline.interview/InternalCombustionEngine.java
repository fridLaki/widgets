package com.worldline.interview;

public class InternalCombustionEngine {

    private boolean running;
    private int fuelLevel;
    private FuelType requiredFuelType;
    private FuelType[] arrRequiredFuelType;
    private FuelType fuelType;

    public InternalCombustionEngine(FuelType requiredFuelType) {
        this.requiredFuelType = requiredFuelType;
        running = false;
        fuelLevel = 0;
    }

    public InternalCombustionEngine(FuelType[] arrRequiredFuelType) {
        this.arrRequiredFuelType = arrRequiredFuelType;
        running = false;
        fuelLevel = 0;
    }

    public void start() {
        if (fuelLevel > 0 && (arrRequiredFuelType[0].equals(fuelType) ||
                arrRequiredFuelType[1].equals(fuelType))) {
            running = true;
        } else {
             throw new IllegalStateException("Not able to start engine.");
        }
    }

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public void fill(FuelType fuelType, int fuelLevel) {
        if (fuelLevel >= 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
        }
        else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        }
        else {
            this.fuelLevel = 0;
        }

        if(fuelType.equals(FuelType.PETROL) || fuelType.equals(FuelType.DIESEL)) {
            throw new IllegalStateException("Sorry, the fuel type isn't supported");
        }

        this.fuelType = fuelType;
    }

    public FuelType getFuelType() {
        for (FuelType type: arrRequiredFuelType) {
            if (type.equals(fuelType)) {
                return  type;
            }
        }
        return null;
    }
}
