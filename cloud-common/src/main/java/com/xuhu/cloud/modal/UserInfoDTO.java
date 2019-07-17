package com.xuhu.cloud.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInfoDTO implements Serializable {
    private String id;
    private String userName;
    private Integer age;
}
