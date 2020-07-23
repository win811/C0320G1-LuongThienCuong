import { Component, OnInit } from '@angular/core';
import {EmployeesService} from '../../services/employees.service';
import { Employee } from '../../models/Employee';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit {
 
  term : any;
  p : any;
  employeeList : Employee[] = [];

  constructor(
    public employeesService : EmployeesService,
    private router : Router
    ) { }

  showCreateEmployee() {
    this.router.navigateByUrl('/employees/create');
  }
  showEditForm(id : number) {
    this.router.navigate(['/employees/edit',id]);
  }
  deleteEmployee (id : number) {
    this.employeesService.deleteEmployee(id).subscribe(()=>{
      this.employeeList = this.employeeList.filter(
        t => t.id !== id
      );
    })
  }

  ngOnInit() {
    this.employeesService.getAllEmployee().subscribe(data => {this.employeeList = data});
  }

}
