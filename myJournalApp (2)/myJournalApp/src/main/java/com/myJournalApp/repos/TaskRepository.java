package com.myJournalApp.repos;

import com.myJournalApp.entity.Task;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    List<Task> findAllByTaskNameContains(String name);

    List<Task> findAllByTaskDate(@DateTimeFormat(pattern = "yyyy-MM-dd") @Param("from") Date from);
}