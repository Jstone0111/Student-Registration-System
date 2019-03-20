/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg1;


/**
 *
 * @author Jacob
 */
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
