package endpoint;

import controller.BookController;
import model.BookModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Collection;

@Path("/books")
public class Book {

    public BookModel get(int id) {
        return BookController.INSTANCE.getById(id);
    }

    @GET
    @Produces("text/plain")
    public String deleteme() {
        return "Hoi";
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public Collection<BookModel> getAll() {
        return BookController.INSTANCE.getAll();
    }
}
