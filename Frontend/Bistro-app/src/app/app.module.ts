import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { SearchRestaurantComponent } from './searching_restaurants/search-restaurant/search-restaurant.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ProfileComponent } from './profile/profile.component';

import { AuthInterceptor } from './_helpers/auth.interceptor';
import { SearchFoodComponent } from './search-food/search-food.component';
import { LastPageComponent } from './last-page/last-page.component';
import { MainPageComponent } from './main-page/main-page.component';
import { PizzaRestaurantsComponent } from './Pizza_Restaurants/Pizza_Restaurants.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { RestaurantPageComponent } from './restaurant-page/restaurant-page.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    SearchRestaurantComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    SearchFoodComponent,
    LastPageComponent,
    MainPageComponent,
    PizzaRestaurantsComponent,
    RestaurantPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FontAwesomeModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      multi: true,
      useClass: AuthInterceptor,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
