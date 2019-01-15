package com.project.app;

import java.util.List;

public interface UserDao {
	public void createUser(User user);    
	public User getUserById(Integer id);
    public List<User> getAllUsers();    
    public void updateUser(User user);    
    public void deleteUser(Integer id);
}
