import java.util.Enumeration;
import java.util.Vector;

class Customer {
  // name of customer and a Vector of all their rentals
  private String _name;
  private Vector<Rental> _rentals = new Vector<>();

  // constructor
  public Customer(String name) {
    _name = name;
  }

  public void addRental(Rental arg) {
    _rentals.addElement(arg);
  }

  public String getName() {
    return _name;
  }

  // create the context object
  public RentalStatementContext createRentalStatementContext() {
    RentalStatementContext rentalStatementContext = new RentalStatementContext(this);
    Enumeration<Rental> rentals = _rentals.elements();

    // go through each rental
    while (rentals.hasMoreElements()) {
      Rental rental = (Rental) rentals.nextElement();

      // add rental to context
      rentalStatementContext.addRental(rental);
    }

    return rentalStatementContext;
  }

  // calculate total charge
  public double getTotalCharge() {
    double result = 0;
    Enumeration<Rental> rentals = _rentals.elements();

    while (rentals.hasMoreElements()) {
      Rental rental = (Rental) rentals.nextElement();
      result += rental.getCharge();
    }

    return result;
  }

  // calculate total frequent renter points
  public int getTotalFrequentRenterPoints() {
    int result = 0;
    Enumeration<Rental> rentals = _rentals.elements();

    while (rentals.hasMoreElements()) {
      Rental rental = (Rental) rentals.nextElement();
      result += rental.getFrequentRenterPoints();
    }

    return result;
  }
}
