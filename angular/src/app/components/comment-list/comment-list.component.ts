import {Component, OnInit, Input} from '@angular/core';
import {Observable} from 'rxjs';
import { CommentRepository } from 'src/app/services/comment.repository';
import {Comment} from '../../models/comment';

import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'ngu-comment-list',
  templateUrl: './comment-list.component.html',
  styleUrls: ['./comment-list.component.scss']
})
export class CommentListComponent implements OnInit {
  commentList: Observable<Comment[]>;
  @Input() wallMessageId: string;

  constructor(
    private route: ActivatedRoute,
    private commentService: CommentRepository
  ) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      console.log("comment-list:"+this.wallMessageId);
      let goodId = this.wallMessageId;
      if(params.has("wallMessageId")) {
        goodId = params.get("wallMessageId");
      }
      this.commentList = this.commentService.byWallMessageId(goodId);
    });
  }

  deleteComment(comment: Comment): void {
    console.log("Deleting comment,id:"+comment.id);
    this.commentService.delete(comment);
  };
}