import java.util.Vector;

public class Dispatcher {
  private Vector<RentalStatementInterceptor> _interceptors = new Vector<>();

  public void registerInterceptor(RentalStatementInterceptor interceptor) {
    _interceptors.add(interceptor);
  }

  public void dispatch(RentalStatementContext rentalStatementContext) {
    for (RentalStatementInterceptor interceptor : _interceptors) {
      interceptor.intercept(rentalStatementContext);
    }
  }
}
