package com.itland.naumenko.itjava.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private  int id;
    private String login;
    private String password;
}
