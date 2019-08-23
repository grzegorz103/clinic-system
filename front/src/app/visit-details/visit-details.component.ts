import { Component, OnInit } from '@angular/core';
import { Visit } from '../models/visit';
import { VisitService } from '../services/visit.service';
import { ActivatedRoute } from '@angular/router';
import * as moment from 'moment';

@Component({
  selector: 'app-visit-details',
  templateUrl: './visit-details.component.html',
  styleUrls: ['./visit-details.component.css']
})
export class VisitDetailsComponent implements OnInit {

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
  .subscribe(res => this.visit = res);
  }

}
