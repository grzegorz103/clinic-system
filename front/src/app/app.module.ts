import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { RegisterComponent } from "./public/register/register.component";
import { LoginComponent } from "./public/login/login.component";
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import { VisitCreateComponent } from './visit-create/visit-create.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { UserService } from './services/user.service';
import { RequestInterceptor } from './request-interceptor';
import { VisitsMyComponent } from './visits-my/visits-my.component';
import { DlDateTimeDateModule, DlDateTimePickerModule } from 'angular-bootstrap-datetimepicker';
import { MomentModule } from 'ngx-moment';
import 'moment/locale/de';
import { VisitEditComponent } from './visit-edit/visit-edit.component';
import { VisitDetailsComponent } from './visit-details/visit-details.component';
import { DoctorListComponent } from './doctor-list/doctor-list.component';
import { IndexComponent } from './index/index.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    RegisterComponent,
    VisitCreateComponent,
    VisitsMyComponent,
    VisitEditComponent,
    VisitDetailsComponent,
    DoctorListComponent,
    IndexComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    DlDateTimeDateModule,
    DlDateTimePickerModule, 
    MomentModule
  ],
  providers: [UserService, {
    provide: HTTP_INTERCEPTORS,
    useClass: RequestInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule {
}
