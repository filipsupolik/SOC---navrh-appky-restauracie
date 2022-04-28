import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { EMPTY, Observable } from 'rxjs';
import { CATEGORY } from '../category';
import { Food } from '../food.model';
import { Restaurant } from '../restaurant.model';
import { FoodService } from '../_services/food.service';

@Component({
  selector: 'app-add-food',
  templateUrl: './add-food.component.html',
  styleUrls: ['./add-food.component.scss']
})
export class AddFoodComponent implements OnInit {

  categories$: Observable<CATEGORY[]> = EMPTY;  
  form!: FormGroup;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private foodService: FoodService,
    private route: ActivatedRoute,
    ) { }

  ngOnInit(): void {
    const id = +(this.route.snapshot.paramMap.get('categoryId') ?? 1);
    this.categories$ = this.foodService.getAllCategories();
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
        description: [
          '',
          [
            Validators.required,
            Validators.minLength(1),
          ]
        ],
        category: [
            '2',
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
      description: this.form.controls.description.value,
      price: this.form.controls.price.value,
      restaurantId: this.form.controls.restaurantId.value,
      categoryId: this.form.controls.category.value,
    }
    this.foodService.addFood(food as Food).subscribe();
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
