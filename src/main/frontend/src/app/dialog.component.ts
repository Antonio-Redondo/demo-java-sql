
import {Component, Inject} from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material'; 



@Component({
  selector: 'dialog-component',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})

export class DialogComponent{
  public message:string;

  constructor(
    public dialogRef: MatDialogRef<DialogComponent>) { }

  ngOnInit() {
    
  }
  onNoClick(): void {
    this.dialogRef.close();
  }

}
