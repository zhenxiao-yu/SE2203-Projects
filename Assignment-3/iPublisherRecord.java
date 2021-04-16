package iPublisher;

import javafx.beans.property.StringProperty;

public class iPublisherRecord {
    //Attribute to be manipulated
    private final StringProperty publisherInfo;
    private final StringProperty contracts;
    private final StringProperty authors;
    private final StringProperty titles;

    //constructor method for iPublisher model class
    public iPublisherRecord(StringProperty publisherInfo, StringProperty contracts, StringProperty authors, StringProperty titles) {
        this.publisherInfo = publisherInfo;
        this.contracts = contracts;
        this.authors = authors;
        this.titles = titles;
    }
    /*
       Setter and Getter Methods for model class
    */
    public void setPublisherInfo(String info ){
        publisherInfo.set(info);
    }
    public String getPublisherInfo() {
        return publisherInfo.get();
    }

    public StringProperty publisherInfoProperty() {
        return publisherInfo;
    }
    public void setContracts(String contractName){
        contracts.set(contractName);
    }
    public String getContracts() {
        return contracts.get();
    }
    public void setAuthors(String name){
        authors.set(name);
    }
    public StringProperty contractsProperty() {
        return contracts;
    }

    public String getAuthors() {
        return authors.get();
    }

    public StringProperty authorsProperty() {
        return authors;
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
}
