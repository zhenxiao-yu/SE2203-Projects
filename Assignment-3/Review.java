package iPublisher;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Review {
    //Attribute to be manipulated
    private final IntegerProperty profitPerBranch;
    private final StringProperty titles;
    private final IntegerProperty salesPerTitle;

    //constructor method for Review model class
    public Review(IntegerProperty profitPerBranch, StringProperty titles, IntegerProperty salesPerTitle) {
        this.profitPerBranch = profitPerBranch;
        this.titles = titles;
        this.salesPerTitle = salesPerTitle;
    }

    /*
       Setter and Getter Methods for model class
    */
    public void setProfitPerBranch(Integer profit){
        profitPerBranch.set(profit);
    }

    public int getProfitPerBranch() {
        return profitPerBranch.get();
    }

    public IntegerProperty profitPerBranchProperty() {
        return profitPerBranch;
    }

    public void setTitles(String title){
        titles.set(title);
    }

    public String getTitles() {
        return titles.get();
    }

    public StringProperty titlesProperty() {
        return titles;
    }

    public void salesPerTitle(Integer sales){
        salesPerTitle.set(sales);
    }

    public int getSalesPerTitle() {
        return salesPerTitle.get();
    }

    public IntegerProperty salesPerTitleProperty() {
        return salesPerTitle;
    }
}
