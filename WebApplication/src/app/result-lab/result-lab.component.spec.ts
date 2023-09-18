import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultLabComponent } from './result-lab.component';

describe('ResultLabComponent', () => {
  let component: ResultLabComponent;
  let fixture: ComponentFixture<ResultLabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResultLabComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ResultLabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
