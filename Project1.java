package project.pkg1;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;



public class Project1 {
    
    public static final int TRADITIONAL = 11;
    public static final int ONLINE = 7;
    
        public static void main(String[] args) throws IOException {
            
            Scanner in = new Scanner(Paths.get("project1input.csv"), "UTF-8");
            ArrayList<Course> fullClassList = new ArrayList<>();


                while ( in.hasNextLine() ) {
                    String line = in.nextLine();
                    String [] currentCourse = (line.split("\t"));
                    
                        if(currentCourse.length == TRADITIONAL){
                            
                            String [] start = currentCourse[5].split(":");
                            String [] end = currentCourse[6].split(":");
                            
                            int startHour = Integer.parseInt(start[0]);
                            int startMinute = Integer.parseInt(start[1]);
                            
                            int endHour = Integer.parseInt(end[0]);
                            int endMinute = Integer.parseInt(end[1]);
                            
                            LocalTime newStrt = LocalTime.of(startHour, startMinute);
                            LocalTime newEnd = LocalTime.of(endHour, endMinute);
                            
                            Traditional t = new Traditional
                           (currentCourse[0], 
                            Integer.parseInt(currentCourse[1]),
                            currentCourse[2],
                            currentCourse[3],
                            Integer.parseInt(currentCourse[4]),
                            newStrt,
                            newEnd,
                            currentCourse[7],
                            currentCourse[8],
                            currentCourse[9],
                            currentCourse[10]);
                            
                            fullClassList.add(t);
                            
                            
                            
                  
                }
                        else if (currentCourse.length == ONLINE){
                            
                            Online o = new Online(
                            currentCourse[0],
                            Integer.parseInt(currentCourse[1]),
                            currentCourse[2],
                            currentCourse[3],
                            Integer.parseInt(currentCourse[4]),
                            currentCourse[5],
                            currentCourse[6]);
                            
                            
                            fullClassList.add(o);
                        }
                        
                        
                        
                        
                       
                }
                
                boolean finishedSchedule = false;
                ArrayList<Course> actualSchedule = new ArrayList<>();
                
                while (!finishedSchedule){
            System.out.println("1) Search Courses");
            System.out.println("2) Register for Course");
            System.out.println("3) View Trial Schedule");
            System.out.println("4) Quit");
            
            Scanner c = new Scanner(System.in);

            int choice = c.nextInt();
            
            if (choice == 1){
                System.out.println("Please search for the class you want. Ex: CS 231: ");
            
            Scanner pick = new Scanner(System.in);
            String classChoice = pick.nextLine();
            
            ArrayList<Course> options = new ArrayList<>();
            
            for (Course l : fullClassList){
                if (l.getCourseNumber().equals(classChoice)){
                    options.add(l);
                }
                
            }
            
            for (Course l : options){
                System.out.println(l);  
            }
        }
            
            else if (choice == 2){
                System.out.println("Please enter the CRN number for the class you would like to add: ");
                
                Scanner crnChoice = new Scanner(System.in);
                int crn = crnChoice.nextInt();
                
                
                for (Course l : fullClassList){
                    
                    if (l.getCRNnumber() == crn){
                        Course chosenCourse = l;
                        
                        if(actualSchedule.isEmpty()){
                            actualSchedule.add(chosenCourse);
                            System.out.println("Class Added!");
                            System.out.println();
                            
                        }
                        else{
                            
                            int conflictCounter = 0;
                            for (Course course : actualSchedule){
                                
                                if(chosenCourse.conflictsWith(course) == false){
                                    ++conflictCounter;
                                }
                                
                                else{
                                    System.out.println("Conflict Detected!");
                                    System.out.println();
                                }
                                
                            }
                            if(conflictCounter == actualSchedule.size()){
                                actualSchedule.add(chosenCourse);
                                System.out.println("Class Added!");
                                System.out.println();
                            }
                        }
                    }
                }
                
            }
            
            else if(choice == 3){
                for (Course l: actualSchedule){
                    System.out.println(l);
                }
                System.out.println();
            }
            else if(choice == 4){
                System.out.println("Programming Ended!");
                        
                        finishedSchedule = true;
            }
            
            
            
            
            
            
            
                }
        }
}
            
            