package project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Carlos Rodriguez
//November 12, 2018
//This is the application class. Here, a file is read with all the stations, and organized within the array list
//when the CTARoute is used. Then, the user interface has a menu with all the different operations. Each operation
//is done by operating a method. The methods use the CTARoute (inherently) to perform these operations.

public class CTAStopApp extends CTARoute{

    //This method runs find the transfer between the start and end, then saves the path description in a text file.
    public static void transferStationSave(ArrayList <CTARoute> CTARoutes, String name1, int lineIndex1, String name2, int lineIndex2) throws IOException {
        //CTARoute is the group of lines, name1 is the station started at, name2 is the station end, lineIndex1 is the start line, lineIndex2 is the end line.
        if(lineIndex1 == lineIndex2) {
            System.out.println("Start at: " + name1);
            System.out.println("No transfer needed.");
            System.out.println("End at: " + name2);

            FileWriter fw = new FileWriter("save.txt");
            //fw is the variable to write in the text file
            fw.write("Start at: " + name1);
            fw.write("No transfer needed.");
            fw.write("End at: " + name2);

            fw.close();

        }else {
            boolean flag = false;
            //boolean to check when loop can stop
            for(int i = 0; i < CTARoutes.get(lineIndex1).getStops().size(); i++) {
                // i and j are counters
                for(int j = 0; j < CTARoutes.get(lineIndex2).getStops().size();j++) {

                    if(CTARoutes.get(lineIndex1).getStops().get(i) == CTARoutes.get(lineIndex2).getStops().get(j)) {
                        System.out.println("Start at: " + name1);
                        System.out.println("Transfer at: " + CTARoutes.get(lineIndex1).getStops().get(i).getName() + "," + CTARoutes.get(lineIndex2).getName());
                        System.out.println("End at: " + name2);
                        FileWriter fww = new FileWriter("save.txt");

                        fww.write("Start at: " + name1);
                        fww.write("Transfer at: " + CTARoutes.get(lineIndex1).getStops().get(i).getName() + "," + CTARoutes.get(lineIndex2).getName());
                        fww.write("End at: " + name2);

                        fww.close();
                        flag = true;
                        break;
                    }

                }
                if(flag) {
                    break;
                }
            }
        }


    }
    //This method runs find the transfer between the start and end.
    public static void transferStation(ArrayList <CTARoute> CTARoutes, String name1, int lineIndex1, String name2, int lineIndex2) {
        //CTARoute is the group of lines, name1 is the station started at, name2 is the station end, lineIndex1 is the start line, lineIndex2 is the end line.

        if(lineIndex1 == lineIndex2) {
            //lineIndex1 and lineIndex2 are train line counters
            System.out.println("Start at: " + name1);
            System.out.println("No transfer needed.");
            System.out.println("End at: " + name2);

        }else {
            boolean flag = false;
            for(int i = 0; i < CTARoutes.get(lineIndex1).getStops().size(); i++) {
                for(int j = 0; j < CTARoutes.get(lineIndex2).getStops().size();j++) {

                    if(CTARoutes.get(lineIndex1).getStops().get(i) == CTARoutes.get(lineIndex2).getStops().get(j)) {
                        System.out.println("Start at: " + name1);
                        System.out.println("Transfer at: " + CTARoutes.get(lineIndex1).getStops().get(i).getName() + "," + CTARoutes.get(lineIndex2).getName());
                        System.out.println("End at: " + name2);
                        flag = true;
                        break;
                    }

                }
                if(flag) {
                    break;
                }
            }
        }

    }

    //This method runs a loop that through the whole array, and prints the name of all of them.
    public static void displayStationNames(ArrayList <CTARoute> CTARoutes ) {
        //CTARoute is the group of lines
        for(int i = 0; i < CTARoutes.size(); i++) {
            //i and j are counters
            for(int j = 0; j < CTARoutes.get(i).getStops().size(); j++) {
                System.out.println(CTARoutes.get(i).getStops().get(j).getName());



            }


        }




    }
    //The method runs a loop that checks if the each station has the wheelchair.
    public static void displayByWheelchair(ArrayList<CTARoute> CTARoutes, boolean user) {
        //CTARoute is the group of lines. i and j are counters. user is the boolean condition to check if to display
        for(int i = 0; i < CTARoutes.size(); i++) {
            for(int j = 0; j < CTARoutes.get(i).getStops().size();j++) {
                CTARoutes.get(i).getStops().get(j).getWheelchair();
                if(user == CTARoutes.get(i).getStops().get(j).getWheelchair()) {
                    System.out.println(CTARoutes.get(i).getStops().get(j).getName());

                }

            }
        }



    }
    //The method runs through the all the station coordinates to the inputted coordinates, and compares until the shortest distance is met.
    public static void displayNearest(ArrayList<CTARoute> CTARoutes, double userLatitude, double userLongitude) {
        CTAStation min = CTARoutes.get(0).getStops().get(0);
        //CTARoute is the group of lines. user latitude and user longitude are the inputs of coordinates

        for(int i = 0; i < CTARoutes.size(); i++) {
            for(int j = 0; j < CTARoutes.get(i).getStops().size(); j++) {

                double minDistance = min.calcDistance(userLatitude, userLongitude);
                double stationDistance = CTARoutes.get(i).getStops().get(j).calcDistance(userLatitude, userLongitude);
                //minDistance is the variable that has the lowest distance from the coordinates.
                if( minDistance > stationDistance ) {
                    min = CTARoutes.get(i).getStops().get(j);

                }
            }
        }




        System.out.println("Closest station: " + min.getName());


    }
    //The method runs a loop through the array to find the desired station and displays all its information through the toString method.
    public static void displayStationInfo(ArrayList<CTARoute> CTARoutes, String name) {
        //CTARoute is the group of lines. i are counters. name is the variable for the station
        for(int i = 0; i < CTARoutes.size(); i++) {
            CTAStation station = CTARoutes.get(i).lookUpStation(name);
            if(station != null) {
                System.out.println(CTARoutes.get(i).getName() + " : " + station.toString());

            }

        }





    }
    //The method runs a loop through the entire array and displays all its information through the toString method.
    public static void displayALLStationInfo(ArrayList<CTARoute> CTARoutes) {
        for(int i = 0; i < CTARoutes.size(); i++) {
            //CTARoute is the group of lines. i and j are counters
            for(int j = 0; j < CTARoutes.get(i).getStops().size(); j++) {

                System.out.println(CTARoutes.get(i).getStops().get(j).toString());


            }

        }


    }
    //The method runs through the loop to find the previous station given, and uses the insertStation method.
    public static void addStation(CTARoute route, String previous, String following, CTAStation newStation) {
        //CTARoute is the group of lines. previous is the variable for the previous station. following is the variables for the following station. newStation is the name for the new station
        for(int i = 0; i < route.getStops().size(); i++) {
            if(previous.equals(route.getStops().get(i).getName())) {
                route.insertStation(i+1, newStation);

            }

        }

    }
    //This method runs a loop and finds the station, then it is deleted with the removeStation method.
    public static void deleteStation(CTARoute route, String name) {
        //CTARoute is the group of lines. name is the variable for the station
        for(int i = 0; i <route.getStops().size(); i++) {
            if(name.equals(route.getStops().get(i).getName())) {
                route.removeStation(route.getStops().get(i));

            }

        }


    }


    public static void main(String args[]) throws IOException{
        String string = "";

        File excel = new File("src/project/CTAStops.csv");
        Scanner input = new Scanner(excel);		//input is the varible for the scanner of the excel file
        input.useDelimiter(",|\n");
        ArrayList<CTARoute> CTARoutes = new ArrayList<CTARoute>(); //array list for the different CTA Routes (lines)
        CTARoutes.add(new CTARoute("Red Line",new ArrayList<CTAStation>())); //red
        CTARoutes.add(new CTARoute("Green Line",new ArrayList<CTAStation>())); //green
        CTARoutes.add(new CTARoute("Blue Line",new ArrayList<CTAStation>())); //blue
        CTARoutes.add(new CTARoute("Brown Line",new ArrayList<CTAStation>()));// brown
        CTARoutes.add(new CTARoute("Purple Line",new ArrayList<CTAStation>()));//purple
        CTARoutes.add(new CTARoute("Pink Line",new ArrayList<CTAStation>()));//pink
        CTARoutes.add(new CTARoute("Orange Line",new ArrayList<CTAStation>()));//orange
        CTARoutes.add(new CTARoute("Yellow Line",new ArrayList<CTAStation>()));//yellow

        for(int i = 0; i <26; i++) {
            input.next();

        }


        while(input.hasNext()){
            CTAStation name = new CTAStation(); 	//name is the variable for the CTA station
            name.setName(input.next());
            name.setLat(input.nextDouble());
            name.setLng(input.nextDouble());
            name.setLocation(input.next());
            name.setWheelchair(input.nextBoolean());
            //System.out.println(name.getName());

            if(input.nextInt() >= 0) {
                CTARoutes.get(0).addStation(name);

            }
            if(input.nextInt() >= 0) {
                CTARoutes.get(1).addStation(name);

            }
            if(input.nextInt() >= 0) {
                CTARoutes.get(2).addStation(name);

            }
            if(input.nextInt() >= 0) {
                CTARoutes.get(3).addStation(name);

            }
            if(input.nextInt() >= 0) {
                CTARoutes.get(4).addStation(name);

            }
            if(input.nextInt() >= 0) {
                CTARoutes.get(5).addStation(name);

            }
            if(input.nextInt() >= 0) {
                CTARoutes.get(6).addStation(name);

            }
            if(input.nextInt() >= 0) {
                CTARoutes.get(7).addStation(name);

            }



        }




        Scanner scan = new Scanner(System.in);		//scan is the variable for the scanner

        String user;
        //boolean user1 = true;

        do {
            System.out.println("Input number corresponding to desired command: ");
            System.out.println("1. Display Station Names");
            System.out.println("2. Display Station with/without Wheelchair access");
            System.out.println("3. Display Nearest Station");
            System.out.println("4. Display information for a station with a specific name");
            System.out.println("5. Display information for all stations");
            System.out.println("6. Add a new station");
            System.out.println("7. Delete an existing station");
            System.out.println("8. Transfer station");
            System.out.println("9. Exit");

            user = scan.nextLine(); //input of the user for the menu


            if(user.equals("1")) {
                displayStationNames(CTARoutes);

            }

            if(user.equals("2")) {
                try {
                    System.out.println("Input 'y' for wheelchair access. \nInput 'n' for without wheelchair access.");
                    boolean user1 = true;	//boolean user1 for the condition

                    user = scan.nextLine();

                    if(user.equalsIgnoreCase("y")) {
                        user1 = true;

                        displayByWheelchair(CTARoutes,user1);

                    }
                    else if(user.equalsIgnoreCase("n")) {
                        user1 = false;

                    }


                }
                catch(Exception e) {
                    System.out.println("Error.");

                }
            }

            if(user.equals("3")) {
                double userLatitude1 = 0;		//userLatitude for the inputted latitude
                double userLongitude1 = 0;		//userLongitude for the inputted longitude
                System.out.println("Input latitude: ");
                String userLatitude = scan.nextLine();
                System.out.println("Input longitude: ");
                String userLongitude = scan.nextLine();
                boolean didA = false;		//boolean didA
                boolean didB = false;		//boolean didB
                try {
                    userLatitude1 = Double.parseDouble(userLatitude);
                    didA = true;
                    userLongitude1 = Double.parseDouble(userLatitude);
                    didA = true;
                    displayNearest(CTARoutes, userLatitude1, userLongitude1);

                }
                catch(Exception e){
                    System.out.println("Invalid.");


                }


            }

            if(user.equals("4")) {
                try {
                    System.out.println("Input station name: ");
                    String stationName = scan.nextLine();		//user input for the StationName
                    displayStationInfo(CTARoutes, stationName);
                }
                catch(Exception e) {
                    System.out.println("Error.");

                }

            }

            if(user.equals("5")) {
                displayALLStationInfo(CTARoutes);

            }

            if(user.equals("6")) {
                try {
                    CTAStation stationNEW = new CTAStation(); //variable for the new station created
                    System.out.println("Longitude: ");
                    stationNEW.setLng(Double.parseDouble(scan.nextLine()));
                    System.out.println("Latitude: ");
                    stationNEW.setLat(Double.parseDouble(scan.nextLine()));
                    System.out.println("Name of station: ");
                    stationNEW.setName(scan.nextLine());
                    System.out.println("Location Description (enter elevated, subway, embankment, surface): ");
                    stationNEW.setLocation(scan.nextLine());
                    System.out.println("For wheelchair accessibility enter 'true'. Otherwise, enter false: ");
                    stationNEW.setWheelchair(Boolean.parseBoolean(scan.nextLine()));
                    System.out.println("Previous station name: ");
                    String previous = scan.nextLine();
                    System.out.println("Following station name: ");
                    String following = scan.nextLine();
                    System.out.println("Input the numerical representation for the line: ");
                    System.out.println("Red Line (0) ");
                    System.out.println("Green Line (1) ");
                    System.out.println("Blue Line (2) ");
                    System.out.println("Brown Line (3) ");
                    System.out.println("Purple Line (4) ");
                    System.out.println("Pink Line (5) ");
                    System.out.println("Orange Line (6) ");
                    System.out.println("Yellow Line (7) ");
                    String userInput = scan.nextLine();		//userInput and newInput for the new line and station
                    int newInput = Integer.parseInt(userInput);

                    addStation(CTARoutes.get(newInput), previous, following, stationNEW);
                }
                catch(Exception e) {
                    System.out.println("Error.");

                }






            }

            if(user.equals("7")) {
                try {
                    System.out.println("Input the numerical representation for the line: ");
                    System.out.println("Red Line (0) ");
                    System.out.println("Green Line (1) ");
                    System.out.println("Blue Line (2) ");
                    System.out.println("Brown Line (3) ");
                    System.out.println("Purple Line (4) ");
                    System.out.println("Pink Line (5) ");
                    System.out.println("Orange Line (6) ");
                    System.out.println("Yellow Line (7) ");
                    String stationRoute = scan.nextLine();
                    int newStationRoute = Integer.parseInt(stationRoute); //name and newStation route for the new line
                    System.out.println("Name?");
                    String name = scan.nextLine();


                    deleteStation(CTARoutes.get(newStationRoute), name);
                }
                catch(Exception e) {
                    System.out.println("Error.");

                }




            }

            if(user.equals("8")) {
                int startLine = 0; //line started in
                String startStation = ""; //new station started in
                int endLine = 0; //line ended
                String endStation = ""; //station ended
                System.out.println("Do wish to save this path? If yes, input 'y'. If no, input 'n'.");
                String option = scan.nextLine();
                String fileName; //new file name to save
                try {
                    if(option.equals("y")) {
                        System.out.println("Line corresponding to number: ");
                        System.out.println("Red Line (0) ");
                        System.out.println("Green Line (1) ");
                        System.out.println("Blue Line (2) ");
                        System.out.println("Brown Line (3) ");
                        System.out.println("Purple Line (4) ");
                        System.out.println("Pink Line (5) ");
                        System.out.println("Orange Line (6) ");
                        System.out.println("Yellow Line (7) ");


                        System.out.println("Input start station: ");
                        startStation = scan.nextLine();
                        System.out.println("Input start line number: ");
                        startLine = Integer.parseInt(scan.nextLine());

                        System.out.println("Input end station: ");
                        endStation = scan.nextLine();
                        System.out.println("Input end line number: ");
                        endLine = Integer.parseInt(scan.nextLine());
                        transferStationSave(CTARoutes, startStation, startLine, endStation, endLine);

                    }
                    else if(option.equals("n")) {
                        System.out.println("Line corresponding to number: ");
                        System.out.println("Red Line (0) ");
                        System.out.println("Green Line (1) ");
                        System.out.println("Blue Line (2) ");
                        System.out.println("Brown Line (3) ");
                        System.out.println("Purple Line (4) ");
                        System.out.println("Pink Line (5) ");
                        System.out.println("Orange Line (6) ");
                        System.out.println("Yellow Line (7) ");


                        System.out.println("Input start station: ");
                        startStation = scan.nextLine();
                        System.out.println("Input start line number: ");
                        startLine = Integer.parseInt(scan.nextLine());

                        System.out.println("Input end station: ");
                        endStation = scan.nextLine();
                        System.out.println("Input end line number: ");
                        endLine = Integer.parseInt(scan.nextLine());
                        transferStation(CTARoutes, startStation, startLine, endStation, endLine);
                    }
                }
                catch(Exception e) {
                    System.out.println("Error.");
                }


            }

        }while(!user.equals("9"));
    }

}





