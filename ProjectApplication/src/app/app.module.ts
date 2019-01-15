import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ProjectComponent } from './project/project.component';
import { TaskComponent } from './task/task.component';
import { UserComponent } from './user/user.component';
import {FormsModule}        from '@angular/forms';
import { HttpClientModule  } from '@angular/common/http';
import { NavigationComponent } from './navigation/navigation.component';
import { MysortPipe } from './mysort.pipe';
import { FilterPipe } from './filter.pipe';
const appRoutes: Routes = [

   { path: '', pathMatch:'full', redirectTo: 'Project' },
   { path: 'Project', component: ProjectComponent },
   { path: 'Task', component: TaskComponent },
   { path: 'User', component: UserComponent }
];
@NgModule({
  declarations: [
    AppComponent,
    ProjectComponent,
    TaskComponent,
    UserComponent,
    NavigationComponent,
    MysortPipe,
    FilterPipe
  ],
  imports: [
    BrowserModule,FormsModule,
	HttpClientModule,
   RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
