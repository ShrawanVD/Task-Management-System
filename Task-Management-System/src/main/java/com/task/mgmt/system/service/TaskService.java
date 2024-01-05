package com.task.mgmt.system.service;

import java.util.List;

import com.task.mgmt.system.entity.TaskEntity;

public interface TaskService {

	public TaskEntity addTask(TaskEntity task);
	public List<TaskEntity> getAllTasks();
	public TaskEntity updateTask(TaskEntity task, long id);
	public void delete(long id);
	
}
