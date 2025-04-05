package com.utc.btl.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {

    private Long id;
    private String username;
    private String password;
    private long elo;
    private int win;
    private int loss;
    private int draw;
}
