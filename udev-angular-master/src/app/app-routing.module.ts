import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { WallMessageComponent } from './components/wallMessage/wallMessage.component';
import { WallComponent } from './components/wall/wall.component';
import { CommentComponent } from './components/comment/comment.component';

const routes: Routes = [
  {path: '', component: WallComponent},
  {path: 'wallMessages/:id', component: WallMessageComponent},
  {path: 'comments/:id', component: CommentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
