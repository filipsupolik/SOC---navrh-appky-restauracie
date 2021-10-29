import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { RegisterComponent } from './register/register.component';
const routes: Routes = [
  {path: 'serach-bar', component: NavBarComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent },

  // otherwise redirect to home
  {path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
