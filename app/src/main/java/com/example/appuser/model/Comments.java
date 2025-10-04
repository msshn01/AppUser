package com.example.appuser.model;

public class Comments {
    UserProfile buyer;
    UserProfile seller;
    String comment;

    public Comments(UserProfile buyer, UserProfile seller, String comment) {
        this.buyer = buyer;
        this.seller = seller;
        this.comment = comment;
    }

    public UserProfile getBuyer() {
        return buyer;
    }

    public void setBuyer(UserProfile buyer) {
        this.buyer = buyer;
    }

    public UserProfile getSeller() {
        return seller;
    }

    public void setSeller(UserProfile seller) {
        this.seller = seller;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
