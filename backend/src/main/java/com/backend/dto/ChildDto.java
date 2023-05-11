package com.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChildDto implements Serializable {
    private Long id;
    private String sender;
    private String receiver;
    private Long totalAmount;
    private Long totalPaidAmount;
}
