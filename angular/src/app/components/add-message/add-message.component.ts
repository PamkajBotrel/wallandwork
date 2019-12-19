import { Component} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { WallMessage } from 'src/app/models/wallMessage';
import { WallMessageRepository } from 'src/app/services/wallMessage.repository';

@Component({
  selector: 'ngu-add-message',
  templateUrl: './add-message.component.html',
  styleUrls: ['./add-message.component.scss']
})
export class AddMessageComponent {

  message: WallMessage = {} as WallMessage;

  constructor(
    private route: ActivatedRoute,
    private wallMessageService: WallMessageRepository
  ) {}

  createMessage(): void {
    this.wallMessageService.add(this.message)
    .subscribe(data => {alert("Message posted successfully.")});
  }

}
