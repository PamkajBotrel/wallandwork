import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { WallMessageComponent } from './components/wallMessage/wallMessage.component';
import { AddMessageComponent } from './components/add-message/add-message.component';
import { WallComponent } from './components/wall/wall.component';
import {FormConnectionComponent} from './components/form-connection/form-connection.component';
import { CommentComponent } from './components/comment/comment.component';
import { CommentListComponent } from './components/comment-list/comment-list.component';
import { AddCommentComponent } from './components/add-comment/add-comment.component';

const routes: Routes = [
  {path: '', component: WallComponent },
  {path: 'wallmessages/:id', component: WallMessageComponent},
  {path: 'wallmessages/o/add', component: AddMessageComponent},
  {path: 'comments/:id', component: CommentComponent},
  {path: 'comments/o/add', component: AddCommentComponent},
  {path: 'comments/o/delete', component: CommentComponent},
  {path: 'comments/wallmessage/:wallMessageId', component: CommentListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
