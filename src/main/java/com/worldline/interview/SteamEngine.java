package main.java.com.worldline.interview;

public class SteamEngine extends AbstractEngine {

    public SteamEngine(FuelType requiredFuelType) {

        if (!(requiredFuelType.equals(FuelType.WOOD) || requiredFuelType.equals(FuelType.COAL))) {
            throw new IllegalStateException("Incompatible fuel type");
        }

        this.requiredFuelType = requiredFuelType;
        this.batchSize = 2;
        running = false;
        fuelLevel = 0;
    }
}
