
package com.ford.apps.service;

import com.ford.apps.dto.CouponCreateDTO;
import com.ford.apps.dto.CouponResponseDTO;
import com.ford.apps.entity.Company;
import com.ford.apps.entity.Coupon;
import com.ford.apps.repository.ICompanyRepository;
import com.ford.apps.repository.ICouponRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CouponServiceImplTests {

    @Mock
    private ICouponRepository couponRepository;

    @Mock
    private ICompanyRepository companyRepository;

    @InjectMocks
    private CouponServiceImpl couponService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCouponByIdWhenFound() {
// Given
        Long couponId = 1L;
        Coupon mockCoupon = new Coupon();
        given(couponRepository.findById(couponId)).willReturn(Optional.of(mockCoupon));

// When
        Coupon foundCoupon = couponService.getCouponById(couponId);

// Then
        assertNotNull(foundCoupon);
        then(couponRepository).should().findById(couponId);
    }

    @Test
    public void testGetCouponByIdWhenNotFound() {
// Given
        given(couponRepository.findById(anyLong())).willReturn(Optional.empty());

// When
        Coupon foundCoupon = couponService.getCouponById(1L);

// Then
        assertNull(foundCoupon);
        then(couponRepository).should().findById(anyLong());
    }



    @Test
    public void testGenerateCoupons() {
// Given
        Company company = new Company();
        company.setCompanyName("Test Company");
        given(companyRepository.findByCompanyName("Test Company")).willReturn(company);

        CouponCreateDTO couponCreateDTO = new CouponCreateDTO();
        couponCreateDTO.setName("Test Company");
        couponCreateDTO.setAmount(1000.0);

// Assume issueCoupon generates and returns a list of coupons, need to mock this behavior if issueCoupon is not tested separately
// Mocking couponRepository.save to simply return the passed coupon for simplicity
        given(couponRepository.save(any(Coupon.class))).willAnswer(invocation -> invocation.getArgument(0));

// When
        CouponResponseDTO responseDTO = couponService.generateCoupons(couponCreateDTO);

// Then
        assertNotNull(responseDTO);
        assertEquals("Test Company", responseDTO.getCompanyName());
// Assuming addCouponDTO method correctly updates the responseDTO, check for expected coupons
// This assumes CouponResponseDTO has a way to get the coupons list back, which might need mocking or actual implementation

        then(companyRepository).should().findByCompanyName("Test Company");
// Verify save was called, exact times depends on issueCoupon implementation
        then(couponRepository).should(atLeastOnce()).save(any(Coupon.class));
    }

    @Test
    public void testDeleteCoupon() {
// Given
        Long couponId = 1L;

// No need to mock couponRepository.deleteById as it returns void, just need to verify action

// When
        boolean result = couponService.deleteCoupon(couponId);

// Then
        assertTrue(result);
        then(couponRepository).should().deleteById(couponId);
    }

/*@Test
public void testViewCoupons() {
// Given
String companyName = "TestCompany";
Company company = new Company();
company.setCompanyName(companyName);
List<Coupon> mockCoupons = Arrays.asList(new Coupon(), new Coupon());
company.setCoupons(mockCoupons); // Assuming Company class has a setCoupons method
given(companyRepository.findByCompanyName(companyName)).willReturn(company);

// When
CouponResponseDTO couponResponseDTO = couponService.viewCoupons(companyName);

// Then
assertNotNull(couponResponseDTO);
assertEquals(companyName, couponResponseDTO.getCompanyName());
// Assuming CouponResponseDTO has a method to retrieve coupons which were added
// This assumes CouponResponseDTO has a way to verify added coupons

then(companyRepository).should().findByCompanyName(companyName);
}*/

    @Test
    public void testUpdateCoupon() {
// Given
        Coupon couponToUpdate = new Coupon();
        given(couponRepository.save(any(Coupon.class))).willReturn(couponToUpdate);

// When
        Coupon updatedCoupon = couponService.updateCoupon(couponToUpdate);

// Then
        assertNotNull(updatedCoupon);
        then(couponRepository).should(times(1)).save(couponToUpdate);
    }





}
