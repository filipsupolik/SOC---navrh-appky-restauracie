import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegionRestaurantsComponent } from './region-restaurants.component';

describe('RegionRestaurantsComponent', () => {
  let component: RegionRestaurantsComponent;
  let fixture: ComponentFixture<RegionRestaurantsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegionRestaurantsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegionRestaurantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
