import { Component, Input} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Comment } from 'src/app/models/comment';
import { CommentRepository } from 'src/app/services/comment.repository';

@Component({
  selector: 'ngu-add-comment',
  templateUrl: './add-comment.component.html',
  styleUrls: ['./add-comment.component.scss']
})
export class AddCommentComponent {

  comment: Comment = {} as Comment;
  @Input() wallMessageId: string;

  constructor(
    private route: ActivatedRoute,
    private commentService: CommentRepository
  ) {}

  createComment(): void {
    console.log(JSON.stringify(this.comment));
    this.commentService.add(this.comment)
    .subscribe(data => {alert("Comment posted successfully.")});
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params =>
      {
        if(params.has("wallMessageId")) {
          this.comment.wallMessageId = params.get("wallMessageId");
        }
        this.comment.wallMessageId = this.wallMessageId;
      }
      );
  }

}
