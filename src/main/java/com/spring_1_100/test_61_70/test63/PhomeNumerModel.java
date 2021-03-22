package com.spring_1_100.test_61_70.test63;

public class PhomeNumerModel {

    private String areaCode;

    public PhomeNumerModel(String areaCode) {
        this.areaCode = areaCode;
    }

    private String bb ;



    public static PhomeNumerModel valueOf(String a ){
        System.out.println("========of========" + a);

        return new PhomeNumerModel("3333");
    }



    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public PhomeNumerModel(String areaCode, String bb) {
        this.areaCode = areaCode;
        this.bb = bb;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }



}
