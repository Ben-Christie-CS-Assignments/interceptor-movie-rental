import java.util.Enumeration;
import java.util.Vector;

class Customer {
  private String _name;
  private Vector<Rental> _rentals = new Vector<>();

  public Customer(String name) {
    _name = name;
  }

  public void addRental(Rental arg) {
    _rentals.addElement(arg);
  }

  public String getName() {
    return _name;
  }

  public RentalStatementContext createRentalStatementContext() {
    RentalStatementContext rentalStatementContext = new RentalStatementContext(this);
    Enumeration<Rental> rentals = _rentals.elements();

    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      rentalStatementContext.addRental(each);
    }

    return rentalStatementContext;
  }

  public double getTotalCharge() {
    double result = 0;
    Enumeration<Rental> rentals = _rentals.elements();

    while (rentals.hasMoreElements()) {
      Rental rental = (Rental) rentals.nextElement();
      result += rental.getCharge();
    }

    return result;
  }

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
