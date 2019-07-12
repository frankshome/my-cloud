package com.xuhu.cloud.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dept implements Serializable {
    private String id;
    private String deptName;
    private String source;
}
