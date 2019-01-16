package com.project.app;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

@ContextConfiguration(locations="classpath:ServiceAppln-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class DaoTestCase  {

	@Autowired
	private TaskDaoImpl tkImpl;
	@Autowired
	private ParentTaskDaoImpl ptImpl;
	@Autowired
	private ProjectDaoImpl pjImpl;
	@Autowired
	private UserDaoImpl usrImpl;
	
	
	@Test
	public void test1() {
	   assertEquals(2,2);
	}
		
		
	@Test
	@Transactional
	@Rollback(true)
	public void testAllTasks() {
		List<Task> tasklist = tkImpl.getAllTasks();
			assertEquals(tasklist.size(), 7);
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void createTask() {
		Task task = new Task(Integer.valueOf(123), Integer.valueOf(123), Integer.valueOf(143), "Test Title", new Timestamp(( new java.util.Date()).getTime()),new Timestamp(( new java.util.Date()).getTime()), Integer.valueOf(1), "Completed", 323786);
		System.out.println("Test execution ::"+task.toString()+""+task.hashCode());

		boolean created = task.equals(task);
		tkImpl.createTask(task);
			assertEquals(task.task_Title, "Test Title");
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void getTaskById() {
		
		Task tk = tkImpl.getTaskById(3);

		assertNotNull(tk);
			assertEquals(tk.task_Title, "New Task 3");
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void updateTask() {
		
		Task tk = tkImpl.getTaskById(3);
		tk.setStatus("InProgress");
		tk.setTask_id(1);
		tk.setPriority(3);
		tk.setEnddate(new Timestamp(( new java.util.Date()).getTime()));
		tk.setStartdate(new Timestamp(( new java.util.Date()).getTime()));
		tk.setEmployee_id(53534);
		tk.setTask_Title("New Task 1");
		tk.setParent_id(2434);
		tk.setProject_id(534);
		  tkImpl.updateTask(tk);

			assertNotNull(tk);
			assertEquals(tk.getTask_Title(), "New Task 1");
			assertEquals(String.valueOf(tk.getEmployee_id()),"53534");
			assertEquals(String.valueOf(tk.getPriority()), "3");
			assertEquals(String.valueOf(tk.getProject_id()), "534");
			assertEquals(String.valueOf(tk.getTask_id()), "1");
			assertEquals(String.valueOf(tk.getStatus()), "InProgress");
			System.out.println(tk.getEnddate()+""+tk.getStartdate());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void deleteTask() {
		
		 tkImpl.deleteTask(3);
		 Task tk = tkImpl.getTaskById(1);
			assertNull(tk);
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testAllParentTasks() {
		List<ParentTask> tasklist = ptImpl.getAllParentTasks();
			assertEquals(tasklist.size(), 4);
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void createParentTask() {
		ParentTask task = new ParentTask(Integer.valueOf(123),"Test Parent Value");
		System.out.println("Test execution ::"+task.toString()+""+task.hashCode());
		ptImpl.createParentTask(task);
			assertEquals(String.valueOf(task.getParent_id()),"123");
			ParentTask pTas = ptImpl.getParentTaskById(123);			
			boolean created = task.equals(pTas);
			
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void getParentTaskById() {
		
		ParentTask pTas = ptImpl.getParentTaskById(8963);

		assertNotNull(pTas);
			assertEquals(pTas.getParent_task(), "Test Parent Value");
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void updateParentTask() {
		
		ParentTask pTas = ptImpl.getParentTaskById(8963);
		pTas.setParent_task("UpdatedValue");
		pTas.setParent_id(1);
		  ptImpl.updateParentTask(pTas);

			assertNotNull(pTas);
			assertEquals(pTas.parent_task, "UpdatedValue");
			assertEquals(String.valueOf(pTas.parent_id), "1");
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void deleteParentTask() {
		
		 ptImpl.deleteParentTask(8963);
		 ParentTask pTas = ptImpl.getParentTaskById(1);
			assertNull(pTas);
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testAllUsers() {
		List<User> usrList = usrImpl.getAllUsers();
			assertEquals(usrList.size(), 7);
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void createUser() {
		User usr = new User(12,323123, "Rad", "sel", 12, 345);
		System.out.println("Test execution ::"+usr.toString()+""+usr.hashCode());
		
		usrImpl.createUser(usr);
		boolean created = usr.equals(usr);
			assertEquals(usr.first_name, "Rad");
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void getUserById() {
		
		User usr = usrImpl.getUserById(1);

		assertNotNull(usr);
			assertEquals(usr.getFirst_name(), "Radha");
			assertEquals(usr.getLast_name(), "Selvaraj");
			assertEquals(String.valueOf(usr.getEmployee_id()), "323786");
			assertEquals(String.valueOf(usr.getUser_id()), "1");
			assertEquals(String.valueOf(usr.getProject_id()), "1");
			assertEquals(String.valueOf(usr.getTask_id()), "1");
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void updateUser() {
		
		User usr = usrImpl.getUserById(2612);
		usr.setLast_name("selvarajj");
		usr.setFirst_name("Radhaa");
		usr.setEmployee_id(322323);
		usr.setProject_id(55);
		usr.setTask_id(5555553);
		usr.setUser_id(35);
		  usrImpl.updateUser(usr);

			assertNotNull(usr);
			assertEquals(usr.first_name, "Radhaa");
			assertEquals(String.valueOf(usr.user_id), "35");
			assertEquals(String.valueOf(usr.project_id),"55");
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void deleteUser() {
		
		 usrImpl.deleteUser(6917);
		 User usr = usrImpl.getUserById(7878);
			assertNull(usr);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testAllProject() {
		List<Project> prjList = pjImpl.getAllProjects();
			assertEquals(prjList.size(), 6);
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void createProject() {
		Project prj = new Project("Test Project", new Timestamp(( new java.util.Date()).getTime()), new Timestamp(( new java.util.Date()).getTime()), 1, 1, 323786,"Started");
		System.out.println("Test execution ::"+prj.toString()+""+prj.hashCode());
		
		pjImpl.createProject(prj);
			assertEquals(prj.project, "Test Project");
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void getProjectById() {
		
		Project prj = pjImpl.getProjectById(1267);

		boolean created = prj.equals(prj);
		assertNotNull(prj);
			assertEquals(prj.project, "Test Project");
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void updateProject() {
		
		Project prj = pjImpl.getProjectById(1267);
		prj.setProject("New Project 1 Update");
		prj.setManager_id(43);
		prj.setEnddate(new Timestamp(( new java.util.Date()).getTime()));
		prj.setStartdate(new Timestamp(( new java.util.Date()).getTime()));
		prj.setProject_id(2324);
		prj.setPriority(4);
		  pjImpl.updateProject(prj);

			assertNotNull(prj);
			assertEquals(prj.getProject(), "New Project 1 Update");
			assertEquals(String.valueOf(prj.getManager_id()),"43");
			assertEquals(String.valueOf(prj.getPriority()), "4");
			assertEquals(String.valueOf(prj.getProject_id()), "2324");
			System.out.println(prj.getEnddate()+""+prj.getStartdate());

	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void deleteProject() {
		
		 pjImpl.deleteProject(1267);
		 Project prj = pjImpl.getProjectById(9);
			assertNull(prj);
	}

}
