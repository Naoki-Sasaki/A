interface rehandmini{
    public void setMen(String s,int i,int j);
    public void setAgari(boolean b);
    public void setMati(String s);
    public void setYakuhai(String s);
    public void setMenCounter();
    
    public String getMen(int i,int j);
    public boolean getAgari();
    public boolean getMati();
    public String getYakuhai();
    public String getMenCounter(String s);
    public String getSyurui(int i, int j);
    public String getOption(int i);
    public String getEnterOrReturn(int i);
    
    public String serch();
    public void removeMen(int i,int j);
    public void removeAtama();
    public void removeAgari();
    public void removeMati();
    public void removeYakuhai();

}

class ReHandMini implements rehandmini{
    private final String[][] syurui ={
        {"m1","m2","m3","m4","m5","m6","m7","m8","m9"},
        {"s1","s2","s3","s4","s5","s6","s7","s8","s9"},
        {"p1","p2","p3","p4","p5","p6","p7","p8","p9"},
        {"東","南","西","北","白","發","中"}};

    public final String[] option = {"ポン","チー","ロン","ツモ"};
    public final String[] enterOrReturn = {"戻る","決定"};

    private String[][] ments = {{"?","?","?"},
                              {"?","?","?"},
                              {"?","?","?"},
                              {"?","?","?"},
                              {"?","?",null}};
    private String atama;
    private boolean agari = false;              //tumo -> ture、ron -> false
    private boolean mati;                        //ryanmen,syabo:false   pentyan,kantyan,tanki,nobetan:ture
    private String yakuhai;


    public void setMen(String s,int i,int j){

    }
    public void setAgari(boolean b){

    }
    public void setMati(String s){

    }
    public void setYakuhai(String s){

    }
    public void setMenCounter(){

    }
    
    public String getMen(int i,int j){
        return ments[i][j];
    }
    public boolean getAgari(){
        
    }
    public boolean getMati(){

    }
    public String getYakuhai(){

    }
    public String getMenCounter(String s){

    }
    public String getSyurui(int i, int j){
        return syurui[i][j];
    }

    public String getOption(int i){
        return option[i];
    }
    public String getEnterOrReturn(int i){
        return enterOrReturn[i];
    }    
    
    public void removeMen(int i,int j){

    }
    public void removeAtama(){

    }
    public void removeAgari(){

    }
    public void removeMati(){

    }
    public void removeYakuhai(){

    }

    public String serch(){

    }

    public String serchLastPush(){
        if(ments[0][0].equals("?")){
            return "NO";

        } else if(ments[1][0].equals("?") && !(ments[0][2].equals("?"))){

            return "0,2";

        } else if(ments[2][0].equals("?") && !(ments[1][2].equals("?"))){
            return "1,2";

        } else if(ments[3][0].equals("?") && !(ments[2][2].equals("?"))){
            return "2,2";

        } else if(ments[4][0].equals("?") && !(ments[3][2].equals("?"))){
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

 
}