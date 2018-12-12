package model;

import java.awt.print.Book;

public class BookModel implements Comparable<BookModel> {
    public int id;
    public String title;
    public String author;
    public String text;

    @Override
    public int hashCode() {
        if (this.id != 0)
            return this.id;
        else
            return super.hashCode();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that)
            return true;

        if (that == null)
            return false;

        return that instanceof BookModel && this.id == ((BookModel) that).id;
    }

    @Override
    public int compareTo(BookModel that) {
        return this.id - that.id;
    }
}
