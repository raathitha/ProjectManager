package com.project.app;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="USERS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "USERS")
public class User {
	
	
	
	@Id
    @Column(name = "USER_ID", unique = true)
	public Integer user_id;
	
	@Column(name = "EMPLOYEE_ID", unique = true)
	public Integer employee_id;
	

	@Column(name = "FIRST_NAME")
	public String first_name;

	@Column(name = "LAST_NAME")
	public String last_name;


	@Column(name = "PROJECT_ID")
	public Integer project_id;

	@Column(name = "TASK_ID")
	public Integer task_id;

	
	
	public User()
    {
        super();
    }
    public User(Integer employee_id,String first_name, String last_name,Integer project_id,Integer task_id)
    {
        super();
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.project_id = project_id;
        this.task_id = task_id;
    }
 
    public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Integer getProject_id() {
		return project_id;
	}
	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}
	public Integer getTask_id() {
		return task_id;
	}
	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}
	@Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((employee_id == 0) ? 0 : String.valueOf(employee_id).hashCode());
        result = prime * result + ((first_name == null) ? 0 :  String.valueOf(first_name).hashCode());
        result = prime * result + ((project_id == null) ? 0 :  String.valueOf(project_id).hashCode());
        result = prime * result + ((last_name == null) ? 0 :  String.valueOf(last_name).hashCode());
        result = prime * result + ((task_id == null) ? 0 :  String.valueOf(task_id).hashCode());
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
        User other = (User) obj;
        if (task_id == 0)
        {
            if (other.task_id != 0)
                return false;
        } else if (task_id != other.task_id)
            return false;
        if (employee_id == null)
        {
            if (other.employee_id != null)
                return false;
        } else if (!employee_id.equals(other.employee_id))
            return false;
        if (project_id == null)
        {
            if (other.project_id != null)
                return false;
        } else if (!project_id.equals(other.project_id))
            return false;
        if (first_name == null)
        {
            if (other.first_name != null)
                return false;
        } else if (!first_name.equals(other.first_name))
            return false;
        if (last_name == null)
        {
            if (other.last_name != null)
                return false;
        } else if (!last_name.equals(other.last_name))
            return false;
       
       
        
        return true;
    }
    @Override
    public String toString()
    {
        return "User [EmployeeId=" + employee_id + ", Firstname=" + first_name +"]";
    }
}
