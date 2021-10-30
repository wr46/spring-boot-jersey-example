package com.github.wr46.springbootjerseyexample.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class TaskDTO implements Serializable {
    private Long id;
    private String name;
}
