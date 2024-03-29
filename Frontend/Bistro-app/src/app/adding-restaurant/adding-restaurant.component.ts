import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EMPTY, Observable } from 'rxjs';
import { Restaurant } from '../restaurant.model';
import { FoodService } from '../_services/food.service';
import { RestaurantService } from '../_services/restaurant.service';

@Component({
  selector: 'app-adding-restaurant',
  templateUrl: './adding-restaurant.component.html',
  styleUrls: ['./adding-restaurant.component.scss']
})
export class AddingRestaurantComponent implements OnInit {

  form!: FormGroup;
  submitted = false;
  //categories$: Observable<String[]> = EMPTY;

  constructor(
    private formBuilder: FormBuilder,
    private restaurantService: RestaurantService,
    private foodService: FoodService) { }

  ngOnInit(): void {
    //this.categories$ = this.foodService.getCategories();
    this.form = this.formBuilder.group(
      {
        restaurantName: [
          '', 
        [
          Validators.required,
          Validators.pattern('[a-zA-Z ]*'),
        ]
      ],
        description: [
          '',
          [
            Validators.required,
            Validators.minLength(5),
            Validators.maxLength(20),
            Validators.pattern('[a-zA-Z ]*'),
          ]
        ],
        openingDay: [
          '',
          [
            Validators.required,
            Validators.minLength(1),
            Validators.maxLength(4),
          ]
        ],
        closingDay: [
          '',
          [
            Validators.required,
            Validators.minLength(1),
            Validators.maxLength(4),
          ]
        ],
        openingTime: [
          '',
          [
            Validators.required,
            Validators.minLength(1),
            Validators.maxLength(10),
            Validators.pattern('[a-zA-Z0-9]'),
          ]
        ],
        closingTime: [
          '',
          [
            Validators.required,
            Validators.minLength(1),
            Validators.maxLength(10),
            Validators.pattern('[a-zA-Z0-9]'),
          ]
        ],
        address: [
          '',
          [
            Validators.required,
            Validators.minLength(1),
            Validators.maxLength(10),
            Validators.pattern('[a-zA-Z0-9]')
          ]
          
        ],
        region: [
          '',
          [
            Validators.required,
            Validators.minLength(1),
            Validators.maxLength(10),
            Validators.pattern('[a-zA-Z0-9]')
          ]
          
        ],
        categories: [
            '',
            [
              Validators.required
            ]
        ],
      }
    )
  }

  createRestaurant(): void {
    const restaurant = {
      restaurantName: this.form.controls.restaurantName.value,
      description: this.form.controls.description.value,
      openingDay: this.form.controls.openingDay.value,
      closingDay: this.form.controls.closingDay.value,
      openingTime: this.form.controls.openingTime.value,
      closingTime: this.form.controls.closingTime.value,
      region: this.form.controls.region.value,
      address: this.form.controls.address.value,
    }
    this.restaurantService.createRestaurant(restaurant as unknown as Restaurant).subscribe();
  }

  get r(): { [key:string]: AbstractControl} {
    return this.form.controls;
  }

  onSubmit(): void {
    this.submitted = true;
    if (this.form.invalid) {
      return;
    }
  }

  onReset(): void{
    this.submitted = false;
    this.form.reset();
  }

}
