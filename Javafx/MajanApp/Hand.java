interface InterHand{
    public void setMen(String s,int i);
    public void setPon(String s,int i);
    public void setTii(String s,int i);
    public void setAnkan(String s,int i);
    public void setMinkan(String s,int i);
    public void setAtama(String s);
    public void setAgari(boolean b);
    public void setMati(String s);
    public String getMen(int i);
    public String getPon(int i);
    public String getTii(int i);
    public String getAnkan(int i);
    public String getMinkan(int i);
    public String getAtama();
    public boolean getAgari();
}

class Hand implements InterHand{
    private String[] Men = new String[12];
    private String[] Pon = new String[4];
    private String[] Tii = new String[12];          //2次元配列にしよう
    private String[] Ankan = new String[4];
    private String[] Minkan = new String[4];
    private String Atama;
    private boolean Agari = false;              //tumo -> ture、ron -> false
    private String Mati;
    private String Yakuhai;

    public void setMen(String s,int i){
        Men[i] = s;
    }
    public void setPon(String s,int i){
        Pon[i] = s;
    }
    public void setTii(String s,int i){
        Tii[i] = s;
    }
    public void setAnkan(String s,int i){
        Ankan[i] = s;
    }
    public void setMinkan(String s,int i){
        Minkan[i] = s;
    }
    public void setAtama(String s){
        Atama = s;
    }
    public void setAgari(boolean b){
        Agari = b;
    }
    public void setMati(String s){
        Mati = s;
    }
    public void setYakuhai(String s){
        Yakuhai = s;
    }

    public String getMen(int i){
        return Men[i];
    }
    public String getPon(int i){
        return Pon[i];
    }
    public String getTii(int i){
        return Tii[i];
    }
    public String getAnkan(int i){
        return Ankan[i];
    }
    public String getMinkan(int i){
        return Minkan[i];
    }
    public String getAtama(){
        return Atama;
    }
    public boolean getAgari(){
        return Agari;
    }
    public String getMati(){
        return Mati;
    }
    public String getYakuhai(){
        return Yakuhai;
    }
}