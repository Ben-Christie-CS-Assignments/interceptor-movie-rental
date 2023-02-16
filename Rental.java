// represents a customer renting a movie
// represents a customer renting a single movie for a specific number of days
class Rental {
  private Movie _movie;
  private int _daysRented;

  public Rental(Movie movie, int daysRented) {
    _movie = movie;
    _daysRented = daysRented;
  }

  public int getDaysRented() {
    return _daysRented;
  }

  public Movie getMovie() {
    return _movie;
  }

  // get the charge for the movie based on the price code, add late charges too
  public double getCharge() {
    double charge = 0;

    switch (this.getMovie().getPriceCode()) {
      case Movie.REGULAR:
        charge += 2;
        if (this.getDaysRented() > 2) {
          charge += (this.getDaysRented() - 2) * 1.5;
        }
        break;

      case Movie.NEW_RELEASE:
        charge += this.getDaysRented() * 3;
        break;

      case Movie.CHILDREN:
        charge += 1.5;
        if (this.getDaysRented() > 3) {
          charge += (this.getDaysRented() - 3) * 1.5;
        }
        break;
    }

    return charge;
  }

  // get the renter points for the rental
  int getFrequentRenterPoints() {
    // add bonus for a 2 day new release rental
    if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
      return 2;
    } else {
      return 1;
    }
  }
}
