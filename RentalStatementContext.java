import java.util.Vector;

public class RentalStatementContext {
  private Customer _customer;
  private Vector<Rental> _rentals = new Vector<>();
  private String _result;

  public RentalStatementContext(Customer customer) {
    _customer = customer;
  }

  public Customer getCustomer() {
    return _customer;
  }

  public void addRental(Rental arg) {
    _rentals.addElement(arg);
  }

  public Vector<Rental> getRentals() {
    return _rentals;
  }

  public String getResult() {
    return _result;
  }

  public void setResult(String arg) {
    _result = arg;
  }
}
