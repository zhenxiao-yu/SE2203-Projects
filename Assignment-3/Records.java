package iPublisher;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Records {
    //Attribute to be manipulated
    private final IntegerProperty discount;
    private final StringProperty latestUpdateDate;

    //constructor method for Record model class
    public Records(IntegerProperty discount, StringProperty latestUpdateDate) {
        this.discount = discount;
        this.latestUpdateDate = latestUpdateDate;
    }

    /*
       Setter and Getter Methods for model class
    */

    public void setDiscount(Integer discounts){
        discount.set(discounts);
    }

    public int getDiscount() {
        return discount.get();
    }

    public IntegerProperty discountProperty() {
        return discount;
    }

    public void setLatestUpdateDate(String date ){
        latestUpdateDate.set(date);
    }

    public String getLatestUpdateDate() {
        return latestUpdateDate.get();
    }

    public StringProperty latestUpdateDateProperty() {
        return latestUpdateDate;
    }
}
