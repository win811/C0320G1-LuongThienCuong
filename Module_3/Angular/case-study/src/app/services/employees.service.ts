import { Injectable } from '@angular/core';
import { Employee } from '../models/Employee';
import{ HttpClient,HttpHeaders} from'@angular/common/http';
import { Observable } from 'rxjs';
import { AbstractControl, ValidationErrors } from '@angular/forms';


@Injectable({
  providedIn: 'root'
})
export class EmployeesService {
  private readonly API_URL = "http://localhost:3000/employeeList";

  httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
  constructor(private http: HttpClient) {}

  getAllEmployee() : Observable<Employee[]> {
      return this.http.get<Employee[]>(this.API_URL);
  };
  
  addEmployee (employee : Employee) : Observable<Employee> {
    return this.http.post<Employee>(this.API_URL,JSON.stringify(employee),this.httpOptions);
      // return this.http.post<Employee>(this.API_URL,Employee);
  }
  deleteEmployee (id : number) : Observable<any> {
    return this.http.delete(`${this.API_URL}/${id}`, this.httpOptions);
  }

  findEmployeeById (id : number) : Observable<Employee> {
    return this.http.get<Employee>(`${this.API_URL}/${id}`);
  }

  editEmployee(employee : Employee) : Observable<Employee> {
    return this.http.patch<Employee>(`${this.API_URL}/${employee.id}`,employee);
  }

  checkDate(control: AbstractControl): ValidationErrors | null {
      const _date = new Date(control.value);
      if (_date.toString() == 'Invalid Date') {
        return { invalidDate: true };
      }
      return null;
    }
}
