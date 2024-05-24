import java.util.ArrayList;

public class Plane extends  Thread{
    private String airline;
    private int flightNumber;
    private String[] route;

    ArrayList<Airport> allAirports;

    public Plane(String airline, int flightNumber, String[] route, ArrayList<Airport> allAirports){
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.route = route;
        this.allAirports = allAirports;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getAirline() {
        return airline;
    }


    public void run(){
        String currentCity = route[0]; // setting route outside, so it can be used in setup and loop regardless of scope.
        synchronized (allAirports) {//almost forgot this existed
            // we need two separate syncronized. One so both setups can happen at their own time, and one for the actual loop
            for (int i = 0; i < allAirports.size(); i++) {
                if (allAirports.get(i).getName().equals(currentCity)) { //doing a first iteration to add the planes to their starting points
                    allAirports.get(i).arrive(this);
                    System.out.println(allAirports.get(i));
                }

            }
        }

            for(int i = 0; i< route.length; i++){
                synchronized (allAirports){ //sincronized has to be INSIDE of the for loop so that the sleep function can be inside of the for loop, but outside of the syncronized.
                currentCity = route[i];
                String nextCity;


                if(i>=(route.length-1)){ // prevents index out of bounds issues by loopng back to the begining of the array.
                    nextCity = route[0];
                }else {
                    nextCity = route[i+1];
                }

                System.out.println("Flight " + this.airline + " " + this.flightNumber + " is flying from " + currentCity + " to " + nextCity);
                for(Airport x: allAirports){
                    if (x.getName().equals(currentCity)) {
                        x.depart(this);
                        System.out.println(x);
                    }

                }
                for(Airport x : allAirports){
                    if(x.getName().equals(nextCity)){
                        x.arrive(this);
                        System.out.println(x);
                    }
                }

                if(i >= route.length-1) i = -1; // resets i so the loop can be infinite.  We need to put -1 if we want to start back a 0, since for loops increment by 1 at the end.



        }
            try { // using a try/catch in case the sleep method breaks. Better safe than sorry!!
                this.sleep(2000); // sleep needs to be outside of the syncronized method, so that the other threads can run while this one sleeps
            } catch (InterruptedException e) {
                System.out.println("womp womp");
                throw new RuntimeException(e);
            }


        }
    }
}
