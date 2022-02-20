import { NgModule } from "@angular/core";
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import {MatSnackBarModule} from '@angular/material/snack-bar';

@NgModule({
    imports: [
        MatCardModule,
        MatIconModule,
        MatSelectModule,
        MatSnackBarModule,
    ],
    exports: [
        MatCardModule,
        MatIconModule,
        MatSelectModule,
        MatSnackBarModule,
    ]
})
export class MaterialModule { }
