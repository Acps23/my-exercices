package io.codeforall.fanstatics;
import javax.persistence.*;
@Entity(name="BoatSingleTable")
@DiscriminatorValue("car")
public class Car extends Vehicle {
    private Integer gears;

    public Integer getGears() {
        return gears;
    }

    public void setGears(Integer gears) {
        this.gears = gears;
    }
}