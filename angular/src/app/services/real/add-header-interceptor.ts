import {
  HttpEvent,
  HttpInterceptor,
  HttpHandler,
  HttpRequest,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { OktaAuthService } from '@okta/okta-angular';
import { Injectable } from '@angular/core';

@Injectable()
export class AddHeaderInterceptor implements HttpInterceptor {
  constructor(private oktaAuth: OktaAuthService) { }


  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // Clone the request to add the new header
    const accessToken = this.oktaAuth.getAccessToken();
    console.log(accessToken);
    const clonedRequest = req.clone({ headers: req.headers.set('Authorization', 'Bearer' + accessToken) });

    // Pass the cloned request instead of the original request to the next handle
    return next.handle(clonedRequest);
  }


}