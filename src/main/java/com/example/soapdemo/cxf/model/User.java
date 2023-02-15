package com.example.soapdemo.cxf.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = -3628469724795296287L;

    private String userId;
    private String userName;
    private String email;
}
