import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Post} from '../../models/post';
import {PostRepository} from '../../services/post.repository';
import { Observable } from 'rxjs';


@Component({
  selector: 'ngu-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.scss']
})
export class PostComponent implements OnInit {
  post: Observable<Post>;

  constructor(
    private route: ActivatedRoute,
    private postService: PostRepository
  ) { }

  ngOnInit() {
    console.log("ngOnInit Post");
    };

}
