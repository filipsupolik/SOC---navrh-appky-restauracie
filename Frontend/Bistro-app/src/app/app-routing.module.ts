import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { MainPageComponent } from './main-page/main-page.component';
import { PizzaRestaurantsComponent } from './Pizza_Restaurants/Pizza_Restaurants.component';
import { RestaurantPageComponent } from './restaurant-page/restaurant-page.component';
import { BurgerRestaurantsComponent } from './Burger-restaurants/burger-restaurants.component';

const routes: Routes = [
  {path: '', component: MainPageComponent},
  {path: 'login', component: LoginComponent },
  {path: 'register', component: RegisterComponent},
  {path: 'main-page', component: MainPageComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'pizzarestaurants', component: PizzaRestaurantsComponent},
  {path: 'burgerrestaurants', component: BurgerRestaurantsComponent},
  {path: 'restaurantpage', component: RestaurantPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
