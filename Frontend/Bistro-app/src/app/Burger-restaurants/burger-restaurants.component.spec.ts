import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BurgerRestaurantsComponent } from './burger-restaurants.component';

describe('BurgerRestaurantsComponent', () => {
  let component: BurgerRestaurantsComponent;
  let fixture: ComponentFixture<BurgerRestaurantsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BurgerRestaurantsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BurgerRestaurantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
