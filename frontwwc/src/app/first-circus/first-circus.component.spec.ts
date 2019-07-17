import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FirstCircusComponent } from './first-circus.component';

describe('FirstCircusComponent', () => {
  let component: FirstCircusComponent;
  let fixture: ComponentFixture<FirstCircusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FirstCircusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FirstCircusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
