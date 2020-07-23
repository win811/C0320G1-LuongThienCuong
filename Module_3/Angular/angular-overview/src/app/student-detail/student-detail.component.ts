import { Component, OnInit, Input, Output, EventEmitter,} from '@angular/core';
import { IStudent } from '../model/IStudent';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.scss']
})
export class StudentDetailComponent implements OnInit {
  @Input()
  student : IStudent;
  @Output() changeMark = new EventEmitter();
  constructor() { }

  ngOnInit() {
  }
  setMark(number) {
    this.student.mark = number;
    this.changeMark.emit(number);
  }
}
