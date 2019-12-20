import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {WallMessage} from '../../models/wallMessage';
import {WallMessageRepository} from '../wallMessage.repository';

@Injectable()
export class WallMessageService implements WallMessageRepository {
  private url: string = environment.api + '/wallmessages';

  constructor(private http: HttpClient) { }

  add(wallMessage: WallMessage): Observable<WallMessage> {
    return this.http.post<WallMessage>(`${this.url}/o/add`, wallMessage);/*c'est là que se fait le lien avec le projet Springboot*/
  }

  all(): Observable<WallMessage[]> {
    return this.http.get<WallMessage[]>(this.url);
  }

  byId(id: string): Observable<WallMessage> {
    return this.http.get<WallMessage>(`${this.url}/${id}`);
  }

  delete(wallMessage: WallMessage): Observable<WallMessage> {
    console.log(`${this.url}/o/delete`);
    let result = this.http.post<WallMessage>(`${this.url}/o/delete`,wallMessage);
    result.toPromise(); // MAGIC, delete the comment ??
    return result;
  }
}