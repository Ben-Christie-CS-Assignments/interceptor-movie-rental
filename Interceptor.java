// Interceptor interface, this would in theory ensure that all interceptors in our program implement the 
//intercept functionality
public interface Interceptor {
  void intercept(RentalStatementContext context);
}
