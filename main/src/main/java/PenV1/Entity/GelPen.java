package PenV1.Entity;

import PenV1.Interfaces.RefillPen;
import PenV1.Strategy.SmoothWritingStrategy;

public class GelPen extends Pen implements RefillPen {

    public GelPen(String name, String brand, double price) {
        super(name, brand, price, Type.GEL, new SmoothWritingStrategy());
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
        return true;
    }
}
