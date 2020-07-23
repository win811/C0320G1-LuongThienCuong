import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FacilityListComponent } from './facility-list/facility-list.component';
import { FacilitiesRoutingModule } from './facilities-routing.module';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FormsModule } from '@angular/forms'
import { NgxPaginationModule } from 'ngx-pagination';
import { FacilityCreateComponent } from './facility-create/facility-create.component';
import {ReactiveFormsModule} from '@angular/forms';
import { FacilityEditComponent } from './facility-edit/facility-edit.component'





@NgModule({
  declarations: [FacilityListComponent, FacilityCreateComponent, FacilityEditComponent],
  imports: [
    CommonModule,
    FacilitiesRoutingModule,
    Ng2SearchPipeModule,
    FormsModule,
    NgxPaginationModule,
    ReactiveFormsModule
  ]
})
export class FacilitiesModule { }
