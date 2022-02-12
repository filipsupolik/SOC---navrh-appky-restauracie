import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddingRestaurantComponent } from './adding-restaurant.component';

describe('AddingRestaurantComponent', () => {
  let component: AddingRestaurantComponent;
  let fixture: ComponentFixture<AddingRestaurantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddingRestaurantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddingRestaurantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
