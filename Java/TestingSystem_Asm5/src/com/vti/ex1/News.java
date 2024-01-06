package com.vti.ex1;

import com.vti.ex1.INews;

public class News implements INews {
    private int id;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;
  public  int[] rates = new int[3];
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }


    @Override
    public void Display() {
        System.out.println("Title:" + title + "\n"
        +"PublishDate :" + publishDate + "\n"
        + "Author :" + author+"\n"
        +"Content:" + content + "\n"
        +"AverageRate :" + averageRate

        );
    }

    @Override
    public float Calculate() {
        averageRate = 0;
        for (int i = 0; i < rates.length; i++) {
            averageRate = averageRate + rates[i];
            averageRate = averageRate / rates.length;
        }
            return averageRate;

    }
}
