import { Component, OnInit } from '@angular/core';
import { Tag } from '../../models/tag.model';
import { Enjoy } from '../../models/enjoy.model';
import { User } from '../../models/user.model';
import { PostService } from '../../services/post.service';
import { Post } from '../../models/post.model';
import { Comment } from '../../models/comment.model';
import { Router } from '@angular/router';
import { LocalStorage } from '@ngx-pwa/local-storage';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  title = 'Mi Blog';
  posts: Post[];
  inPosts: Post[];
  existPost: boolean = false;
  user: User;


  constructor(
    private postService: PostService,
    protected localStorage: LocalStorage,
    private router: Router
    ) { }

  ngOnInit() {
    this.posts = [];
    this.postService.getPosts().subscribe( data => {
      this.inPosts = data;
      this.localStorage.setItem('Posts', data).subscribe(() => {});
      if (PostService.length > 0){
        this.existPost = true;
      }

      this.localStorage.getItem<User>('user').subscribe((user) => {this.user = user;
        for(let item of this.inPosts){

          if(this.user.nickname.localeCompare(item.user.nickname)===0) {
            this.posts.push(item);
          }
       }
      });
    });
  }



  Onfilter(index: string){


if(this.inPosts !== null){

      switch(index) {
        case '2': {
          for(const item of this.inPosts){

            for(const userLike of item.enjoys.users){
            if(this.user.nickname.localeCompare(userLike.nickname) === 0) {
            this.posts.push(item);
            }
          }

        }

          break;
        }
        case '3': {

          for (const item of this.inPosts) {
            for ( const tag of item.tagsPost) {
              for ( const tagUser of this.user.tags) {

                  if (tagUser.name.localeCompare(tag.name) === 0 ) {

                    this.posts.push(item);
                  }
               }
            }
          }


           break;
        }

        default: {

           for(let item of this.inPosts){

              if(this.user.nickname.localeCompare(item.user.nickname)===0) {
                this.posts.push(item);
              }
           }
           break;
        }
     }


  }

}
}
