package com.personal.manager.service;

import com.personal.manager.model.Task;
import com.personal.manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Optional<Task> updateTask(Long id, Task updatedTask) {
        Optional<Task> existingTask = taskRepository.findById(id);

        if (existingTask.isPresent()) {
            Task task = existingTask.get();
            task.setText(updatedTask.getText());
            task.setCompleted(updatedTask.isCompleted());

            return Optional.of(taskRepository.save(task));
        }

        return Optional.empty();
    }

    public Optional<Task> toggleTaskStatus(Long id) {
        Optional<Task> existingTask = taskRepository.findById(id);

        if (existingTask.isPresent()) {
            Task task = existingTask.get();
            task.setCompleted(!task.isCompleted());

            return Optional.of(taskRepository.save(task));
        }

        return Optional.empty();
    }
}
