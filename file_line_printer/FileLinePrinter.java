/*
 * FileLinePrinter.java
 * This class reads a file and prints its content line by line.
 * Each line is split into several lines if its length exceeds a given maximum length.
 * The maximum length and the file name are given as arguments.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLinePrinter {

    private static String[] splitLine(String line, int maxLength) {
        int totalLenght = line.length();
        // substract 1 to round up (60+12 - 1) / 12 = 5
        // (60+12) / 12 = 6 but 5 lines are enough
        int nbLines = (totalLenght + maxLength - 1) / maxLength; 
        String[] lines = new String[nbLines];

        for(int i = 0; i < nbLines; i++) { 
            lines[i] = line.substring(i*maxLength, Math.min((i*maxLength) + maxLength, totalLenght));
        }
        return lines;
    }

    public static void readFile(String filename, int maxLength) {
        try {
            // Open the file
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int lineNumber = 0;
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                String[] lines = splitLine(line, maxLength);
                for(String l : lines) {
                    // Print the line with its line number
                    System.out.printf("%5d ", ++lineNumber);
                    System.out.println("   " + l);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error while reading file : " + e.getMessage() + "\nUsage : java CutLine <filename> <maxLength>");
        }
    } 


    public static void main(String args[]) {
        try {
            if(args.length != 2) {
                throw new IllegalArgumentException("Two arguments expected.");
            }  
            String filename = args[0];
            int maxLength = Integer.parseInt(args[1]);
            if(maxLength <= 0) {
                throw new NumberFormatException("Max length must be a positive integer.");
            }
            FileLinePrinter.readFile(filename, maxLength);
        
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\nUsage : java CutLine <filename> <maxLength>");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\nUsage : java CutLine <filename> <maxLength>");
        }

    }
}
   

