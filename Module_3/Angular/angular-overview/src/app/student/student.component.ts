import { Component, OnInit } from '@angular/core';
import { IStudent } from '../model/IStudent';
import {STUDENTDAO} from '../model/StudentDao';
@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.scss']
})
export class StudentComponent implements OnInit {

  studentList = STUDENTDAO;
  studentTarget : IStudent;
  constructor() { }

  ngOnInit() {
  }
  chooseStudent (student) {
    this.studentTarget = student;
  }
  setMark(number) {
    this.studentTarget.mark = number;
  }
}
