package io.github.regnex.groundup.Model;

/**
 * Created by HP on 19/02/2018.
 */

public class WallpaperItem {
    public String imageUrl;
    public String categoryId;

    public WallpaperItem(){

    }

    public WallpaperItem(String imageUrl, String categoryId) {
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
