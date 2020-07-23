import { Component, OnInit } from '@angular/core';
import { Facility } from '../../models/Facility';
import {ActivatedRoute, ParamMap} from '@angular/router'
import { FacilitiesService } from './../../services/facilities.service';
import { AbstractControl, FormBuilder, FormGroup, Validators, ValidationErrors } from '@angular/forms';
import {Router} from '@angular/router';


@Component({
  selector: 'app-customer-edit',
  templateUrl: './facility-edit.component.html',
  styleUrls: ['./facility-edit.component.scss']
})
export class FacilityEditComponent implements OnInit {
  createForm : FormGroup;

  constructor(
    private fb: FormBuilder,
    private facilitiesService : FacilitiesService,
    private router : Router,
    private activatedRoute : ActivatedRoute,
    ) { 
  }

  ngOnInit() {

    this.createForm = this.fb.group({
      id : [''],
      code : ['',[Validators.required,Validators.pattern(/^DV\-\d{4}$/)]],
      name : ['',[Validators.required,Validators.minLength(4)]],
      areaUse : ['',[Validators.required,Validators.min(30)]],
      rentCost : ['',[Validators.required,Validators.min(1)]],
      maxGuest : ['',[Validators.required,Validators.min(1)]],
      roomStandard : ['',[Validators.required,Validators.minLength(3)]],
      convenient : ['',[Validators.required,Validators.minLength(5)]],
      areaPool : ['',[Validators.required,Validators.min(0)]],
      floor : ['',[Validators.required,Validators.min(1)]],
      freeService : ['',[Validators.required]]
    });

    this.activatedRoute.params.subscribe( (param) => {
      const id = Number(param.id);
      this.facilitiesService.findFacilityById(id).subscribe( (data)=>{
        this.createForm.patchValue(data);
      })
    });
    
  }

  onSubmit() {
    
    this.facilitiesService.editFacility(this.createForm.value).subscribe( () => {
      this.router.navigateByUrl('/facilities');
    })
  }

}
