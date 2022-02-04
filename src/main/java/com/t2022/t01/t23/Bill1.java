package com.t2022.t01.t23;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

public class Bill1 {

    public static void main(String[] args) {
        double b1 = 	493.79 + 108.33 + 103.7 + 47.45  ;
        System.out.println(b1);

        double b2 = 502.02 +100.1 + 92.46 + 47.45;
        System.out.println(b2 );


        double b3 = 510.38 + 91.74 + 81.66 + 	47.45 -0.42 ;
        System.out.println(b3);
        System.out.println(81.66 - 0.42);

        double alx = b1 + b2 + b3;
        System.out.println(alx);


        // 本金 +  利息 + 担保费用 + 逾期费用
        double b10 = 545.27 + 56.85 + 	47.45 + 30.9;
        System.out.println(b10 );

        double b11 = 554.36 + 	47.76 +   47.45+	17.55  	;
        System.out.println(b11 );

        double b12 = 563.6 + 	38.52  + 47.45 + 3.29;
        System.out.println(b12 );

        System.out.println(b10 + b11 + b12 );

        double sumRepay = 680.47 + 667.12 +652.86;
        System.out.println(sumRepay);

        double  b3repay = (sumRepay -b1 -b2   );
        System.out.println("b3repay="+b3repay);

        double b3sum_capit = b3repay- (91.74 + 81.24 + 	47.45);

        System.out.println("b3sum_capit="+b3sum_capit);    // 已经还本金 284.30
        double b3not_repay_catpit = 510.38- b3sum_capit;
        System.out.println("b3not_repay_catpit="+b3not_repay_catpit);     // 226.08

        System.out.println(104.11 -0.41 +92.87  -  0.41 + 81.24 );

        System.out.println(108.33 +100.1  +  91.74);

        System.out.println(	69.62 + 57.15 + 44.69 );




        System.out.println(104.11 -0.41  );
        System.out.println(92.87  -  0.41);

        System.out.println(30.9- 31.35);
        System.out.println(18.02- 17.55);
        System.out.println(3.76- 3.29);

    }
}
