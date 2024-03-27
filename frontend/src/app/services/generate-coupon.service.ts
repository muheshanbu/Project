import { Injectable } from '@angular/core';
import { CouponInputDto } from '../modal-interface/coupon-input-dto';
import { CouponOutputDto } from '../modal-interface/coupon-output-dto';
import { CouponDTO } from '../modal-interface/coupon-output-dto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GenerateCouponService {

  private Url = 'http://localhost:8081/CouponManagementSystem/api/coupons/generate';


  constructor(private http:HttpClient) { }
  createCoupon(coupon:CouponInputDto):Observable<CouponOutputDto> {
    return this.http.post<CouponOutputDto>(this.Url, coupon);
  }
}

