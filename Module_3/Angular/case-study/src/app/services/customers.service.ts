import { Injectable } from '@angular/core';
import {Customer} from '../models/Customer';
import{ HttpClient,HttpHeaders} from'@angular/common/http';
import { Observable } from 'rxjs';
import { AbstractControl, ValidationErrors } from '@angular/forms';

@Injectable ({
    providedIn : 'root'
})

export class CustomersService {

    private readonly API_URL = "http://localhost:3000/customerList";

    httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })
      };
    constructor(private http: HttpClient) {}

    getAllCustomer() : Observable<Customer[]> {
        return this.http.get<Customer[]>(this.API_URL);
    };
    
    addCustomer (customer : Customer) : Observable<Customer> {
      return this.http.post<Customer>(this.API_URL,JSON.stringify(customer),this.httpOptions);
        // return this.http.post<Customer>(this.API_URL,customer);
    }
    deleteCustomer (id : number) : Observable<any> {
      return this.http.delete(`${this.API_URL}/${id}`, this.httpOptions);
    }

    findCustomerById (id : number) : Observable<Customer> {
      return this.http.get<Customer>(`${this.API_URL}/${id}`);
    }

    editCustomer(customer : Customer) : Observable<Customer> {
      return this.http.patch<Customer>(`${this.API_URL}/${customer.id}`,customer);
    }

    checkDate(control: AbstractControl): ValidationErrors | null {
        const _date = new Date(control.value);
        if (_date.toString() == 'Invalid Date') {
          return { invalidDate: true };
        }
        return null;
      }
}