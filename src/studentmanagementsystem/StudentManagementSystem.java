/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.util.Scanner;

/**
 *
 * @author chung
 */
public class StudentManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        
        Scanner input=new Scanner(System.in);
        int list = 4;
        // Create student object
        Student[] studentList = new Student[list];
        for (int i = 0; i < list; i++)
        {
            studentList[i] =  new Student();
        }
        
        // Set studentName
        for(int i = 0; i < list; i++){
            String studentName;
            do{
                System.out.println("Please input your  student name for the " + (i+1) + " student : ");
                studentName = input.nextLine();
                
            }while(studentList[i].setStudentName(studentName) == false);
            System.out.println("The " + (i+1) + " student's ID is : " + studentList[i].getStudentName());
        
        // Set studentID
            int studentID = 0;
            do{
                System.out.println("Please enter your student ID for the " + (i+1) + " student, ID must starts with 1001 + any 4 digits : ");
                int ID = input.nextInt();
                input.nextLine();
                
                for(int j = 0; j < studentList.length-1; j++){
                    studentList[j].getStudentID();
                    if(studentList[j].getStudentID() != ID){
                        studentID = ID;
                    }
                }
                if(studentList.length == 1){
                    studentID = ID;
                }
                if(studentID != ID){
                    System.out.println("This ID is already taken, please choose another ID.");
                }
            }while(studentList[i].setStudentID(studentID) == false);
            System.out.println("The " + (i+1) + " student's ID is : " + studentList[i].getStudentID());
        
        // Set password
            String password;
            do{
                System.out.println("Please set the " + (i+1) + " student's password. Password must contain 8 characters, with at least 1 capitalized letter and 1 small letter and 1 numeric value : ");
                password = input.nextLine(); 
            }while(studentList[i].setPassword(password) == false);
            System.out.println("The " + (i+1) + " student's password is: " + studentList[i].getPassword());
        
        // Set studyMode
            /*String studyMode;
            do{
                System.out.println("Please set the " + (i+1) + " student's study mode (1 = Full time, 2 = Part time) : ");
                studyMode = input.nextLine();
            }while(studentList[i].setStudyMode(studyMode) == false);
            System.out.println("The " + (i+1) + "th student's studyMode is: " + studentList[i].getStudyMode());*/
        
        // Set programme
            String programme;
            do{
                System.out.println("Please set the " + (i+1) + " student's study programme : ");
                System.out.println("(1 = Higher Diploma in Information Technology (Computing), 2 = Higher Diploma in Information Technology (Cyber Security and Investigation)");
                programme = input.nextLine(); 
            }while(studentList[i].setProgramme(programme) == false);
        
            System.out.println("The " + (i+1) + "th student's programme is: " + studentList[i].getProgramme());
        
        // Set current level
            int currentLevel;
            do{
                System.out.println("Please set the " + (i+1) + " student's current level (1 - 2) : ");
                currentLevel = input.nextInt(); 
                input.nextLine();
            }while(studentList[i].setCurrentLevel(currentLevel) == false);
            System.out.println("The " + (i+1) + " student's current level is : " + studentList[i].getCurrentLevel());

        // Set modules taken
            int modulesTake;
            do{
                System.out.println("Please set the " + (i+1) + " student's number of module studied (2 - 4) : ");
                modulesTake = input.nextInt(); 
                input.nextLine();
            }while(studentList[i].setModulesTake(modulesTake) == false);
            System.out.println("The " + (i+1) + " student's number of module studied is : " + studentList[i].getModulesTake());
        
        // Choose module code
            studentList[i].chooseModule();
            studentList[i].print();
        }
        
        // Log in
        boolean quit = false;
        do{
            // Input student ID
            boolean ID = false;
            int inputAc = 0;
            do{
                System.out.println("Please input the student ID to log in : ");
                int loginId = input.nextInt();
                input.nextLine();

                for(int i = 0; i < studentList.length; i++){
                    studentList[i].getStudentID();
                    if(studentList[i].getStudentID() == loginId){
                        inputAc = i;
                        ID = true;
                    }
                }
                if(ID == false){
                        System.out.println("Wrong username, please check and the re-enter your username.");
                }
            }while(ID == false);
            
            // Input student password
            boolean password = false;
            String inputPw;
            do{
                System.out.println("Please input the password : ");
                inputPw = input.nextLine();
                if(studentList[inputAc].getPassword().equals(inputPw)){
                    studentList[inputAc].print();
                   password = true;
                }else{
                    System.out.println("Wrong password, please check and re-enter your password.");
                }
            }while(password == false);
            
            // Input student next action
            int action = 0;
            do{
                System.out.println("Please input your next action (1 = Quit the program, 2 = Login other student account) : ");
                action = input.nextInt();
                if(action == 1){
                    quit = true;
                }else{
                    quit = false;
                }
            }while(action != 1 && action != 2);
        }while(quit == false);
    }
    
}