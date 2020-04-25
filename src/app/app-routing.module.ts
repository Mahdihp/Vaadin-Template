import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {UserListComponent} from './user-list/user-list.component';
import { NgxPermissionsGuard } from 'ngx-permissions';
import { BookListComponent } from './book-list/book-list.component';


const routes: Routes = [
  {
    path: 'users', component: UserListComponent,
    canActivate: [NgxPermissionsGuard],
    data: {
      permissions: {
        only: ['Role_Admin', 'USER'],
      }
    }
  },
  {
    path: 'books', component: BookListComponent,
    canActivate: [NgxPermissionsGuard],
    data: {
      permissions: {
        only: ['USER','Role_Admin'],
        redirectTo: '/'
      }
    }
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
