import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Customer } from '../../models/Customer';
import { Employee } from '../../models/Employee';
import { Facility } from '../../models/Facility';
import { CustomersService } from '../../services/customers.service';
import { ContractsService } from '../../services/contracts.service';
import { FacilitiesService } from '../../services/facilities.service';
import { EmployeesService } from '../../services/employees.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-contract-edit',
  templateUrl: './contract-edit.component.html',
  styleUrls: ['./contract-edit.component.scss']
})
export class ContractEditComponent implements OnInit {
  
  createForm : FormGroup;
  // minDate = new Date(1900,0,1);
  // maxDate = new Date();
  @Output()
  doCreate = new EventEmitter();

  customerList : Customer[];
  employeeList : Employee[];
  facilityList : Facility[];

  constructor(
    private fb: FormBuilder,
    private contractsService : ContractsService,
    private customersService : CustomersService,
    private employeesService : EmployeesService,
    private facilitiesService : FacilitiesService,
    private router : Router,
    private activatedRoute : ActivatedRoute,
    ) { }
  
  ngOnInit() {
    this.createForm = this.fb.group({
      id : [''],
      code : ['',[Validators.required,Validators.pattern(/\d{4}/)]],
      startDate :['',[Validators.required,this.contractsService.checkDate]],
      endDate : ['',[Validators.required,this.contractsService.checkDate]],
      serviceCode : ['',[Validators.required]],
      deposit : ['',[Validators.required]],
      totalPay : ['',[Validators.required]],
      customerCode : ['',[Validators.required]],
      employeeCode : ['',[Validators.required]]
    },{validators : [this.contractsService.checkDeposit,this.contractsService.checkStartDate]});

    this.customersService.getAllCustomer().subscribe(data => {this.customerList = data;});
    this.employeesService.getAllEmployee().subscribe(data => {this.employeeList = data;});
    this.facilitiesService.getAllFacility().subscribe(data => {this.facilityList = data;});
    this.activatedRoute.params.subscribe( (param) => {
      const id = Number(param.id);
      this.contractsService.findContractById(id).subscribe( (data)=>{
        this.createForm.patchValue(data);
      })
    });
  };

  onChange() {
    let contract = this.createForm.value;
    let facilityCode = contract.serviceCode;
    let totalDateStay : number ;
    let currentTotalPay : number;
    if (facilityCode !== '' && contract.startDate !== '' && contract.endDate !== '') {
        this.facilitiesService.findFacilityByCode(facilityCode).subscribe(
          data => {  
            let facility : Facility = data[0];
            let startDate :number = new Date(contract.startDate).getTime()/1000/60/60/24;
            let endDate : number = new Date(contract.endDate).getTime()/1000/60/60/24;
            totalDateStay = endDate - startDate;
            currentTotalPay = facility.rentCost * totalDateStay;
            this.createForm.patchValue({
              totalPay : currentTotalPay
            })
          }
        );
      }
  };

  onSubmit() {
    this.contractsService.editContract(this.createForm.value).subscribe( () => {
      this.router.navigateByUrl('/contracts');
    })
  }

}
