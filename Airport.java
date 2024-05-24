import java.util.LinkedList;

public class Airport {
    private String name;
    private LinkedList<Plane> PlaneList;

    public Airport(){
        this.name = "Unknown Airport";
        PlaneList = new LinkedList<>();
    }
    public Airport(String name){
        this.name = name;
        PlaneList = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void depart(Plane departingPlane){
        PlaneList.remove(departingPlane);
    }
    public void arrive(Plane arrivingPlane){
        PlaneList.add(arrivingPlane);
    }

    @Override
    public String toString() {
        String totalString = "";
        totalString += (this.name + " currently has the following planes: \n");
        for(Plane x : PlaneList){
            totalString += (x.getAirline() + " " + x.getFlightNumber() + "\n");
        }
        return totalString;
    }
}
