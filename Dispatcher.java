import java.util.Vector;

public class Dispatcher {
  private Vector<RentalStatementInterceptor> _interceptors = new Vector<>();

  // add an interceptor to the list of interceptors
  public void registerInterceptor(RentalStatementInterceptor interceptor) {
    _interceptors.add(interceptor);
  }

  // dispatch a RentalStatementContext to all the interceptors
  public void dispatch(RentalStatementContext rentalStatementContext) {
    for (RentalStatementInterceptor interceptor : _interceptors) {
      interceptor.intercept(rentalStatementContext);
    }
  }
}
