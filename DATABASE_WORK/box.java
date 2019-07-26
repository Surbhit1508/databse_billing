/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DATABASE_WORK;

import java.awt.List;
import java.util.Scanner;

/**
 *
 * @author Mentorus3
 */
public class box
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = 10;
        int spacesNeeded = 0;
        int size = 0;
        System.out.println("How many inputs?");
        size = Integer.parseInt(in.nextLine());
        String[] inputs = new String[size];
        System.out.println("Enter words");
        for (int i = 0; i < size; i++) {
            inputs[i] = in.nextLine();
        }
        System.out.print("+");

        int maxsize = 0;

        for (String s : inputs) {
            if (s.length() > maxsize) {
                maxsize = s.length();
            }
        }

        for (int i = 0; i <= maxsize + 1; i++) {
            System.out.print("-");
        }

        System.out.print("+");
        System.out.println();
        for (int j = 0; j < inputs.length; j++) {
            System.out.print("| " + inputs[j]);

            for (int i = inputs[j].length(); i <= maxsize-1; i++) {
                System.out.print(" ");
            }
            System.out.print(" |");
            System.out.println();

        }
        System.out.print("+");

        for (int i = 0; i <= maxsize + 1; i++) {
            System.out.print("-");
        }

        System.out.print("+");
        System.out.println();
        in.close();
    }
    
}
