import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Post} from '../../models/post';
import {PostRepository} from '../../services/post.repository';

@Component({
  selector: 'ngu-wallpost',
  templateUrl: './wallpost.component.html',
  styleUrls: ['./wallpost.component.scss']
})
export class WallpostComponent implements OnInit {
  wallpost: Observable<Post[]>;

  constructor(
    private postService: PostRepository
  ) { }

  ngOnInit() {
    this.wallpost = this.postService.all();
  }
}