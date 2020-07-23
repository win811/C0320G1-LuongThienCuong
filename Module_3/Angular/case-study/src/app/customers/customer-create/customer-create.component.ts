import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators, ValidationErrors } from '@angular/forms';
import { CustomersService } from '../../services/customers.service';
import {Customer} from '../../models/Customer';
import {Router} from '@angular/router';
@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.scss']
})
export class CustomerCreateComponent implements OnInit {
  createForm : FormGroup;
  // minDate = new Date(1900,0,1);
  // maxDate = new Date();
  @Output()
  doCreate = new EventEmitter();

  constructor(
    private fb: FormBuilder,
    private customersService : CustomersService,
    private router : Router
    ) { }

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
    })
  }
  onSubmit() {
    this.customersService.addCustomer(this.createForm.value).subscribe(()=>{
      this.doCreate.emit();
      // this.router.navigateByUrl('/customers');
    });
    
  }

  
}
