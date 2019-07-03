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