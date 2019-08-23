import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from "./public/register/register.component";
import { LoginComponent } from './public/login/login.component';
import { VisitsMyComponent } from './visits-my/visits-my.component';
import { VisitEditComponent } from './visit-edit/visit-edit.component';
import { VisitDetailsComponent } from './visit-details/visit-details.component';
import { VisitCreateComponent } from './visit-create/visit-create.component';
import { DoctorListComponent } from './doctor-list/doctor-list.component';


const routes: Routes = [
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'visits/my', component: VisitsMyComponent },
  { path: 'visits/:id', component: VisitEditComponent },
  { path: 'visits/:id/details', component: VisitDetailsComponent },
  { path: 'visits/new/form', component: VisitCreateComponent },
  {path: 'doctors', component: DoctorListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
