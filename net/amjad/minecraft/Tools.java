package net.amjad.minecraft;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Tools {

    private String toolName;
    private boolean isBroken=false;
    private int durability;

public Tools(String toolName,int durability){
    this.toolName=toolName;

    this.durability=durability;
}
public void decreaseDurability(int amount){
        if (durability>amount){
        durability-= amount;


        }else {
            if (!toolName.equalsIgnoreCase("hand")){
                durability=0;
                toolBroke();
                isBroken=true;
                System.out.println(toolName+" broke !");
            }

        }
    }

    public int getDurability() {
        return durability;
    }
    public String getToolName() {
        return toolName;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public void displayDurability(){
        System.out.println(toolName+": "+durability);
    }
    public void toolBroke(){
        File audioFile =new File("C:\\Users\\amjad\\IdeaProjects\\Java introduction\\src\\net\\amjad\\minecraft\\sounds\\break\\break.wav");
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(audioFile.getAbsolutePath()));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
