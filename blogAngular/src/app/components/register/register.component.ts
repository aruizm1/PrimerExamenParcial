import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Tag } from '../../models/tag.model';
import {User} from '../../models/user.model';
import { TagsService } from '../../services/tags.service';
import { UserService } from '../../services/user.service';
import { LocalStorage } from '@ngx-pwa/local-storage';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
tag: Tag[];
nickname: string;
user: User = null;
tagStorage: Tag[];

  constructor(
    private router: Router,
    private tagsService: TagsService,
    private userService: UserService,
    protected localStorage: LocalStorage) { }

  ngOnInit() {
this.tagsService.getTags().subscribe(data => {
  this.tag = data;
});
  }

  OntagAgreado(tags: Tag[]) {

    this.user = new User(null, this.nickname, 1, tags)
  }

  registerUser() {

    this.localStorage.getItem<Tag[]>('tagsUser').subscribe((data) => {
      this.tagStorage = data;
      if(this.user === null ){
        this.user = new User(null, this.nickname, 1, this.tagStorage);
      }

      if(this.user.nickname !== null){
        this.userService.registerUser(this.user).subscribe(data =>{
          this.router.navigate(['dashboard']);
        });
      }
    });




  }

}
