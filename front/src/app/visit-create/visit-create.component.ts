import { Component, OnInit } from '@angular/core';
import { Visit } from '../models/visit';
import { VisitService } from '../services/visit.service';
import { Router } from '@angular/router';
import * as moment from 'moment';
import { DateButton } from 'angular-bootstrap-datetimepicker';

@Component({
  selector: 'app-visit-create',
  templateUrl: './visit-create.component.html',
  styleUrls: ['./visit-create.component.css']
})
export class VisitCreateComponent implements OnInit {

  visit: Visit;

  constructor(private visitService: VisitService,
    private router: Router) {

  }

  ngOnInit() {
    this.fetchData();
  }

  fetchData() {
    this.visit = new Visit();
    const current = new Date();
    current.setHours(current.getHours() + 1, 0, 0, 0);
    this.visit.visitDate = current;
    moment.locale('pl');
  }

  save() {
    if (this.visit.visitDate.getTime() < Date.now() || (this.visit.visitDate.getHours() < 8 ||
      this.visit.visitDate.getHours() > 16)) {
      alert('Niepoprawna data');
      return;
    }
    this.visitService.create(this.visit)
      .subscribe(res => {
        this.visit = res;
        this.visit.visitDate = new Date(this.visit.visitDate);
        alert('Zapisano na wizytę')
      }, err => { alert('Data zajeta'); this.fetchData() });
  }

  selectFilter(dateButton: DateButton, viewName: string): boolean {
    let date = new Date();
    date.setHours(0, 0, 0, 0);
    return dateButton.value >= date.getTime();
  }
}
