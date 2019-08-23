import { Component, OnInit } from '@angular/core';
import { VisitService } from '../services/visit.service';
import { Visit } from '../models/visit';
import { ActivatedRoute } from '@angular/router';
import * as moment from 'moment';
import { DateButton } from 'angular-bootstrap-datetimepicker';

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
    this.getVisit();
  }

  getVisit() {
    this.visitService.findById(this.id)
      .subscribe(res => {
        this.visit = res;
        this.visit.visitDate = new Date(this.visit.visitDate);
      });
  }

  save() {
    if (this.visit.visitDate.getTime() < Date.now() || (this.visit.visitDate.getHours() < 8 ||
    this.visit.visitDate.getHours() > 16)) {
      alert('Niepoprawna data');
      return;
    }
    this.visitService.update(this.visit)
      .subscribe(res => {
        this.visit = res;
        this.visit.visitDate = new Date(this.visit.visitDate);
        alert('Wizyta zaktualizowana')
      }, err => { alert('Data zajeta'); this.getVisit() });
  }

   selectFilter(dateButton: DateButton, viewName: string): boolean {
    let date = new Date();
    date.setHours(0,0,0,0);
    return dateButton.value >= date.getTime();
 }
}
