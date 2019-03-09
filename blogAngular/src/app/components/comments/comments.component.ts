import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Comment } from '../../models/comment.model';
import { LocalStorage } from '@ngx-pwa/local-storage';
import { User } from '../../models/user.model';
import { CommentService } from '../../services/comment.service';


@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {
  editComment: boolean = false;
  edit: boolean = true;
@Input() comment: Comment;
commentEdit: string;

  constructor(
    protected localStorage: LocalStorage,
    private commentService: CommentService

  ) { }

  ngOnInit() {
    this.localStorage.getItem<User>('user').subscribe((user) => {
      if(this.comment.user.nickname.localeCompare(user.nickname) === 0){
        this.edit = false;

              }
    });
  }

  editarComment(){
    this.editComment = true;

      }

  saveComment(){
    this.editComment = false;
// tslint:disable-next-line:max-line-length
    this.commentService.registerComment(new Comment(this.comment.id, this.commentEdit, this.comment.timestamp, this.comment.status, this.comment.user)).subscribe(data =>{ });
  }

}
