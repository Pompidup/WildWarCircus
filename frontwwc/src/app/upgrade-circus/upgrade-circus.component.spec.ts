import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpgradeCircusComponent } from './upgrade-circus.component';

describe('UpgradeCircusComponent', () => {
  let component: UpgradeCircusComponent;
  let fixture: ComponentFixture<UpgradeCircusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpgradeCircusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpgradeCircusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
