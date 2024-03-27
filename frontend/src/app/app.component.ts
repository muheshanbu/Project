import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent{
  title = 'frontend';

  items:MenuItem[];

  constructor(){

    this.items=[
      {
        label:'Login',
        icon:'pi pi-fw pi-sign-in',
        routerLink:['/login']
      },
      {
        label:'Register',
        icon:'pi pi-w pi-user-plus',
        routerLink:['/register']
      }
    ];
  }
}
