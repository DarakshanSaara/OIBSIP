package OnlineReservationSystem;

public class Reservation {
    private String name;
    private String trainNo;
    private String trainName;
    private String classType;
    private String dateOfJourney;
    private String from;
    private String to;
    private String pnr;

    public Reservation(String name, String trainNo, String trainName, String classType,
                       String dateOfJourney, String from, String to, String pnr) {
        this.name = name;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.from = from;
        this.to = to;
        this.pnr = pnr;
    }

    public String getPNR() {
        return pnr;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getName() {
        return name;
    }

    public String getFrom(){
        return from;
    }

    public String getTo(){
        return to;
    }

    public String getClassType(){
        return classType;
    }

    public String getDateOfJourney(){
        return dateOfJourney;
    }

    // Method to display reservation details
    public void display() {
        System.out.println("----- Reservation Details -----");
        System.out.println("PNR Number     : " + pnr);
        System.out.println("Passenger Name : " + name);
        System.out.println("Train Number   : " + trainNo);
        System.out.println("Train Name     : " + trainName);
        System.out.println("Class Type     : " + classType);
        System.out.println("Date of Journey: " + dateOfJourney);
        System.out.println("From           : " + from);
        System.out.println("To             : " + to);
    }
}

