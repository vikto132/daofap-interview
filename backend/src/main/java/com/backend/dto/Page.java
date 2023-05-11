package com.backend.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Page<T> implements Serializable {
    private List<T> data;
    private int total;
}
