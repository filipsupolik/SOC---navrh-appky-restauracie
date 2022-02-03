import { NgModule } from "@angular/core";
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';



@NgModule({
    imports: [
        MatCardModule,
        MatIconModule,
    ],
    exports: [
        MatCardModule,
        MatIconModule,
    ]
})
export class MaterialModule { }
