package iPublisher;

import javafx.beans.property.IntegerProperty;

public class RevenueRecord {
    //Attribute to be manipulated
    private final IntegerProperty revenue;
    private final IntegerProperty profitMargin;
    private final IntegerProperty sales;


    //constructor method for RevenueRecord  model class
    public RevenueRecord(IntegerProperty revenue, IntegerProperty profitMargin, IntegerProperty sales) {
        this.revenue = revenue;
        this.profitMargin = profitMargin;
        this.sales = sales;
    }

    /*
        Setter and Getter Methods for model class

     */
    public void setProfitPerBranch(Integer revenues){
        revenue.set(revenues);
    }

    public int getRevenue() {
        return revenue.get();
    }

    public IntegerProperty revenueProperty() {
        return revenue;
    }

    public void setProfitMargin(Integer profit){
        profitMargin.set(profit);
    }

    public int getProfitMargin() {
        return profitMargin.get();
    }

    public IntegerProperty profitMarginProperty() {
        return profitMargin;
    }

    public void setSales(Integer sale){
        sales.set(sale);
    }

    public int getSales() {
        return sales.get();
    }

    public IntegerProperty salesProperty() {
        return sales;
    }
}
