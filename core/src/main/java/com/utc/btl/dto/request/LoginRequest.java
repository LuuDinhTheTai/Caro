package com.utc.btl.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginRequest {

    private String username;
    private String password;

    public boolean validate() {

        if (Objects.equals(username, "a") && Objects.equals(password, "a")) {
            return true;
        }
        return false;
    }
}
