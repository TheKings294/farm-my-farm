package save;

import Farm.Farm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
    public void LoadGame() {
        try(BufferedReader fileReader = new BufferedReader(new FileReader("./save/save.txt"))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                // Split line by ":" and trim spaces
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    int value = Integer.parseInt(parts[1].trim()); // Convert to int
                    System.out.println(key + " -> " + value); // Print extracted value
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void SaveGame(Farm farm) {
        try(FileWriter fileWriter = new FileWriter("./save/save.txt")) {
            fileWriter.write("money:" + farm.getBankAcount() + "\n");
            fileWriter.write("wheatSeed: " + farm.getWheatSeed() + "\n");
            fileWriter.write("barleySeed: " + farm.getBarleySeed() + "\n");
            fileWriter.write("rapeseedSeed" + farm.getRapeseedSeed() + "\n");
            fileWriter.write("maizeSeed: " + farm.getMaizeSeed() + "\n");
            fileWriter.write("soySeed: " + farm.getSoySeed() + "\n");
            fileWriter.write("wheatHarvest: " + farm.getWheatHarvest() + "\n");
            fileWriter.write("barleyHarvest: " + farm.getBarleyHarvest() + "\n");
            fileWriter.write("rapeseedHarvest:" + farm.getRapeseedHarvest() + "\n");
            fileWriter.write("maizeHarvest:" + farm.getMaizeHarvest() + "\n");
            fileWriter.write("soyHarvest:" + farm.getSoyHarvest() + "\n");
            fileWriter.write("cow:" + farm.getCowCount() + "\n");
            fileWriter.write("sheep:" + farm.getSheepCount() + "\n");
            fileWriter.write("goat:" + farm.getGoatCount() + "\n");
            fileWriter.write("pig:" + farm.getPigCount() + "\n");
            fileWriter.write("chicken:" + farm.getChickenCount() + "\n");
            fileWriter.write("babyCow:" + farm.getBabyCowCount() + "\n");
            fileWriter.write("babySheep:" + farm.getBabySheepCount() + "\n");
            fileWriter.write("babyGoat:" + farm.getBabyGoatCount() + "\n");
            fileWriter.write("babyPig:" + farm.getBabyPigCount() + "\n");
            fileWriter.write("babyChicken:" + farm.getBabyChickenCount() + "\n");
            fileWriter.write("milk:" + farm.getMilkCount() + "\n");
            fileWriter.write("wool:" + farm.getWoolCount() + "\n");
            fileWriter.write("goatMilk:" + farm.getGoatMilkCount() + "\n");
            fileWriter.write("sausages:" + farm.getSausagesCount() + "\n");
            fileWriter.write("eggs:" + farm.getEggsCount() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
