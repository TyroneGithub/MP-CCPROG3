package com.company;
import java.lang.Math;

public class ActionCardv1{
    private String description;
    private boolean isBank;
    private boolean toAll;
    private double value;

	/*
	ActionCard(){

	}*/

    //Collect from the Bank
    public ActionCardv1(boolean isBank){
        String[] description;

        description = new String[]{"Tax Refund", "Sell an Item", "Bonus Payday", "Setup School", "Write a Book"};

        this.description = description[(int) (Math.random() * description.length)];

        this.value = 1000 * ((int) (Math.random() * (100-1+1)*1));
    }





    //Pay the Bank
	/*
	ActionCard(boolean isBank, boolean toPay){
		String
	}
	*/

    @Override
    public String toString(){
        return "Description: " + description + "\t $" +value;
    }




}
