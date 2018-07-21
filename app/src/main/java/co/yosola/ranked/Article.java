package co.yosola.ranked;

//Create for Cristina on 07/19/2018. A class Article that contains all the data from an Ranked article in the Guardian
public class Article {

    private String mTitle;
    private String mUrl;
    private String mPublishedDate;
    private String mSection;
    private String mImageUrl;

    public Article(String title, String url, String publishedDate, String section, String imageUrl) {
        this.mTitle = title;
        this.mUrl = url;
        this.mPublishedDate = publishedDate;
        this.mSection = section;
        this.mImageUrl = imageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getPublishedDate() {
        return mPublishedDate;
    }

    public String getSection() {
        return mSection;
    }

    public String getImageUrl() {
        return mImageUrl;
    }


}
