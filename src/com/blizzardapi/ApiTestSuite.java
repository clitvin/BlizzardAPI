package com.blizzardapi;

import java.util.Random;

/**
 * Created by Cris on 19/04/2015.
 */
public class ApiTestSuite {


    // This method takes two id's one for the API id one for the file id.
    // It then creates two item objects and compares them
    public static boolean ValidateApiCalltoExpectedResult(String ItemId){
        WowItem api_item = GetItem.getItem(ItemId);
        WowItem expectedresult = GetExpectedItem.getExpectedItem(ItemId);
        System.err.println("Debug: Actual name:"+api_item.getName()+" vs Expected name:"+expectedresult.getName());
        System.err.println("Debug: Actual id:"+api_item.getId()+" vs Expected id:"+expectedresult.getId());
        System.err.println("Debug: Actual ilvl:"+api_item.getItemLevel()+" vs Expected ilvl:"+expectedresult.getItemLevel());
        return api_item.equals(expectedresult);
    }

    //Test Case 5 calls the blizzard API sets a itemset variable, then checks each item to the expected result.
    //For the purpose of this test the validation only compares the item id's and item names
    public static boolean TestCase4(){
        WowItemSet TC5_itemset = GetItemSet.getItemSet("1060");
        System.err.println("Debug: The item set retrived from the Blizzard API has id: "+TC5_itemset.getId()+" and name:"+TC5_itemset.getName());
        System.err.println("Debug: Checking each item in the set vs expected results files ");
        // We check to see if all items match the expected result, if any item differs we return false;
        for (int i=0; i<TC5_itemset.getItemsLenght();i++){
            if (ValidateApiCalltoExpectedResult(Integer.toString(TC5_itemset.getItems(i)))==false) return false;
        }
        return true; //all items have returned true
    }

    //Test case 10 calls the blizzard API and creates an item variable, then iterates through the set that should contain this item
    //to look for it and returns true if it finds it.
    public static boolean TestCase10() {
        WowItem TC10_item = GetItem.getItem("77030");
        WowItemSet TC10_itemset = GetItemSet.getItemSet("1061");
        //first we validate the API returned the item we expected from our expected results file
        if (ValidateApiCalltoExpectedResult("77030")==false) return false;
        System.err.println("Debug: The item set retrived from the Blizzard API has id: "+TC10_itemset.getId());
        System.err.println("Debug: The item set retrived from the Blizzard API has name: "+TC10_itemset.getName());
        //Check to see if we can find our item in the array of items from our 1061 itemset
        for (int i=0; i<TC10_itemset.getItemsLenght();i++) {
            if (TC10_itemset.getItems(i)==TC10_item.getId()) {
                System.err.println("Debug: We found our WowItem: "+TC10_item.getName()+" at array position:"+Integer.toString(i));
                return true;
            }
        }
        return false; //we did not find our item :(
    }

    //Test case 11 we have modified the expected result json to have an item level of 45 instead of 40. We expect this test to fail.
    public static boolean TestCase11() {
        return ValidateApiCalltoExpectedResult("17036");
    }

    public static boolean TestCase12() {
        int itemid = 17039;
        for (int i=1; i<4;i++){
            if (ValidateApiCalltoExpectedResult(Integer.toString(itemid))==false) return false;
            itemid+=3;
        }
        return true;
    }

    public static boolean TestCase13() {
        // We create an int array of all the api id's we have created expected results for and use it to generate a random number
        int n [] = {17039,17042,17045,18803,18809,76749,76750,76751,76752,76753,76753,77030};
        Random random = new Random();
        if (ValidateApiCalltoExpectedResult(Integer.toString(n[random.nextInt(n.length)]))==false) return false;
        return true;
    }
}
