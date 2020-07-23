import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup,FormControl, Validators, ValidationErrors } from '@angular/forms';
import { EmployeesService } from '../../services/employees.service';
import {Employee} from '../../models/Employee';
import {Router} from '@angular/router';
import { DatePipe } from '@angular/common';



@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.scss']
})
export class EmployeeCreateComponent implements OnInit {
  minDate = new Date (1900,0,1);
  maxDate = new Date ();
  createForm : FormGroup;

  @Output()
  doCreate = new EventEmitter();

  constructor(
    private fb: FormBuilder,
    private employeesService : EmployeesService,
    private router : Router
  ) { }

  ngOnInit() {
    this.createForm = this.fb.group({
      id : [],
      code : ['',[Validators.required,Validators.pattern(/^NV\-\d{4}$/)]],
      name :['',[Validators.required,Validators.minLength(2)]],
      birthday : ['', [Validators.required, this.employeesService.checkDate]],
      // Validators.pattern(/\d{2}\/\d{2}\/\d{4}/)
      gender : ['',[Validators.required,Validators.minLength(2)]],
      idCard : ['',[Validators.required,Validators.pattern(/^\d{9}$/)]],
      numberPhone : ['',[Validators.required,Validators.pattern(/^(\(\+84\)|0)9[01]\d{7}$/)]],
      email : ['',[Validators.required,Validators.email]],
      level : ['',[Validators.required]],
      position : ['',[Validators.required]],
      salary : ['',[Validators.required,Validators.min(1)]],
      department : ['',Validators.required]

    })
  }

  onSubmit() {
    let employee = this.createForm.value as Employee;
    let datePipe = new DatePipe('en-Us');
    employee.birthday = datePipe.transform(employee.birthday, 'yyyy-MM-dd');
    this.employeesService.addEmployee(employee).subscribe(()=>{
      this.doCreate.emit();
      // this.router.navigateByUrl('/employees');
    });
    
  }

  
}
