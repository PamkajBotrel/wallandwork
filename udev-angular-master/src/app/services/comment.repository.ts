import {Observable} from 'rxjs';
import {Comment} from '../models/comment';

export abstract class CommentRepository {
  abstract add(comment: Comment): Observable<Comment>;
  abstract byWallMessageId(): Observable<Comment[]>;
  abstract byId(id: string): Observable<Comment>;
}
