import Farm.Farm;
import Modal.Modal;
import Shop.Shop;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import save.Save;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main extends Application {
    @FXML
    private GridPane gridPane;
    @FXML
    private Label wheatSeed;
    @FXML
    private Label barleySeed;
    @FXML
    private Label rapeseedSeed;
    @FXML
    private Label maizeSeed;
    @FXML
    private Label soySeed;
    @FXML
    private Label wheatHarvest;
    @FXML
    private Label barleyHarvest;
    @FXML
    private Label rapeseedHarvest;
    @FXML
    private Label maizeHarvest;
    @FXML
    private Label soyHarvest;
    @FXML
    private Label cowCount;
    @FXML
    private Label sheepCount;
    @FXML
    private Label goatCount;
    @FXML
    private Label pigCount;
    @FXML
    private Label chickenCount;
    @FXML
    private Label babyCowCount;
    @FXML
    private Label babySheepCount;
    @FXML
    private Label babyGoatCount;
    @FXML
    private Label babyPigCount;
    @FXML
    private Label babyChickenCount;
    @FXML
    private Label milkCount;
    @FXML
    private Label woolCount;
    @FXML
    private Label goatMilkCount;
    @FXML
    private Label sausagesCount;
    @FXML
    private Label eggsCount;
    @FXML
    private Button shopBtn;
    @FXML
    private Label bankAccount;
    @FXML
    private Button saveBtn;
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("./fxml/map.fxml"));
            SplitPane root = fxmlLoader.load();
            Scene scene = new Scene(root, 900, 700);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Farm.Farm My Farm.Farm");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initialize() {
        Farm farm = new Farm(500);
        Save save = new Save();
        wheatSeed.textProperty().bind(farm.getWheatSeedProperty().asString());
        barleySeed.textProperty().bind(farm.getBarleySeedProperty().asString());
        rapeseedSeed.textProperty().bind(farm.getRapeseedSeedProperty().asString());
        maizeSeed.textProperty().bind(farm.getMaizeSeedProperty().asString());
        soySeed.textProperty().bind(farm.getSoySeedProperty().asString());
        wheatHarvest.textProperty().bind(farm.getWheatHarvestProperty().asString());
        barleyHarvest.textProperty().bind(farm.getBarleyHarvestProperty().asString());
        rapeseedHarvest.textProperty().bind(farm.getRapeseedHarvestProperty().asString());
        maizeHarvest.textProperty().bind(farm.getMaizeHarvestProperty().asString());
        soyHarvest.textProperty().bind(farm.getSoyHarvestProperty().asString());
        cowCount.textProperty().bind(farm.getCowProperty().asString());
        sheepCount.textProperty().bind(farm.getSheepProperty().asString());
        goatCount.textProperty().bind(farm.getGoatProperty().asString());
        pigCount.textProperty().bind(farm.getPigProperty().asString());
        chickenCount.textProperty().bind(farm.getChickenProperty().asString());
        babyCowCount.textProperty().bind(farm.getBabyCowProperty().asString());
        babySheepCount.textProperty().bind(farm.getBabySheepProperty().asString());
        babyGoatCount.textProperty().bind(farm.getBabyGoatProperty().asString());
        babyPigCount.textProperty().bind(farm.getBabyPigProperty().asString());
        babyChickenCount.textProperty().bind(farm.getBabyChickenProperty().asString());
        milkCount.textProperty().bind(farm.getMilkProperty().asString());
        woolCount.textProperty().bind(farm.getWoolProperty().asString());
        goatMilkCount.textProperty().bind(farm.getGoatMilkProperty().asString());
        sausagesCount.textProperty().bind(farm.getSausagesProperty().asString());
        eggsCount.textProperty().bind(farm.getEggsProperty().asString());
        bankAccount.textProperty().bind(farm.BankAcountProperty().asString());

        Path pathToSave = Path.of("./save/save.txt");

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 18; j++) {
                Button button = new Button();
                button.setText(i + "-" + j);
                button.setOnAction(e -> {
                   Modal.showModal(button.getText(), farm, (Button) e.getSource());
                });
                gridPane.add(button, i, j);
            }
        }

        shopBtn.setOnAction(e -> {
            Shop.showShop(farm);
        });
        saveBtn.setOnAction(e -> {
            save.SaveGame(farm);
        });

        /*farm.setWheatSeed(200);
        farm.setSoySeed(200);
        farm.setBarleySeed(200);
        farm.setMaizeSeed(200);
        farm.setRapeseedSeed(200);
        farm.setBabyCowCount(10);
        farm.setBabySheepCount(10);
        farm.setBabyGoatCount(10);
        farm.setBabyPigCount(10);
        farm.setBabyChickenCount(10);*/
        if (Files.exists(pathToSave)) {
            save.LoadGame();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}