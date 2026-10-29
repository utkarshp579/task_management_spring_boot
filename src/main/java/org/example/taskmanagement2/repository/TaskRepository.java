package org.example.taskmanagement2.repository;

import org.example.taskmanagement2.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {

}
