package org.dzubairo.model;

public class Advert {
    private int id;
    private int userId;
    private String title;
    private String content;
    private AdvertCategory advertCategory;
    private String phoneNumber;
    private String creationDate;

    public Advert() {

    }

    public Advert(int userId, String title, String content, AdvertCategory advertCategory, String phoneNumber,
                  String creationDate) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.advertCategory = advertCategory;
        this.phoneNumber = phoneNumber;
        this.creationDate = creationDate;
    }

    public Advert(int id, int userId, String title, String content, AdvertCategory advertCategory, String phoneNumber,
                  String creationDate) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.advertCategory = advertCategory;
        this.phoneNumber = phoneNumber;
        this.creationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AdvertCategory getAdvertCategory() {
        return advertCategory;
    }

    public void setAdvertCategory(AdvertCategory advertCategory) {
        this.advertCategory = advertCategory;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
