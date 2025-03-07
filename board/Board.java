package board;

import Farm.Farm;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Board {
    @FXML
    private Label boardBank, totalBuy, totalSell, totalMilk, totalWool, totalGoatMilk, totalSaussages, totalEggs;

    private IntegerProperty totalBuyV = new SimpleIntegerProperty();
    private IntegerProperty totalSellV = new SimpleIntegerProperty();
    private IntegerProperty totalMilkProduced = new SimpleIntegerProperty();
    private IntegerProperty totalWoolProduced = new SimpleIntegerProperty();
    private IntegerProperty totalEggsProduced = new SimpleIntegerProperty();
    private IntegerProperty totalGoatMilkProduced = new SimpleIntegerProperty();
    private IntegerProperty totalSaussagesProduced = new SimpleIntegerProperty();

    public int getTotalBuy() {
        return this.totalBuyV.getValue();
    }
    public int getTotalSell() {
        return this.totalSellV.getValue();
    }
    public int getTotalMilkProduced() {
        return this.totalMilkProduced.getValue();
    }
    public int getTotalWoolProduced() {
        return this.totalWoolProduced.getValue();
    }
    public int getTotalEggsProduced() {
        return this.totalEggsProduced.getValue();
    }
    public int getTotalGoatMilkProduced() {
        return this.totalGoatMilkProduced.getValue();
    }
    public int getTotalSaussagesProduced() {
        return this.totalSaussagesProduced.getValue();
    }

    public void setTotalBuy(int totalBuy) {
        this.totalBuyV.set(totalBuy);
    }
    public void setTotalSell(int totalSell) {
        this.totalSellV.set(totalSell);
    }
    public void setTotalMilkProduced(int totalMilkProduced) {
        this.totalMilkProduced.set(totalMilkProduced);
    }
    public void setTotalWoolProduced(int totalWoolProduced) {
        this.totalWoolProduced.set(totalWoolProduced);
    }
    public void setTotalEggsProduced(int totalEggsProduced) {
        this.totalEggsProduced.set(totalEggsProduced);
    }
    public void setTotalGoatMilkProduced(int totalGoatMilkProduced) {
        this.totalGoatMilkProduced.set(totalGoatMilkProduced);
    }
    public void setTotalSaussagesProduced(int totalSaussagesProduced) {
        this.totalSaussagesProduced.set(totalSaussagesProduced);
    }

    public static void showBoard(Farm farm, Board board2) {
        try {
            FXMLLoader loader = new FXMLLoader(Board.class.getResource("../fxml/board.fxml"));
            Parent root = loader.load();
            Board board = loader.getController();

            board.setup(farm, board2);

            Stage stage = new Stage();
            stage.setTitle("Board");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setup(Farm farm, Board board2) {
        boardBank.setText(Integer.toString(farm.getBankAcount()));
        totalBuy.textProperty().bind(board2.totalBuyV.asString());
        totalSell.textProperty().bind(board2.totalSellV.asString());
        totalMilk.textProperty().bind(board2.totalMilkProduced.asString());
        totalWool.textProperty().bind(board2.totalWoolProduced.asString());
        totalEggs.textProperty().bind(board2.totalEggsProduced.asString());
        totalGoatMilk.textProperty().bind(board2.totalGoatMilkProduced.asString());
        totalSaussages.textProperty().bind(board2.totalSaussagesProduced.asString());
    }
}