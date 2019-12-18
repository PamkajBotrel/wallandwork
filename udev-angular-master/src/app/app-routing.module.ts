import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { WallMessageComponent } from './components/wallMessage/wallMessage.component';
import { WallComponent } from './components/wall/wall.component';

const routes: Routes = [
  {path: '', component: WallComponent},
  {path: 'wallMessages/:id', component: WallMessageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
