import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../service/auth/auth.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  signUpForm!: FormGroup

  constructor(private fb: FormBuilder, private authService: AuthService) { 
  
  }

  ngOnInit(): void {
    // this.signUpForm = this.fb.group({
    //   name: ['',Validators.required],
    //   email: ['',Validators.required,Validators.email],
    //   password: ['',Validators.required,Validators.minLength(4)],    //do later
    //   checkPassword: ['',Validators.required],

    // });
    this.signUpForm = this.fb.group({
      name: [''],
      email: ['',],
      password: ['',],
      checkPassword: [''],

    });
  }
  onSubmit(){
    // if(this.signUpForm.valid){
    //   console.log(this.signUpForm.value);
    // }
    this.authService.register(this.signUpForm.value).subscribe((res) => {
      console.log("from backend : ");
      console.log(res);
    });
  }

}
