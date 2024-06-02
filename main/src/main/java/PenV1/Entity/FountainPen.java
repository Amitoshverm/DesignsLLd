package PenV1.Entity;

import PenV1.Interfaces.RefillPen;
import PenV1.Strategy.SmoothWritingStrategy;
import PenV1.Strategy.WritingStrategy;

public class FountainPen extends Pen implements RefillPen{
    public FountainPen(String name, String brand, double price) {
        super(name, brand, price, Type.FOUNTAIN, new SmoothWritingStrategy());
    }

    @Override
    public void changeRefill() {

    }

    @Override
    public Refill getRefill() {
        return null;
    }

    @Override
    public boolean canRefill() {
        return false;
    }
}
