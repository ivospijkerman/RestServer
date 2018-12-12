package controller;

import model.BookModel;

import java.util.*;

public class BookController {
    public static final BookController INSTANCE = new BookController();

    private final SortedMap<Integer, BookModel> data;

    private BookController() {
        data = new TreeMap<>();

        BookModel book = new BookModel();
        book.id = 1;
        book.author = "lipsum.com";
        book.title = "What is Lorem Ipsum";
        book.text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        create(book);
    }

    public BookModel create(BookModel in) {
        // TODO make this perform better on large datasets
        int nextId = 0;
        for (BookModel book : getAll()) {
            if (book.id > nextId)
                nextId = book.id;
        }
        nextId++;
        in.id = nextId;

        data.put(nextId, in);

        return in;
    }

    public BookModel update(int id, BookModel in) {
        BookModel old = data.get(id);
        if (in.text != null)
            old.text = in.text;
        if (in.title != null)
            old.title = in.title;
        if (in.author != null)
            old.author = in.author;
        return old;
    }

    public boolean remove(int id) {
        return data.remove(id) != null;
    }

    public Collection<BookModel> getAll() {
        return data.values();
    }

    public BookModel getById(int id) {
        return data.get(id);
    }
}

