import java.util.ArrayList;

interface InterCalc{
    public void setMenList(String s,int i);
    public void setPonList(String s,int i);
    public void setTiiList(String s,int i);
    public void setAnkanList(String s,int i);
    public void setMinkanList(String s,int i);
    public void setAtamaL(String s);
    public void setAgariL(boolean b);
    public void setMatiL(String s);
    public int calcAll();
    public int calcMen();
    public int calcPon();
    public int calcTii();
    public int calcAnkan();
    public int calcMinkan();
    public int calcAtama();
    public int calcAgari();
    public int calcMati();
}

class Calc implements InterCalc{
    String[][] syurui ={
        {"m1","m2","m3","m4","m5","m6","m7","m8","m9"},
        {"s1","s2","s3","s4","s5","s6","s7","s8","s9"},
        {"p1","p2","p3","p4","p5","p6","p7","p8","p9"},
        {"東","南","西","北","白","發","中"}};

    String[] tyutyan = {"m2","m3","m4","m5","m6","m7","m8",
                        "s2","s3","s4","s5","s6","s7","s8",
                        "p2","p3","p4","p5","p6","p7","p8"};

    String[] yaotyu = {"m1","m9","s1","s9","p1","p9",
                       "東","南","西","北","白","發","中"};

    ArrayList<String> MenList = new ArrayList<String>();
    ArrayList<String> PonList = new ArrayList<String>();
    ArrayList<String> TiiList = new ArrayList<String>();
    ArrayList<String> AnkanList = new ArrayList<String>();
    ArrayList<String> MinkanList = new ArrayList<String>();
    String AtamaL;
    String MatiL;
    boolean AgariL;
    String Yakuhai;

    public void setMenList(String s){
        for(int i = 0; i < 12; i++){
            if(s != null){
                MenList.add(s);
            }
        }
    }
    public void setTiiList(String s){
        for(int i = 0; i < 12; i++){
            if(s != null){
                TiiList.add(s);
            }
        }
    }
    public void setPonList(String s){
        for(int i = 0; i < 4; i++){
            if(s != null){
                PonList.add(s);
            }
        }
    }
    public void setAnkanList(String s){
        for(int i = 0; i < 4; i++){
            if(s != null){
                AnkanList.add(s);
            }
        }
    }
    public void setMinkanList(String s){
        for(int i = 0; i < 4; i++){
            if(s != null){
                MinkanList.add(s);
            }
        }
    }
    public void setAtamaL(String s){
        AtamaL = s;
    }
    public void setAgariL(boolean b){
        AgariL = b;
    }
    public void setMatiL(String s){
        MatiL = s;
    }

    //ここから符の計算
    // public int calcMen();
    public int calcPon(){
        int tmp = 0;
        for(int i = 0; i < PonList.size(); i++){
            for(int j = 0; j < tyutyan.length; j++){
                if(tyutyan[j].equals(PonList.get(i))){
                    tmp = tmp + 2;
                } else {
                    tmp = tmp + 4;
                }
            }
        }
        return tmp;
    }

    //public int calcTii();

    public int calcAnkan(){
        int tmp = 0;
        for(int i = 0; i < AnkanList.size(); i++){
            for(int j = 0; j < tyutyan.length; j++){
                if(tyutyan[j].equals(AnkanList.get(i))){
                    tmp = tmp + 16;
                } else {
                    tmp = tmp + 32;
                }
            }
        }
        return tmp;
    }

    public int calcMinkan(){
        int tmp = 0;
        for(int i = 0; i < MinkanList.size(); i++){
            for(int j = 0; j < tyutyan.length; j++){
                if(tyutyan[j].equals(MinkanList.get(i))){
                    tmp = tmp + 8;
                } else {
                    tmp = tmp + 16;
                }
            }
        }
        return tmp;
    }

    public int calcAtama(){
        int tmp = 0;
        for(int i = 0; i < 7; i++){
            if(AtamaL.equals(Yakuhai)){
                tmp = tmp + 2;
                break;
            }
        }
        return tmp;
    }

    public int calcAgari(){
        if((PonList.size() == 0) && (TiiList.size() == 0) && (MinkanList.size() == 0)){
            if(AgariL == true){
                return 2;
            } else {
                return 10;
            }
        } else{
            return 0;
        }
    }
    //public int calcMati();
}