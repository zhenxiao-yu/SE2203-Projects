package iPublisher;

import javafx.beans.property.StringProperty;

public class Report {
    //Attribute to be manipulated
    private final StringProperty publicationsPerYear;
    private final StringProperty titles;
    private final StringProperty publishedTitles;

    //constructor method for Report model class
    public Report(StringProperty publicationsPerYear, StringProperty titles, StringProperty publishedTitles) {
        this.publicationsPerYear = publicationsPerYear;
        this.titles = titles;
        this.publishedTitles = publishedTitles;
    }
    /*
        Setter and Getter Methods for model class
     */

    public void setPublicationPerYear(String year ){
        publicationsPerYear.set(year);
    }
    public String getPublicationsPerYear() {
        return publicationsPerYear.get();
    }

    public StringProperty publicationsPerYearProperty() {
        return publicationsPerYear;
    }

    public void setTitles(String title ){
        titles.set(title);
    }
    public String getTitles() {
        return titles.get();
    }

    public StringProperty titlesProperty() {
        return titles;
    }

    public void setPublishedTitles(String pTitles){
        publishedTitles.set(pTitles);
    }
    public String getPublishedTitles() {
        return publishedTitles.get();
    }

    public StringProperty publishedTitlesProperty() {
        return publishedTitles;
    }
}
