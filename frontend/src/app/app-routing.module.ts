import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './auth/components/register/register.component';
import { LoginComponent } from './auth/components/login/login.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {path : "register", component:RegisterComponent},
  {path : "login", component:LoginComponent},
  {path : "home", component:HomeComponent},
  {path : "" , component:HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
