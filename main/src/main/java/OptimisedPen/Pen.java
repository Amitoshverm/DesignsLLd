package OptimisedPen;

import PenV1.Entity.Refill;
import PenV1.Entity.Type;
import PenV1.Strategy.WritingStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class Pen {
    private String name;
    private String brand;
    private Type type;
    private double price;
    private WritingStrategy writingStrategy;

    public void write() {
        writingStrategy.write();
    }

}
