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
    private Button[][] bt = new Button[4][9];
    private Button[] bt2 = new Button[4];
    private Button[] bt3 = new Button[2];
    private Label[][] mentlabel = new Label[5][3];

    public static void main(String... args){
        launch(args);
    }

    public void start(Stage stage) throws Exception{
        HandMini hand = new HandMini();
        
    //初期画面の作成    
        stage.setWidth(800);
        stage.setHeight(400);

        String[][] syurui ={
            {"m1","m2","m3","m4","m5","m6","m7","m8","m9"},
            {"s1","s2","s3","s4","s5","s6","s7","s8","s9"},
            {"p1","p2","p3","p4","p5","p6","p7","p8","p9"},
            {"東","南","西","北","白","發","中"}};

        String[] Op = {"ポン","チー","ロン","ツモ"};
        String[] Ent = {"戻る","決定"};

        //ハイのボタンの作成・テキストをセット(中央)
        for(int i = 0; i < bt.length; i++){
            if(i == 3){
                for(int j = 0; j < 7; j++){
                    bt[i][j] = new Button(syurui[i][j]);
                    bt[i][j].setPrefWidth(50);
               }
            } else{
                for(int j = 0; j < 9; j++){
                    bt[i][j] = new Button(syurui[i][j]);
                    bt[i][j].setPrefWidth(50);
               }
            } 
        }

        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(20, 20, 20, 20));
        for(int i = 0; i < bt.length; i++){
            if(i == 3){
                for(int j = 0; j < 7; j++){
                    gp.add(bt[i][j],j,i);
                }
            } else{
                for(int j = 0; j < 9; j++){
                    gp.add(bt[i][j],j,i);
                }
            }
        }
        
        //オプションボタンを作成・テキストをセット(右側)
        for(int i = 0; i < bt2.length; i++){
            bt2[i] = new Button(Op[i]);
        }

        VBox vb = new VBox(10d);
        vb.setPadding(new Insets(20, 20, 20, 20));
        for (int i = 0; i<bt2.length; i++) {
            vb.getChildren().addAll(bt2[i]);
        }

        //決定・戻るボタンの作成(下側)
        for(int i = 0; i < bt3.length; i++){
            bt3[i] = new Button(Ent[i]);
        }
        
        HBox hb = new HBox(30d);
        hb.setPadding(new Insets(20, 20, 20, 20));

        for (int i = 0; i<bt3.length; i++) {
            hb.getChildren().addAll(bt3[i]);
        }

        //メンツの表示(左) <- Handからのゲッターで行う
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

        //rootPaneの作成
        BorderPane root = new BorderPane();
        root.setCenter(gp);
        root.setRight(vb);
        root.setBottom(hb);
        root.setLeft(mentGp);;
        gp.setAlignment(Pos.CENTER);
        vb.setAlignment(Pos.CENTER_RIGHT);
        hb.setAlignment(Pos.BOTTOM_CENTER);
        mentGp.setAlignment(Pos.CENTER_LEFT);

        //決定が押された後に頭・役牌・待ちの選択

        //ここまで初期画面

        bt[0][0].setOnAction((ActionEvent e) -> {  //？のところを見つけて入れる
            hand.setMen(syurui[0][0],0,0);
            mentlabel[0][0].setText(hand.getMen(0,0));
        });

        /*
        bt[0][0].setOnAction((ActionEvent e) -> {  //？のところを見つけて入れる
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 3; j++){
                    if(hand.getMen(i,j).equals("?")){
                        hand.setMen(syurui[0][0],0,0);
                        mentlabel[i][j].setText(hand.getMen(i,j));
                        break;
                    }
                    break;
                }
                break;
            }
        });
        */

        


        stage.setScene(new Scene(root));
        stage.setTitle("符計算");
        stage.show();

    }
}