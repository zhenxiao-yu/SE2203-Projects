package iPublisher;

import javafx.beans.property.StringProperty;

public class JSONFile {
    //Attribute to be manipulated
    private final StringProperty fileName;
    private final StringProperty releaseDate;

    //constructor method for JSONFile model class
    public JSONFile(StringProperty fileName, StringProperty releaseDate) {
        this.fileName = fileName;
        this.releaseDate = releaseDate;
    }
    /*
        Setter and Getter Methods for model class
     */
    public void setFileName(String name){
       fileName.set(name);
    }

    public String getFileName() {
        return fileName.get();
    }

    public StringProperty fileNameProperty() {
        return fileName;
    }

    public void setReleaseDate(String date){
        releaseDate.set(date);
    }

    public String getReleaseDate() {
        return releaseDate.get();
    }

    public StringProperty releaseDateProperty() {
        return releaseDate;
    }
}
