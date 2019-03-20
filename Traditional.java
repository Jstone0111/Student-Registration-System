/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg1;
import java.time.LocalTime;

/**
 *
 * @author Jacob
 */
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
                
                
                
                if(this.getEndTime().isAfter(trad.getStartTime()) && this.getStartTime().isBefore(trad.getStartTime())){
                    conflicts = true;
                }
                
                else if (this.getStartTime().isBefore(trad.getEndTime()) && this.getEndTime().isAfter(trad.getEndTime())){
                    conflicts = true;
                }
                else if (this.getStartTime().isAfter(trad.getStartTime()) && this.getEndTime().isBefore(trad.getEndTime())){
                    conflicts = true;
                }
                else if(this.getStartTime() == trad.getStartTime()){
                    conflicts = true;
                }    
            }
            else{
                conflicts = false;
            }  
        }
        return conflicts;
    }
}

