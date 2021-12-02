import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PizzaRestaurantsComponent } from './Pizza_Restaurants.component';

describe('AllRestaurantsComponent', () => {
  let component: PizzaRestaurantsComponent;
  let fixture: ComponentFixture<PizzaRestaurantsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PizzaRestaurantsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PizzaRestaurantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
