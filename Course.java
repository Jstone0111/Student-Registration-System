package project.pkg1;



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

