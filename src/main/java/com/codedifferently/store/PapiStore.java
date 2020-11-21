//This is a store class in a user defined package codedifferently.
package com.codedifferently.store;
//These are imports of ArrayList, hashMap, and Map in util sub package inside java package.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//papiStore is a public class which can be accessed by every where within the store package.
public class PapiStore {
    //this is a private primitive type boolean that returns either true or false for the isStoreOpen.
    private boolean isStoreOpen;
    //A new arrays list for the object tabs is created and only accessible by PapiStore class.
    private ArrayList<String> tabs;
    Map<String, Double> owesPapiMoney; // this is a map that takes string  name of a person and a key the money owes.
    // This is a constructor for the PapiStore class.
    public PapiStore(){
        //"this." is used to connect directly to isStoreOpen and set to false
        this.isStoreOpen = false;
        //the reference tabs already created in line 12 is been referenced(called)
        this.tabs = new ArrayList();
        //This is a HasMap this will allow null values and a null key
        this.owesPapiMoney = new HashMap<>();
    }
    // this is another constructor which is Boolean type that returns true or false for the isStoreOpen argument
    public PapiStore(Boolean isOpen, ArrayList<String> tabsIn){
        this.isStoreOpen = isOpen;
        this.tabs = tabsIn;
        this.owesPapiMoney = new HashMap<>();
    }
    //This is public class closeStore that doesn't return anything because it is void.
    public void closeStore(){

    }
    // This is public class openStore that doesn't return anything. but for openStore in order to return true, we create another helper method called public boolean isStorOpen()
    public void openStore(){
        this.isStoreOpen = true;
    }
    //This is a helper method created to to be called by the above public void open store so that the we get a binary return of true or false in this case we want it to return true
    public boolean isStoreOpen() {
        return isStoreOpen;
    }

    //this is a public boolean called allowToUseTab that has an input name.
    public Boolean allowToUseTab(String name){
        //The boolean is initially set to false
        Boolean response = false;
        //if the person name has active tabs and the person doesn't owe any money it suppose to turn false.
        if(hasAnActiveTab(name) && !hasAnOverDueBalance(name))
            //otherwise it is true
            response = true;
        //and it returns the response
        return response;
    }
    //this is a private boolean method called hasAnOerDueBalance that checks an overdue balance
    private boolean hasAnOverDueBalance(String name){
        //if the person whose name in the active tabs does owe money return false
        if(!owesPapiMoney.containsKey(name))
            return false;
        //Double data type is for the decimals in money and this getter method get the amount of money a person whose name on the active tabs
        Double money = owesPapiMoney.get(name);
        //This boolean set to false initially to allow for a condition the person doesn't owe any money
        Boolean owes = false;
        //but if the person owe any money (money >0.0) even if it is a hundredth of a penny it will return true
        if(money > 0.0)
            owes = true;
        //And then it returns owe
        return owes;
    }
    //This is a helper method that tracks and being called by the method alowToUserTab
    private boolean hasAnActiveTab(String name){
        //For each String tab inside tabs
        for (String tab : tabs){
            //if name has active tab this helper method will return true
            if (tab.equals(name))
                return true;
        }
        //otherwise false
        return false;
    }
    //This is a public method that doesn't return anything
    public void createActiveTab(String name){
        this.tabs.add(name);
    }

    // This ia public static void main that allows the JVM to call the main method without any restriction
    public static void main(String[] args) {
       //sout will print the string inside the parenthesis in one line
        System.out.println("Welcome to Papi Store, Hola");
    }


}
