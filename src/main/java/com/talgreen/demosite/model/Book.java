package com.talgreen.demosite.model;

import java.util.Objects;


public class Book {
    private int id;
    private String name;
    private String author;
    private int publishYear;
    private double price;
    private int stockCount;

    public Book(int id, String name, String author, int publishYear, double price, int stockCount) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.price = price;
        this.stockCount = stockCount;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public double getPrice() {
        return price;
    }

    public Book setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                publishYear == book.publishYear &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, publishYear);
    }

}
