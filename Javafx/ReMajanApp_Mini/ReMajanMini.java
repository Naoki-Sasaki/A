import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.*;
import javafx.beans.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReMajanMini extends Application{
    ReHandMini hand = new ReHandMini();
    ReCheckMini check = new ReCheckMini();
    Button[][] btnHai = new Button[4][9];
    Button[] btnReturnEnter = new Button[2];
    Button[] btnPonTii = new Button[2];
    Label[][] lblMents = new Label[5][3];
    Label lblInstructionToUser = new Label();
    BorderPane paneRoot = new BorderPane();
    GridPane paneDispHai = new GridPane();
    GridPane paneDispMents = new GridPane();
    VBox paneDistPonTii = new VBox(10d);
    HBox paneDispReturnEnter = new HBox(10d);
    FlowPane paneInstructionToUser = new FlowPane();
  
    Label lblAgari = new Label();
    Label lblMati = new Label();
    Label lblYakuhai = new Label();
    Button btnAfterEnter = new Button();
    GridPane paneAfterGrid = new GridPane();
    HBox paneYakuhaiBox = new HBox(30d);
    HBox paneMatiBox = new HBox(30d);
    HBox paneAgariBox = new HBox(30d);
    VBox paneAfterRightVbox = new VBox();
    HBox paneAfterEnter = new HBox(30d);
    ComboBox<String> paneSelectAgari = new ComboBox<String>();
    ComboBox<String> paneSelectMati = new ComboBox<String>();
    ComboBox<String> paneSelectYakuhai = new ComboBox<String>();
    String agariStr;
    String matiStr;
    String yakuhaiStr;




    public static void main(String... args){
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception{
        //haiに配置(中央)
        for(int i = 0; i < btnHai.length; i++){
            if(i == 3){
                for(int j = 0; j < 7; j++){
                    btnHai[i][j] = new Button(hand.HAI[i][j]);
                    btnHai[i][j].setPrefWidth(50);
                    btnHai[i][j].setId(String.valueOf(i) + "," + String.valueOf(j));  //押された牌を検索するID
                    btnHai[i][j].setOnAction(new PushBtnHai());
               }
            } else{
                for(int j = 0; j < 9; j++){
                    btnHai[i][j] = new Button(hand.HAI[i][j]);
                    btnHai[i][j].setPrefWidth(50);
                    btnHai[i][j].setId(String.valueOf(i) + "," + String.valueOf(j));
                    btnHai[i][j].setOnAction(new PushBtnHai());
               }
            } 
        }
        paneDispHai.setHgap(10);
        paneDispHai.setVgap(10);
        paneDispHai.setPadding(new Insets(20, 20, 20, 20));
        for(int i = 0; i < btnHai.length; i++){
            if(i == 3){
                for(int j = 0; j < 7; j++){
                    paneDispHai.add(btnHai[i][j],j,i);
                }
            } else{
                for(int j = 0; j < 9; j++){
                    paneDispHai.add(btnHai[i][j],j,i);
                }
            }
        }

        //mentsに配置(左)
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 3; j++){     
                String tmpMents = hand.getMents(i,j);
                lblMents[i][j] = new Label(tmpMents);
                lblMents[i][j].setPrefWidth(20);
            }
        }
        paneDispMents.setHgap(10);
        paneDispMents.setVgap(10);
        paneDispMents.setPadding(new Insets(20, 20, 20, 20));
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 3; j++){
                paneDispMents.add(lblMents[i][j],j,i);
            }
        }

        //pontiiに配置(右)
        for(int i = 0; i < btnPonTii.length; i++){
            btnPonTii[i] = new Button(hand.PONTII[i]);
        }
        paneDistPonTii.setPadding(new Insets(20, 20, 20, 20));
        for (int i = 0; i< btnPonTii.length; i++) {
            paneDistPonTii.getChildren().addAll(btnPonTii[i]);
        }

        //enterreturnに入り(した)
        for(int i = 0; i < btnReturnEnter.length; i++){
            btnReturnEnter[i] = new Button(hand.RETURNENTER[i]);
        }
        btnReturnEnter[0].setOnAction(new PushBtnReturn());
        btnReturnEnter[1].setOnAction(new PushBtnEnter());
        paneDispReturnEnter.setPadding(new Insets(20, 20, 20, 20));
        for (int i = 0; i<btnReturnEnter.length; i++) {
            paneDispReturnEnter.getChildren().addAll(btnReturnEnter[i]);
        }

        //(上)
        lblInstructionToUser.setText("選択してください");
        paneInstructionToUser.getChildren().add(lblInstructionToUser);
        paneInstructionToUser.setPadding(new Insets(20, 20, 20, 20));

        //rootpaneに配置
        paneDispHai.setAlignment(Pos.CENTER);
        paneDispMents.setAlignment(Pos.CENTER_LEFT);
        paneDistPonTii.setAlignment(Pos.CENTER_RIGHT);
        paneDispReturnEnter.setAlignment(Pos.BOTTOM_CENTER);
        paneInstructionToUser.setAlignment(Pos.CENTER);
        paneRoot.setCenter(paneDispHai);
        paneRoot.setLeft(paneDispMents);
        paneRoot.setRight(paneDistPonTii);
        paneRoot.setBottom(paneDispReturnEnter);
        paneRoot.setTop(paneInstructionToUser);

        //stageの設定
        stage.setScene(new Scene(paneRoot));
        stage.setTitle("符計算");
        stage.setWidth(800);
        stage.setHeight(400);
        stage.show();
    }

    class PushBtnHai implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            Button b = (Button)e.getSource();
            String Id = b.getId();
            String[] Stid = Id.split(",", 0);
            int x = Integer.parseInt(Stid[0]);
            int y = Integer.parseInt(Stid[1]);

            if(check.canAddMents(hand.getMentsArgs()) == true && check.isHaiCounter4(x, y)){
                String[] mentsIJ = hand.serchLastAddMents("?AtFirst").split(",",0);
                int mentsI = Integer.parseInt(mentsIJ[0]);
                int mentsJ = Integer.parseInt(mentsIJ[1]);
                hand.setMents(hand.serchLastAddMents("?AtFirst"), x, y);
                lblMents[mentsI][mentsJ].setText(hand.HAI[x][y]);
                check.setHaiCounter(x, y);
                lblInstructionToUser.setText("選択してください");
            } else {
                if(!(lblInstructionToUser.equals("追加できません"))){
                    lblInstructionToUser.setText("追加できません");
                }
            }
        }
    }

    class PushBtnReturn implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            if(check.canRemoveMents(hand.getMentsArgs()) == true ){
                String[] mentsIJ = hand.serchLastAddMents("lstAddMents").split(",",0);
                int mentsI = Integer.parseInt(mentsIJ[0]);
                int mentsJ = Integer.parseInt(mentsIJ[1]);
                String s = hand.getMentsToIndex(hand.getMents(mentsI,mentsJ));
                String[] index = s.split(",",0);
                check.removeHiCounter(Integer.parseInt(index[0]),Integer.parseInt(index[1]));
                hand.removeMen(hand.serchLastAddMents("lstAddMents"));
                lblMents[mentsI][mentsJ].setText("?");
                lblInstructionToUser.setText("選択してください");
            } else {
                lblInstructionToUser.setText("削除できません");
            }
        }
    }

    class PushBtnEnter implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            if(check.isFullMents(hand.getMentsArgs()) == false){
                lblInstructionToUser.setText("手牌を全て入力して下さい");
            } else {
                paneSelectAgari.getItems().addAll("ロン","ツモ");
                paneSelectAgari.setPrefWidth(160);
                paneSelectAgari.setOnAction(new SelectComb());
                paneSelectMati.getItems().addAll("辺張・嵌張・単騎","それ以外");
                paneSelectMati.setPrefWidth(160);
                paneSelectMati.setOnAction(new SelectComb());
                paneSelectYakuhai.getItems().addAll("自風","他風");
                paneSelectYakuhai.setPrefWidth(160);
                paneSelectYakuhai.setOnAction(new SelectComb());
                paneMatiBox.setAlignment(Pos.CENTER_RIGHT);
                paneAgariBox.setAlignment(Pos.CENTER_RIGHT);
                paneYakuhaiBox.setAlignment(Pos.CENTER_RIGHT);
                paneAfterEnter.setAlignment(Pos.CENTER);

                btnAfterEnter = new Button("計算に進む");
                paneAfterEnter.setPadding(new Insets(20, 20, 20, 20));
                paneAfterEnter.getChildren().add(btnAfterEnter);

                GridPane paneAfterGrid = new GridPane();
                lblAgari.setText("上がり");
                lblMati.setText("待ち");
                lblYakuhai.setText("役牌");
                paneAfterGrid.setHgap(50);
                paneAfterGrid.setVgap(50);
                paneAfterGrid.setPadding(new Insets(20, 20, 20, 20));
                paneAfterGrid.add(lblAgari,0,0);
                paneAfterGrid.add(paneSelectAgari,1,0);
                paneAfterGrid.add(lblMati,0,1);
                paneAfterGrid.add(paneSelectMati,1,1);
                paneAfterGrid.add(lblYakuhai,0,2);
                paneAfterGrid.add(paneSelectYakuhai,1,2);

                paneRoot.setCenter(paneAfterGrid);
                paneRoot.setRight(paneAfterRightVbox);
                paneRoot.setBottom(paneAfterEnter);
                
            }
        }
    }

    class SelectComb implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e){

            ComboBox tmp = (ComboBox) e.getSource();
            if(tmp == paneSelectAgari){
                agariStr = tmp.getValue().toString();
            } else if(tmp == paneSelectMati){
                matiStr = tmp.getValue().toString();
            } else {
                yakuhaiStr = tmp.getValue().toString();
            }

            if(agariStr != null && matiStr != null && yakuhaiStr != null){
                lblInstructionToUser.setText("入力完了");
                
            } 

        }
    }
}