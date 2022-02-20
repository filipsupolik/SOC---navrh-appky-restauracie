import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SteakComponent } from './steak.component';

describe('SteakComponent', () => {
  let component: SteakComponent;
  let fixture: ComponentFixture<SteakComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SteakComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SteakComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
