import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

  getPosts(): Observable< any[]>
  {
    const url = `http://localhost:8080/api/all-post`;
    return this.http.get<any[]>(url);
  }
  registerPost(post: any): Observable<any[]> {
    const url = `http://localhost:8080/api/register-post`;
    return this.http.post<any[]>(url, post);
  }
  updatePost(post: any): Observable<any[]> {
    const url = `http://localhost:8080/api/update-post`;
    return this.http.put<any[]>(url, post);
  }
}
