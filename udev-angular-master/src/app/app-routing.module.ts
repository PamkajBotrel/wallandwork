import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BookComponent} from './components/book/book.component';
import {LibraryComponent} from './components/library/library.component';
import {RegisterComponent} from './components/register/register.component';
import { PostComponent } from './components/post/post.component';

const routes: Routes = [
  {path: '', component: LibraryComponent},
  {path: 'books/:id', component: BookComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'posts/:id', component: PostComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
