import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SerachBarComponent } from './serach-bar/serach-bar.component';

const routes: Routes = [
  {path: "serach-bar", component: SerachBarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
