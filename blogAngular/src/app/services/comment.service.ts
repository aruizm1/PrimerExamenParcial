import { Injectable } from '@angular/core';
import {HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';

const ParseHeaders = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient) {

  }

  getComment(): Observable< any[]>
  {
    const url = `http://localhost:8080/api/all-comment`;
    return this.http.get<any[]>(url);
  }
  registerComment(any): Observable<any> {
    const url = `http://localhost:8080/api/register-comment`;
    return this.http.post<any>(url, any, ParseHeaders);

  }
}
