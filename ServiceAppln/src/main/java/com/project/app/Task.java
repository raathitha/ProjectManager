package com.project.app;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="TASK")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TASK")
public class Task {
	@Id
    @Column(name = "TASK_ID", unique = true)
	public Integer task_id;
	
	@Column(name = "PARENT_ID")
	public Integer parent_id;
	
	
	@Column(name = "PROJECT_ID")
	public Integer project_id;
	
	@Column(name = "TASK_TITLE")
	public String task_Title;
	

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	@Column(name = "STARTDATE")
	public Timestamp startdate;
	

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	@Column(name = "ENDDATE")
	public Timestamp enddate;

	@Column(name = "PRIORITY")
	public Integer priority;
	
	@Column(name = "Status")
	public String status;
	
	@Column(name = "EMPLOYEE_ID")
	public Integer employee_id;
	
	   public Task()
	    {
	        super();
	    }
	    public Task(Integer task_id,Integer parent_id,Integer project_id, String task_Title,Timestamp startdate,Timestamp enddate,Integer priority,String status,Integer employee_id)
	    {
	        super();
	        this.task_id = task_id;
	        this.parent_id = parent_id;
	        this.project_id = project_id;
	        this.task_Title = task_Title;
	        this.startdate = startdate;
	        this.enddate = enddate;
	        this.priority = priority;
	        this.employee_id = employee_id;
	        this.status = status;
	    }
	 
	    public Integer getTask_id() {
			return task_id;
		}
		public void setTask_id(Integer task_id) {
			this.task_id = task_id;
		}
		public Integer getParent_id() {
			return parent_id;
		}
		public void setParent_id(Integer parent_id) {
			this.parent_id = parent_id;
		}
		public Integer getProject_id() {
			return project_id;
		}
		public void setProject_id(Integer project_id) {
			this.project_id = project_id;
		}
		public String getTask_Title() {
			return task_Title;
		}
		public void setTask_Title(String task_Title) {
			this.task_Title = task_Title;
		}
		public Timestamp getStartdate() {
			return startdate;
		}
		public void setStartdate(Timestamp startdate) {
			this.startdate = startdate;
		}
		public Timestamp getEnddate() {
			return enddate;
		}
		public void setEnddate(Timestamp enddate) {
			this.enddate = enddate;
		}
		public Integer getPriority() {
			return priority;
		}
		public void setPriority(Integer priority) {
			this.priority = priority;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		public Integer getEmployee_id() {
			return employee_id;
		}
		public void setEmployee_id(Integer employee_id) {
			this.employee_id = employee_id;
		}
		@Override
	    public int hashCode()
	    {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((task_id == 0) ? 0 : String.valueOf(task_id).hashCode());
	        result = prime * result + ((parent_id == null) ? 0 :  String.valueOf(task_id).hashCode());
	        result = prime * result + ((project_id == null) ? 0 :  String.valueOf(project_id).hashCode());
	        result = prime * result + ((task_Title == null) ? 0 :  String.valueOf(task_Title).hashCode());
	        result = prime * result + ((startdate == null) ? 0 :  String.valueOf(startdate).hashCode());
	        result = prime * result + ((enddate == null) ? 0 :  String.valueOf(enddate).hashCode());
	        result = prime * result + ((priority == null) ? 0 :  String.valueOf(priority).hashCode());
	        result = prime * result + ((status == null) ? 0 :  String.valueOf(status).hashCode());
	        result = prime * result + ((employee_id == null) ? 0 :  String.valueOf(employee_id).hashCode());
	        return result;
	    }
	    @Override
	    public boolean equals(Object obj)
	    {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Task other = (Task) obj;
	        if (task_id == 0)
	        {
	            if (other.task_id != 0)
	                return false;
	        } else if (task_id != other.task_id)
	            return false;
	        if (parent_id == null)
	        {
	            if (other.parent_id != null)
	                return false;
	        } else if (!parent_id.equals(other.parent_id))
	            return false;
	        if (project_id == null)
	        {
	            if (other.project_id != null)
	                return false;
	        } else if (!project_id.equals(other.project_id))
	            return false;
	        if (task_Title == null)
	        {
	            if (other.task_Title != null)
	                return false;
	        } else if (!task_Title.equals(other.task_Title))
	            return false;
	        if (startdate == null)
	        {
	            if (other.startdate != null)
	                return false;
	        } else if (!startdate.equals(other.startdate))
	            return false;
	        if (enddate == null)
	        {
	            if (other.enddate != null)
	                return false;
	        } else if (!enddate.equals(other.enddate))
	            return false;
	        if (priority == null)
	        {
	            if (other.priority != null)
	                return false;
	        } else if (!priority.equals(other.priority))
	            return false;
	        if (status == null)
	        {
	            if (other.status != null)
	                return false;
	        } else if (!status.equals(other.status))
	            return false;
	        if (employee_id == null)
	        {
	            if (other.employee_id != null)
	                return false;
	        } else if (!employee_id.equals(other.employee_id))
	            return false;
	        return true;
	    }
	    @Override
	    public String toString()
	    {
	        return "Task [TaskID=" + task_id + ", task_Title=" + task_Title +"]";
	    }
}
