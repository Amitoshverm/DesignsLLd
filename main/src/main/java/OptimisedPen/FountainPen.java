package OptimisedPen;

import PenV1.Entity.Ink;
import PenV1.Entity.Nib;
import PenV1.Entity.Refill;
import PenV1.Entity.Type;
import PenV1.Strategy.SmoothWritingStrategy;

public class FountainPen extends Pen{
    private Ink ink;
    private Nib nib;

    public FountainPen(String name, String brand, double price, Ink ink, Nib nib) {
        super(name, brand, Type.FOUNTAIN, price, new SmoothWritingStrategy());
        this.nib = nib;
        this.ink = ink;

    }
    void changeInk(Ink ink) {
        this.ink = ink;
    }
}
