# Student-Registration-System
This code is remaking part of the student registration system at JSU.
I was given this project in order to help me further understand classes in Java and also to learn the use of abstract classes and super.
## The Course Class

```

public abstract class Course {

    private String course_name;
    private int CRN_number;
    private String course_number;
    private String section_number;
    private int credit_hour;
    private String instructor_name;
    
        public Course(String cn, int crn, String cnum, String snum, int ch, String in){
            this.course_name = cn;
            this.CRN_number = crn;
            this.course_number = cnum;
            this.section_number = snum;
            this.credit_hour = ch;
            this.instructor_name = in;     
        }
        public String getCourseName(){
            return course_name;
        }
        public String setCourseName(String cn){
            return this.course_name = cn;
        }
        public int getCRNnumber(){
            return CRN_number;
        }
        public int setCRNnumber(int crn){
            return this.CRN_number = crn;
        }
        public String getCourseNumber(){
            return course_number;
        }
        public String setCourseNumber(String cnum){
            return this.course_number = cnum;
        }
        public String getSectionNumber(){
            return section_number;
        }
        public String setSectionNumber(String snum){
            return this.section_number = snum;
        }
        public int getCreditHour(){
            return credit_hour;
        }
        public int setCreditHour(int ch){
            return this.credit_hour = ch;
        }
        public String getInstructorName(){
            return instructor_name;
        }
        public String setInstructorName(String in){
            return this.instructor_name = in;
        }
        
        public abstract boolean conflictsWith(Course c);
}
```
This code is setting up an abstract class called Course. It is then setting "getters" and "setters" for every object in this class.
This class is what the other classes extend off of.

## The Traditional Class

```
public class Traditional extends Course{
    
    private LocalTime start_time;
    private LocalTime end_time;
    private String meeting_days;
    private String meeting_location;
    private String course_type;
    
    
    public Traditional(String cn, int crn, String cnum, String snum, int ch, LocalTime st, LocalTime et, String md, String ml, String ct, String in){
        
            super (cn, crn, cnum, snum, ch, in);
            
            this.start_time = st;
            this.end_time = et;
            this.meeting_days = md;
            this.meeting_location = ml;
            this.course_type = ct;
        
    }
    
        public LocalTime getStartTime(){
            return start_time;
        }
        public LocalTime setStartTime(LocalTime st){
            return this.start_time = st;
        }
        public LocalTime getEndTime(){
            return end_time;
        }
        public LocalTime setEndTime(LocalTime et){
            return this.end_time = et;
        }
        public String getMeetingDays(){
            return meeting_days;
        }
        public String setMeetingDays(String md){
            return this.meeting_days = md;
        }
        public String getMeetingLocation(){
            return meeting_location;
        }
        public String setMeetingLocation(String ml){
            return this.meeting_location = ml;
        }
        public String getCourseType(){
            return course_type;
        }
        public String setCourseType(String ct){
            return this.course_type = ct;
        } 
        

    @Override
        public String toString(){
            return ("#" + getCRNnumber() + ": " + getCourseNumber() + " (" + getCourseName() + "), " + getInstructorName() + ", " +
                    getCourseType() + ", " + getStartTime() + " - " + getEndTime() + ", " + getMeetingDays() + ", " + getMeetingLocation());
        }
        
        
        
    
    @Override
    public boolean conflictsWith(Course c){
        boolean conflicts = false;
        
        if(c instanceof Traditional){
            Traditional trad = (Traditional)c;
            
            if (this.getMeetingDays().equals(trad.getMeetingDays())){
```

This is the first class that extends the Course class. This class is for all of the non-online classes. It sets the "getters" and "setters"
that are not in both types of courses. This class also has a toString() method that formats the output into its proper format.
The conflictsWith() method is used in order to make sure you do not schedule more than one class at the same time during the day.

## The Online Class

```
public class Online extends Course {
    
    private String class_type;
    
    public Online(String cn, int crn, String cnum, String snum, int ch, String ct, String in){
        
        super(cn, crn, cnum, snum, ch, in);
        
        this.class_type = ct;
    }
    
    public String getClassType(){
        return class_type;
    }
    public String setClassType(String ct){
        return this.class_type = ct;
    }
    
    @Override
    public String toString(){
            return ("#" + getCRNnumber() + ": " + getCourseNumber() + " (" + getCourseName() + "), " + getInstructorName() + ", " +
                    getClassType());
        }

    @Override
    public boolean conflictsWith(Course c) {
        boolean conflicts = false;
        
        if(this.getCRNnumber() == c.getCRNnumber()){
            conflicts = true;
        }
        return conflicts;
    }
    
    
    
}
```

This is the second class that extends the Course class. This class is for all online classes.
This class is very similar to the Traditional Class except that it does not have any times because it is online.
The only extra method required for this class is the classType() method. This class also has a toString() method
in order to format it as well as a conflictsWith() to ensure you are not already registered for that class.

## The Main Project
The main file of this project has many parts so I will break it down.

### Reading From the File and Setting Content into an Array List

```
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
                
```
This section of the code reads the information out of an input file. It the reads the file line by line and finds whether it is
a traditional class or an online class.

### Getting Input From User

```

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
```
This code first ask the user to choose from a list of options.
Each option has a different function such as the first option being a class lookup system.
The second option adds classes to your schedule while making sure you are not already registered for that class and that is does not have any time conflicts.
The third option prints out all of the classes you are registered for, and the final option closes out the program.








