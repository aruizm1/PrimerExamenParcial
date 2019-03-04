import { Component, OnInit } from '@angular/core';
import { LocalStorage } from '@ngx-pwa/local-storage';
import {Router} from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(
    protected localStorage: LocalStorage,
    private router: Router) { }

  ngOnInit() {
  }

  logout() {
     this.localStorage.clear().subscribe(() => {});
     this.router.navigate(['']);
  }
}
