package main.java.com.worldline.interview;

public class InternalCombustionEngine extends AbstractEngine {

    public InternalCombustionEngine(FuelType requiredFuelType) {

        if (!(requiredFuelType.equals(FuelType.PETROL) || requiredFuelType.equals(FuelType.DIESEL))) {
            throw new IllegalStateException("Incompatible fuel type");
        }

        this.requiredFuelType = requiredFuelType;
        this.batchSize = 8;
        running = false;
        fuelLevel = 0;
    }
}
