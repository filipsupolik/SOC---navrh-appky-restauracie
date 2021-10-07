import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SerachBarComponent } from './serach-bar.component';

describe('SerachBarComponent', () => {
  let component: SerachBarComponent;
  let fixture: ComponentFixture<SerachBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SerachBarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SerachBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
