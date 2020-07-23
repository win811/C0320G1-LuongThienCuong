import { Component, OnInit } from '@angular/core';
import { CustomersService } from '../../services/customers.service';
import {Router} from '@angular/router';
import { Customer } from '../../models/Customer';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {
  term : any;
  p : any;
  customerList : Customer[] = [];

  constructor(
    public customersService : CustomersService,
    private router : Router
    ) { }

  showCreateCustomer() {
    this.router.navigateByUrl('/customers/create');
  }
  showEditForm(id : number) {
    this.router.navigate(['/customers/edit',id]);
  }
  deleteCustomer (id : number) {
    this.customersService.deleteCustomer(id).subscribe(()=>{
      this.customerList = this.customerList.filter(
        t => t.id !== id
      );
    })
  }

  ngOnInit() {
    this.customersService.getAllCustomer().subscribe(data => {this.customerList = data})
  }

}
