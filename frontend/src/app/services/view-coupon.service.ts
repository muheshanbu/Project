import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ViewCouponService {



  constructor(private http:HttpClient) { }
  // createCoupon(coupon:CouponInputDto):Observable<CouponOutputDto> {
  //   return this.http.post<CouponOutputDto>(this.Url, coupon);
  // }

  viewCoupon(companyName:string):Observable<any>{
    let Url = `http://localhost:8081/CouponManagementSystem/api/coupons/view_coupon/${companyName}`;
    return this.http.get(Url);
  }
}