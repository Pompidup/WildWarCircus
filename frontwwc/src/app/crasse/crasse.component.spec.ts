import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CrasseComponent } from './crasse.component';

describe('CrasseComponent', () => {
  let component: CrasseComponent;
  let fixture: ComponentFixture<CrasseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CrasseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrasseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
