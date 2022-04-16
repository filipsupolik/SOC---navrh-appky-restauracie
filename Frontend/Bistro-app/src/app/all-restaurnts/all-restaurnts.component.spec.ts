import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllRestaurntsComponent } from './all-restaurnts.component';

describe('AllRestaurntsComponent', () => {
  let component: AllRestaurntsComponent;
  let fixture: ComponentFixture<AllRestaurntsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllRestaurntsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllRestaurntsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
