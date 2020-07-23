import { Component, OnInit } from '@angular/core';
import { Employee } from '../../models/Employee';
import {ActivatedRoute, ParamMap} from '@angular/router'
import { EmployeesService } from '../../services/employees.service';
import { AbstractControl, FormBuilder, FormGroup, Validators, ValidationErrors } from '@angular/forms';
import {Router} from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.scss']
})
export class EmployeeEditComponent implements OnInit {
  minDate = new Date ('1900-1-1');
  maxDate = new Date ();
  createForm : FormGroup;

  constructor(
    private fb: FormBuilder,
    private employeesService : EmployeesService,
    private router : Router,
    private activatedRoute : ActivatedRoute,
    ) { 
  }

  ngOnInit() {

    this.createForm = this.fb.group({
      id : [''],
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
    });

    this.activatedRoute.params.subscribe( (param) => {
      const id = Number(param.id);
      this.employeesService.findEmployeeById(id).subscribe( (data)=>{
        this.createForm.patchValue(data);
      })
    });
    
  }

  onSubmit() {
    let employee = this.createForm.value as Employee
    let datePipe = new DatePipe('en-Us')
    employee.birthday = datePipe.transform(employee.birthday, 'yyyy-MM-dd')
    this.employeesService.editEmployee(employee).subscribe( () => {
      this.router.navigateByUrl('/employees');
    })
  }

}
