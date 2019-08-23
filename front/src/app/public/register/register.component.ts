import { Component, OnInit } from '@angular/core';
import { DoctorService } from "../../services/doctor.service";
import { UserService } from "../../services/user.service";
import { User } from "../../models/user";
import { Doctor } from "../../models/doctor";
import { Patient } from 'src/app/models/patient';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User;
  doctors: Doctor[];

  constructor(
    private doctorService: DoctorService,
    private userService: UserService,
    private router: Router
  ) {
    this.user = new User();
    this.user.patient = new Patient();
    this.doctorService.findAll()
      .subscribe(res => this.doctors = res);
  }

  ngOnInit() {
  }

  onSubmit() {
    this.userService.create(this.user)
      .subscribe(res => { alert('Dziękujemy za rejestrację'); this.router.navigate(['login']) },
        err => console.log('Error'));
  }
}
