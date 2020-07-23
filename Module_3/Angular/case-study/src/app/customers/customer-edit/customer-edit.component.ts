import { Component, OnInit } from '@angular/core';
import { Customer } from '../../models/Customer';
import {ActivatedRoute, ParamMap} from '@angular/router'
import { CustomersService } from '../../services/customers.service';
import { AbstractControl, FormBuilder, FormGroup, Validators, ValidationErrors } from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.scss']
})
export class CustomerEditComponent implements OnInit {
  createForm : FormGroup;

  constructor(
    private fb: FormBuilder,
    private customersService : CustomersService,
    private router : Router,
    private activatedRoute : ActivatedRoute,
    ) { 
  }

  ngOnInit() {

    this.createForm = this.fb.group({
      id : [''],
      code : ['',[Validators.required,Validators.pattern(/^KH\-\d{4}$/)]],
      name :['',[Validators.required,Validators.minLength(2)]],
      birthday : ['',[Validators.required,this.customersService.checkDate]],
      // Validators.pattern(/\d{2}\/\d{2}\/\d{4}/)
      gender : ['',[Validators.required,Validators.minLength(2)]],
      idCard : ['',[Validators.required,Validators.pattern(/^\d{9}$/)]],
      numberPhone : ['',[Validators.required,Validators.pattern(/^(\(\+84\)|0)9[01]\d{7}$/)]],
      email : ['',[Validators.required,Validators.email]],
      customerType : ['',Validators.required],
      address : ['',Validators.required]
    });

    this.activatedRoute.params.subscribe( (param) => {
      const id = Number(param.id);
      this.customersService.findCustomerById(id).subscribe( (data)=>{
        this.createForm.patchValue(data);
      })
    });
    
  }

  onSubmit() {
    this.customersService.editCustomer(this.createForm.value).subscribe( () => {
      this.router.navigateByUrl('/customers');
    })
  }

}
