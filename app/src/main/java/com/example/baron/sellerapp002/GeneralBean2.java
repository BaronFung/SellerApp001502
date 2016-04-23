package com.example.baron.sellerapp002;

import java.io.Serializable;

/**
 * Created by Baron on 4/23/16.
 */
public class GeneralBean2 implements Serializable{
    private int resid2;
    private String name2;
    private String detail2;

    public int getResid2() {
        return resid2;
    }

    public void setResid2(int resid2) {
        this.resid2 = resid2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getDetail2() {
        return detail2;
    }

    public void setDetail2(String detail2) {
        this.detail2 = detail2;
    }

    public GeneralBean2(int resid2, String name2, String detail2) {
        this.resid2 = resid2;
        this.name2 = name2;
        this.detail2 = detail2;
    }

    @Override
    public String toString() {
        return "GeneralBean2{" +
                "resid2=" + resid2 +
                ", name2='" + name2 + '\'' +
                ", detail2='" + detail2 + '\'' +
                '}';
    }
}
