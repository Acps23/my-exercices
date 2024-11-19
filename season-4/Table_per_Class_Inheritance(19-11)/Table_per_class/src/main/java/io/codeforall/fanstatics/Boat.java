package io.codeforall.fanstatics;

import javax.persistence.*;

@Entity
@Table(name = "boat_table_per_class")
public class Boat extends Vehicle {
    private Integer engines;

    public Integer getEngines() {
        return engines;
    }

    public void setEngines(Integer engines) {
        this.engines = engines;
    }
}
