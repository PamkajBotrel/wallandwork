import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {WallMessage} from '../../models/wallMessage';
import {WallMessageRepository} from '../../services/wallMessage.repository';

@Component({
  selector: 'ngu-wall',
  templateUrl: './wall.component.html',
  styleUrls: ['./wall.component.scss']
})
export class WallComponent implements OnInit {
  wall: Observable<WallMessage[]>;

  constructor(
    private postService: WallMessageRepository
  ) { }

  ngOnInit() {
    this.wall = this.postService.all();
  }
}
