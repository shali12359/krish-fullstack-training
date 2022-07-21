import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'em-progress-bar',
  templateUrl: './progress-bar.component.html',
  styleUrls: ['./progress-bar.component.scss']
})
export class ProgressBarComponent implements OnInit {
  color: string = '';
  @Input() progress: number = 0;
  @Input() fName: string = '';
  @Output() progressClick: EventEmitter<string> = new EventEmitter<string>();

  constructor() { }

  // SET PROGRESS BAR COLOR
  ngOnInit(): void {
    if (this.progress < 0 || this.progress > 100) {
      this.progress = 0;
    }

    if (this.progress < 35) {
      this.color = 'red';
    }
    else if (this.progress < 75) {
      this.color = 'yellow';
    }
    else {
      this.color = 'green';
    }
  }

  // SHOW EMPLOYEE PROGRESS MESSAGE
  onClick() {
    this.progressClick.emit(` ${this.fName}'s Progress is ${this.progress} %`);
  }
  
}
