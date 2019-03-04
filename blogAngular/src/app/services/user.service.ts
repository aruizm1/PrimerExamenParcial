import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import {HttpHeaders} from '@angular/common/http';
import { User } from '../models/user.model';

const ParseHeaders = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {

  }

  getUsers(): Observable< any[]>
  {
    const url = `http://localhost:8080/api/all-user`;
    return this.http.get<any[]>(url);
  }
  registerUser(user: User): Observable<User> {
    const url = `http://localhost:8080/api/register-user`;
    return this.http.post<User>(url, user, ParseHeaders);

  }
}
