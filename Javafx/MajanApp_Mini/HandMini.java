interface InterHandMini{
    public void setMen(String s,int i,int j);
    public void setAtama(String s);
    public void setAgari(boolean b);
    public void setMati(String s);
    public void setYakuhai(String s);

    public String getMen(int i,int j);
    public String getAtama();
    public boolean getAgari();
    public boolean getMati();
    public String getYakuhai();
}

class HandMini implements InterHandMini{
    private final String[][] syurui ={
        {"m1","m2","m3","m4","m5","m6","m7","m8","m9"},
        {"s1","s2","s3","s4","s5","s6","s7","s8","s9"},
        {"p1","p2","p3","p4","p5","p6","p7","p8","p9"},
        {"東","南","西","北","白","發","中"}};

    private final String[] Op = {"ポン","チー","ロン","ツモ"};
    private final String[] Ent = {"戻る","決定"};
    private String[][] Men = {{"?","?","?"},
                              {"?","?","?"},
                              {"?","?","?"},
                              {"?","?","?"},
                              {"?","?"," "}};
    private String Atama;
    private boolean Agari = false;              //tumo -> ture、ron -> false
    private boolean Mati;                        //ryanmen,syabo:false   pentyan,kantyan,tanki,nobetan:ture
    private String Yakuhai;

    public void setMen(String s,int i,int j){
        Men[i][j] = s;
    }
    public void setAtama(String s){
        Atama = s;
    }
    public void setAgari(boolean b){
        Agari = b;
    }
    public void setMati(String s){
        if(s.equals("両面") || s.equals("双碰")){
            Mati = false;
        } else {
            Mati = true;
        }
        
    }
    public void setYakuhai(String s){
        Yakuhai = s;
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
    public String getAtama(){
        return Atama;
    }
    public boolean getAgari(){
        return Agari;
    }
    public boolean getMati(){
        return Mati;
    }
    public String getYakuhai(){
        return Yakuhai;
    }
}