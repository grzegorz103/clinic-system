import { Component, OnInit } from '@angular/core';
import { Visit } from '../models/visit';
import { VisitService } from '../services/visit.service';
import { ActivatedRoute } from '@angular/router';
import * as moment from 'moment';
import { Doctor } from '../models/doctor';
import { DoctorService } from '../services/doctor.service';

@Component({
  selector: 'app-visit-details',
  templateUrl: './visit-details.component.html',
  styleUrls: ['./visit-details.component.css']
})
export class VisitDetailsComponent implements OnInit {

  visit: Visit;
  id: number;
  doctor: Doctor;

  constructor(private visitService: VisitService,
    private activatedRoute: ActivatedRoute,
    private doctorService: DoctorService) {
    moment.locale('pl');
    this.activatedRoute.params.subscribe(params =>
      this.id = params['id']
    );
  }

  ngOnInit() {
    this.visitService.findById(this.id)
      .subscribe(res => {
        this.visit = res;
        this.doctorService.findUsers()
          .subscribe(data => this.doctor = data);
      });
  }

}
