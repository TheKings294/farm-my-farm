package save;

import Farm.Farm;
import Modal.Modal;
import board.Board;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Save {
    public void LoadGame(Farm farm, Board board) {
        try(BufferedReader fileReader = new BufferedReader(new FileReader("./save/save.txt"))) {
            String line;
            ArrayList<Integer> values = new ArrayList<>();
            while ((line = fileReader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    values.add(Integer.parseInt(parts[1].trim()));
                }
            }
            farm.setBankAcount(values.getFirst());
            farm.setWheatSeed(values.get(1));
            farm.setBarleySeed(values.get(2));
            farm.setRapeseedSeed(values.get(3));
            farm.setMaizeSeed(values.get(4));
            farm.setSoySeed(values.get(5));
            farm.setWheatHarvest(values.get(6));
            farm.setBarleyHarvest(values.get(7));
            farm.setRapeseedHarvest(values.get(8));
            farm.setMaizeHarvest(values.get(9));
            farm.setSoyHarvest(values.get(10));
            farm.setCowCount(values.get(11));
            farm.setSheepCount(values.get(12));
            farm.setGoatCount(values.get(13));
            farm.setPigCount(values.get(14));
            farm.setChickenCount(values.get(15));
            farm.setBabyCowCount(values.get(16));
            farm.setBabySheepCount(values.get(17));
            farm.setBabyGoatCount(values.get(18));
            farm.setBabyPigCount(values.get(19));
            farm.setBabyChickenCount(values.get(20));
            farm.setMilkCount(values.get(21));
            farm.setWoolCount(values.get(22));
            farm.setGoatMilkCount(values.get(23));
            farm.setSausagesCount(values.get(24));
            farm.setEggsCount(values.get(25));
            board.setTotalBuy(values.get(26));
            board.setTotalSell(values.get(27));
            board.setTotalMilkProduced(values.get(28));
            board.setTotalWoolProduced(values.get(29));
            board.setTotalGoatMilkProduced(values.get(30));
            board.setTotalSaussagesProduced(values.get(31));
            board.setTotalEggsProduced(values.get(32));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void SaveGame(Farm farm, Board board, GridPane pane) {
        try(FileWriter fileWriter = new FileWriter("./save/save.txt")) {
            fileWriter.write("money:" + farm.getBankAcount() + "\n");
            fileWriter.write("wheatSeed: " + farm.getWheatSeed() + "\n");
            fileWriter.write("barleySeed: " + farm.getBarleySeed() + "\n");
            fileWriter.write("rapeseedSeed:" + farm.getRapeseedSeed() + "\n");
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
            fileWriter.write("totalBuy:" + board.getTotalBuy() + "\n");
            fileWriter.write("totalSell:" + board.getTotalSell() + "\n");
            fileWriter.write("totalMilk:" + board.getTotalMilkProduced() + "\n");
            fileWriter.write("totalWool:" + board.getTotalWoolProduced() + "\n");
            fileWriter.write("totalGoatMilk:" + board.getTotalGoatMilkProduced() + "\n");
            fileWriter.write("totalSausasges:" + board.getTotalSaussagesProduced() + "\n");
            fileWriter.write("totalEggs:" + board.getTotalEggsProduced() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(FileWriter fileWriter = new FileWriter("./save/map.txt")) {
            for (Node node : pane.getChildren()) {
                if (node instanceof Button) {
                    Button btn = (Button) node;
                    int codePoint = btn.getText().codePointAt(0);
                    if (codePoint >= 0x1F600 && codePoint <= 0x1F64F) {
                        fileWriter.write(GridPane.getRowIndex(btn) + ',' + GridPane.getColumnIndex(btn) + ',' + btn.getText());
                    }
                }
            }
        } catch (IOException event) {
            event.printStackTrace();
        }
    }
}
