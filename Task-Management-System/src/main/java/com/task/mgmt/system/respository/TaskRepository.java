package com.task.mgmt.system.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.mgmt.system.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long>{

}
