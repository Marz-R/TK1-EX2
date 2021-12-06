public class Client {
  public static void main(String[] args) {
    // client log in to the server
    // receive ACK (client ID logged in) from the server (SOAP/REST)?

    // System.out.println("Hello, customer " + clientID + "! Here are the list of currently available flights:");
    // get list of available flights from the server (SOAP/REST)
    // if (availableFlight.isEmpty()) System.out.println("There is no available flights.");
		// else print(availableFlights)  // assuming that the flights with the all seats unavailable are already filtered at this point

    // print("To which flight would you like to make a reservation?"")
		// customer select flight; get available seats of the selected flight from the server (SOAP/REST);
		// print("Here is the list of available seats for this flight")
		// print(available seats)  // assuming that at least one seat is available at the time of printing out; that last seat could be unavailble if other customer reserved that seat while the customer is hesitating

    // customer select seat; check if the selected seat is still available (SOAP/REST)
    // if that seat is still available, set selected seat as reserved (SOAP/REST)
    // else, print("Unfortunately, that seat became unavailable a moment ago"); print the list of available seats of the selected flight again; if the seat that became unavailable was the last available one, print available flights

    // seat successfully reserved
    // customer may cancel his reservation (provide client with the steps to ask the customer if he wants to cancel his reservation OR detect when the customer exited the process or closed window); in that case, change the reserved seat back to available
    // print("Which type of meal would you like to choose?: Standard, Vegetarian, Vegan")
    // customer select meal type; send selection to the server (SOAP/REST)

    // assumption: customer can reserve exactly one seat for one flight
    // client get price (optionally, selected flight, seat, and meal info as well) info from the server (SOAP/REST)
    // print("The price for your reservation is: " + price)
    // again, the customer may cancel his reservation at this point
    // cutomer pay the amount (prompt with the message such as "Type Y to pay, N to not" and assume the payment will be done with the exact amount); send whether paid or not to the server? (SOAP/REST)
    // if Y, print("Your reservation was successfully processed. Thank you for using our service!")
    // if N, print("Would you like to choose different seat? Or would you like to choose different flight? Or would you like to cancel your reservation?"); print list of seats or flights again or handle cancel

    // end (client log out from the server)
  }
}
