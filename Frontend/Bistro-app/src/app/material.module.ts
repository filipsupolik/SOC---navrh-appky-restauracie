import { NgModule } from "@angular/core";
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';



@NgModule({
    imports: [
        MatCardModule,
        MatIconModule,
        MatSelectModule,
    ],
    exports: [
        MatCardModule,
        MatIconModule,
        MatSelectModule,
    ]
})
export class MaterialModule { }
