import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Dogadjaj } from './dogadjaj';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DogadjajService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getDogadjaj(): Observable<Dogadjaj[]> {
    return this.http.get<Dogadjaj[]>(`${this.apiServerUrl}/dogadjaj/all`)
  }

  public addDogadjaj(dogadjaj: Dogadjaj): Observable<Dogadjaj> {
    return this.http.post<Dogadjaj>(`${this.apiServerUrl}/dogadjaj/add`, dogadjaj);
  }

  public updateDogadjaj(dogadjaj: Dogadjaj): Observable<Dogadjaj> {
    return this.http.put<Dogadjaj>(`${this.apiServerUrl}/dogadjaj/update`, dogadjaj);
  }

  public deleteDogadjaj(dogadjajId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/dogadjaj/delete/${dogadjajId}`);
  }
  
}
