import java.util.List;
import java.util.concurrent.Callable;

public class FlightServiceCallable implements Callable<List<FlightData>> {
    private FlightServiceInterface flightServiceInterface;
    private String criteria;

    public FlightServiceCallable(FlightServiceInterface flightServiceInterface, String criteria) {
        this.flightServiceInterface = flightServiceInterface;
        this.criteria = criteria;
    }

    @Override
    public List<FlightData> call() throws Exception {
        return flightServiceInterface.getFlightDataOfCriteria(criteria);

    }
}
