package endpoint;

import controller.BookController;
import model.BookModel;

import javax.ws.rs.*;
import java.util.Collection;

@Path("/books")
public class Book {

    @GET
    @Path("/{id}")
    public BookModel get(@PathParam("id") int id) {
        return BookController.INSTANCE.getById(id);
    }

    @GET
    @Path("/all")
    public Collection<BookModel> getAll() {
        return BookController.INSTANCE.getAll();
    }

    @POST
    @Path("/")
    public BookModel create(BookModel in) {
        return BookController.INSTANCE.create(in);
    }

    @PUT
    @Path("/{id}")
    public BookModel update(@PathParam("id") int id, BookModel in) {
        return BookController.INSTANCE.update(id, in);
    }

    @DELETE
    @Path("/{id}")
    public boolean delete(@PathParam("id") int id) {
        return BookController.INSTANCE.remove(id);
    }
}
