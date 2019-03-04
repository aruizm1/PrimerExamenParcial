import { Component, OnInit } from '@angular/core';
import { Tag } from '../../models/tag.model';
import { Enjoy } from '../../models/enjoy.model';
import { User } from '../../models/user.model';
import { PostService } from '../../services/post.service';
import { Post } from '../../models/post.model';
import { Comment } from '../../models/comment.model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  title = 'Mi Blog';
  posts: Post[];
  userPost: User[];
  likePost: Enjoy[];
  tagsPost: Tag[];
  tagsUser: User;
  comments: Comment[];
  usersComments: User[];
  UserLike: User;


  constructor(
    private postService: PostService
    ) { }

  ngOnInit() {
    this.postService.getPosts().subscribe( data => {
      this.posts = data;
    });
  }

}
