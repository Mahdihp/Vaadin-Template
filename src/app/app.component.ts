import {Component, OnInit} from '@angular/core';
import {NgxPermissionsService} from 'ngx-permissions';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(private permissionsService: NgxPermissionsService) {}


  ngOnInit(): void {
    const perm = ['Role_Admin'];
    this.permissionsService.loadPermissions(perm);

    console.log(this.permissionsService.getPermissions());
  }

}
