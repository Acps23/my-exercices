package io.codeforall.fanstatics;

import javax.persistence.*;

@Entity
@Table(name = "car_table_per_class")
public class Car extends Vehicle {
    private Integer gears;

    public Integer getGears() {
        return gears;
    }

    public void setGears(Integer gears) {
        this.gears = gears;
    }
}
