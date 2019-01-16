package com.project.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="PARENTTASK")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PARENTTASK")
public class ParentTask {
	@Id
    @Column(name = "PARENT_ID", unique = true)
	public Integer parent_id;
	
	@Column(name = "PARENT_TASK", unique = false, nullable = false)
	public String parent_task;
	
	   public ParentTask()
	    {
	        super();
	    }
	    public ParentTask(Integer parent_id, String parent_task)
	    {
	        super();
	        this.parent_id = parent_id;
	        this.parent_task = parent_task;
	    }
	 
	    public Integer getParent_id() {
			return parent_id;
		}
		public void setParent_id(Integer parent_id) {
			this.parent_id = parent_id;
		}
		public String getParent_task() {
			return parent_task;
		}
		public void setParent_task(String parent_task) {
			this.parent_task = parent_task;
		}
		@Override
	    public int hashCode()
	    {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((parent_id == 0) ? 0 : String.valueOf(parent_id).hashCode());
	        result = prime * result + ((parent_task == null) ? 0 : parent_task.hashCode());
	        return result;
	    }
	    @Override
	    public boolean equals(Object obj)
	    {
	        if (this == obj)
	            return true;
	        /*if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        ParentTask other = (ParentTask) obj;
	        if (parent_id == 0)
	        {
	            if (other.parent_id != 0)
	                return false;
	        } else if (parent_id != other.parent_id)
	            return false;
	        if (parent_task == null)
	        {
	            if (other.parent_task != null)
	                return false;
	        } else if (!parent_task.equals(other.parent_task))
	            return false;*/
	        
	        return true;
	    }
	    @Override
	    public String toString()
	    {
	        return "ParentTask [parentId=" + parent_id + ", parent_task=" + parent_task +"]";
	    }
}
