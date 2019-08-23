import { Component, OnInit } from '@angular/core';
import { Doctor } from '../models/doctor';
import { DoctorService } from '../services/doctor.service';
import { User } from '../models/user';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent implements OnInit {

  doctors: Doctor[];
  doctor: Doctor;

  constructor(private doctorService: DoctorService) {
    this.fetchData();
    this.doctor = new Doctor();
    this.doctor.user = new User();
  }

  ngOnInit() {
  }

  fetchData() {
    this.doctorService.findAll()
      .subscribe(res => this.doctors = res);
  }

  remove(id: number) {
    this.doctorService.remove(id)
      .subscribe(res => this.fetchData());
  }

  save() {
    this.doctorService.save(this.doctor)
      .subscribe(res => { this.fetchData(); this.doctor = new Doctor(); this.doctor.user = new User() })
  }
}
