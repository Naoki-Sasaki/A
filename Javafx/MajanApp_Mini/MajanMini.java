import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.*;

public class MajanMini extends Application{
    HandMini hand = new HandMini();
    private Button[][] bt = new Button[4][9];
    private Button[] bt2 = new Button[4];
    private Button[] bt3 = new Button[2];
    private Label[][] mentlabel = new Label[5][3];
    private Label uplabel;

    public static void main(String... args){
        launch(args);
    }

    public void start(Stage stage) throws Exception{
        HandMini hand = new HandMini();
        
    //初期画面の作成    
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
        hai.setAlignment(Pos.CENTER);
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
        //bt3[0].setOnAction(new push_return());
        
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
        mentGp.setAlignment(Pos.CENTER);
        mentGp.setHgap(10);
        mentGp.setVgap(10);
        mentGp.setPadding(new Insets(20, 20, 20, 20));

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 3; j++){
                mentGp.add(mentlabel[i][j],j,i);
            }
        }

        //上に表示するラベル
        Label uplabel = new Label("選択してください");
        FlowPane attent = new FlowPane(uplabel);
        attent.setPadding(new Insets(20, 20, 20, 20));


        //rootPaneの作成
        BorderPane root = new BorderPane();
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

        //決定が押された後に頭・役牌・待ちの選択

        stage.setScene(new Scene(root));
        stage.setTitle("符計算");
        stage.show();

    }

    //牌が押された時の処理
    class push_hai implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e){
            Button b = (Button)e.getSource();
            String Id = b.getId();
            String[] Stid = Id.split(",", 0);
            int x = Integer.parseInt(Stid[0]);
            int y = Integer.parseInt(Stid[1]);
            //lb.setText(((Button)e.getSource()).getId());

            boolean flag = false;
            for(int i = 0; i < 5; i++){
                if(flag == true){
                    break;
                }
                for(int j = 0; j < 3; j++){
                    if(flag == true){
                        break;
                    }
                    if(hand.getMen(i,j).equals("?")){
                        hand.setMen(hand.getSyurui(x,y),i,j);
                        mentlabel[i][j].setText(hand.getMen(i,j));
                        
                        /*　printテスト
                        for(int q = 0; q < 5;q++){
                            for(int r = 0; r < 3; r++){
                                System.out.println(hand.getMen(q, r));
                            }
                        }
                        */


                        flag = true;
                    }
                }
            }
        }
    }


    /* mentlabelでエラー出る(´･ω･`)
    class push_return implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e){
            boolean flag = false;

            for(int i = 0; i < 5; i++){
                if(flag == true){
                    break;
                }

                for(int j = 0; j < 3; j++){
                    if(flag == true){
                        break;
                    } 
                    if(i == 4 && j == 2){
                        flag = true;
                        break;
                    }

                    if(hand.getMen(0,0).equals("?")){
                        flag = true;
                        break;
                    }

                    if(!(hand.getMen(i,j).equals("?"))){
                        hand.remMen(i,j);
                        //uplabel.setText("削除しました");
                        mentlabel[i][j].setText("?");

                    }
                }
            }
        }
    }
    */
    
}

