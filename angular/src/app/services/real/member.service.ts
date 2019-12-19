import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {Book} from '../../models/book';
import {BookRepository} from '../book.repository';
import {Member} from '../../models/member';
import {MemberRepository} from '../member.repository';

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

  checkEmail(email: string) {
    console.log(email);
    let response: number;
    this.http.get<number>(`${this.url}/${email}`)
      .subscribe( ( data: number ) => {
          response = data;
      } );

    return response;
     }

}
