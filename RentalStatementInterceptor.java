import java.util.Enumeration;

// intercepts the context and provides the statement based on the rentals in the context
public class RentalStatementInterceptor implements Interceptor {
  @Override
  public void intercept(RentalStatementContext rentalStatementContext) {
    Enumeration<Rental> rentals = rentalStatementContext.getRentals().elements();

    String result = "Rental Record for " + rentalStatementContext.getCustomer().getName() + "\n";

    while (rentals.hasMoreElements()) {
      Rental rental = (Rental) rentals.nextElement();

      // add rental details to result string
      result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
    }

    // add total charge and frequent renter points to result string
    result += "Amount owed is " + String.valueOf(rentalStatementContext.getCustomer().getTotalCharge()) + "\n";

    result += "You earned " + String.valueOf(rentalStatementContext.getCustomer().getTotalFrequentRenterPoints())
        + " frequent renter points" + "\n";

    // set the result of the context to the result string
    rentalStatementContext.setResult(result);
  }
}
