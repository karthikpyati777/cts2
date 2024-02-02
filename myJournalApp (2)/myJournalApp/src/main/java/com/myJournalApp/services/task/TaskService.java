package com.myJournalApp.services.task;

import com.myJournalApp.dtos.TaskDTO;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface TaskService {

    TaskDTO save(TaskDTO taskDTO);

    List<TaskDTO> findAll();

    List<TaskDTO> findAllByName(String name);

    TaskDTO findById(Long id);

    TaskDTO update(TaskDTO taskDTO, Long id);

    List<TaskDTO> findAllByDate(Date date) throws ParseException;
}