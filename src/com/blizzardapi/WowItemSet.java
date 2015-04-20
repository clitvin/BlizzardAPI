/**
 * Created by Cris on 19/04/2015.
 */
package com.blizzardapi;


public class WowItemSet {
    private int id;
    private String name;
    private int[] items;

    public int getId(){ return id;}

    public String getName(){ return name;}

    public int getItems(int x){
        return this.items[x];
    }

    public int getItemsLenght(){
        return this.items.length;
    }
}
