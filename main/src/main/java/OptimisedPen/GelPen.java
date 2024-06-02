package OptimisedPen;

import PenV1.Entity.Refill;
import PenV1.Entity.Type;
import PenV1.Interfaces.RefillPen;
import PenV1.Strategy.SmoothWritingStrategy;


public class GelPen extends Pen implements RefillPen {
    private Refill refill;

    public GelPen(String name, String brand, double price, Refill refill) {
        super(name, brand, Type.GEL, price, new SmoothWritingStrategy());
        this.refill = refill;
    }
    @Override
    public void write() {
        System.out.println("gel pen writing ");
    }

    @Override
    public void changeRefill() {
        if (canRefill()){
            this.refill = refill;
        }
     }

    @Override
    public Refill getRefill() {
        return refill;
    }

    @Override
    public boolean canRefill() {
        return false;
    }
}
