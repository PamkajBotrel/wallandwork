import {Observable} from 'rxjs';
import {Member} from '../models/member';

export abstract class MemberRepository {

  abstract all(): Observable<Member[]>;

  abstract byId(id: string): Observable<Member>;

  abstract checkEmail(email: string);
}
