package com.task.mgmt.system.service;

import java.util.List;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.task.mgmt.system.entity.TaskEntity;
import com.task.mgmt.system.respository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public TaskEntity addTask(TaskEntity task) {
		return taskRepository.save(task);
	}

	@Override
	public List<TaskEntity> getAllTasks() {
		return taskRepository.findAll(); 
	}

	@Override
	public TaskEntity updateTask(TaskEntity task, long id) {
		
		TaskEntity entity = taskRepository.findById(id).orElseThrow( () -> new RuntimeException("TaskEntity with id " + id + " not found"));

	    entity.setTitle(task.getTitle());
	    entity.setDescription(task.getDescription());
	    entity.setDueDate(task.getDueDate());
	    entity.setPriority(task.getPriority());
	    entity.setStatus(task.getStatus());

	    return taskRepository.save(entity);
		
//		Optional<TaskEntity> data = taskRepository.findById(id);
//		TaskEntity entity = null;
//		if(data.isPresent()) {
//	        entity.setTitle(task.getTitle());
//	        entity.setDescription(task.getDescription());
//	        entity.setDueDate(task.getDueDate());
//	        entity.setPriority(task.getPriority());
//	        entity.setStatus(task.getStatus());
//	        
//	        return taskRepository.save(entity);
//		}
//		System.out.print(id);
//		return null;
	}

	@Override
	public void delete(long id) {
		
		Optional<TaskEntity> data = taskRepository.findById(id);
		TaskEntity entity = null;
		if(data.isPresent()) {
			entity = data.get();
		}
		taskRepository.delete(entity);
		
	}

}
