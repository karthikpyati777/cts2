package com.myJournalApp.controllers;

import com.myJournalApp.dtos.TaskDTO;
import com.myJournalApp.services.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping()
    public ResponseEntity<TaskDTO> saveTask(@RequestBody TaskDTO taskDTO)
    {
        return new ResponseEntity(taskService.save(taskDTO), HttpStatus.CREATED);

    }

    @GetMapping("all")
    public ResponseEntity<TaskDTO> getAllTask()
    {
        return new ResponseEntity(taskService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/searchByName/{title}")
    public ResponseEntity searchTasksByTitle(@PathVariable("title") String title) {
        return new ResponseEntity(taskService.findAllByName(title), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TaskDTO findById(@PathVariable("id") Long id) {
        return taskService.findById(id);
    }

    @PutMapping("/{id}")
    public TaskDTO updateTask(@PathVariable("id") Long id, @RequestBody TaskDTO taskDTO) {
        return taskService.update(taskDTO,id);
    }

    @GetMapping("/searchByDate/{date}")
    public ResponseEntity searchTaskByDate(@PathVariable("date") Date date) throws ParseException {
        return new ResponseEntity(taskService.findAllByDate(date), HttpStatus.OK);
    }
}
