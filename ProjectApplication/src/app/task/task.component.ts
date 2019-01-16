import { Component, OnInit } from '@angular/core';

import {FormsModule}        from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {
tasks: any[];
users: any[];
projects:any[];
parents:any[];

parentsObj:any[];
sortvar ='task_id';
addButton=true;
projec='';
startddate : any; 
parentT ='';
user='';
tsk: any = {};
newObj:any = {};
selProj='';
selUsr='';
selTas='';
endate : any;
private taskURL = 'http://localhost:8156/tasks'; 
private parentURL = 'http://localhost:8156/parents'; 
private projectURL = 'http://localhost:8156/projects'; 
private gettaskURL = 'http://localhost:8156/task'; 
private userURL = 'http://localhost:8156/users'; 
private closetaskURL = 'http://localhost:8156/closeTask'; 
private addTaskURL = 'http://localhost:8156/createTask';  
private upTaskURL = 'http://localhost:8156/updateTask'; 
private delTaskURL = 'http://localhost:8156/deleteTask'; 
private closeParenttaskURL = 'http://localhost:8156/closeParent'; 
private addParentTaskURL = 'http://localhost:8156/createParent';  
private upParentTaskURL = 'http://localhost:8156/updateParent'; 
private delParentTaskURL = 'http://localhost:8156/deleteParent'; 
  httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' ,'Access-Control-Allow-Origin': '*'})
};
 httpOptions2 = {
  headers: new HttpHeaders({ 'Access-Control-Allow-Origin': '*'})
}; constructor(private http: HttpClient) { }

  ngOnInit() {
	   this.http.get(this.projectURL)  
      .subscribe(response => {  
	  this.projects = response as any;  
	 
        
      });
	   this.http.get(this.taskURL)  
      .subscribe(response => {  
	  this.tasks = response as any;  
	  
        
      });
	   this.http.get(this.parentURL)  
      .subscribe(response => {  
	  this.parents = response as any;
	
        
      }); 
	  this.http.get(this.userURL)  
      .subscribe(response => {  
	  this.users = response as any;  
	  
        
      });
  }
addP(mValues:any,textTo :any){
	 this.projec = textTo;
	 this.selProj = mValues;
 }
   addStartDate(sValue:any){
	  alert(sValue);
	  this.startddate=sValue;
  }
    addEndDate(eValue:any){
	  alert(eValue);
	    this.endate=eValue;
  }
 addPar(mValues:any,textTo :any){
	 this.parentT = textTo;
	 this.selUsr = mValues;
 } 
  addUsr(mValues:any,textTo :any){
	 this.user = textTo;
	 this.selTas = mValues;
 }  
  createTask(task:any){
	  var val = Math.floor(1000 + Math.random() * 9000);
	 	task.task_id=val;
		task.project_id=this.selProj;
		task.user_id=this.selUsr;
		task.parent_id=this.parentT;
		task.enddate=this.endate;
		task.startdate=this.startddate;		
		task.status='InProgress';		
		 console.log(task);
		 console.log(task.parent_id);
		 if(task.parent_id){
			 this.http.post(this.addTaskURL, JSON.stringify(task),this.httpOptions)  
				.subscribe(response => {  
					 this.http.get(this.taskURL)  
				  .subscribe(response => {  
					this.tasks = response as any;  
				  });   
				});
		 }else{
			 
			 this.newObj.parent_id=task.task_id;
			 this.newObj.parent_task=task.task_title;
			 this.http.post(this.addParentTaskURL, JSON.stringify(this.newObj),this.httpOptions)  
				.subscribe(response => {  
					 this.http.get(this.parentURL)  
				  .subscribe(response => {  
					this.parents = response as any;  
				  });   
				});
		 }
	/*
	this.http.post(this.addTaskURL, JSON.stringify(task),this.httpOptions)  
    .subscribe(response => {  
		 this.http.get(this.taskURL)  
      .subscribe(response => {  
        this.tasks = response as any;  
      });   
    });  */
	//console.log(project);	
	alert("Task Created");
}
editTask(task:any){
	alert("edit triggered");
	if(task.parent_id){
		this.http.get(this.gettaskURL+'/'+task.task_id,this.httpOptions2)  
      .subscribe(response => {  
        this.tsk = response as any;
		//console.log(this.prj);
      });  
	}else{
		this.http.get(this.gettaskURL+'/'+task.task_id,this.httpOptions2)  
      .subscribe(response => {  
        this.tsk = response as any;  
		//console.log(this.prj);
      }); 
	}
	this.addButton = false;
}

deleteTask(task:any){
	this.http.delete(this.delTaskURL + '/' + task.task_id)  
      .subscribe(response => {  
        let index = this.tasks.indexOf(task);  
        this.tasks.splice(index, 1);  
      });    	
	alert("Task Deleted");
}

sortTask(sortValue:any){
	 this.sortvar = sortValue;	 
}


}
