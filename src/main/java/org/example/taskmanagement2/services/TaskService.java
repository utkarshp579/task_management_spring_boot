package org.example.taskmanagement2.services;

import org.example.taskmanagement2.annotations.TrackExecutionTime;
import org.example.taskmanagement2.dto.requestDto.CreateRequestDto;
import org.example.taskmanagement2.dto.responseDto.ResponseInfoDto;
import org.example.taskmanagement2.entity.Task;
import org.example.taskmanagement2.exception.ResourceNotFoundException;
import org.example.taskmanagement2.repository.TaskRepository;
import org.springframework.stereotype.Service;


@Service
public class TaskService {
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // mapper class
    public ResponseInfoDto save(CreateRequestDto requestDto) {

        // mapper Class 
        Task task = mapDtoToEntity(requestDto);
        Task savedTask = taskRepository.save(task);
        ResponseInfoDto responseInfoDto = mapEntityToRequestDto(savedTask);
        return responseInfoDto;
    }

    @TrackExecutionTime(
            warnAfter = 1500,
            operation = "Get Student Data"
    )
    public Task findById(int id) {
        Task taskResponse = taskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Currently in Service. No task found by id : " + id )
        );

        return taskResponse;
    }

    public Task update(int id, Task requestTask){
        Task taskResponse = taskRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No task found with the " + id)
        );

        taskResponse.setDescription(requestTask.getDescription());
        taskResponse.setStatus(requestTask.getStatus());

        return taskRepository.save(taskResponse);
    }



//    public boolean delete(int id){
//        taskRepository.deleteById(id); ;
//        return true ;
//    }
    public Task delete(int id) {
        Task taskResponse = taskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No task found for deletion with " + id));

        taskRepository.delete(taskResponse);

        return taskResponse;
    }
        

    private Task mapDtoToEntity(CreateRequestDto requestDto) {
        Task task = new Task();
        task.setDescription(requestDto.getDescription());
        task.setStatus(requestDto.getStatus());
        return task;
    }

    private ResponseInfoDto mapEntityToRequestDto(Task task) {
        ResponseInfoDto responseInfoDto = new ResponseInfoDto();
        responseInfoDto.setMessage("Task created successfully");
        responseInfoDto.setStatus("success");
        responseInfoDto.setDescription(task.getDescription());
        responseInfoDto.setId(task.getId());
        return responseInfoDto;
    }
    
}
