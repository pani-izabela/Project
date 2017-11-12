package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TaskMapperTest {
    @Test
    public void testMapToTask() throws Exception {
        //Given
        TaskDto taskDto = new TaskDto(1L, "test title", "test_content");
        TaskMapper taskMapper = new TaskMapper();

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(task.getContent(), "test_content");
    }

    @Test
    public void testMapToTaskDto() throws Exception {
        //Given
        Task task = new Task(1L, "test title task", "test content task");
        TaskMapper taskMapper = new TaskMapper();

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(taskDto.getTitle(), "test title task");

    }

    @Test
    public void testMapToTaskDtoList() throws Exception {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "test title task", "test content task"));
        TaskMapper taskMapper = new TaskMapper();

        //When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(taskDtos.size(), 1);
    }

}