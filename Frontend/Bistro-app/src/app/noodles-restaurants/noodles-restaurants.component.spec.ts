import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NoodlesRestaurantsComponent } from './noodles-restaurants.component';

describe('NoodlesRestaurantsComponent', () => {
  let component: NoodlesRestaurantsComponent;
  let fixture: ComponentFixture<NoodlesRestaurantsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NoodlesRestaurantsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NoodlesRestaurantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
