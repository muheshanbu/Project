import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CouponInputDto } from '../modal-interface/coupon-input-dto';
import { GenerateCouponService } from '../services/generate-coupon.service';
import { CouponOutputDto } from '../modal-interface/coupon-output-dto';
import { ViewCouponService } from '../services/view-coupon.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})


export class DashboardComponent implements OnInit {

  selectedTab:string ='tab2';

  items:MenuItem[] = [];

  couponResponse:CouponOutputDto |undefined;


  couponForm: FormGroup = new FormGroup({
    companyName: new FormControl<string>('', Validators.required), // 'companyName' field
    amount: new FormControl<number>(0, [Validators.required, Validators.pattern(/^\d+$/)]) // 'amount' field
  });


  viewForm: FormGroup = new FormGroup({
    companyName: new FormControl<string>('', Validators.required), // 'companyName' field
  });


  constructor(private generateCouponService : GenerateCouponService , private viewCouponService : ViewCouponService) {
    this.items=[
      {
        label:'Generate coupons',
        command: () => {
					this.selectedTab = 'tab1';
        }
      
      },
      {
        label:'View coupons',
        command: () => {
          this.selectedTab = 'tab2'; 
        }
       
      }
    ];
   }

  ngOnInit(): void {
  }
generateRequestSubmit(): void {
  const newCoupon:CouponInputDto =new CouponInputDto();
  newCoupon.name=this.couponForm.get('companyName')?.value;
  newCoupon.amount=this.couponForm.get('amount')?.value;

  console.log(this.couponForm.value);
  console.log(typeof newCoupon);

  this.generateCouponService.createCoupon(newCoupon).subscribe((response)=>
    {
    this.couponResponse=response;
      this.selectedTab="tab3"
      console.log('Coupon created', response);
    },
    (error) => {
      console.log('Error' ,error);
    }
  );
}

generateViewSubmit():void{
  this.viewCouponService.viewCoupon(this.viewForm.get('companyName')?.value).subscribe((response)=>
  {
    console.log("yes",response);
    this.couponResponse=response;
    this.selectedTab="tab3";
  },
  (error)=>{

    console.log("error",error);
  }
  );
  console.log(this.viewForm.value);
}
}

