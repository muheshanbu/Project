import { TestBed } from '@angular/core/testing';

import { ViewCouponService } from './view-coupon.service';

describe('ViewCouponService', () => {
  let service: ViewCouponService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewCouponService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
