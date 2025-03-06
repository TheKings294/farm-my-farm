package Shop;

import Farm.Farm;
import Modal.Modal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Shop {
    @FXML
    private Button wheatBuy;
    @FXML
    private Button wheatSell;
    @FXML
    private Button barleyBuy;
    @FXML
    private Button barleySell;
    @FXML
    private Button rapeseedBuy;
    @FXML
    private Button rapeseedSell;
    @FXML
    private Button maizeBuy;
    @FXML
    private Button maizeSell;
    @FXML
    private Button soyBuy;
    @FXML
    private Button soySell;
    @FXML
    private Button cowBuy;
    @FXML
    private Button sheepBuy;
    @FXML
    private Button goatBuy;
    @FXML
    private Button pigBuy;
    @FXML
    private Button chickenBuy;
    @FXML
    private Button milkSell;
    @FXML
    private Button woolSell;
    @FXML
    private Button goatMilkSell;
    @FXML
    private Button sausagesSell;
    @FXML
    private Button eggsSell;
    public static void showShop(Farm farm) {
        try {
            FXMLLoader loader = new FXMLLoader(Shop.class.getResource("../fxml/shop.fxml"));
            Parent root = loader.load();
            Shop shop = loader.getController();

            shop.initializeBuyBtnAnimals(farm);
            shop.initializeBuyBtnSeed(farm);
            shop.initializeSellBtnAnimals(farm);
            shop.initializeSellBtnSeed(farm);

            Stage stage = new Stage();
            stage.setTitle("Shop");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initializeBuyBtnSeed(Farm farm) {
        wheatBuy.setOnAction(e -> {
            if ((farm.getBankAcount() - 50) >= 0) {
                farm.setWheatSeed(farm.getWheatSeed() + 10);
                farm.setBankAcount(farm.getBankAcount() - 50);
            }
        });
        barleyBuy.setOnAction(e -> {
            if ((farm.getBankAcount() - 50) >= 0) {
                farm.setBarleySeed(farm.getBarleySeed() + 10);
                farm.setBankAcount(farm.getBankAcount() - 50);
            }
        });
        rapeseedBuy.setOnAction(e -> {
            if ((farm.getBankAcount() - 50) >= 0) {
                farm.setRapeseedSeed(farm.getRapeseedSeed() + 10);
                farm.setBankAcount(farm.getBankAcount() - 50);
            }
        });
        maizeBuy.setOnAction(e -> {
            if ((farm.getBankAcount() - 50) >= 0) {
                farm.setMaizeSeed(farm.getMaizeSeed() + 10);
                farm.setBankAcount(farm.getBankAcount() - 50);
            }
        });
        soyBuy.setOnAction(e -> {
            if ((farm.getBankAcount() - 50) >= 0) {
                farm.setSoySeed(farm.getSoySeed() + 10);
                farm.setBankAcount(farm.getBankAcount() - 50);
            }
        });
    }
    public void initializeBuyBtnAnimals(Farm farm) {
        cowBuy.setOnAction(e -> {
            if ((farm.getBankAcount() - 3000) >= 0) {
                farm.setBabyCowCount(farm.getBabyCowCount() + 1);
                farm.setBankAcount(farm.getBankAcount() - 3000);
            }
        });
        sheepBuy.setOnAction(e -> {
            if ((farm.getBankAcount() - 3500) >= 0) {
                farm.setBabySheepCount(farm.getBabySheepCount() + 1);
                farm.setBankAcount(farm.getBankAcount() - 3500);
            }
        });
        goatBuy.setOnAction(e -> {
            if ((farm.getBankAcount() - 4000) >= 0) {
                farm.setBabyGoatCount(farm.getBabyGoatCount() + 1);
                farm.setBankAcount(farm.getBankAcount() - 4000);
            }
        });
        pigBuy.setOnAction(e -> {
            if ((farm.getBankAcount() - 1000) >= 0) {
                farm.setBabyPigCount(farm.getBabyPigCount() + 1);
                farm.setBankAcount(farm.getBankAcount() - 1000);
            }
        });
        chickenBuy.setOnAction(e -> {
            if ((farm.getBankAcount() - 500) >= 0) {
                farm.setBabyChickenCount(farm.getBabyChickenCount() + 1);
                farm.setBankAcount(farm.getBankAcount() - 500);
            }
        });
    }
    public void initializeSellBtnSeed(Farm farm) {
        wheatSell.setOnAction(e -> {
            if (farm.getWheatHarvest() >= 100) {
                farm.setWheatHarvest(farm.getWheatHarvest() - 100);
                farm.setBankAcount(farm.getBankAcount() + 400);
            } else if (farm.getWheatHarvest() < 100) {
                int price = (farm.getWheatHarvest() * 400) / 100;
                farm.setBankAcount(farm.getBankAcount() + price);
                farm.setWheatHarvest(0);
            }
        });
        barleySell.setOnAction(e -> {
            if (farm.getBarleyHarvest() >= 100) {
                farm.setBarleyHarvest(farm.getBarleyHarvest() - 100);
                farm.setBankAcount(farm.getBankAcount() + 700);
            } else if (farm.getBarleyHarvest() < 100) {
                int price = (farm.getBarleyHarvest() * 700) / 100;
                farm.setBankAcount(farm.getBankAcount() + price);
                farm.setBarleyHarvest(0);
            }
        });
        rapeseedSell.setOnAction(e -> {
            if (farm.getRapeseedHarvest() >= 100) {
                farm.setRapeseedHarvest(farm.getRapeseedHarvest() - 100);
                farm.setBankAcount(farm.getBankAcount() + 700);
            } else if (farm.getRapeseedHarvest() < 100) {
                int price = (farm.getRapeseedHarvest() * 700) / 100;
                farm.setBankAcount(farm.getBankAcount() + price);
                farm.setRapeseedHarvest(0);
            }
        });
        maizeSell.setOnAction(e -> {
            if (farm.getMaizeHarvest() >= 100) {
                farm.setMaizeHarvest(farm.getMaizeHarvest() - 100);
                farm.setBankAcount(farm.getBankAcount() + 900);
            } else if (farm.getMaizeHarvest() < 100) {
                int price = (farm.getMaizeHarvest() * 900) / 100;
                farm.setBankAcount(farm.getBankAcount() + price);
                farm.setMaizeHarvest(0);
            }
        });
        soySell.setOnAction(e -> {
            if (farm.getSoyHarvest() >= 100) {
                farm.setSoyHarvest(farm.getSoyHarvest() - 100);
                farm.setBankAcount(farm.getBankAcount() + 1200);
            } else if (farm.getSoyHarvest() < 100) {
                int price = (farm.getSoyHarvest() * 1200) / 100;
                farm.setBankAcount(farm.getBankAcount() + price);
                farm.setSoyHarvest(0);
            }
        });
    }
    public void initializeSellBtnAnimals(Farm farm) {
        milkSell.setOnAction(e -> {
           int price = farm.getMilkCount() * 2;
           farm.setBankAcount(farm.getBankAcount() + price);
           farm.setMilkCount(0);
        });
        woolSell.setOnAction(e -> {
            int price = farm.getWoolCount() * 3;
            farm.setBankAcount(farm.getBankAcount() + price);
            farm.setWoolCount(0);
        });
        goatMilkSell.setOnAction(e -> {
            int price = farm.getGoatCount() * 5;
            farm.setBankAcount(farm.getBankAcount() + price);
            farm.setGoatCount(0);
        });
        sausagesSell.setOnAction(e -> {
            double price = farm.getSausagesCount() * 1.5;
            farm.setBankAcount(farm.getBankAcount() + (int)price);
            farm.setSausagesCount(0);
        });
        eggsSell.setOnAction(e -> {
            int price = farm.getEggsCount();
            farm.setBankAcount(farm.getBankAcount() + price);
            farm.setEggsCount(0);
        });
    }
}
