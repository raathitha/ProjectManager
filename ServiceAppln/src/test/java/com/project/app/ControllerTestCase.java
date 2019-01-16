package com.project.app;

import static org.junit.Assert.*;

import org.aspectj.lang.annotation.Before;
import org.junit.BeforeClass;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import io.restassured.RestAssured;
import junit.framework.TestCase;

@ContextConfiguration(locations="classpath:ServiceAppln-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ControllerTestCase {

	 private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext wac;
	
	 @org.junit.Before
	    public void setup() throws Exception {
	        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	    }
	
	    
	 @Test
		@Transactional
		@Rollback(true)
	 public void getParentHappyFace() {
	     try {
			this.mockMvc.perform(get("/parents")).andDo(MockMvcResultHandlers.print()).andExpect(status().is2xxSuccessful());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	 @Test
		@Transactional
		@Rollback(true)
	 public void getTaskHappyFace() {
	     try {
			this.mockMvc.perform(get("/tasks")).andDo(MockMvcResultHandlers.print()).andExpect(status().is2xxSuccessful());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getProjectHappyFace() {
	     try {
			this.mockMvc.perform(get("/projects")).andDo(MockMvcResultHandlers.print()).andExpect(status().is2xxSuccessful());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getUserHappyFace() {
	     try {
			this.mockMvc.perform(get("/users")).andDo(MockMvcResultHandlers.print()).andExpect(status().is2xxSuccessful());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	    
	 @Test
		@Transactional
		@Rollback(true)
	 public void getParentByIdHappyFace() {
	     try {
			this.mockMvc.perform(get("/parent/{id}",8963)).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 @Test
		@Transactional
		@Rollback(true)
	 public void getParentByIdSadFace() {
	     try {
			this.mockMvc.perform(get("/parent/{id}",11)).andDo(MockMvcResultHandlers.print()).andExpect(status().isNotFound());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	    
	 @Test
		@Transactional
		@Rollback(true)
	 public void getProjectByIdHappyFace() {
	     try {
			this.mockMvc.perform(get("/project/{id}",1267)).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 @Test
		@Transactional
		@Rollback(true)
	 public void getProjectByIdSadFace() {
	     try {
			this.mockMvc.perform(get("/project/{id}",11)).andDo(MockMvcResultHandlers.print()).andExpect(status().isNotFound());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getUserByIdHappyFace() {
	     try {
			this.mockMvc.perform(get("/user/{id}",2612)).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 @Test
		@Transactional
		@Rollback(true)
	 public void getUserByIdSadFace() {
	     try {
			this.mockMvc.perform(get("/user/{id}",11)).andDo(MockMvcResultHandlers.print()).andExpect(status().isNotFound());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getTaskByIdHappyFace() {
	     try {
			this.mockMvc.perform(get("/task/{id}",2)).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 @Test
		@Transactional
		@Rollback(true)
	 public void getTaskByIdSadFace() {
	     try {
			this.mockMvc.perform(get("/task/{id}",11)).andDo(MockMvcResultHandlers.print()).andExpect(status().isNotFound());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getParentDeleteByIdHappyFace() {
	     try {
			//this.mockMvc.perform(delete("/deleteParent/{id}",1)).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 @Test
		@Transactional
		@Rollback(true)
	 public void getParentDeleteByIdSadFace() {
	     try {
			this.mockMvc.perform(delete("/deleteParent/{id}",11)).andDo(MockMvcResultHandlers.print()).andExpect(status().isNotFound());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	    
	 @Test
		@Transactional
		@Rollback(true)
	 public void getProjectDeleteByIdHappyFace() {
	     try {
			//this.mockMvc.perform(delete("/deleteProject/{id}",1267)).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 @Test
		@Transactional
		@Rollback(true)
	 public void getProjectDeleteByIdSadFace() {
	     try {
			this.mockMvc.perform(delete("/deleteProject/{id}",11)).andDo(MockMvcResultHandlers.print()).andExpect(status().isNotFound());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getUserDeleteByIdHappyFace() {
	     try {
			//this.mockMvc.perform(delete("/deleteUser/{id}",1)).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 @Test
		@Transactional
		@Rollback(true)
	 public void getUserDeleteByIdSadFace() {
	     try {
			this.mockMvc.perform(delete("/deleteUser/{id}",11)).andDo(MockMvcResultHandlers.print()).andExpect(status().isNotFound());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getTaskDeleteByIdHappyFace() {
	     try {
			///this.mockMvc.perform(delete("/deleteTask/{id}",1)).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 @Test
		@Transactional
		@Rollback(true)
	 public void getTaskDeleteByIdSadFace() {
	     try {
			this.mockMvc.perform(delete("/deleteTask/{id}",11)).andDo(MockMvcResultHandlers.print()).andExpect(status().isNotFound());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getParentCreateHappyFace() {
	     try {
	    	 ParentTask pTsk = new ParentTask(Integer.valueOf(123443),"Test Parent Value");
	    	    ObjectMapper mapper = new ObjectMapper();
	    	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

	    	 String requestJson=ow.writeValueAsString(pTsk );
			this.mockMvc.perform(post("/createParent").contentType("application/json").content(requestJson)).andExpect(status().isConflict());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getProjectCreateHappyFace() {
	     try {
	    	 Project prj = new Project("Test Project", new Timestamp(( new java.util.Date()).getTime()), new Timestamp(( new java.util.Date()).getTime()), 1, 34546, 323786,"Started");
	 		   ObjectMapper mapper = new ObjectMapper();
	    	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

	    	 String requestJson=ow.writeValueAsString(prj );
			this.mockMvc.perform(post("/createProject").contentType("application/json").content(requestJson)).andExpect(status().isConflict());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getUserCreateHappyFace() {
	     try {
	    	 User usr = new User(12897,323123, "Rad", "sel", 12, 345);
	 		  ObjectMapper mapper = new ObjectMapper();
	    	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

	    	 String requestJson=ow.writeValueAsString(usr );
			this.mockMvc.perform(post("/createUser").contentType("application/json").content(requestJson)).andExpect(status().is2xxSuccessful());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getTaskCreateHappyFace() {
	     try {
	    	 Task task = new Task(Integer.valueOf(12365), Integer.valueOf(123), Integer.valueOf(143), "Test Title", new Timestamp(( new java.util.Date()).getTime()),new Timestamp(( new java.util.Date()).getTime()), Integer.valueOf(1), "Completed", 323786);
	 		  ObjectMapper mapper = new ObjectMapper();
	    	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

	    	 String requestJson=ow.writeValueAsString(task );
			this.mockMvc.perform(post("/createTask").contentType("application/json").content(requestJson)).andExpect(status().isConflict());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getParentUpdateHappyFace() {
	     try {
	    	 ParentTask pTsk = new ParentTask(Integer.valueOf(12342443),"Test Parent Value");
	    	    ObjectMapper mapper = new ObjectMapper();
	    	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

	    	 String requestJson=ow.writeValueAsString(pTsk );
			this.mockMvc.perform(put("/updateParent").contentType("application/json").content(requestJson)).andExpect(status().isNotFound());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getProjectUpdateHappyFace() {
	     try {
	    	 Project prj = new Project("Test Project", new Timestamp(( new java.util.Date()).getTime()), new Timestamp(( new java.util.Date()).getTime()), 1, 4234546, 323786,"Started");
	 		   ObjectMapper mapper = new ObjectMapper();
	    	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

	    	 String requestJson=ow.writeValueAsString(prj );
			this.mockMvc.perform(put("/updateProject").contentType("application/json").content(requestJson)).andExpect(status().isNotFound());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getUserUpdateHappyFace() {
	     try {
	    	 User usr = new User(12842,323123, "Rad", "sel", 12, 345);
	 		  ObjectMapper mapper = new ObjectMapper();
	    	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

	    	 String requestJson=ow.writeValueAsString(usr );
			this.mockMvc.perform(put("/updateUser").contentType("application/json").content(requestJson)).andExpect(status().isNotFound());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getTaskUpdateHappyFace() {
	     try {
	    	 Task task = new Task(Integer.valueOf(12362325), Integer.valueOf(123), Integer.valueOf(143), "Test Title", new Timestamp(( new java.util.Date()).getTime()),new Timestamp(( new java.util.Date()).getTime()), Integer.valueOf(1), "Completed", 323786);
	 		  ObjectMapper mapper = new ObjectMapper();
	    	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

	    	 String requestJson=ow.writeValueAsString(task );
			this.mockMvc.perform(put("/updateTask").contentType("application/json").content(requestJson)).andExpect(status().isNotFound());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getParentUpdateSadFace() {
	     try {
	    	 ParentTask pTsk = new ParentTask(Integer.valueOf(8963),"Test Parent Value");
	    	    ObjectMapper mapper = new ObjectMapper();
	    	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

	    	 String requestJson=ow.writeValueAsString(pTsk );
			this.mockMvc.perform(put("/updateParent").contentType("application/json").content(requestJson)).andExpect(status().is2xxSuccessful());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getProjectUpdateSadFace() {
	     try {
	    	 Project prj = new Project("Test Project", new Timestamp(( new java.util.Date()).getTime()), new Timestamp(( new java.util.Date()).getTime()), 1, 1267, 323786,"Started");
	 		   ObjectMapper mapper = new ObjectMapper();
	    	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

	    	 String requestJson=ow.writeValueAsString(prj );
			this.mockMvc.perform(put("/updateProject").contentType("application/json").content(requestJson)).andExpect(status().is2xxSuccessful());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getUserUpdateSadFace() {
	     try {
	    	 User usr = new User(128,323123, "Rad", "sel", 12, 345);
	 		  ObjectMapper mapper = new ObjectMapper();
	    	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

	    	 String requestJson=ow.writeValueAsString(usr );
			this.mockMvc.perform(put("/updateUser").contentType("application/json").content(requestJson)).andExpect(status().is2xxSuccessful());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Test
		@Transactional
		@Rollback(true)
	 public void getTaskUpdateSadFace() {
	     try {
	    	 Task task = new Task(Integer.valueOf(123), Integer.valueOf(123), Integer.valueOf(143), "Test Title", new Timestamp(( new java.util.Date()).getTime()),new Timestamp(( new java.util.Date()).getTime()), Integer.valueOf(1), "Completed", 323786);
	 		  ObjectMapper mapper = new ObjectMapper();
	    	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

	    	 String requestJson=ow.writeValueAsString(task );
			this.mockMvc.perform(put("/updateTask").contentType("application/json").content(requestJson)).andExpect(status().is2xxSuccessful());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
