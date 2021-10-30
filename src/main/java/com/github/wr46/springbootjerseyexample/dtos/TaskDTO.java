package com.github.wr46.springbootjerseyexample.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class TaskDTO implements Serializable {
    private long id;
    private String name;
}
