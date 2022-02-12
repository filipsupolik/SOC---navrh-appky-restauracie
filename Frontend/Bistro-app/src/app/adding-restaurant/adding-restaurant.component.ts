import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { Restaurant } from '../restaurant.model';
import { RestaurantService } from '../_services/restaurant.service';

@Component({
  selector: 'app-adding-restaurant',
  templateUrl: './adding-restaurant.component.html',
  styleUrls: ['./adding-restaurant.component.scss']
})
export class AddingRestaurantComponent implements OnInit {

  form!: FormGroup;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private restaurantService: RestaurantService) { }

  ngOnInit(): void {
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
        deliveryTime: [
          '',
          [
            Validators.required,
            Validators.minLength(1),
            Validators.maxLength(4),
            Validators.pattern('[0-9]*'),
          ]
        ],
        opening: [
          '',
          [
            Validators.required,
            Validators.minLength(1),
            Validators.maxLength(10),
            Validators.pattern('[a-zA-Z0-9]'),
          ]
        ]
      }
    )
  }

  createRestaurant(): void {
    const restaurant = {
      restaurantName: this.form.controls.restaurantName.value,
      address: this.form.controls.address.value,
    }
    this.restaurantService.createRestaurant(restaurant as Restaurant).subscribe();
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
