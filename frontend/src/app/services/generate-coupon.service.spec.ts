import { TestBed } from '@angular/core/testing';

import { GenerateCouponService } from './generate-coupon.service';

describe('GenerateCouponService', () => {
  let service: GenerateCouponService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GenerateCouponService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
