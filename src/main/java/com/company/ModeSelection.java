package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModeSelection {


    public int get_mode() {
        System.out.println("Select the mode number");
        Scanner sc = new Scanner(System.in);
        int mode = sc.nextInt();
        sc.close();
        return mode;
    }

}
