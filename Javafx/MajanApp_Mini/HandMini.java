

interface InterHandMini{
    public void setMen(String s,int i,int j);
    public void setAgari(boolean b);
    public void setMati(boolean b);
    public void setYakuhai(boolean b);

    public String getSyurui(int i, int j);
    public String getOp(int i);
    public String getEnt(int i);

    public String getMen(int i,int j);
    public boolean getAgari();
    public boolean getMati();
    public boolean getYakuhai();

    public void remMen(int i,int j);
    public void remAgari();
    public void remMati();
    public void remYakuhai();

}

class HandMini implements InterHandMini{
    private final String[][] syurui ={
        {"m1","m2","m3","m4","m5","m6","m7","m8","m9"},
        {"s1","s2","s3","s4","s5","s6","s7","s8","s9"},
        {"p1","p2","p3","p4","p5","p6","p7","p8","p9"},
        {"東","南","西","北","白","發","中"}};

    private int[][] menCounter = {{0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0}};

    private final String[] Op = {"ポン","チー","ロン","ツモ"};
    private final String[] Ent = {"戻る","決定"};
    private String[][] Men = {{"?","?","?"},
                              {"?","?","?"},
                              {"?","?","?"},
                              {"?","?","?"},
                              {"?","?",null}};
    private boolean Agari = false;              //ron -> ture、tumo -> false
    private boolean Mati = false;                        //ryanmen,syabo:false   pentyan,kantyan,tanki,nobetan:ture
    private boolean Yakuhai = false;            //zikaze -> true

    public void setMen(String s,int i,int j){
        Men[i][j] = s;
        
        for(int x = 0; x < 4; x++){
            if(x != 3){
                for(int y = 0; y < 9; y++){
                    if(syurui[x][y].equals(s)){
                        menCounter[x][y]++;
                    }
                }
            } else {
                for(int y = 0; y < 7; y++){
                    if(syurui[x][y].equals(s)){
                        menCounter[x][y]++;
                    }
                }
            }
        }

        /*
        for(int x = 0; x < 4; x++){
            if(x != 3){
                for(int y = 0; y < 9; y++){
                    System.out.print(menCounter[x][y]);
                }
            } else {
                for(int y = 0; y < 7; y++){
                    System.out.print(menCounter[x][y]);
                }
            }
            System.out.println();
        }
        */
    }
    public void setAgari(boolean b){
        Agari = b;
    }
    public void setMati(boolean b){
        Mati = b;
    }
    public void setYakuhai(boolean b){
        Yakuhai = b;
    }

    public String getMenCounter(String s){

        int b = 0;
        boolean flag = false;

        for(int i = 0; i < menCounter.length; i++){
            if(flag = true){
                if(i != 3){
                    for(int j = 0; j < menCounter[0].length; j++){
                        if(syurui[i][j].equals(s)){
                            b = menCounter[i][j];
                            flag = true;
                            break;
                        }
                    }
                } else {
                    for(int j = 0; j < menCounter[3].length; j++){
                        if(syurui[i][j].equals(s)){
                            b = menCounter[i][j];
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }

        if(b >= 4){
            return "NG";
        } else {
            return "OK";
        }
    }

    public String getSyurui(int i, int j){
        return syurui[i][j];
    }

    public String getOp(int i){
        return Op[i];
    }

    public String getEnt(int i){
        return Ent[i];
    }

    public String getMen(int i,int j){
            return Men[i][j];
    }

    public boolean getAgari(){
        return Agari;
    }
    public boolean getMati(){
        return Mati;
    }
    public boolean getYakuhai(){
        return Yakuhai;
    }

    public String serch(){
        if(Men[0][0].equals("?")){
            return "NO";

        } else if(Men[1][0].equals("?") && !(Men[0][2].equals("?"))){

            return "0,2";

        } else if(Men[2][0].equals("?") && !(Men[1][2].equals("?"))){
            return "1,2";

        } else if(Men[3][0].equals("?") && !(Men[2][2].equals("?"))){
            return "2,2";

        } else if(Men[4][0].equals("?") && !(Men[3][2].equals("?"))){
            return "3,2";

        }else{
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 3; j++){
                    
                    if(i == 4 && j == 2){
                        return "4,1";

                    } else if (Men[i][j].equals("?")){
                        return Integer.toString(i) + "," + Integer.toString(j-1);
                    }
                }
            }
        }
        return "NO";
    }

    public boolean sheckEnough(){
        for(int i = 0; i < Men.length; i++){
            if(i != 4){
                for(int j = 0; j < 3; j++){
                    if(Men[i][j].equals("?")){
                        return false;
                    }
                }
            } else {
                for(int j = 0; j < 2; j++){
                    if(Men[i][j].equals("?")){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void remMen(int i,int j){
        String b = getMen(i,j);

        for(int x = 0; x < 4; x++){
            if(x != 3){
                for(int y = 0; y < 9; y++){
                    if(syurui[x][y].equals(b)){
                        menCounter[x][y]--;
                    }
                }
            } else {
                for(int y = 0; y < 7; y++){
                    if(syurui[x][y].equals(b)){
                        menCounter[x][y]--;
                    }
                }
            }
        }


        Men[i][j] = "?";
    }
    public void remAtama(){

    }
    public void remAgari(){

    }
    public void remMati(){

    }
    public void remYakuhai(){

    }


}