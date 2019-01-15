import { Component, OnInit } from '@angular/core';
import {FormsModule}        from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {
projects: any[];
users: any[];
sortvar ='project_id';
mvalue='';
startddate : any;
endate : any;
private projectURL = 'http://localhost:8156/projects'; 
private getprojectURL = 'http://localhost:8156/project'; 
private userURL = 'http://localhost:8156/users'; 
private closeprojectURL = 'http://localhost:8156/closeProject'; 
private addProjectURL = 'http://localhost:8156/createProject';  
private upProjectURL = 'http://localhost:8156/updateProject'; 
private delProjectURL = 'http://localhost:8156/deleteProject'; 
 httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' ,'Access-Control-Allow-Origin': '*'})
};
 httpOptions2 = {
  headers: new HttpHeaders({ 'Access-Control-Allow-Origin': '*'})
};

  prj: any = {};
  constructor(private http: HttpClient) { }

  ngOnInit() {
	  this.http.get(this.projectURL)  
      .subscribe(response => {  
	  this.projects = response as any;  
	  
        
      });
	  this.http.get(this.userURL)  
      .subscribe(response => {  
	  this.users = response as any;  
	  });
  }
 updateManager(mValues:any){
	 this.mvalue = mValues;
 }
  
  addStartDate(sValue:any){
	  alert(sValue);
	  this.startddate=sValue;
  }
    addEndDate(eValue:any){
	  alert(eValue);
	    this.endate=eValue;
  }
  createProject(project:any){
	  var val = Math.floor(1000 + Math.random() * 9000);
	 	project.project_id=val;
		project.manager_id=this.mvalue;
		project.enddate=this.endate;
		project.startdate=this.startddate;
		 console.log(project);
	
	this.http.post(this.addProjectURL, JSON.stringify(project),this.httpOptions)  
    .subscribe(response => {  
		 this.http.get(this.projectURL)  
      .subscribe(response => {  
        this.projects = response as any;  
      });   
    });  
	//console.log(project);	
	alert("Project Created");
}
editProject(project:any){
	alert("edit triggered");
	this.http.get(this.getprojectURL+'/'+project.project_id,this.httpOptions2)  
      .subscribe(response => {  
        this.prj = response;  
		//console.log(this.prj);
      });  
}

updateProject(project:any){
    this.http.put(this.upProjectURL , JSON.stringify(project),this.httpOptions)  
    .subscribe(response => {
		 this.http.get(this.projectURL)  
      .subscribe(response => {  
        this.projects = response as any;    
      });
    }); 	
	alert("Project Updated");
}
deleteProject(project:any){
	this.http.delete(this.delProjectURL + '/' + project.project_id)  
      .subscribe(response => {  
        let index = this.projects.indexOf(project);  
        this.projects.splice(index, 1);  
      });    	
	alert("Project Deleted");
}
sortProject(sortValue:any){
	 this.sortvar = sortValue;	 
}

}
