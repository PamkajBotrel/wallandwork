import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { WallMessageComponent } from './components/wallMessage/wallMessage.component';
import { AddMessageComponent } from './components/add-message/add-message.component';
import { WallComponent } from './components/wall/wall.component';
import { CommentComponent } from './components/comment/comment.component';
import { CommentListComponent } from './components/comment-list/comment-list.component';
import { AddCommentComponent } from './components/add-comment/add-comment.component';
import { AppComponent } from './app.component';
import { OktaCallbackComponent } from '@okta/okta-angular';

const routes: Routes = [
  {path: '', component: AppComponent},
  {path: 'wall', component: WallComponent },
  {path: 'wallmessages/:id', component: WallMessageComponent},
  {path: 'wallmessages/o/add', component: AddMessageComponent},
  {path: 'wallmessages/o/delete', component: WallMessageComponent},
  {path: 'comments/:id', component: CommentComponent},
  {path: 'comments/o/add', component: AddCommentComponent},
  {path: 'comments/o/delete', component: CommentComponent},
  {path: 'comments/wallmessage/:wallMessageId', component: CommentListComponent},
  {path: 'login/okta', component: OktaCallbackComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
