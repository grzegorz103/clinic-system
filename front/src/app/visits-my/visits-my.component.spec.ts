import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VisitsMyComponent } from './visits-my.component';

describe('VisitsMyComponent', () => {
  let component: VisitsMyComponent;
  let fixture: ComponentFixture<VisitsMyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VisitsMyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VisitsMyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
