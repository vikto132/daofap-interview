package com.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Parent{
    private Long id;
    private String sender;
    private String receiver;
    private Long totalAmount;
}
