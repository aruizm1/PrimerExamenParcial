import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { LocalStorage } from '@ngx-pwa/local-storage';
import {Router} from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
@Output() selectOption = new EventEmitter<string>();
  index: string = '1';

  constructor(
    protected localStorage: LocalStorage,
    private router: Router) {

    }

  ngOnInit() {

  }

  logout() {
     this.localStorage.clear().subscribe(() => {});
     this.router.navigate(['']);
  }

  capture(){
    this.selectOption.emit(this.index);
  }
}
