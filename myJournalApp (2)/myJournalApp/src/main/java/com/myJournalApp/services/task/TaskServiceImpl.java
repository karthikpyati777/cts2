package com.myJournalApp.services.task;

import com.myJournalApp.dtos.TaskDTO;
import com.myJournalApp.entity.User;
import com.myJournalApp.repos.TaskRepository;
import com.myJournalApp.entity.Task;
import com.myJournalApp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private UserRepo userRepo;


    @Override
    public TaskDTO save(TaskDTO taskDTO) {
        Optional<User> optionalUser = userRepo.findById(taskDTO.getCreatedBy());
        if(optionalUser.isPresent()){
            Task task = new Task();
            task.setTaskName(taskDTO.getTaskName());
            task.setTaskDesc(taskDTO.getTaskDesc());
            task.setTaskDate(taskDTO.getTaskDate());
            task.setCreatedTS(new Date());
            task.setUpdatedTS(new Date());
            task.setCreatedBy(optionalUser.get());
            task.setUpdatedBy(optionalUser.get());
            return repository.save(task).getDto();
        }
        else{
            return null;
        }
    }


    @Override
    public TaskDTO findById(Long id) {
        return repository.findById(id).orElse(null).getDto();
    }

    @Override
    public List<TaskDTO> findAll() {
         List<Task> taskList = (List<Task>) repository.findAll();
         return taskList.stream().map(Task::getDto).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findAllByName(String name) {
        List<Task> taskList = repository.findAllByTaskNameContains(name);
        return taskList.stream().map(Task::getDto).collect(Collectors.toList());
    }

    @Override
    public TaskDTO update(TaskDTO taskDTO, Long id) {
        Optional<User> optionalUser = userRepo.findById(taskDTO.getUpdatedBy());
        Optional<Task> optional = repository.findById(id);
        if (optional.isPresent() && optionalUser.isPresent()) {
            Task task = optional.get();
            task.setTaskName(taskDTO.getTaskName());
            task.setTaskDesc(taskDTO.getTaskDesc());
            task.setTaskDate(taskDTO.getTaskDate());
            task.setUpdatedTS(new Date());
            task.setUpdatedBy(optionalUser.get());

            repository.save(task);
            return task.getDto();
        }
        return null;
    }

    @Override
    public List<TaskDTO> findAllByDate(Date date) throws ParseException {
        List<Task> taskList = repository.findAllByTaskDate(date);
        return taskList.stream().map(Task::getDto).collect(Collectors.toList());
    }
}