package cn.ecomb.poi.controller.dto;

/**
 * @author zhouzhigang
 * @date 2018/4/8.
 */
public class BookDTO {

    private String name;
    private int number;
    private String photoUrl;

    public String getName() {
        return name;
    }

    public BookDTO setName(String name) {
        this.name = name;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public BookDTO setNumber(int number) {
        this.number = number;
        return this;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public BookDTO setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }
}
