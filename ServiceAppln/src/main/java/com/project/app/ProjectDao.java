package com.project.app;

import java.util.List;

public interface ProjectDao {
	public void createProject(Project project);    
	public Project getProjectById(Integer id);
    public List<Project> getAllProjects();    
    public void updateProject(Project project);    
    public void deleteProject(Integer id);  
    public String getNoOfTasks(Integer id);
}
