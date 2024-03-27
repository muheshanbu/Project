export interface CouponOutputDto {
    companyName: string;
    couponsDTOS: CouponDTO[];
}

export interface CouponDTO{
    id:number;
    name:string;
    denomination:number;
    code:string;
    expDate:string
}
