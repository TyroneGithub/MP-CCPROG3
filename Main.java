package com.company;
import java.util.*;



public class Main{
    public static void main(String[] args){

        ActionCardv1[] actionCards = new ActionCardv1[50];

        //generate 20 cards
        for(int i = 0; i < 20; i++){
            actionCards[i] = new ActionCardv1(true);
        }


        for(int i = 0; i < 20; i++){
            System.out.println(actionCards[i].toString());
        }


    }
}



