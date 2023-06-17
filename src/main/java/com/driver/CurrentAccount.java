package com.driver;

import java.util.Stack;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {

        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);

        this.tradeLicenseId = tradeLicenseId;
        validateLicenseId();




    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<tradeLicenseId.length();i++){

            while(!sb.isEmpty() && !st.isEmpty() && sb.charAt(sb.length()-1)!=st.peek()){
                sb.append(st.pop());
            }
            if(!sb.isEmpty() && sb.charAt(sb.length()-1)==tradeLicenseId.charAt(i))
                st.push(tradeLicenseId.charAt(i));
            else
                sb.append(tradeLicenseId.charAt(i));
            System.out.println(sb);
        }

        while(!sb.isEmpty() && !st.isEmpty() && sb.charAt(sb.length()-1)!=st.peek()){
            sb.append(st.pop());
        }
        if(!st.isEmpty())
            throw new Exception("Valid License can not be generated");

        tradeLicenseId = sb.toString();



    }

}
