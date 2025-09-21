import java.util.Scanner;
public class Patterns {
    static int i = 0;
    static int j = 0;
    static int k = 0;
    static int n;

    public static void patt1(){
        //Pattern 1
        //*****
        //*****
        //*****
        //*****
        //*****


        for(i = 0; i < n; i++){
            for(j = 0; j < n; j++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    public static void patt2(){
        //Pattern 2
        //*
        //**
        //***
        //****
        //*****

        for(i = 0; i < n; i++){
            for (j = 0; j <= i; j++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    public static void patt3(){
        //Pattern 3
        //1
        //12
        //123
        //1234
        //12345

        for(i = 1; i <= n; i++){
            for (j = 1; j <= i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void patt4(){
        //Pattern 4
        //1
        //22
        //333
        //4444
        //55555

        for(i = 1; i <= n; i++){
            for (j = 1; j <= i; j++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void patt5(){
        //Pattern 5
        //*****
        //****
        //***
        //**
        //*
        for(i = n; i >= 1; i--){
            for (j = 1; j <= i; j++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }

    }

    public static void patt6(){
        //Pattern 6
        //12345
        //1234
        //123
        //12
        //1
        for(i = n; i >= 1; i--){
            for (j = 1; j <= i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void patt7(){
        //Pattern 7
        //    *
        //   ***
        //  *****
        // *******
        //*********
        for(i = 1; i <= n; i++){
            for(j = n-i; j >= 0; j--){
                System.out.print(" ");
            }
            for(j = 1; j <= 2*i-1; j++){
                System.out.print("*");
            }
            for(j = n-i; j >= 0; j--){
                System.out.print(" ");
            }
            System.out.println();
        } 
    }

    public static void patt8(){
        //Pattern 8
        //*********
        // *******
        //  *****
        //   ***
        //    *

        for(i = 1; i <= n; i++){
            for(j = 0; j <= i-1; j++){
                System.out.print(" ");
            }
            for(j = (2*n)-(2*i+1)+2; j >= 1; j--){
                System.out.print("*");
            }
            for(j = 0; j <= i-1; j++){
                System.out.print(" ");
            }
            System.out.println();
        } 
    }

    public static void patt9() {
        patt7();
        patt8();
    } 

    public static void patt10(){
        //Pattern 10
        //*
        //**
        //***
        //****
        //*****
        //****
        //***
        //**
        //*

        for(i = 1; i <= 2*n-1; i++){
            int stars = i;
            if(i > n){
                stars = 2*n - i;
            }
            for(j = 1; j <= stars; j++){
                System.out.print("*" + " ");
            }
        System.out.println();
        }
    }

    public static void patt11(){
        //1
        //0 1
        //1 0 1
        //0 1 0 1
        //1 0 1 0 1
        int binary;
        for(i = 1; i <= n; i++){
            if(i%2 == 0){
                binary = 0;
            }
            else{
                binary = 1;
            }
            for(j = 1; j <= i; j++){
                System.out.print(binary+ " ");
                binary = 1 - binary;
            }
            System.out.println(); 
            }
    }

    public static void patt12(){
        //1      1
        //12    21
        //123  321
        //12344321
        for(i = 1; i <= n; i++){
            for(j = 1; j <= i; j++){
                System.out.print(j);
            }
            for(j = 2*n-2*i; j > 0; j--){
                System.out.print(" ");
            }
            for(j = i; j >= 1; j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void patt13(){
        //1
        //2 3
        //4 5 6
        //7 8 9 10
        //11 12 13 14 15
        k = 1;
        for(i = 1; i <= n; i++){
            for(j = 1; j <= i; j++){
                System.out.print(k+" ");
                k++;
            }
            System.out.println();
        }
    }

    public static void patt14(){
        //A
        //AB
        //ABC
        //ABCD
        //ABCDE
        for(i = 1; i <= n; i++){
            k = 65;
            for(j = 1; j <= i; j++){
                System.out.print((char)k+" ");
                k++;
            }
            System.out.println();
        }
    }

    public static void patt15(){
        //ABCDE
        //ABCD
        //ABC
        //AB
        //A
        for(i = 0; i < n; i++){
            k = 65;
            for(j = n-i; j >= 1; j--){
                System.out.print((char)k+" ");
                k++;
            }
            System.out.println();
        }
    }

    public static void patt16(){
        //A
        //BB
        //CCC
        //DDDD
        //EEEEE
        k = 65;
        for(i = 1; i <= n; i++){
            for(j = 1; j <= i; j++){
                System.out.print((char)k+" ");
            }
            k++;
            System.out.println();
        }
    }

    public static void patt17(){
        //    A
        //   ABA
        //  ABCBA
        // ABCDCBA
        int breakpoint;
        for(i = 1; i <= n; i++){
            for(j = n-i; j >= 0; j--){
                System.out.print(" ");
            }
            k = 65;
            breakpoint = ((2*i-1)/2)+1;
            for(j = 1; j <= 2*i-1; j++){
                System.out.print((char)k); 
                if(j >= breakpoint){
                    k--;
                }
                else{
                    k++;
                }             
            }
            for(j = n-i; j >= 0; j--){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void patt18(){
        //E
        //DE
        //CDE
        //BCDE
        //ABCDE
        k = 64+n;
         for(i = 0; i < n; i++){
            for(j = k-i; j <= k; j++){
                System.out.print((char)j+" ");
                
            }
            System.out.println();
        }
    }

    public static void patt19(){
        //**********
        //****  ****
        //***    ***
        //**      **
        //*        *
        //*        *
        //**      **
        //***    ***
        //****  ****
        //**********
        for(i = 0; i < n; i++){
            for(j = n-i; j >= 1; j--){
                System.out.print("*");
            }
            for(j = 0; j < 2*i; j++){
                System.out.print(" ");
            }
            for(j = n-i; j >= 1; j--){
                System.out.print("*");
            }
            System.out.println();
        }
        for(i = 1; i <= n; i++){
            for(j = 1; j <= i; j++){
                System.out.print("*");
            }
            for(j = 2*n-2*i; j > 0; j--){
                System.out.print(" ");
            }
            for(j = i; j >= 1; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patt20(){
        //*        *
        //**      **
        //***    ***
        //****  ****  
        //**********
        //****  ****
        //***    ***
        //**      **
        //*        *
        for(i = 0; i < n*2; i++){
            for(j = 0; j <= i; j++){
                System.out.print("*");
            }
            for(j = 2*n-(2*i+2); j >=0; j--){
                System.out.print(" ");
            }
            for(j = 0; j <= i; j++){
                System.out.print("*");
            }
            if(i > n){
                for(j = n-2; j >= 1; j--){
                    System.out.print("*");
            }
                for(j = 2*n-(2*i+2); j >=0; j--){
                    System.out.print(" ");
            }
                for(j = 0; j <= i; j++){
                    System.out.print("*");
            }
            }
        }
    }
    public static void main(String args[]){
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the value of n: ");
      n = in.nextInt();
      patt20();
    }
    
}
