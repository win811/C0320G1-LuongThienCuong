import { Injectable } from '@angular/core';
import { Facility } from '../models/Facility';
import{ HttpClient,HttpHeaders} from'@angular/common/http';
import { Observable } from 'rxjs';
import { AbstractControl, ValidationErrors } from '@angular/forms';


@Injectable({
  providedIn: 'root'
})
export class FacilitiesService {
  private readonly API_URL = "http://localhost:3000/facilityList";

  httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
  constructor(private http: HttpClient) {}

  getAllFacility() : Observable<Facility[]> {
      return this.http.get<Facility[]>(this.API_URL);
  };
  
  addFacility (facility : Facility) : Observable<Facility> {
    return this.http.post<Facility>(this.API_URL,JSON.stringify(facility),this.httpOptions);
      // return this.http.post<Facility>(this.API_URL,Facility);
  }
  deleteFacility (id : number) : Observable<any> {
    return this.http.delete(`${this.API_URL}/${id}`, this.httpOptions);
  }

  findFacilityById (id : number) : Observable<Facility> {
    return this.http.get<Facility>(`${this.API_URL}/${id}`);
  }

  findFacilityByCode (code : string ) : Observable<Facility[]> {
    return this.http.get<Facility[]>(this.API_URL, { params : { code: code } })
  }

  editFacility(facility : Facility) : Observable<Facility> {
    return this.http.patch<Facility>(`${this.API_URL}/${facility.id}`,facility);
  }

  checkDate(control: AbstractControl): ValidationErrors | null {
      const _date = new Date(control.value);
      if (_date.toString() == 'Invalid Date') {
        return { invalidDate: true };
      }
      return null;
    }
}
