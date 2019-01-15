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
@Table(name="PROJECT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PROJECT")
public class Project {

	@Id
    @Column(name = "PROJECT_ID", unique = true)
	public Integer project_id;
		
	@Column(name = "PROJECT")
	public String project;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	@Column(name = "STARTDATE")
	public Timestamp startdate;
	

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	@Column(name = "ENDDATE")
	public Timestamp enddate;

	@Column(name = "PRIORITY")
	public Integer priority;
	

	@Column(name = "MANAGER_ID")
	public Integer manager_id;
	
	 public Project()
	    {
	        super();
	    }
	    public Project(String project,Timestamp startdate,Timestamp enddate,Integer priority, Integer project_id,Integer manager_id)
	    {
	        super();
	        this.project = project;
		    this.startdate = startdate;
	        this.enddate = enddate;
	        this.priority = priority;
	        this.manager_id = manager_id;
	    }
	 
	    public Integer getProject_id() {
			return project_id;
		}
		public void setProject_id(Integer project_id) {
			this.project_id = project_id;
		}
		public String getProject() {
			return project;
		}
		public void setProject(String project) {
			this.project = project;
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
		
		
		
		public Integer getManager_id() {
			return manager_id;
		}
		public void setManager_id(Integer manager_id) {
			this.manager_id = manager_id;
		}
		@Override
	    public int hashCode()
	    {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((project_id == 0) ? 0 : String.valueOf(project_id).hashCode());
	        result = prime * result + ((project == null) ? 0 :  String.valueOf(project).hashCode());
	        result = prime * result + ((startdate == null) ? 0 :  startdate.hashCode());
	        result = prime * result + ((enddate == null) ? 0 :  enddate.hashCode());
	        result = prime * result + ((priority == null) ? 0 :  String.valueOf(priority).hashCode());
	        result = prime * result + ((manager_id == null) ? 0 :  String.valueOf(manager_id).hashCode());
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
	        Project other = (Project) obj;
	        if (project_id == 0)
	        {
	            if (other.project_id != 0)
	                return false;
	        } else if (project_id != other.project_id)
	            return false;
	        if (project == null)
	        {
	            if (other.project != null)
	                return false;
	        } else if (!project.equals(other.project))
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
	        if (manager_id == null)
	        {
	            if (other.manager_id != null)
	                return false;
	        } else if (!manager_id.equals(other.manager_id))
	            return false;
	       
	        
	        return true;
	    }
	    @Override
	    public String toString()
	    {
	        return "Project [ProjectID=" + project_id + ", project=" + project +"]";
	    }
}
