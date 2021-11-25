import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { MainPageComponent } from './main-page/main-page.component';
import { AllRestaurantsComponent } from './all-restaurants/all-restaurants.component';
import { RestaurantPageComponent } from './restaurant-page/restaurant-page.component';

const routes: Routes = [
  {path: '', component: MainPageComponent},
  {path: 'login', component: LoginComponent },
  {path: 'register', component: RegisterComponent},
  {path: 'main-page', component: MainPageComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'restaurants', component: AllRestaurantsComponent},
  {path: 'restaurantpage', component: RestaurantPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
