package test.java.com.worldline.interview;

import main.java.com.worldline.interview.FuelType;
import main.java.com.worldline.interview.InternalCombustionEngine;
import main.java.com.worldline.interview.SteamEngine;
import main.java.com.worldline.interview.WidgetMachine;
import org.junit.Test;

import static org.junit.Assert.*;

public class WidgetMachineTest {

    @Test
    public void produceWidgetWithDieselTest() {
        WidgetMachine machine = new WidgetMachine(new InternalCombustionEngine(FuelType.DIESEL), FuelType.DIESEL, 100);
        assertEquals(12.00, machine.produceWidgets(8), 0);
    }

    @Test
    public void produceWidgetWithPetrolTest() {
        WidgetMachine machine = new WidgetMachine(new InternalCombustionEngine(FuelType.PETROL), FuelType.PETROL, 100);
        assertEquals(9.00, machine.produceWidgets(8), 0);
    }

    @Test
    public void produceWidgetWithWoodTest() {
        WidgetMachine machine = new WidgetMachine(new SteamEngine(FuelType.WOOD), FuelType.WOOD, 100);
        assertEquals(4.35, machine.produceWidgets(2), 0);
    }

    @Test
    public void produceWidgetWithCoalTest() {
        WidgetMachine machine = new WidgetMachine(new SteamEngine(FuelType.COAL), FuelType.COAL, 100);
        assertEquals(5.65, machine.produceWidgets(2), 0);
    }

    @Test(expected = IllegalStateException.class)
    public void fillIncompatibleFuelTypeTest() {
        WidgetMachine machine = new WidgetMachine(new InternalCombustionEngine(FuelType.PETROL), FuelType.DIESEL, 100);
        assertEquals(9, machine.produceWidgets(8), 0);
    }

    @Test(expected = IllegalStateException.class)
    public void insufficientFuelWidgetWithDieselTest() {
        WidgetMachine machine = new WidgetMachine(new InternalCombustionEngine(FuelType.DIESEL), FuelType.DIESEL, 0);
        assertEquals(12.00, machine.produceWidgets(8), 0);
    }

    @Test(expected = IllegalStateException.class)
    public void initIncompatibleFuelTypeTest() {
        WidgetMachine machine = new WidgetMachine(new InternalCombustionEngine(FuelType.WOOD), FuelType.WOOD, 100);
        assertEquals(4.35, machine.produceWidgets(8), 0);
    }


}