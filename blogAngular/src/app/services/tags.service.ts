import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TagsService {

  constructor(private http: HttpClient) { }

  getTags(): Observable< any[]>
  {
    const url = `http://localhost:8080/api/all-tag`;
    return this.http.get<any[]>(url);
  }
  registerUser(tag: any): Observable<any[]> {
    const url = `http://localhost:8080/api/register-tag`;
    return this.http.post<any[]>(url, tag);
  }
  updateUser(tag: any): Observable<any[]> {
    const url = `http://localhost:8080/api/update-tag`;
    return this.http.put<any[]>(url, tag);
  }
}
