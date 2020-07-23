import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';
import { FormsModule } from '@angular/forms';

const routes: Routes = [
  {
    path:'employees', 
    // loadChildren: () => import('./employee/employee.module').then(mod => mod.EmployeeModule)
    loadChildren: './employee/employee.module#EmployeeModule'
  },
  {
    path:'facilities', 
    loadChildren: './facilities/facilities.module#FacilitiesModule'
  },
  {
    path:'customers', 
    loadChildren: './customers/customers.module#CustomersModule'
  },
  {
    path:'contracts', 
    loadChildren: './contracts/contracts.module#ContractsModule'
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes,{
      preloadingStrategy: PreloadAllModules
    }),
    FormsModule,
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
