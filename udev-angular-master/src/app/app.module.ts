import {HttpClient, HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {ReactiveFormsModule, FormsModule } from '@angular/forms';
import {MatButtonModule, MatCardModule, MatIconModule, MatInputModule, MatSnackBarModule, MatToolbarModule, MatFormFieldModule} from '@angular/material';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';



import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BookComponent} from './components/book/book.component';
import {LibraryComponent} from './components/library/library.component';
import {RegisterComponent} from './components/register/register.component';
import {BookRepository} from './services/book.repository';
import {BookService} from './services/real/book.service';
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


@NgModule({
  declarations: [
    AppComponent,
    LibraryComponent,
    BookComponent,
    RegisterComponent,
    WallComponent,
    WallMessageComponent,
    FormConnectionComponent,
    CommentComponent,
    CommentListComponent
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
    FormsModule
  ],
  providers: [
    {provide: BookRepository, useFactory: (http: HttpClient) => new BookService(http), 'deps': [HttpClient]},
    {provide: WallMessageRepository, useFactory: (http: HttpClient) => new WallMessageService(http), 'deps': [HttpClient]},
    {provide: MemberRepository, useFactory: (http: HttpClient) => new MemberService(http), 'deps' : [HttpClient]},
    {provide: CommentRepository, useFactory: (http: HttpClient) => new CommentService(http), 'deps': [HttpClient]}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
