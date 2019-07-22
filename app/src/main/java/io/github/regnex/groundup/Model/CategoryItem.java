package io.github.regnex.groundup.Model;

/**
 * Created by HP on 19/02/2018.
 */

public class CategoryItem {
    public String name;
    public String imageLink;

    public CategoryItem(){

    }

    public CategoryItem(String name, String imageLink) {
        this.name = name;
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
