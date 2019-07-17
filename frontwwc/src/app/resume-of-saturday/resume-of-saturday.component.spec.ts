import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResumeOfSaturdayComponent } from './resume-of-saturday.component';

describe('ResumeOfSaturdayComponent', () => {
  let component: ResumeOfSaturdayComponent;
  let fixture: ComponentFixture<ResumeOfSaturdayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResumeOfSaturdayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResumeOfSaturdayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
