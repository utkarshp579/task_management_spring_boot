package org.example.taskmanagement2.controllers;

import jakarta.validation.Valid;
import org.example.taskmanagement2.dto.requestDto.CreateRequestDto;
import org.example.taskmanagement2.dto.responseDto.ResponseInfoDto;
import org.example.taskmanagement2.entity.Task;
import org.example.taskmanagement2.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TaskController {

    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<ResponseInfoDto> create(@RequestBody(required = false) @Valid CreateRequestDto requestDto) {
        ResponseInfoDto savedResponseInfo = taskService.save(requestDto);
        return savedResponseInfo != null ? new ResponseEntity<>(savedResponseInfo, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable int id) {
        Task taskResponse = taskService.findById(id) ;
//        return taskResponse == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.status(HttpStatus.OK).body(taskResponse);
        return ResponseEntity.ok(taskResponse); // after setting Exception Handler. 
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable int id, @RequestBody Task requestTask) {
        Task taskResponse = taskService.update(id, requestTask);

        // happy flow. 
        return ResponseEntity.status(HttpStatus.OK).body(taskResponse);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteById(@PathVariable int id) {
        Task taskResponse = taskService.delete(id) ;
        return taskResponse == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.status(HttpStatus.OK).body(taskResponse);
    }

//    @DeleteMapping("/{id}")
//    public String deleteById(@PathVariable int id) {
//        taskService.delete(id) ;
//        return "Deleted task with id: " + id ;
//    }

}
