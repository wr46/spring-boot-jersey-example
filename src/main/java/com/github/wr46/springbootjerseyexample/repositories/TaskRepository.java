package com.github.wr46.springbootjerseyexample.repositories;

import com.github.wr46.springbootjerseyexample.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
