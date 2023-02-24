package com.worldline.interview;

public class WidgetMachine {
    private InternalCombustionEngine engine = new InternalCombustionEngine(new FuelType[]{FuelType.WOOD, FuelType.COAL});

    public double produceWidgets(int quantity) {
        engine.start();
        double cost = 0;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();

        return cost;
    }

    private double produce(int quantity) {
        int batch = 0;
        int batchCount = 0;
        double costPerBatch = 0;

        if (engine.getFuelType() == FuelType.PETROL) {
            costPerBatch = 9;
        } else if (engine.getFuelType() == FuelType.DIESEL) {
            costPerBatch = 12;
        } else if(engine.getFuelType() == FuelType.COAL) {
            costPerBatch = 5.65;
        } else if(engine.getFuelType() == FuelType.WOOD) {
            costPerBatch = 4.35;
        }

        if(engine.getFuelType().equals(FuelType.PETROL) ||
                engine.getFuelType().equals(FuelType.DIESEL)) {
            while (batch < quantity) {
                batch = batch + 8;
                batchCount++;
            }
        } else {
            while (batch < quantity) {
                batch = batch + 2;
                batchCount++;
            }
        }

        return batchCount * costPerBatch;
    }

    public InternalCombustionEngine getEngine() {
        return engine;
    }

}
