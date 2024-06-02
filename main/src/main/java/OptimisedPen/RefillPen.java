package OptimisedPen;

import PenV1.Entity.Refill;

public interface RefillPen {
    void changeRefill(Refill refill);
    boolean canRefill();
    void getRefill();
}
