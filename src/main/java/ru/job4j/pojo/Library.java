package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCodeBook = new Book("Clean code", 500);
        Book metro2033Book = new Book("Metro 2033", 700);
        Book bibleBook = new Book("Bible", 1500);
        Book warAndPeaceBook = new Book("War and Peace", 900);

        Book[] library = new Book[4];
        library[0] = cleanCodeBook;
        library[1] = metro2033Book;
        library[2] = bibleBook;
        library[3] = warAndPeaceBook;
        for (int i = 0; i < library.length; i++) {
            System.out.println(library[i].getName() + " " + library[i].getPagesNumber());
        }

        System.out.println();

        Book tempBook = library[0];
        library[0] = library[3];
        library[3] = tempBook;
        for (int i = 0; i < library.length; i++) {
            System.out.println(library[i].getName() + " " + library[i].getPagesNumber());
        }

        System.out.println();

        for (int i = 0; i < library.length; i++) {
            if ("Clean code".equals(library[i].getName())) {
                System.out.println(library[i].getName() + " " + library[i].getPagesNumber());
            }
        }
    }
}
