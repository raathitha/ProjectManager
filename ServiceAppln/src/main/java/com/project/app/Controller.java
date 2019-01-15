package com.project.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class Controller {
	@Autowired
    private BookDAOImpl bookDAOImpl;
	@Autowired
    private ParentTaskDaoImpl parentTaskDAOImpl;
	@Autowired
    private TaskDaoImpl taskDAOImpl;
	@Autowired
    private ProjectDaoImpl projectDaoImpl;
	@Autowired
    private UserDaoImpl userDaoImpl;
	
	
    /*** Creating a new Book ***/
    @RequestMapping(value="/create", method=RequestMethod.POST, 
            produces="application/json", consumes="application/json")
    public ResponseEntity<Void> createBook(@RequestBody Book book, UriComponentsBuilder ucBuilder)
    {
           System.out.println("Creating User " + book.getTitle());
        
        if (bookDAOImpl.getBookById(book.getBookid())!=null) {
            System.out.println("A Book with id " + book.getBookid() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }else{ 
	        bookDAOImpl.createBook(book);	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/book/{id}").buildAndExpand(book.getBookid() ).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
    }
    
    /*** Retrieve a single Book ***/
    @RequestMapping(value="/book/{id}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBookById(@PathVariable("id") long id)
    {
        Book book = bookDAOImpl.getBookById(id);
        if (book == null) {
            System.out.println("Book with id " + id + " not found");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }else{
        	return new ResponseEntity<Book>(book, HttpStatus.OK);
        }
    }
    
    /*** Retrieve all Books ***/
    @RequestMapping(value="/books", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getAllBooks()
    {
        List bookList = bookDAOImpl.getAllBooks();
        if(bookList.isEmpty()){
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
        }else{
        	return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
        }
    }
    /*** Retrieve all Books ***/
    @RequestMapping(value="/", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>>  getAllBooksHome()
    {
    	 List bookList = bookDAOImpl.getAllBooks();
         if(bookList.isEmpty()){
             return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
         }else{
        	 return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
         }
    }
    /*** Update a Book ***/
    @RequestMapping(value="/update", method=RequestMethod.PUT, consumes="application/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book>  updateBook(@RequestBody Book book)
    {
    	 if (bookDAOImpl.getBookById(book.getBookid())==null) {
             System.out.println("Book with id " + book.getBookid() + " not found");
             return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
         }else{
        	 bookDAOImpl.updateBook(book);
        	 return new ResponseEntity<Book>(book, HttpStatus.OK);
         }
    }
    
    /*** Delete a Book ***/
    @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void>  deleteBook(@PathVariable("id") long id)
    {
    	if (bookDAOImpl.getBookById(id)==null) {
            System.out.println("Book with id " + id + " not found");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

            bookDAOImpl.deleteBook(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }
    
    //--------------------------------------------------------Create-----------------------------------------------------------
    /*** Creating a new ParentTask ***/
    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value="/createParent", method=RequestMethod.POST, 
            produces="application/json", consumes="application/json")
    public ResponseEntity<Void> createParentTask(@RequestBody ParentTask parentTask, UriComponentsBuilder ucBuilder)
    {
           System.out.println("Creating parentTask " + parentTask.getParent_task());
        
        if (parentTaskDAOImpl.getParentTaskById(parentTask.getParent_id())!=null) {
            System.out.println("A Parent with id " + parentTask.getParent_id() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }else{ 
        	parentTaskDAOImpl.createParentTask(parentTask);	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/parent/{id}").buildAndExpand(parentTask.getParent_id() ).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
    }
    
    /*** Creating a new Task ***/

    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value="/createTask", method=RequestMethod.POST, 
            produces="application/json", consumes="application/json")
    public ResponseEntity<Void> createTask(@RequestBody Task task, UriComponentsBuilder ucBuilder)
    {
           System.out.println("Creating Task " + task.getTask_id());
        
        if (taskDAOImpl.getTaskById(task.getTask_id())!=null) {
            System.out.println("A Task with id " + task.getTask_id() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }else{ 
        	taskDAOImpl.createTask(task);	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/task/{id}").buildAndExpand(task.getTask_id() ).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
    }
    /*** Creating a new Project ***/

    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value="/createProject", method=RequestMethod.POST, 
            produces="application/json", consumes="application/json")
    public ResponseEntity<Void> createProject(@RequestBody Project project, UriComponentsBuilder ucBuilder)
    {
           System.out.println("Creating project " + project.getProject_id());
        
        if (projectDaoImpl.getProjectById(project.getProject_id())!=null) {
            System.out.println("A project with id " + project.getProject_id() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }else{ 
        	projectDaoImpl.createProject(project);	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/project/{id}").buildAndExpand(project.getProject_id() ).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
    }
    /*** Creating a new User ***/

    @CrossOrigin(origins = "http://localhost:4201")
     @RequestMapping(value="/createUser", method=RequestMethod.POST, 
            produces="application/json", consumes="application/json")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder)
    {
           System.out.println("Creating User " + user.getEmployee_id());        
        if (userDaoImpl.getUserById(user.getEmployee_id())!=null) {
            System.out.println("A User with id " + user.getEmployee_id() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }else{ 
        	userDaoImpl.createUser(user);	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getEmployee_id() ).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
    }
    
    //----------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------ALL LIST----------------------------------------------------------------------
    /*** Retrieve all ParentTask ***/

    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value="/parents", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ParentTask>> getAllParentTask()
    {
        List parentList = parentTaskDAOImpl.getAllParentTasks();
        if(parentList.isEmpty()){
            return new ResponseEntity<List<ParentTask>>(HttpStatus.NO_CONTENT);
        }else{
        	return new ResponseEntity<List<ParentTask>>(parentList, HttpStatus.OK);
        }
    }
    
    /*** Retrieve all Task ***/

    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value="/tasks", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Task>> getAllTask()
    {
        List tasksList = taskDAOImpl.getAllTasks();
        if(tasksList.isEmpty()){
            return new ResponseEntity<List<Task>>(HttpStatus.NO_CONTENT);
        }else{
        	return new ResponseEntity<List<Task>>(tasksList, HttpStatus.OK);
        }
    }
    
    /*** Retrieve all Project ***/

    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value="/projects", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Project>> getAllProject()
    {
        List projList = projectDaoImpl.getAllProjects();
        if(projList.isEmpty()){
            return new ResponseEntity<List<Project>>(HttpStatus.NO_CONTENT);
        }else{
        	return new ResponseEntity<List<Project>>(projList, HttpStatus.OK);
        }
    }
    
    /*** Retrieve all User ***/

    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value="/users", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUser()
    {
        List userlist = userDaoImpl.getAllUsers();
        if(userlist.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }else{
        	return new ResponseEntity<List<User>>(userlist, HttpStatus.OK);
        }
    }
    
  //--------------------------------------------------------Create-----------------------------------------------------------
    
  //--------------------------------------------------------Update-----------------------------------------------------------
    /*** Update a ParentTask ***/

    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value="/updateParent", method=RequestMethod.PUT, consumes="application/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ParentTask>  updateParentTask(@RequestBody ParentTask pTask)
    {
    	 if (parentTaskDAOImpl.getParentTaskById(pTask.getParent_id())==null) {
             System.out.println("Book with id " + pTask.getParent_id() + " not found");
             return new ResponseEntity<ParentTask>(HttpStatus.NOT_FOUND);
         }else{
        	 parentTaskDAOImpl.updateParentTask(pTask);
        	 return new ResponseEntity<ParentTask>(pTask, HttpStatus.OK);
         }
    }
    /*** Update a Task ***/

    @CrossOrigin(origins = "http://localhost:4201")
     @RequestMapping(value="/updateTask", method=RequestMethod.PUT, consumes="application/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task>  updateTask(@RequestBody Task task)
    {
    	 if (taskDAOImpl.getTaskById(task.getTask_id())==null) {
             System.out.println("task with id " + task.getTask_id() + " not found");
             return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
         }else{
        	 taskDAOImpl.updateTask(task);
        	 return new ResponseEntity<Task>(task, HttpStatus.OK);
         }
    }
    /*** Update a Project ***/

    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value="/updateProject", method=RequestMethod.PUT, consumes="application/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project>  updateProject(@RequestBody Project project)
    {
    	 if (projectDaoImpl.getProjectById(project.getProject_id())==null) {
             System.out.println("project with id " + project.getProject_id() + " not found");
             return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
         }else{
        	 projectDaoImpl.updateProject(project);
        	 return new ResponseEntity<Project>(project, HttpStatus.OK);
         }
    }
    /*** Update a User ***/

    @CrossOrigin(origins = "http://localhost:4201")
     @RequestMapping(value="/updateUser", method=RequestMethod.PUT, consumes="application/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User>  updateUser(@RequestBody User user)
    {
    	 if (userDaoImpl.getUserById(user.getUser_id())==null) {
             System.out.println("User with id " + user.getUser_id() + " not found");
             return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
         }else{
        	 userDaoImpl.updateUser(user);
        	 return new ResponseEntity<User>(user, HttpStatus.OK);
         }
    }
    
  //-------------------------------------------------------Update-----------------------------------------------------------
    
    //--------------------------------------------------------delete-----------------------------------------------------------
    /*** Delete a Parent ***/

    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value="/deleteParent/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void>  deleteParentTask(@PathVariable("id") Integer id)
    {
    	if (parentTaskDAOImpl.getParentTaskById(id)==null) {
            System.out.println("Parent with id " + id + " not found");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	parentTaskDAOImpl.deleteParentTask(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }
    
    
    /*** Delete a Task ***/

    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value="/deleteTask/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void>  deleteTask(@PathVariable("id") Integer id)
    {
    	if (taskDAOImpl.getTaskById(id)==null) {
            System.out.println("Task with id " + id + " not found");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	taskDAOImpl.deleteTask(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }
    
    
    /*** Delete a Project ***/

    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value="/deleteProject/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void>  deleteProject(@PathVariable("id") Integer id)
    {
    	if (projectDaoImpl.getProjectById(id)==null) {
            System.out.println("Project with id " + id + " not found");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	projectDaoImpl.deleteProject(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }
    
    
    /*** Delete a User ***/

    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value="/deleteUser/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void>  deleteUser(@PathVariable("id") Integer id)
    {
    	if (userDaoImpl.getUserById(id)==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{

        	userDaoImpl.deleteUser(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------
    
    /*** Retrieve a single Book ***/
    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value="/parent/{id}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ParentTask> getParentById(@PathVariable("id") Integer id)
    {
        ParentTask pt = parentTaskDAOImpl.getParentTaskById(id);
        if (pt == null) {
            System.out.println("Parent with id " + id + " not found");
            return new ResponseEntity<ParentTask>(HttpStatus.NOT_FOUND);
        }else{
        	return new ResponseEntity<ParentTask>(pt, HttpStatus.OK);
        }
    }
    
    /*** Retrieve a single Book ***/
    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value="/task/{id}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Integer id)
    {
        Task tk = taskDAOImpl.getTaskById(id);
        if (tk == null) {
            System.out.println("Task with id " + id + " not found");
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }else{
        	return new ResponseEntity<Task>(tk ,HttpStatus.OK);
        }
    }
    
    /*** Retrieve a single Book ***/
    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value="/project/{id}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> getProjectById(@PathVariable("id") Integer id)
    {
        Project pt = projectDaoImpl.getProjectById(id);
        if (pt == null) {
            System.out.println("Project with id " + id + " not found");
            return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
        }else{
        	return new ResponseEntity<Project>(pt, HttpStatus.OK);
        }
    }
    
    /*** Retrieve a single Book ***/
    @CrossOrigin(origins = "http://localhost:4201")
    @RequestMapping(value="/user/{id}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id)
    {
        User usr = userDaoImpl.getUserById(id);
        if (usr == null) {
            System.out.println("Parent with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }else{
        	return new ResponseEntity<User>(usr, HttpStatus.OK);
        }
    }
    
}
