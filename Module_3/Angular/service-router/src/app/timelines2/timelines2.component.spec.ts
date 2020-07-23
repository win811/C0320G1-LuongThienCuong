import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Timelines2Component } from './timelines2.component';

describe('Timelines2Component', () => {
  let component: Timelines2Component;
  let fixture: ComponentFixture<Timelines2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Timelines2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Timelines2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
