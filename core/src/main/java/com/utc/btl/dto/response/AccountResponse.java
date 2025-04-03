package com.utc.btl.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountResponse {

    private long id;
    private String username;
    private String password;
    private long elo;
    private int win;
    private int loss;
    private int draw;
}
