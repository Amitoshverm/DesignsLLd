package PenV1;

import PenV1.Entity.FountainPen;
import PenV1.Entity.Pen;

public class main {
    public static void main(String[] args) {
        Pen pen = new FountainPen("trimax", "rynolds", 30);
        pen.getWritingStrategy().write();
    }
}
