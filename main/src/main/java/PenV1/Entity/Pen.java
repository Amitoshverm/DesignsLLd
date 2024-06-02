package PenV1.Entity;

import PenV1.Strategy.WritingStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Pen {
    private String name;
    private String brand;
    private double price;
    private Type type;
    private WritingStrategy writingStrategy;

    public void write() {
        writingStrategy.write();
    }
}
