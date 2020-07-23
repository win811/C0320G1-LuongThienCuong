import { Injectable } from '@angular/core';
import { Contract } from '../models/Contract';
import{ HttpClient,HttpHeaders} from'@angular/common/http';
import { Observable, from } from 'rxjs';
import { AbstractControl, ValidationErrors } from '@angular/forms';


@Injectable({
  providedIn: 'root'
})
export class ContractsService {
  private readonly API_URL = "http://localhost:3000/contractList";

  httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
  constructor(private http: HttpClient) {}

  getAllContract() : Observable<Contract[]> {
      return this.http.get<Contract[]>(this.API_URL);
  };
  
  addContract (contract : Contract) : Observable<Contract> {
    return this.http.post<Contract>(this.API_URL,JSON.stringify(contract),this.httpOptions);
      // return this.http.post<Contract>(this.API_URL,Contract);
  }
  deleteContract (id : number) : Observable<any> {
    return this.http.delete(`${this.API_URL}/${id}`, this.httpOptions);
  }

  findContractById (id : number) : Observable<Contract> {
    // return this.http.get<Contract>(`${this.API_URL}/${id}`);
    return this.http.get<Contract>(`${this.API_URL}/${id}`);
  }

  editContract(contract : Contract) : Observable<Contract> {
    return this.http.patch<Contract>(`${this.API_URL}/${contract.id}`,contract);
  }

  checkDate(control: AbstractControl): ValidationErrors | null {
    const _date = new Date(control.value);
    if (_date.toString() == 'Invalid Date') {
      return { invalidDate: true };
    }
    return null;
  }
  checkDeposit(formGroup : AbstractControl) : ValidationErrors | null {
    const contract : Contract = formGroup.value;
    if (contract.deposit - contract.totalPay > 0) {
      return { invalidDeposit : true  };
    };
    return null;
  }
  checkStartDate(formGroup : AbstractControl) : ValidationErrors | null {
    const contract : Contract = formGroup.value;
    let startDate = new Date(contract.startDate).getTime();
    let endDate = new Date(contract.endDate).getTime();
    if (startDate - endDate > 0) {
      return { invalidStartDate : true };
    };
    return null;
  }

}
