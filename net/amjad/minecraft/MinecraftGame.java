package net.amjad.minecraft;

import java.util.*;

public class MinecraftGame {

private Scanner scanner = new Scanner(System.in);

    public Set<Items> getInventory() {
        return inventory;
    }

    public void addInventory(Items droppedItem) {
        inventory.add(droppedItem);
    }

    private Set<Items> inventory=new HashSet<>();

public void startGame(){
        ToolMap myMap = new ToolMap();
        myMap.createWorld();
        myMap.displayAllDurabilities();
        myMap.displayInventory();
        myMap.displayWorld();
        while (true){
            myMap.controlPlayer(scanner.next());
        }
    }
    public void displayInventory(){
        System.out.print("Inventory: ");
        for (Items items : inventory) {
            System.out.print(items.itemName+" (x"+items.itemCount+") ");
        }
        System.out.println();
    }
}

