/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg1;
import java.util.*;
import java.io.*;

/**
 * Samuel Adetunji
 * CS 2365 - Object Orientated Programming
 * Date - February 8, 2020
 * Purpose - To read an HTML file and print only its text, formatted as needed,
 * to a text file.
 */
public class Project1 {

     /**
     * @param args the command line arguments
     * Prints out the header for this current project
     */
    public static void printHeader(){
        System.out.println("CS  2365");
        System.out.println("Spring 2020");
        System.out.println("Section 002");
    }
    
//TODO - Understand how to read weird paragraph tags
     /**
     * @param line
     * @param args the command line arguments
     * Takes a string and file pointer
     * Checks if the line needs to be changed at all and prints to the output
     * file
     * @return 
     */
    public static String process(String line){
        String done = "";
        if(line.contains("<head>") || line.contains("<title>") || line.contains("<img"))
            return "";
        
        
        //We see a new row element
        if(line.contains("<td")){
            done = line.substring(line.indexOf(">")+1,line.indexOf("</"));
            return done.concat(" ");
        }
        //We see a new row
        if(line.contains("<tr")){
            done = line.substring(line.indexOf(">")+1);
            return done.concat("\n");
        }
        if(line.contains("<th")){
            done = line.substring(line.indexOf(">")+1);
            return done.concat(",");
        }
        
        //We see a new header or paragraph
        if(line.contains("<h") || line.contains("<p") ||line.contains("<a")){
        //from after > to the lastIndexOf </
            if (line.indexOf("</") == -1){
                done = line.substring(line.indexOf(">")+1);
            }else{
                done = line.substring(line.indexOf(">")+1, line.indexOf("</"));
            }
        }
        
        if(line.contains("<br")){
            line = done;
            done = done.substring(0, done.indexOf("<br />"));
            //Kind of hard coded it...
            for(int c = 0;c<6;c++){
                done = done + line.substring(line.indexOf(">")+1,
                        line.indexOf("<br /", line.indexOf(">")+1)) + "\n";
                //adjust the line
                line = line.substring(line.indexOf(">")+1);
            }
            done = done + line.substring(line.indexOf("/>") +2);
            return done;
        }
        
        return "";
    }
    
    /**
     * @param args the command line arguments
     * @throws Exception
     * performs the reading and writing to the output file
     * 
     */
    public static void main(String[] args) throws IOException {
        printHeader();
        //Open both the input and output files
        File source = new File("F:\\School Stuff\\oopProjects\\Project 1\\src\\project\\pkg1\\Matador Song.html");
        File out = new File("Conversion.txt");        
        
        String line;
        Scanner reader = new Scanner(source);
        //The plan is to read in lines, process them if I need to, and print
        //them to the output file
        PrintStream output = new PrintStream (out);
        while(reader.hasNextLine()){
            line = reader.nextLine();
            //I can either do the processing here and make the main method
            //sort of robust or I can do it in another method. I chose option 2
            
            //This line is so I don't have to use a linked list or queue to 
            //store all the lines. I just shoot the processed code 
            
            output.print(process(line));
        }
        
        //Now we close the stream and call it a day
        output.close();
    }
    
}
