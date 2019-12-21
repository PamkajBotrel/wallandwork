import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {Member} from '../../models/member';
import {MemberRepository} from '../member.repository';
import {NavigationExtras, Router} from '@angular/router';

@Injectable()
export class MemberService implements MemberRepository {
  private url: string = environment.api + '/member/email';

  constructor(private http: HttpClient) {
  }

  all(): Observable<Member[]> {
    return this.http.get<Member[]>(this.url);
  }

  byId(id: string): Observable<Member> {
    return this.http.get<Member>(`${this.url}/${id}`);
  }

  checkEmail(email: string){

    return  this.http.get<number>(`${this.url}/${email}`);

     }

}