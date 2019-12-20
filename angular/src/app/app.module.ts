import {HttpClient, HttpClientModule, HttpInterceptor, HttpRequest, HttpHandler, HTTP_INTERCEPTORS} from '@angular/common/http';
import {NgModule, Injectable} from '@angular/core';
import {ReactiveFormsModule, FormsModule } from '@angular/forms';
import {MatButtonModule, MatCardModule, MatIconModule, MatInputModule, MatSnackBarModule, MatToolbarModule, MatFormFieldModule} from '@angular/material';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import { WallComponent } from './components/wall/wall.component';
import { WallMessageComponent } from './components/wallMessage/wallMessage.component';
import { WallMessageRepository } from './services/wallMessage.repository';
import { WallMessageService } from './services/real/wallMessage.service';
import { FormConnectionComponent } from './components/form-connection/form-connection.component';
import {MemberRepository} from './services/member.repository';
import {MemberService} from './services/real/member.service';
import { CommentComponent } from './components/comment/comment.component';
import { CommentRepository } from './services/comment.repository';
import { CommentService } from './services/real/comment.service';
import { CommentListComponent } from './components/comment-list/comment-list.component';
import { AddMessageComponent } from './components/add-message/add-message.component';
import { AddCommentComponent } from './components/add-comment/add-comment.component';
import {
  OktaAuthModule,
  OktaCallbackComponent,
} from '@okta/okta-angular';
import { RouterModule } from '@angular/router';
import { AddHeaderInterceptor } from './services/real/add-header-interceptor';


const config = {
  issuer: 'https://dev-842409.okta.com/oauth2/default',
  redirectUri: 'http://localhost:4200/login/okta',
  clientId: '0oa2add5bvmgUQ6gJ357',
  pkce: true
}

@NgModule({
  declarations: [
    AppComponent,
    WallComponent,
    WallMessageComponent,
    FormConnectionComponent,
    CommentComponent,
    CommentListComponent,
    AddMessageComponent,
    AddCommentComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    AppRoutingModule,
    MatCardModule,
    MatIconModule,
    MatInputModule,
    MatSnackBarModule,
    MatFormFieldModule,
    FormsModule,
    OktaAuthModule.initAuth(config)
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AddHeaderInterceptor,
      multi: true,
    },
    {provide: WallMessageRepository, useFactory: (http: HttpClient) => new WallMessageService(http), 'deps': [HttpClient]},
    {provide: MemberRepository, useFactory: (http: HttpClient) => new MemberService(http), 'deps' : [HttpClient]},
    {provide: CommentRepository, useFactory: (http: HttpClient) => new CommentService(http), 'deps': [HttpClient]}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {};