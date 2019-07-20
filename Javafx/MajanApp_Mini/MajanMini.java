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

public class MajanMini extends Application{
    HandMini hand = new HandMini();
    private Button[][] bt = new Button[4][9];
    private Button[] bt2 = new Button[4];
    private Button[] bt3 = new Button[2];
    private Label[][] mentlabel = new Label[5][3];
    private Label uplabel = new Label();
    BorderPane root = new BorderPane();

    VBox afterBox = new VBox();
    HBox yakuhaiBox = new HBox(30d);
    HBox matiBox = new HBox(30d);
    HBox agariBox = new HBox(30d);
    VBox afterRightVbox = new VBox();
    ComboBox<String> selectAgari = new ComboBox<String>();
    ComboBox<String> selectMati = new ComboBox<String>();
    ComboBox<String> selectYakuhai = new ComboBox<String>();
    String str1,str2,str3;

    

    //public static Scene scene2 = null;


    public static void main(String... args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception{
        HandMini hand = new HandMini();
        
        stage.setWidth(800);
        stage.setHeight(400);

        //牌のボタンの作成・テキストをセット(中央)
        for(int i = 0; i < bt.length; i++){
            if(i == 3){
                for(int j = 0; j < 7; j++){
                    bt[i][j] = new Button(hand.getSyurui(i,j));
                    bt[i][j].setPrefWidth(50);
                    bt[i][j].setId(String.valueOf(i) + "," + String.valueOf(j));  //押された牌を検索するID
                    bt[i][j].setOnAction(new push_hai());
               }
            } else{
                for(int j = 0; j < 9; j++){
                    bt[i][j] = new Button(hand.getSyurui(i,j));
                    bt[i][j].setPrefWidth(50);
                    bt[i][j].setId(String.valueOf(i) + "," + String.valueOf(j));
                    bt[i][j].setOnAction(new push_hai());
               }
            } 
        }

        GridPane hai = new GridPane();
        hai.setHgap(10);
        hai.setVgap(10);
        hai.setPadding(new Insets(20, 20, 20, 20));
        for(int i = 0; i < bt.length; i++){
            if(i == 3){
                for(int j = 0; j < 7; j++){
                    hai.add(bt[i][j],j,i);
                }
            } else{
                for(int j = 0; j < 9; j++){
                    hai.add(bt[i][j],j,i);
                }
            }
        }
        
        //オプションボタンを作成・テキストをセット(右側)
        for(int i = 0; i < bt2.length; i++){
            bt2[i] = new Button(hand.getOp(i));
        }
        VBox option = new VBox(10d);
        option.setPadding(new Insets(20, 20, 20, 20));
        for (int i = 0; i<bt2.length; i++) {
            option.getChildren().addAll(bt2[i]);
        }

        //決定・戻るボタンの作成(下側)
        for(int i = 0; i < bt3.length; i++){
            bt3[i] = new Button(hand.getEnt(i));
        }
        bt3[0].setOnAction(new push_return());
        bt3[1].setOnAction(new push_enter());
        HBox enter_retrun = new HBox(30d);
        enter_retrun.setPadding(new Insets(20, 20, 20, 20));
        for (int i = 0; i<bt3.length; i++) {
            enter_retrun.getChildren().addAll(bt3[i]);
        }

        //メンツの表示(左) 
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 3; j++){     
                String a = hand.getMen(i,j);
                mentlabel[i][j] = new Label(a);
                mentlabel[i][j].setPrefWidth(20);
            }
        }
        GridPane mentGp = new GridPane();
        mentGp.setHgap(10);
        mentGp.setVgap(10);
        mentGp.setPadding(new Insets(20, 20, 20, 20));
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 3; j++){
                mentGp.add(mentlabel[i][j],j,i);
            }
        }

        //上に表示するラベル
        uplabel.setText("選択してください");
        FlowPane attent = new FlowPane(uplabel);
        attent.setPadding(new Insets(20, 20, 20, 20));

        //rootPaneの作成
        //BorderPane root = new BorderPane();
        root.setCenter(hai);
        root.setRight(option);
        root.setBottom(enter_retrun);
        root.setLeft(mentGp);
        root.setTop(attent);
        hai.setAlignment(Pos.CENTER);
        option.setAlignment(Pos.CENTER_RIGHT);
        enter_retrun.setAlignment(Pos.BOTTOM_CENTER);
        mentGp.setAlignment(Pos.CENTER_LEFT);
        attent.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(root));
        stage.setTitle("符計算");
        stage.show();
    }

    //牌が押された時の処理    
    class push_hai implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            Button b = (Button)e.getSource();
            String Id = b.getId();
            String[] Stid = Id.split(",", 0);
            int x = Integer.parseInt(Stid[0]);
            int y = Integer.parseInt(Stid[1]);

            boolean flag = false;
            for(int i = 0; i < 5; i++){
                if(flag == true){
                    break;
                }
                for(int j = 0; j < 3; j++){
                    if(flag == true){
                        break;
                    }
                    if(hand.getMen(i,j) == null){
                        flag = true;
                        break;
                    } else if(hand.getMen(i,j).equals("?")){
                        String w = hand.getSyurui(x,y);
                        if(hand.getMenCounter(w).equals("OK")){
                            hand.setMen(hand.getSyurui(x,y),i,j);
                            mentlabel[i][j].setText(hand.getMen(i,j));
                            if(uplabel.getText().equals("選択できません") || uplabel.getText().equals("選択されていません") || uplabel.getText().equals("手牌が選択されていません")){
                                uplabel.setText("選択してください");
                            }
                        flag = true;
                        } else {
                            uplabel.setText("選択できません");
                           flag = true;
                        }
                    }
                }
            }
        }
    }

    //戻るボタンのイベント
    class push_return implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            if(uplabel.getText().equals("選択できません") || uplabel.getText().equals("手牌が選択されていません")){
                uplabel.setText("選択してください");
            }
            if(hand.serch().equals("NO")){
                uplabel.setText("選択されていません");
            } else {
                String[] tmp = hand.serch().split(",", 0);
                int x = Integer.parseInt(tmp[0]);
                int y = Integer.parseInt(tmp[1]);
                hand.remMen(x,y);
                mentlabel[x][y].setText(hand.getMen(x,y));
            }

        }
    }

    //決定ボタンのイベント・決定後の画面
    class push_enter implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            if(hand.sheckEnough() == false){
                uplabel.setText("手牌が選択されていません");
            } else {
                uplabel.setText("詳細な情報を入力してください");

                

                selectAgari.getItems().addAll("ロン","ツモ");
                selectAgari.setPrefWidth(160);
                selectAgari.setOnAction(new SampleEventHandler1());
                
                selectMati.getItems().addAll("辺張・嵌張・単騎","それ以外");
                selectMati.setPrefWidth(160);
                selectMati.setOnAction(new SampleEventHandler1());
                selectYakuhai.getItems().addAll("自風","他風");
                selectYakuhai.setPrefWidth(160);
                selectYakuhai.setOnAction(new SampleEventHandler1());

                matiBox.setAlignment(Pos.CENTER);
                agariBox.setAlignment(Pos.CENTER);
                yakuhaiBox.setAlignment(Pos.CENTER);
                
                VBox afterBox = new VBox();
                afterBox.setSpacing(30); 
                afterBox.getChildren().addAll(selectAgari);
                afterBox.getChildren().addAll(selectMati);
                afterBox.getChildren().addAll(selectYakuhai);


                root.setCenter(afterBox);
                root.setRight(afterRightVbox);

            }

        }
    }

    class SampleEventHandler1 implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e){

            ComboBox tmp = (ComboBox) e.getSource();
            if(tmp == selectAgari){
                str1 = tmp.getValue().toString();
            } else if(tmp == selectMati){
                str2 = tmp.getValue().toString();
            } else {
                str3 = tmp.getValue().toString();
            }

            if( str1 != null && str2 != null && str3 != null){
                uplabel.setText("入力完了");
                if(str1.equals("ロン")){
                    hand.setAgari(true);
                }
                if(str2.equals("辺張・嵌張・単騎")){
                    hand.setMati(true);
                }
                if(str3.equals("自風")){
                    hand.setYakuhai(true);
                }
            }

        }
    }
    
}


/*
for(int i = 0; i < bt3.length; i++){
            bt3[i] = new Button(hand.getEnt(i));
        }
        bt3[0].setOnAction(new push_return());
        bt3[1].setOnAction(new push_enter());

        HBox enter_retrun = new HBox(30d);
        enter_retrun.setPadding(new Insets(20, 20, 20, 20));
        for (int i = 0; i<bt3.length; i++) {
            enter_retrun.getChildren().addAll(bt3[i]);
        }


*/

