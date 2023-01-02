import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AggregatorDemo {
    private static ExecutorService executorService= Executors.newFixedThreadPool(2);
    public static void main(String[] args) throws Exception {
        String criteria ="LKO:DLI";
        FlightServiceInterface ingoFlightService=new IndigoFlightService();
        FlightServiceInterface oAirFlightService=new GoAirFlightService();

        FlightServiceCallable goAirReq=new FlightServiceCallable(ingoFlightService,criteria);
        FlightServiceCallable indigoReq=new FlightServiceCallable(oAirFlightService,criteria);

        Future<List<FlightData>> goAirResponse=executorService.submit(goAirReq);
        Future<List<FlightData>> indigoResponse=executorService.submit(indigoReq);
        List<FlightData> list1 = goAirResponse.get();

        List<FlightData> list2 = indigoResponse.get();


    }
}
