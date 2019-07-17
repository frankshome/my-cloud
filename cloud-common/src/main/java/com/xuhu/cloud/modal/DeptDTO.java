package com.xuhu.cloud.modal;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeptDTO implements Serializable {
    private String id;
    private String deptName;
    private String source;
}
