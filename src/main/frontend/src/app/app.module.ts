import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material';
import { MatButtonToggleModule } from '@angular/material';
import { MatFormFieldModule } from '@angular/material';
import { MatOptionModule } from '@angular/material';
import { MatSelectModule } from '@angular/material';
import {MatInputModule} from '@angular/material';
import {MatCardModule} from '@angular/material';
import {MatDatepickerModule} from '@angular/material';
import {MatDialogModule} from '@angular/material';
import { AngularDateTimePickerModule } from 'angular2-datetimepicker';
import { AmazingTimePickerModule } from 'amazing-time-picker'; 
import {AccessService} from './services/access.service';
import { HttpModule } from '@angular/http';
import { DateFormatPipe } from "angular2-moment";
import {DialogComponent} from './dialog.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import {DialogModule} from './dialog.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,BrowserAnimationsModule,MatButtonModule
    ,MatFormFieldModule,FormsModule,ReactiveFormsModule
    ,MatOptionModule, MatSelectModule, MatCardModule
    ,MatInputModule,AngularDateTimePickerModule,MatDatepickerModule,
    MatButtonToggleModule,AmazingTimePickerModule,HttpModule,DialogModule
  ],
  exports: [MatButtonModule,MatFormFieldModule,MatOptionModule,MatSelectModule,MatDialogModule], 
  providers: [AccessService,DateFormatPipe],
  bootstrap: [AppComponent,DialogComponent]
})
export class AppModule { }
