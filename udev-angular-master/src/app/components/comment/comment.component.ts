import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { CommentRepository } from 'src/app/services/comment.repository';

@Component({
  selector: 'ngu-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.scss']
})
export class CommentComponent implements OnInit {
  comment: Observable<Comment>;

  constructor(
    private route: ActivatedRoute,
    private commentService: CommentRepository
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.comment = this.commentService.byId(params.get('id'));
    });
  }
}
