import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { NavBarComponent } from './nav-bar/nav-bar.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { SearchRestaurantComponent } from './searching_restaurants/search-restaurant/search-restaurant.component';
import { MainPageComponent } from './main-page/main-page.component';
import { AllRestaurantsComponent } from './all-restaurants/all-restaurants.component';

const routes: Routes = [
  {path: '', component: MainPageComponent},
  {path: 'login', component: LoginComponent },
  {path: 'register', component: RegisterComponent},
  {path: 'main-page', component: MainPageComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'restaurants', component: AllRestaurantsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
