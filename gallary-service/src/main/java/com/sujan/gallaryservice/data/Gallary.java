package com.sujan.gallaryservice.data;

import java.util.List;

public class Gallary {
    private int id;
    private List<Object> images;

    public Gallary() {
    }

    public Gallary(int gallaryId) {
        this.id = gallaryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Object> getImages() {
        return images;
    }

    public void setImages(List<Object> images) {
        this.images = images;
    }
}
