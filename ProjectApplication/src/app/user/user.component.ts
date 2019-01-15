import { Component, OnInit } from '@angular/core';
import {FormsModule}        from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
users: any[];
sortvar ='employee_id';
private userURL = 'http://localhost:8156/users'; 
private getuserURL = 'http://localhost:8156/user'; 
private addUserURL = 'http://localhost:8156/createUser';  
private upUserURL = 'http://localhost:8156/updateUser'; 
private delUserURL = 'http://localhost:8156/deleteUser'; 
 httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' ,'Access-Control-Allow-Origin': '*'})
};
 httpOptions2 = {
  headers: new HttpHeaders({ 'Access-Control-Allow-Origin': '*'})
};

  usr: any = {};
  constructor(private http: HttpClient) { }

  ngOnInit() {
	  this.http.get(this.userURL)  
      .subscribe(response => {  
	  this.users = response as any;  
	  
        
      });
  }
 
  
  createUser(user:any){
	  console.log(user);
	  var val = Math.floor(1000 + Math.random() * 9000);
user.user_id=val;

	this.http.post(this.addUserURL, JSON.stringify(user),this.httpOptions)  
    .subscribe(response => {  
		 this.http.get(this.userURL)  
      .subscribe(response => {  
        this.users = response as any;  
      });   
    });  
	//console.log(user);	
	alert("User Created");
}
editUser(user:any){
	alert("edit triggered");
	this.http.get(this.getuserURL+'/'+user.user_id,this.httpOptions2)  
      .subscribe(response => {  
        this.usr = response;  
		//console.log(this.usr);
      });  
}
updateUser(user:any){
    this.http.put(this.upUserURL , JSON.stringify(user),this.httpOptions)  
    .subscribe(response => {
		 this.http.get(this.userURL)  
      .subscribe(response => {  
        this.users = response as any;    
      });
    }); 	
	alert("User Updated");
}
deleteUser(user:any){
	this.http.delete(this.delUserURL + '/' + user.user_id)  
      .subscribe(response => {  
        let index = this.users.indexOf(user);  
        this.users.splice(index, 1);  
      });    	
	alert("User Deleted");
}
sortUser(sortValue:any){
	 this.sortvar = sortValue;	 
}

}
