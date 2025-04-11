package com.utc.btl.entity;

import lombok.*;

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

    @Override
    public String toString() {
        return "Account [id = " + id
                   + ", username = " + username
                   + ", password = " + password
                   + ", elo = " + elo
                   + ", win = " + win
                   + ", loss = " + loss
                   + ", draw = " + draw + "]";
    }
}
/*
CREATE TABLE `caro`.`account` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `elo` INT NULL DEFAULT 500,
    `win` INT NULL DEFAULT 0,
    `loss` INT NULL DEFAULT 0,
    `draw` INT NULL DEFAULT 0,
PRIMARY KEY (`id`),
UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);
*/
