package com.kintore.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserDto  implements Serializable {
    private String name;
    private String password;
    private String mail;
}