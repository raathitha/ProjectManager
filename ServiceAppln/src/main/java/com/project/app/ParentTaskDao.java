package com.project.app;

import java.util.List;

public interface ParentTaskDao {
	public void createParentTask(ParentTask pTask);    
	public ParentTask getParentTaskById(Integer id);
    public List<ParentTask> getAllParentTasks();    
    public void updateParentTask(ParentTask pTask);    
    public void deleteParentTask(Integer id);
}
