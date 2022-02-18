import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EMPTY, Observable } from 'rxjs';
import { Food } from '../food.model';
import { Restaurant } from '../restaurant.model';
import { FoodService } from '../_services/food.service';

@Component({
  selector: 'app-add-food',
  templateUrl: './add-food.component.html',
  styleUrls: ['./add-food.component.scss']
})
export class AddFoodComponent implements OnInit {

  form!: FormGroup;
  submitted = false;
  //categories$: Observable<String[]> = EMPTY;

  constructor(
    private formBuilder: FormBuilder,
    private foodService: FoodService) { }

    categories = [
      {value: 'Pizza', text: 'Pizza'},
      {value: 'Burger', text: 'Burger'},
      {value: 'Noodles', text: 'Noodles'},
      {value: 'Sandwich', text: 'Sandwich'},
      {value: 'Breakfast', text: 'Breakfast'},
      {value: 'Steak', text: 'Steak'},

    ]

  ngOnInit(): void {
    //this.categories$ = this.foodService.getCategories();
    this.form = this.formBuilder.group(
      {
        foodName: [
          '', 
        [
          Validators.required,
          Validators.pattern('[a-zA-Z ]*'),
        ]
      ],
        price: [
          '',
          [
            Validators.required,
            Validators.minLength(1),
            Validators.maxLength(20),
            Validators.pattern('[0-9]*'),
          ]
        ],
        restaurantId: [
          '',
          [
            Validators.required,
            Validators.minLength(1),
            Validators.maxLength(4),
            Validators.pattern('[0-9]*'),
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

  addFood(): void {
    const food = {
      foodName: this.form.controls.foodName.value,
      price: this.form.controls.price.value,
      restaurantId: this.form.controls.restaurantId.value,
      categories: this.form.controls.categories.value,
    }
    this.foodService.addFood(food as unknown as Food).subscribe();
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
