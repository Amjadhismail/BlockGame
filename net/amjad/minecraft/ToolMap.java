package net.amjad.minecraft;

import java.util.*;

public class ToolMap extends MinecraftGame {
    protected  int sizeX=5;
    protected  int sizeY=5;
    public  int playerPosX=0;
    public  int playerPosY=0;

    protected Tools pickaxe = new Tools("pickaxe",33);
    protected Tools axe = new Tools("axe",33);
    protected Tools shovel = new Tools("shovel",33);
    protected Tools hand = new Tools("hand",0);
    protected Items mud = new Items("mud",0);
    protected Items cobbleStone = new Items("cobblestone",0);
    protected Items wood = new Items("wood",0);

    Blocks dirt = new Blocks("dirt",shovel ,mud,"C:\\Users\\amjad\\IdeaProjects\\Java introduction\\src\\net\\amjad\\minecraft\\sounds\\break\\gravel3.wav","C:\\Users\\amjad\\IdeaProjects\\Java introduction\\src\\net\\amjad\\minecraft\\sounds\\step\\grass1.wav");
    Blocks stone = new Blocks("stone",pickaxe ,cobbleStone,"C:\\Users\\amjad\\IdeaProjects\\Java introduction\\src\\net\\amjad\\minecraft\\sounds\\break\\stone1.wav","C:\\Users\\amjad\\IdeaProjects\\Java introduction\\src\\net\\amjad\\minecraft\\sounds\\step\\stone1.wav");
    Blocks planks = new Blocks("planks",axe ,wood,"C:\\Users\\amjad\\IdeaProjects\\Java introduction\\src\\net\\amjad\\minecraft\\sounds\\break\\wood1.wav","C:\\Users\\amjad\\IdeaProjects\\Java introduction\\src\\net\\amjad\\minecraft\\sounds\\step\\wood1.wav");
    Blocks air = new Blocks("air",hand,null,null,null);
    List<Blocks> listOfBlock = new ArrayList<>(List.of(dirt, stone, planks, air));

    public Blocks[][] worldMap = new Blocks[sizeX][sizeY];
    public int CursorValue;
    public Random random = new Random();


    public void createWorld(){
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                worldMap[i][j]= listOfBlock.get(random.nextInt(listOfBlock.size()));
            }
        }
    }

    public void displayWorld()
    {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (i == playerPosX && j == playerPosY){
                    System.out.print("\t+");
                }
                else {
                    System.out.print("\t"+worldMap[i][j].getBlockName());
                }
            }
            System.out.println();
        }
    }

    public void controlPlayer(String moveInput)
    {
        switch (moveInput){
            case "w":playerPosX--;break;
            case "a":playerPosY--;break;
            case "s":playerPosX++;break;
            case "d":playerPosY++;break;
            case "pickaxe":mineBlock(pickaxe);break;
            case "axe":mineBlock(axe);break;
            case "shovel":mineBlock(shovel);break;
            case "hand":mineBlock(hand);break;
            default:break;
        }
        if (worldMap[playerPosX][playerPosY] != air) {
            worldMap[playerPosX][playerPosY].blockSteppedOn();
        }
        displayAllDurabilities();
        displayInventory();
        displayWorld();

    }

    public void mineBlock(Tools currentTool){
        if (worldMap[playerPosX][playerPosY].getTool()==currentTool && !worldMap[playerPosX][playerPosY].getTool().isBroken()){
            addInventory(worldMap[playerPosX][playerPosY].getDrops());
            worldMap[playerPosX][playerPosY].getDrops().increaseCount();
            currentTool.decreaseDurability(1);
            worldMap[playerPosX][playerPosY].blockBroke();
            worldMap[playerPosX][playerPosY]=air;
        }else{
            currentTool.decreaseDurability(10);
        }
    }

    public void displayAllDurabilities(){
        pickaxe.displayDurability();
        axe.displayDurability();
        shovel.displayDurability();
    }

}
