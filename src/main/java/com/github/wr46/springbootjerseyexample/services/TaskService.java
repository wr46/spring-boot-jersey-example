package com.github.wr46.springbootjerseyexample.services;

import com.github.wr46.springbootjerseyexample.dtos.TaskDTO;
import com.github.wr46.springbootjerseyexample.entities.Task;
import com.github.wr46.springbootjerseyexample.mappers.TaskMapper;
import com.github.wr46.springbootjerseyexample.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private TaskRepository taskRepository;

    public Optional<TaskDTO> getTask(Long id) {
        return taskRepository.findById(id).map(taskMapper::toDTO);
    }

    public List<TaskDTO> getTasks() {
        return taskMapper.toDTOs(taskRepository.findAll());
    }

    public TaskDTO createTask(TaskDTO task) {
        return taskMapper.toDTO(taskRepository.save(taskMapper.toEntity(task)));
    }
}
