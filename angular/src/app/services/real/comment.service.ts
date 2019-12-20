import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {Comment} from '../../models/comment';
import {CommentRepository} from '../comment.repository';

@Injectable()
export class CommentService implements CommentRepository {

  private url: string = environment.api + '/comments';

  constructor(private http: HttpClient) { }

  add(comment: Comment): Observable<Comment> {
    return this.http.post<Comment>(this.url, comment);/*c'est là que se fait le lien avec le projet Springboot*/
  }

  byWallMessageId(wallMessageId: string): Observable<Comment[]> {
        return this.http.get<Comment[]>(`${this.url}/wallmessage/${wallMessageId}`);
  }

  byId(id: string): Observable<Comment> {
    return this.http.get<Comment>(`${this.url}/${id}`);
  }

  delete(comment: Comment): Observable<Comment> {
    console.log(`${this.url}/o/delete`);
    let result = this.http.post<Comment>(`${this.url}/o/delete`,comment);
    result.toPromise(); // MAGIC, delete the comment ??
    return result;
  }
}