import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { PostComponent } from './components/post/post.component';
import { WallpostComponent } from './components/wallpost/wallpost.component';

const routes: Routes = [
  {path: '', component: WallpostComponent},
  {path: 'posts/:id', component: PostComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}