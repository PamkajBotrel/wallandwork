import {HttpClient, HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {MatButtonModule, MatCardModule, MatIconModule, MatInputModule, MatSnackBarModule, MatToolbarModule} from '@angular/material';
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

@NgModule({
  declarations: [
    AppComponent,
    LibraryComponent,
    BookComponent,
    RegisterComponent,
    WallComponent,
    WallMessageComponent
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
    MatSnackBarModule
  ],
  providers: [
    {provide: BookRepository, useFactory: (http: HttpClient) => new BookService(http), 'deps': [HttpClient]},
    {provide: WallMessageRepository, useFactory: (http: HttpClient) => new WallMessageService(http), 'deps': [HttpClient]}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
