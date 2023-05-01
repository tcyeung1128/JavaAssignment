/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author chung
 */
public class Student {
    private String studentName;
    private int studentID;
    private String password;
    private String studyMode;
    private String programme;
    private int currentLevel;
    private int modulesTake;
    private ArrayList<String> moduleCode = new ArrayList<String>();
    private ArrayList<String> moduleName = new ArrayList<String>();
    private ArrayList<Integer> attendance = new ArrayList<Integer>();
    private ArrayList<Integer> examMark = new ArrayList<Integer>();

Student(String studentName, int studentID, String password, String studyMode,
        String programme, int currentLevel, int modulesTake){

    set(studentName, studentID, password, studyMode, programme, currentLevel,
        modulesTake);
}

// set the object structor
Student(){
    set("Name", 10010000, "Ab345678", "1", "1", 1, 4);
}
        

public void set(String studentName, int studentID, String password, String studyMode, String programme, int currentLevel, int modulesTake){
    
    setStudentName(studentName);
    setStudentID(studentID); 
    setPassword(password);
    setStudyMode(studyMode);
    setProgramme(programme);
    setCurrentLevel(currentLevel);
    setModulesTake(modulesTake);
}

// set student name
public boolean setStudentName(String studentName){
    if(studentName.length() <= 25 && !studentName.trim().isEmpty()){
        this.studentName = studentName.trim();
        return true;
    }else{
        System.out.println("The maximum length of the student’s name is 25 characters with space inclusive.");
        return false;
    }
}

// setup the validation and set student Id
public boolean setStudentID(int studentID){
    if (studentID >= 10010000 && studentID <= 10019999){
           this.studentID = studentID;
           return true;
    }else{
            System.out.println("Invalid input. The student ID must consists of 8 digits and starts with 1001");
            return false;
    }
}

// setup a validation and set password
public boolean setPassword(String password){
    char passwordChar;
    boolean number = false;
    boolean capitalized = false;
    boolean small = false;
    boolean length = false;

    for(int j = 0; j < password.length(); j++){
        passwordChar = password.charAt(j);
        if( Character.isDigit(passwordChar)){
            number = true;
        }
        else if (Character.isUpperCase(passwordChar)){
            capitalized = true;
        }
        else if (Character.isLowerCase(passwordChar)){
            small = true;
        }
        if(password.length() >= 8){
            length = true;
        }
    }
    if(capitalized && small && number && length){
        this.password = password;
        return true;
    }else{
        System.out.println("The password must contain 8 characters, with at least 1 capitalized letter and 1 small letter and 1 numeric value.");
        return false;  
    }
}

// setup a validation and set study mode
public boolean setStudyMode(String studyMode){
    if(studyMode.equals("Full time") || studyMode.equals("1")){
        studyMode = "Full time";
        this.studyMode = studyMode;
        return true;
    }else if(studyMode.equals("Part time") || studyMode.equals("2")){
        studyMode = "Part time";
        this.studyMode = studyMode;
        return true;
    }else{
        System.out.println("You can only choose Full time or Part time");
        System.out.println("Please input your study mode (1 = Full time, 2 = Part time) : ");
        return false;
    }
}

// setup a validation and set programme
public boolean setProgramme(String programme){
    if(programme.equals("Higher Diploma in Information Technology (Computing)") || programme.equals("1")){
        programme = "Higher Diploma in Information Technology (Computing)";
        this.programme = programme;
        return true;
    }else if(programme.equals("Higher Diploma in Information Technology (Cyber Security and Investigation)") || programme.equals("2")){
        programme = "Higher Diploma in Information Technology (Cyber Security and Investigation)";
        this.programme = programme;
        return true;
    }else{
        System.out.println("Please input your programme name (1 = Higher Diploma in Information Technology (Computing), 2 = Higher Diploma in Information Technology (Cyber Security and Investigation): ");
        return false;
    }
}

// setup a validation and set pcurrent level
public boolean setCurrentLevel(int currentLevel){
    if(currentLevel == 1 || currentLevel == 2){
            this.currentLevel = currentLevel;
            return true;
    }else{
            System.out.println("Please input your current level of the programme (1 or 2).");
            return false;
    }
}

// setup a validation and set module take
public boolean setModulesTake(int modulesTake){
    if(modulesTake == 2 || modulesTake == 3 || modulesTake == 4){
        this.modulesTake = modulesTake;
        return true;
    }else{
        System.out.println("You must take 2-4 modules each semester.");
        return false;
    }
}

public void setModuleCode(String moduleCode){
    this.moduleCode.add(moduleCode);
}

public void setModuleName(String moduleName){
    this.moduleName.add(moduleName);
}

// setup a validation (0-100) and set attendance
public boolean setAttendance(int attendance){
    if(attendance >= 0 && attendance <= 100){
        this.attendance.add(attendance);
        return true;
    }else{
        System.out.println("Please input a number between 0-100 : ");
        return false;
    }
}
// setup a validation (0-100) and set exam mark
public boolean setExamMark(int examMark){
    if(examMark >= 0 && examMark <= 100){
        this.examMark.add(examMark);
        return true;
    }else{
        System.out.println("Please input a number between 0-100 : ");
        return false;
    }
}

public String getStudentName(){
    return studentName;
}

public int getStudentID(){
    return studentID;
}

public String getPassword(){
    return password;
}

public String getStudyMode(){
    return studyMode;
}

public String getProgramme(){
    return programme;
}

public int getCurrentLevel(){
    return currentLevel;
}

public int getModulesTake(){
    return modulesTake;
}

public String getModuleCode(int moduleCode){
    return this.moduleCode.get(moduleCode);
}

public String getModuleName(int moduleName){
    return this.moduleName.get(moduleName);
}

public Integer getAttendance(int attendance){
    return this.attendance.get(attendance);
}

public Integer getExamMark(int examMark){
    return this.examMark.get(examMark);
}

//setup the grade range
public String grage(int examMarkList){
    this.examMark.get(examMarkList);
    String grage = null;
    if(this.examMark.get(examMarkList) <= 39){
        grage = "F";
    }else if(this.examMark.get(examMarkList) <= 59){
        grage = "P";
    }else if(this.examMark.get(examMarkList) <= 69){
        grage = "C";
    }else if(this.examMark.get(examMarkList) <= 79){
        grage = "D";
    }else if(this.examMark.get(examMarkList) <= 100){
        grage = "HD";
    }
    return grage;
}

// calculate the average mark
public double averageMark(){
    double averageMark = 0;
    for(int i = 0; i < this.modulesTake; i++){
        averageMark += this.examMark.get(i);
    }
    averageMark /= this.modulesTake;
    return averageMark;
}

// calculate the average attendance
public double averageAttendance(){
    double averageAttendance = 0;
    for(int i = 0; i < this.modulesTake; i++){
        averageAttendance += this.attendance.get(i);
    }
    averageAttendance /= this.modulesTake;
    return averageAttendance;
}

// calculate the final grade
public String finalGrage(){
    double averageMark = averageMark();
    String finalGrage = null;
    if(averageMark <= 39){
        finalGrage = "F(Failure)";
    }else if(averageMark <= 59){
        finalGrage = "P(Pass)";
    }else if(averageMark <= 69){
        finalGrage = "C(Credit)";
    }else if(averageMark <= 79){
        finalGrage = "D(Distinguish)";
    }else if(averageMark <= 100){
        finalGrage = "HD(High Distinguish)";
    }
    return finalGrage;
}

// store the remark
public String remark(){
    boolean passExamMark=true;
    boolean passAttendance=true;
    String remark = " ";
    for(int i = 0; i < this.modulesTake; i++){
        getAttendance(i);
        if(getAttendance(i) < 70){
            passAttendance=false;
        }
        getExamMark(i);
        if(getExamMark(i) < 40){
            passExamMark=false;
        }
    }
    
    if(passAttendance&&passExamMark){
        remark="Congratulation! You pass the module!";
    }else if(passAttendance==true&&passExamMark==false){
        remark="You fail the module. Please take the re-exam.";
    }else if(passAttendance==false&&passExamMark==true){
        remark="You fail the module due to low attendance. Please attend the make up classes.";
    }else{
        remark="You fail the module. Please retake the module.";
    }
    return remark;
}

// store the module that students wnat to take
public void chooseModule(){
    Scanner input = new Scanner(System.in);
    ArrayList<String> moduleCodeInformation = new ArrayList<String>();
    ArrayList<String> moduleNameInformation = new ArrayList<String>();
    if(this.programme.equals("Higher Diploma in Information Technology (Computing)")){
        moduleCodeInformation.add("CS401");
        moduleCodeInformation.add("CS402");
        moduleCodeInformation.add("CS403");
        moduleCodeInformation.add("CS404");
        moduleCodeInformation.add("CS405");
        moduleCodeInformation.add("CS406");
        moduleCodeInformation.add("CS407");
        moduleCodeInformation.add("CS408");
        moduleCodeInformation.add("CS409");
        moduleCodeInformation.add("CS410");
    }else if(this.programme.equals("Higher Diploma in Information Technology (Cyber Security and Investigation)")){
        moduleCodeInformation.add("CI401");
        moduleCodeInformation.add("CS402");
        moduleCodeInformation.add("CI404");
        moduleCodeInformation.add("CI405");
        moduleCodeInformation.add("CI406");
        moduleCodeInformation.add("CI407");
        moduleCodeInformation.add("CI408");
        moduleCodeInformation.add("CI409");
        moduleCodeInformation.add("CI410");
    }
    
    if(this.programme.equals("Higher Diploma in Information Technology (Computing)")){
        moduleNameInformation.add("Computaional Theory");
        moduleNameInformation.add("Programming Principles");
        moduleNameInformation.add("Introduction to Networks and Computer Security");
        moduleNameInformation.add("Database Systems");
        moduleNameInformation.add("Data Structures and Algorithms");
        moduleNameInformation.add("Web and Mobile Application Security");
        moduleNameInformation.add("Applied Cryptography");
        moduleNameInformation.add("Artificial Intelligence");
        moduleNameInformation.add("Ethical Hacking Skills (CEF)");
        moduleNameInformation.add("Introduction to Cybersecurity and Cybercrime");
    }else if(this.programme.equals("Higher Diploma in Information Technology (Cyber Security and Investigation)")){
        moduleNameInformation.add("Computing for Cyber Security");
        moduleNameInformation.add("Programming Principles");
        moduleNameInformation.add("Criminal Behaviour and Cyber Security");
        moduleNameInformation.add("Introduction to Criminal Justice System");
        moduleNameInformation.add("Investigation Practices I");
        moduleNameInformation.add("Investigation Practices II");
        moduleNameInformation.add("Introduction to Forensic IT");
        moduleNameInformation.add("Evidence Collection and Cyber Security");
        moduleNameInformation.add("Practices of Cyber Security & Investigation");
    }
    
    for(int i = 0; i < this.modulesTake; i++){
        System.out.println("You can choose from the following modules : ");
        for(int j = 0; j < moduleCodeInformation.size(); j++){
            System.out.println("Enter " + (j+1) + "("+moduleCodeInformation.get(j) + ")" + ":" + moduleNameInformation.get(j));
        }
        
        // check the user is enter duplicate code or not
        System.out.println("Please input a module code : ");
        boolean check;
        do{
            int choice;
            choice = input.nextInt();
            input.nextLine();
            if(choice >= 1 && choice <= moduleCodeInformation.size()){
                String moduleCode = moduleCodeInformation.get(choice-1);
                check = this.moduleCode.contains(moduleCode);
                if(check){
                    System.out.println("You cannot choose the same module again.");
                }else{
                    this.setModuleCode(moduleCode);

                    String moduleName = moduleNameInformation.get(choice-1);
                    this.setModuleName(moduleName);

                    System.out.println(this.getModuleCode(i));
                    System.out.println(this.getModuleName(i));
                    check = false;
                }
            }else{
                System.out.println("Pleas input a valid module code.");
                check = true;
            }
        }while(check == true);
        
        System.out.println("Please input the attendance for this module : ");
        int addAttendance;
        do{
            addAttendance = input.nextInt();
            input.nextLine();
        }while(setAttendance(addAttendance) == false);

        int addExamMark;
        do{
            System.out.println("Please input the exam mark for this module : ");
            addExamMark = input.nextInt();
            input.nextLine();
        }while(setExamMark(addExamMark) == false);
    }
    
}

//Display the menu
public void print(){
    System.out.println("+----------------------------------------------------------------------------------------+");
    System.out.printf("%-89s", "|");
    System.out.printf("|\n");
    System.out.printf("%-89s", "|" + "Student name: " + getStudentName());
    System.out.println("|");
    System.out.printf("%-89s", "|" + "Student ID: " + getStudentID());
    System.out.println("|");
    //System.out.printf("%-89s", "|" + "Your password: " + getPassword());
    //System.out.println("|");
    /*System.out.printf("%-89s", "|" + "Study mode: " + getStudyMode());
    System.out.println("|");*/
    System.out.printf("%-89s", "|" + " ");
    System.out.println("|");
    System.out.printf("%-89s", "|" + "Programme: ");
    System.out.println("|");
    System.out.printf("%-89s", "|" + getProgramme());
    System.out.println("|");
    System.out.printf("%-89s", "|" + "Current Level: Year " + getCurrentLevel());
    System.out.println("|");
    System.out.printf("%-89s", "|" + "Number of modules take by the current term: " + getModulesTake());
    System.out.println("|");
    System.out.printf("%-14s", "|" + "Module Code");
    System.out.printf("%-14s", "Attendance");
    System.out.printf("%-14s", "Exam Mark");
    System.out.printf("%-47s", "Grade");
    System.out.println("|");
    for(int j = 0; j < this.modulesTake; j++){
        System.out.printf("%-18s", "|  " + getModuleCode(j));
        System.out.printf("%-14s", getAttendance(j) + "%");
        System.out.printf("%-12s", getExamMark(j));
        System.out.printf("%-45s", grage(j));
        System.out.println("|");
    }
    System.out.printf("%-89s", "| ");
    System.out.println("|");
    System.out.printf("%-89s", "|" + "Average Mark: " + averageMark());
    System.out.println("|");
    System.out.printf("%-89s", "|" + "Average attendance: " + averageAttendance() + "%");
    System.out.println("|");
    System.out.printf("%-89s", "|" + "Final Grage: " + finalGrage());
    System.out.println("|");
    System.out.printf("%-89s", "|" + "Remake: " + remark());
    System.out.print("|\n");
    System.out.println("+----------------------------------------------------------------------------------------+");
    }
}