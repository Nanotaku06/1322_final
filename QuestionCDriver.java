import java.util.ArrayList;

public class QuestionCDriver {
    public static void main(String[] args){
        ArrayList<Airport> allAirports = new ArrayList<>();

        String[] airportList = {"ATL", "CTL", "IAD", "SFO"}; // made this for loop for quick coding.
        for(String x:airportList){
            Airport apt = new Airport(x);
            allAirports.add(apt); // not in the mood for coding 4 identical .add methods lmao. This works the same tho.
        }
        String[] ks101routes = {"ATL" , "SFO"};
        Thread ks101 = new Plane("KSU Air", 101, ks101routes, allAirports);
        String[] ks115routes = {"CTL", "IAD", "ATL"};
        Thread ks115 = new Plane("KSU Air", 115, ks115routes, allAirports);

        ks115.start();
        ks101.start();
    }
}
