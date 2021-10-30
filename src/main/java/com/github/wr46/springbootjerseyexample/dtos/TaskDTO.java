package com.github.wr46.springbootjerseyexample.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class TaskDTO implements Serializable {
    private long id;
    @NotEmpty
    private String name;
}
