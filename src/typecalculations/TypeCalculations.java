/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typecalculations;

import java.util.*;
import java.io.*;


/**
 *
 * @author User
 */
public class TypeCalculations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Initializing variables and arraylists
        String fileName = "numbers.txt";
        String line = null;
        int lineNumber = 0;
        List<Integer> repeat = new ArrayList<>();
        List<Integer> number = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        List<Integer> prime = new ArrayList<>();
        boolean isPrime;
        //start of try/catch
        try {
            //reading file
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //start of loop
            while ((line = bufferedReader.readLine()) != null) {
                //parsing integer
                int num = Integer.parseInt(line);
                number.add(num);
                //checking if number is greater than 7
                if (num > 7) {
                    greater.add(num);
                }
                //checking if number is prime
                isPrime = true;
                for (int divisor = 2; divisor < num / 2; divisor++) {
                        if(num % divisor == 0){
                                isPrime = false;
                        }
                        if (isPrime == true) {
                                prime.add(num);
                        }
                    }
            }

            bufferedReader.close();
            //checking if number is repeated
            Set<Integer> s = new HashSet<>();
            for (int num : number) {
                if (s.add(num) == false){
                    repeat.add(num);
                }                    
            }
            //outputting values
            System.out.print("Numbers: ");
            System.out.println(number);
            System.out.print("Repeated numbers:");
            System.out.println(repeat);
            System.out.print("Greater than 7: ");
            System.out.println(greater);
            System.out.print("Prime numbers: ");
            System.out.println(prime);
        }
        //end of try/catch
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}