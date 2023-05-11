import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ParentComponent } from './components/parent/parent.component';
import { ChildComponent } from './components/child/child.component';

const routes: Routes = [
  {
    path: '',
    component: ParentComponent
  },
  {
    path: 'parent/:parentId',
    component: ChildComponent
  },
  {
    path: '**',
    redirectTo: '/'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
