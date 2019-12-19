import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { WallMessage } from 'src/app/models/wallMessage';
import { WallMessageRepository } from 'src/app/services/wallMessage.repository';


@Component({
  selector: 'ngu-wall-message',
  templateUrl: './wallMessage.component.html',
  styleUrls: ['./wallMessage.component.scss']
})
export class WallMessageComponent implements OnInit {
  wallMessage: Observable<WallMessage>;

  constructor(
    private route: ActivatedRoute,
    private wallMessageService: WallMessageRepository
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.wallMessage = this.wallMessageService.byId(params.get('id'));
    });
  }
}
