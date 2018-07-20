package co.yosola.ranked;

//Create for Cristina on 07/19/2018. A class Article that contains all the data from an Ranked article in the Guardian
public class Article {

    private String mTitle;
    private String mUrl;
    private String mPublishedDate;
    private String mSection;

    public Article(String title, String url, String publishedDate, String section) {
        this.mTitle = title;
        this.mUrl = url;
        this.mPublishedDate = publishedDate;
        this.mSection = section;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getPublishedDate(){
        return mPublishedDate;
    }

    public String getSection(){
        return mSection;
    }


}
