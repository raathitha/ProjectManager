package com.project.app;

import java.util.List;

public interface TaskDao {
	public void createTask(Task task);    
	public Task getTaskById(Integer id);
    public List<Task> getAllTasks();    
    public void updateTask(Task task);    
    public void deleteTask(Integer id);
}
