import { Component } from '@angular/core';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';
import { MatCalendar } from '@angular/material';
import { AmazingTimePickerService } from 'amazing-time-picker';
import {Access} from './entities/access';
import { AccessService } from './services/access.service';
import { DateFormatPipe } from "angular2-moment";
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material'; 
import {DialogComponent} from './dialog.component';





@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent{

  constructor( private atp: AmazingTimePickerService
    , private accessService : AccessService,public dfp: DateFormatPipe,public dialog: MatDialog ) { }

  ngOnInit() {
    
  }

  public data;
  public selectedTime: string;
  selectedInputTime :string;
  selectedDuration:number;
  selectedThreshold:number;
  formattedDate:string;
  access = new Access();
  startDate = new Date();
  enableButton= false;
  enableButtonThreshold = false;
  thresholds = null;
  durations = [
    {value: 1, viewValue: 'hourly'},
    {value: 24, viewValue: 'daily'}
  ];
  date:  Date= new Date();
    settings = {
        bigBanner: false,
        timePicker: true,

        format: 'yyyy-MM-dd',
        defaultOpen: false
    }

     

    

    open() {
        const amazingTimePicker = this.atp.open();
        amazingTimePicker.afterClose().subscribe(time => {
            this.selectedTime = time; 
            this.selectedInputTime = this.selectedTime;
            console.log("this.selectedTime"+ this.selectedTime);
         
        });
    }
    refresh(){
    
    }

    selectedValueDuration():void{
     this.enableButtonThreshold = true;
     if(this.access.duration == 24){
       this.thresholds = [
          {value: 100, viewValue: '100'},
          {value: 200, viewValue: '200'},
          {value: 300, viewValue: '300'},
          {value: 400, viewValue: '400'},
          {value: 500, viewValue: '500'}
    ];
     }else {
      this.thresholds = [
        {value: 100, viewValue: '100'},
        {value: 200, viewValue: '200'}
      ];
     }
 
    }
    selectedValueThreshold():void{

    }

    seacrhAccess(){
      this.access.time = this.selectedInputTime;
      
    
      console.log("this.selectedDuration"+this.selectedDuration);
      console.log("this.selectedThreshold"+this.selectedThreshold);
      this.formattedDate = this.dfp.transform(this.startDate, 'YYYY-MM-DD');
      this.access.startDateString = this.formattedDate;
      console.log("this.formattedDate"+this.formattedDate);
      console.log("this.access.startDateString"+this.access.startDateString);
    
      this.accessService.findIp(this.access).subscribe(
        data => {
            this.data = data;
            console.log("this.data"+this.data);;
            this.openDialog(this.data);
        },
        error => {
          console.log("error");
        });
    }

    openDialog(data:string): void {
      console.log("this.data "+ this.data);
      console.log("data "+ data);
      let dialogRef = this.dialog.open(DialogComponent, {
        width: '350px',
        data: { data: this.data}
      });
      dialogRef.componentInstance.message =  data;
}
checkFields(){
  console.log("this.startDate : " + this.startDate 
  + "this.selectedInputTime : "+this.selectedInputTime 
  + "this.access.duration :" + this.access.duration
  + "this.access.threshold :" + this.access.threshold);
  if(this.startDate!= null &&  this.selectedInputTime != null
   &&  this.access.duration != null && this.access.threshold !=null){
    this.enableButton = true;
    console.log("inside");

  }
}
}


