import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.scss']
})

export class CalculatorComponent implements OnInit  {
  result:number;
  firstNumber:number;
  secondNumber:number;
  operator:string = '+';
  constructor() { }
  firstNumberChange (value) {
    this.firstNumber = Number(value)
  }
  secondNumberChange (value) {
    this.secondNumber = Number(value);
  }
  operatorChange (value) {
    this.operator = value;
  }
  calculate() {
    switch (this.operator) {
      case '+' :
        this.result = this.firstNumber + this.secondNumber;
        break;
      case '-' :
        this.result = this.firstNumber - this.secondNumber;
        break;
      case '*' :
        this.result = this.firstNumber * this.secondNumber;
        break;
      case '/' :
        this.result = this.firstNumber / this.secondNumber;
        break;
    }
  }
  
  ngOnInit(): void {
    throw new Error("Method not implemented.");
  }
  
}

