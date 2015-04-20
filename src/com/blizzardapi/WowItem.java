/**
 * Created by Cris on 19/04/2015.
 * WowItem class to hold variables we get from the API json
 * Only implemented get/set methods for id, name and itemlevel because that was the only variables I ended up using
 * In a normal situation I would expect to use the same objects the developers use, however since I do not have access
 * to the blizzard code repo I have created my own object to store the variables from the json the api provides.
 */
package com.blizzardapi;


public class WowItem {

    private int id;
    private int disenchantingSkillRank;
    private String description;
    private String name;
    private String icon;
    private int stackable;
    private int itemBind;
    private int buyPrice;
    private int itemClass;
    private int itemSubClass;
    private int containerSlots;
    private int inventoryType;
    private boolean equippable;
    private int itemLevel;
    private int maxCount;
    private int maxDurability;
    private int minFactionId;
    private int minReputation;
    private int quality;
    private int sellPrice;
    private int requiredSkill;
    private int requiredLevel;
    private int requiredSkillRank;
    private int baseArmor;
    private boolean hasSockets;
    private boolean isAuctionable;
    private int armor;
    private int displayInfoId;
    private String nameDescription;
    private String nameDescriptionColor;
    private boolean upgradable;
    private boolean heroicTooltip;
    private String context;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getName() { return name;}

    public int getItemLevel() { return itemLevel;}

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof WowItem)) {
            return false;
        }
        WowItem that = (WowItem) other;
        // We can compare id's, name's and itemlevel plus any other variables we deem necessary here
        // For this test we will keep it simple and compare id's, names and itemlevel only
        return (this.id==that.id)
                && this.name.equals(that.name) && (this.itemLevel==that.itemLevel);
    }
}
