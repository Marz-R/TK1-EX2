package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jakarta.websocket.server.PathParam;

@Path("/rest")
public class ReservationBookingController {

  @GET
  @Path("{id}")
  @Produces(MediaType.TEXT_PLAIN)
  public String addPlainText(@PathParam("a") double a, @PathParam("b") double b) {
    return (a + b) + "";
  }
}
