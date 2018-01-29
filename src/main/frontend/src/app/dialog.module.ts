import {DialogComponent} from './dialog.component';
import {AppComponent} from './app.component';
import { NgModule } from '@angular/core';
import { MatButtonToggleModule } from '@angular/material';
import { MatFormFieldModule } from '@angular/material';




@NgModule({
    imports: [
        MatButtonToggleModule,MatFormFieldModule
    ],
    declarations: [DialogComponent],
    exports:[DialogComponent]
  })
  export class DialogModule { }