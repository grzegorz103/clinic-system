import { Component, OnInit } from '@angular/core';
import { VisitService } from '../services/visit.service';
import { Visit } from '../models/visit';
import * as moment from 'moment';


@Component({
  selector: 'app-visits-my',
  templateUrl: './visits-my.component.html',
  styleUrls: ['./visits-my.component.css']
})
export class VisitsMyComponent implements OnInit {

  visits: Visit[];

  constructor(private visitService: VisitService) { 
    moment.locale('pl');
  }

  ngOnInit() {
    this.visitService.findUsers()
      .subscribe(res => {
        this.visits = res;
        this.visits.forEach(e => e.visitDate = new Date(e.visitDate));
      });
  }

  save(index: number) {
    this.visitService.update(this.visits[index])
      .subscribe(res => this.visits[index] = res);
  }
}
