/*
作成途中の機能
4つ以上の牌を選択できない
手牌が満たされていないと決定できない

決定ボタン後
待ち、上がり、役牌の選択
一つも選択されていない場合進めない

符の計算
計算結果を表示
*/
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.*;

public class ReMajanMini extends Application{
    private Button[][] bt = new Button[4][9];
    private Button[] bt2 = new Button[4];
    private Button[] bt3 = new Button[2];
    private Label[][] mentlabel = new Label[5][3];
    private Label uplabel = new Label();
    BorderPane root = new BorderPane();


    //public static Scene scene2 = null;


    public static void main(String... args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        ReHandMini hand = new ReHandMini();
        
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
            bt2[i] = new Button(hand.getOption(i));
        }

        VBox option = new VBox(10d);
        option.setPadding(new Insets(20, 20, 20, 20));
        for (int i = 0; i<bt2.length; i++) {
            option.getChildren().addAll(bt2[i]);
        }

        //決定・戻るボタンの作成(下側)
        for(int i = 0; i < bt3.length; i++){
            bt3[i] = new Button(hand.enterOrReturn[i]);
        }
        //bt3[0].setOnAction(new PushReturn());
        //bt3[1].setOnAction(new push_enter());

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

        //決定ボタン後のpane
        

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

            

    }

    //戻るボタンのイベント
    class PushReturn implements EventHandler<ActionEvent>{
        @Override

    }

    class PushEnter implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){

        }
    }
    
}

