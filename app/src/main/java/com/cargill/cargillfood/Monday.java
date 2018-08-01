package com.cargill.cargillfood;

import java.util.PriorityQueue;

/**
 * Created by nikhilsawlani on 05/03/18.
 */

public class Monday {
    private String cal;
    private String fooditem;

    public Monday() {

    }

    public Monday(String cal, String fooditem) {
        this.cal = cal;
        this.fooditem = fooditem;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    public String getFooditem() {
        return fooditem;
    }

    public void setFooditem(String fooditem) {
        this.fooditem = fooditem;
    }
}
