import { Component, OnInit } from '@angular/core';
import { VisitService } from '../services/visit.service';
import { Visit } from '../models/visit';
import { ActivatedRoute } from '@angular/router';
import * as moment from 'moment';

@Component({
  selector: 'app-visit-edit',
  templateUrl: './visit-edit.component.html',
  styleUrls: ['./visit-edit.component.css']
})
export class VisitEditComponent implements OnInit {

  visit: Visit;
  id: number;

  constructor(private visitService: VisitService,
    private activatedRoute: ActivatedRoute) {
      moment.locale('pl');
    this.activatedRoute.params.subscribe(params =>
      this.id = params['id']
    );
  }

  ngOnInit() {
    this.visitService.findById(this.id)
      .subscribe(res => {
        this.visit = res;
        this.visit.visitDate = new Date(this.visit.visitDate);
      });
  }

  save() {
    this.visitService.update(this.visit)
      .subscribe(res => {
        this.visit = res;
        this.visit.visitDate = new Date(this.visit.visitDate);
        alert('Wizyta zaktualizowana')
      }, err => alert('Niepoprawna data'));
  }

}
