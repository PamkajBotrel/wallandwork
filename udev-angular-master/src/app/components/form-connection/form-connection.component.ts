import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {WallMessage} from '../../models/wallMessage';
import {Member} from '../../models/member';
import {ActivatedRoute, NavigationExtras, Router} from '@angular/router';
import {WallMessageRepository} from '../../services/wallMessage.repository';
import {NgForm} from '@angular/forms';
import {MemberRepository} from '../../services/member.repository';
import {MemberService} from '../../services/real/member.service';

@Component({
  selector: 'ngu-form-connection',
  templateUrl: './form-connection.component.html',
  styleUrls: ['./form-connection.component.scss']
})
export class FormConnectionComponent implements OnInit {
  isAuth = false;
  msgConn: string = '';
  constructor(private memberService: MemberRepository,  private router: Router) {

  }
  ngOnInit() {
  }

  onSubmit( form: NgForm) {
    this.msgConn="";
   this.memberService.checkEmail(form.value.email).subscribe((data:number)=> {

     if (data === 0) {
       this.msgConn ="mauvais identifiant";
       console.log(data,'mauvais identifiant');
     } else {
       this.msgConn="connection!";
       this.router.navigate(['/wall/']);

     }
   });






  }
}
