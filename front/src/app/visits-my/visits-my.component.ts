import { Component, OnInit } from '@angular/core';
import { VisitService } from '../services/visit.service';
import { Visit } from '../models/visit';

@Component({
  selector: 'app-visits-my',
  templateUrl: './visits-my.component.html',
  styleUrls: ['./visits-my.component.css']
})
export class VisitsMyComponent implements OnInit {

  visits: Visit[];

  constructor(private visitService: VisitService) { }

  ngOnInit() {
    this.visitService.findUsers()
      .subscribe(res => this.visits = res);
  }

}
