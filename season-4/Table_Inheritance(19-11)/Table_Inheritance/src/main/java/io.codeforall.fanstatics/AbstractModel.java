package io.codeforall.fanstatics;

import org.hibernate.annotations.*;

import javax.persistence.*;
import java.sql.Date;

@MappedSuperclass
public abstract class AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    @CreationTimestamp
    private Date creationTime;

    @UpdateTimestamp
    private Date updateTime;
}

