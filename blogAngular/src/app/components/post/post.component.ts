import { Component, OnInit, Input } from '@angular/core';
import { Post } from '../../models/post.model';
import { post } from 'selenium-webdriver/http';
import { LocalStorage } from '@ngx-pwa/local-storage';
import { User } from '../../models/user.model';
import { PostService } from '../../services/post.service';


@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
@Input() post: Post;
category: string;
editPost: boolean = false;
edit: boolean = true;
title: string;
body: string;

  constructor(
    protected localStorage: LocalStorage,
   private postService: PostService
  ) {}

  ngOnInit() {
    this.localStorage.getItem<User>('user').subscribe((user) => {
      if(this.post.user.nickname.localeCompare(user.nickname)===0){
this.edit = false;
      }
    });

  }

  editarPost(){
this.editPost = true;

  }

  savePost(){
    this.editPost = false;
    // tslint:disable-next-line:max-line-length
    this.postService.registerPost(new Post(this.post.id,this.title,this.body,this.post.imagen, this.post.status,this.post.timestamp, this.post.enjoys, this.post.user, this.post.comments, this.post.tagsPost)).subscribe(data =>{ });

  }



}
