package com.github.wr46.springbootjerseyexample.mappers;

import com.github.wr46.springbootjerseyexample.dtos.TaskDTO;
import com.github.wr46.springbootjerseyexample.entities.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDTO toDTO(Task entity);
    Task toEntity(TaskDTO dto);
    List<TaskDTO> toDTOs(List<Task> entity);
}
