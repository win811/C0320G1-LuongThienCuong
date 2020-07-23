import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeRoutingModule } from './employee-routing.module';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FormsModule } from '@angular/forms'
import { NgxPaginationModule } from 'ngx-pagination';
import { EmployeeCreateComponent } from './employee-create/employee-create.component';
import {ReactiveFormsModule} from '@angular/forms';
import { EmployeeEditComponent } from './employee-edit/employee-edit.component'
import { MaterialModule } from '../material.module';



@NgModule({
  declarations: [EmployeeListComponent, EmployeeCreateComponent, EmployeeEditComponent],
  imports: [
    CommonModule,
    EmployeeRoutingModule,
    Ng2SearchPipeModule,
    FormsModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    MaterialModule
  ]
})
export class EmployeeModule { }
