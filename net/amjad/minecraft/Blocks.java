package net.amjad.minecraft;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Blocks {

    //public Map<String ,String> blockToToolMap = Map.of(
//        "air","skip",
//        "dirt","shovel",
//        "stone","pickaxe",
//        "wood","axe"
//);
    private String blockName;
    private final Tools tool;
    private final Items drops;
    private final String audioPathBreak;
    private final String audioPathStep;

    public Blocks(String blockName, Tools tool, Items drops,String audioPathBreak,String audioPathStep) {
        this.blockName = blockName;
        this.tool = tool;
        this.drops = drops;
        this.audioPathBreak=audioPathBreak;
        this.audioPathStep=audioPathStep;
    }

    public Tools getTool() {
        return tool;
    }

    public Items getDrops() {
        return drops;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public void blockBroke(){
        File audioFile =new File(audioPathBreak);
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void blockSteppedOn(){
        File audioFile =new File(audioPathStep);
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




