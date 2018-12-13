package com.talgreen.demosite.model;

public class BookComparators {
    public static int idComparator(Book b1, Book b2) {
        if (b1.getId() < b2.getId()) {
            return -1;
        } else if (b1.getId() > b2.getId()) {
            return 1;
        }
        return 0;
    }

    public static int  nameComparator(Book b1, Book b2) {
        return b1.getName().compareTo(b2.getName());
    }

    public static int  authorComparator(Book b1, Book b2) {
        return b1.getAuthor().compareTo(b2.getAuthor());
    }

    public static int priceComparator(Book b1, Book b2) {
        if (b1.getPrice() < b2.getPrice()) {
            return -1;
        } else if (b1.getPrice() > b2.getPrice()) {
            return 1;
        }
        return 0;
    }

    public static int yearComparator(Book b1, Book b2) {
        if (b1.getPublishYear() < b2.getPublishYear()) {
            return -1;
        } else if (b1.getPublishYear() > b2.getPublishYear()) {
            return 1;
        }
        return 0;
    }

}
