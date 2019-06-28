package com.ll.springcloudapi.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Dept implements Serializable {
    private long deptno;
    private String dname;
    private String db_source;

    public Dept() {
        super();
        this.dname=dname;
    }
}
