import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { WallMessageComponent } from './components/wallMessage/wallMessage.component';
import { WallComponent } from './components/wall/wall.component';
import {FormConnectionComponent} from './components/form-connection/form-connection.component';

const routes: Routes = [
  {path: '', component: FormConnectionComponent},
  {path: 'wallMessages/:id', component: WallMessageComponent},
  {path: 'email/:email', component: WallComponent },
  {path: 'wall', component: WallComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
