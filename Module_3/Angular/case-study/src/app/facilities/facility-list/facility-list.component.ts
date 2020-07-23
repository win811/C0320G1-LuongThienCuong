import { Component, OnInit } from '@angular/core';
import { FacilitiesService } from './../../services/facilities.service';
import { Facility } from '../../models/Facility';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.scss']
})
export class FacilityListComponent implements OnInit {
  
  term : any;
  p : any;
  facilityList : Facility[] = [];

  constructor(
    public facilitiesService : FacilitiesService,
    private router : Router
    ) { }

  showCreateFacility() {
    this.router.navigateByUrl('/facilities/create');
  }
  showEditForm(id : number) {
    this.router.navigate(['/facilities/edit',id]);
  }
  deleteFacility (id : number) {
    this.facilitiesService.deleteFacility(id).subscribe(()=>{
      this.facilityList = this.facilityList.filter(
        t => t.id !== id
      );
    })
  }

  ngOnInit() {
    this.facilitiesService.getAllFacility().subscribe(data => {this.facilityList = data})
  }

}
