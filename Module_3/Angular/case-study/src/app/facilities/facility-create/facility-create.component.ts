import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FacilitiesService } from '../../services/facilities.service';
import {Facility} from '../../models/Facility';
import {Router} from '@angular/router';


@Component({
  selector: 'app-facility-create',
  templateUrl: './facility-create.component.html',
  styleUrls: ['./facility-create.component.scss']
})
export class FacilityCreateComponent implements OnInit {
  createForm : FormGroup;

  @Output()
  doCreate = new EventEmitter();

  constructor(
    private fb: FormBuilder,
    private facilitiesService: FacilitiesService,
    private router : Router
  ) { }

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
    })
  }
  onSubmit() {
    this.facilitiesService.addFacility(this.createForm.value).subscribe(()=>{
      this.doCreate.emit();
      // this.router.navigateByUrl('/facilities');
    });
  }

}
