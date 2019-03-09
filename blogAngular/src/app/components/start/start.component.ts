import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { LocalStorage } from '@ngx-pwa/local-storage';
import { User } from 'src/app/models/user.model';
import {Router} from '@angular/router';
import { Tag } from '../../models/tag.model';


@Component({
  selector: 'app-start',
  templateUrl: './start.component.html',
  styleUrls: ['./start.component.css']
})

export class StartComponent implements OnInit {
public users: User[];
public inputUser: string;
public tags: Tag[];
public reg: boolean = false;

  constructor(
    private userService: UserService,
    protected localStorage: LocalStorage,
    private router: Router) { }

  ngOnInit() {
  }

  loadUsers() {
    this.userService.getUsers().subscribe( data => {
      this.users = data;
      this.startSesion(this.users);
    });
  }

  startSesion(users) {
    for (const user of this.users) {

      if (user.nickname.localeCompare(this.inputUser) === 0) {
        this.localStorage.setItem('user', user).subscribe(() => {});
        this.reg = true;
          this.router.navigate(['dashboard']);
      }

    }

    if(!this.reg){
      this.router.navigate(['register']);
    }


  }
}
