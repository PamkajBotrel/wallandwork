import {Observable} from 'rxjs';
import {WallMessage} from '../models/wallMessage';

export abstract class WallMessageRepository {
  abstract delete(wallMessage: WallMessage): Observable<WallMessage>;
  abstract add(wallMessage: WallMessage): Observable<WallMessage>;
  abstract all(): Observable<WallMessage[]>;
  abstract byId(id: string): Observable<WallMessage>;
}
