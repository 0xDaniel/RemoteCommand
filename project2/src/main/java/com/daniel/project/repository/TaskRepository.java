package com.daniel.project.repository;

import java.util.Optional;

import com.daniel.project.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {

    Optional<Task> findByEmployeename(String employeename);

    Optional<Task> findByTask(String task);
}
