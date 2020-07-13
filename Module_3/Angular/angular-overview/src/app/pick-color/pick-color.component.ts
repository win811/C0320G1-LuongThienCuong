import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pick-color',
  templateUrl: './pick-color.component.html',
  styleUrls: ['./pick-color.component.scss']
})
export class PickColorComponent implements OnInit {

  background = '#00e067';
  constructor() { }

  ngOnInit() {
  }

  onChange(value) {
    this.background = value;
  }
}
