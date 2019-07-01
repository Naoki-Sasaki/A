import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.*;

public class Majan extends Application{
    private Button[][] bt = new Button[4][9];
    private Button[] bt2 = new Button[4];
    private Button[] bt3 = new Button[2];

    public static void main(String... args){
        launch(args);
    }

    public void start(Stage stage) throws Exception{

        stage.setWidth(700);
        stage.setHeight(300);

        String[][] syurui ={
            {"m1","m2","m3","m4","m5","m6","m7","m8","m9"},
            {"s1","s2","s3","s4","s5","s6","s7","s8","s9"},
            {"p1","p2","p3","p4","p5","p6","p7","p8","p9"},
            {"東","南","西","北","白","發","中"}};

        String[] Op = {"ポン","チー","ロン","ツモ"};
        String[] Ent = {"戻る","決定"};

        //ボタンの作成・テキストをセット
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

        //GPを作成し、btをセットする
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
        
        //オプションボタンを作成・テキストをセット
        for(int i = 0; i < bt2.length; i++){
            bt2[i] = new Button(Op[i]);
        }
        VBox vb = new VBox(10d);
        vb.setPadding(new Insets(20, 20, 20, 20));
        for (int i = 0; i<bt2.length; i++) {
            vb.getChildren().addAll(bt2[i]);
        }

        //決定・戻るボタンの作成
        for(int i = 0; i < bt3.length; i++){
            bt3[i] = new Button(Ent[i]);
        }
        HBox hb = new HBox(30d);
        hb.setPadding(new Insets(20, 20, 20, 20));

        for (int i = 0; i<bt3.length; i++) {
            hb.getChildren().addAll(bt3[i]);
        }

        BorderPane root = new BorderPane();
        root.setCenter(gp);
        root.setRight(vb);
        root.setBottom(hb);
        gp.setAlignment(Pos.CENTER);
        vb.setAlignment(Pos.CENTER_RIGHT);
        hb.setAlignment(Pos.BOTTOM_CENTER);

        //上部にgetHandを描写する
        //決定が押された後に頭・役牌・待ちの選択

        stage.setScene(new Scene(root));
        stage.setTitle("符計算");
        stage.show();
    }
}
