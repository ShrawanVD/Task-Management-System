package com.task.mgmt.system.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.mgmt.system.entity.TaskEntity;
import com.task.mgmt.system.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	// add task
	@PostMapping()
	public ResponseEntity<TaskEntity> addTask(@RequestBody TaskEntity task){
		try {
			return new ResponseEntity<TaskEntity>(taskService.addTask(task),HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<TaskEntity>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// get all task
	@GetMapping()
	public ResponseEntity<List<TaskEntity>> getTask(){
		try {
			List<TaskEntity> entityList = taskService.getAllTasks();
			return new ResponseEntity<List<TaskEntity>>(entityList,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	// update task
	@PutMapping("{id}")
	public ResponseEntity<Object> update(@RequestBody TaskEntity task, @PathVariable("id") long id){
		try {
			return new ResponseEntity<>(taskService.updateTask(task, id),HttpStatus.OK);
		} catch (RuntimeException ex) {
	        String errorMessage = "Error: " + ex.getMessage();
	        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
//		catch (NoSuchElementException e) {
//	        String errorMessage = "Task with ID " + id + " not found";
//	        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
//	    } catch (Exception e) {
//	        // Handle other exceptions with a generic error message
//	        return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
	}
	
	
	// update task
		@DeleteMapping("{id}")
		public ResponseEntity<TaskEntity> deleteTask(@PathVariable("id") long id){    
			try {
				this.taskService.delete(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
		        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		    }
		}
	

}













