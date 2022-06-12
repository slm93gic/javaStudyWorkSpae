package com.shenlimin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias(value = "wocao")
public class User {

    private int id;
    private String name;
    private String pwd;
    private String lastName;


}
