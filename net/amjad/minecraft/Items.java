package net.amjad.minecraft;

public class Items {
    public String itemName;
    public int itemCount;
    public Items(String itemName,int itemCount){
        this.itemName=itemName;
        this.itemCount=itemCount;
    }
    public void increaseCount()
    {
        itemCount++;
    }
}
