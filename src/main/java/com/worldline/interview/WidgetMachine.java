package main.java.com.worldline.interview;

public class WidgetMachine {

    private AbstractEngine engine;

    public WidgetMachine(AbstractEngine engine, FuelType fuelType, int fuelLevel) {
        this.engine = engine;

        engine.fill(fuelType, fuelLevel);
    }

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
        int batchSize = engine.getBatchSize();
        double costPerBatch = engine.getFuelType().price;

        while (batch < quantity) {
            batch = batch + batchSize;
            batchCount++;
        }

        return batchCount * costPerBatch;
    }


}
