

class ReHandMini {
    public final String[][] HAI ={
        {"m1","m2","m3","m4","m5","m6","m7","m8","m9"},
        {"s1","s2","s3","s4","s5","s6","s7","s8","s9"},
        {"p1","p2","p3","p4","p5","p6","p7","p8","p9"},
        {"東","南","西","北","白","發","中"}};

    public final String[] PONTII = {"ポン","チー"};
    public final String[] RETURNENTER = {"戻る","決定"};
    private String[][] ments = {{"?","?","?"},
                                {"?","?","?"},
                                {"?","?","?"},
                                {"?","?","?"},
                                {"?","?",null}};
    private String agari;
    private String mati;
    private String yakuhai;


    public void setMents(String s, int x, int y) {
        String[] tmp = s.split(",", 0);
        int i = Integer.parseInt(tmp[0]);
        int j = Integer.parseInt(tmp[1]);

        ments[i][j] = HAI[x][y];
    }

    
    public void setAgari(String s) {
        agari = s;
    }

    
    public void setMati(String s) {
        mati = s;
    }

    
    public void setYakuhai(String s) {
        yakuhai = s;
    }

    public String[][] getMentsArgs(){
        return ments;
    }

    public String getMentsToIndex(String s){
        for(int i = 0; i < HAI.length; i++){
            if(i == 3){
                for(int j = 0; j < 7; j++){
                    if(HAI[i][j].equals(s)){
                        return Integer.toString(i) + "," + Integer.toString(j);
                    }
               }    
            } else{
                for(int j = 0; j < 9; j++){
                    if(HAI[i][j].equals(s)){
                        return Integer.toString(i) + "," + Integer.toString(j);
                    }
               }
            } 
        }
        return "error";
    }
    
    public String getMents(int i, int j){
        return ments[i][j];
    }

    
    public String getAgari() {
        return agari;
    }

    
    public String getMati() {
        return mati;
    }

    
    public String getYakuhai() {
        return yakuhai;
    }

    
    public void removeMen(String s) {
        String[] tmp = s.split(",", 0);
        int x = Integer.parseInt(tmp[0]);
        int y = Integer.parseInt(tmp[1]);

        ments[x][y] = "?";
    }

    
    public String serchLastAddMents(String s) {
        if(ments[0][0].equals("?")){
            if(s.equals("?AtFirst")){
                return "0,0";
            } else if(s.equals("lstAddMents")){
                return  "enpty";
            } else {
                return "error";
            }

        } else if(ments[1][0].equals("?") && !(ments[0][2].equals("?"))){
            if(s.equals("?AtFirst")){
            return "1,0";
            } else if(s.equals("lstAddMents")){
                return  "0,2";
            } else {
                return "error";
            }

        } else if(ments[2][0].equals("?") && !(ments[1][2].equals("?"))){
            if(s.equals("?AtFirst")){
                return "2,0";
            } else if(s.equals("lstAddMents")){
                return  "1,2";
            } else {
                return "error";
            }

        } else if(ments[3][0].equals("?") && !(ments[2][2].equals("?"))){
            if(s.equals("?AtFirst")){
                return "3,0";
            } else if(s.equals("lstAddMents")){
                return  "2,2";
            } else {
                return "error";
            }

        } else if(ments[4][0].equals("?") && !(ments[3][2].equals("?"))){
            if(s.equals("?AtFirst")){
                return "4,0";
            } else if(s.equals("lstAddMents")){
                return  "3,2";
            } else {
                return "error";
            }
        }else{
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 3; j++){
                    if(i == 4 && j == 2){
                        if(s.equals("?AtFirst")){
                            return "fullMents";
                            } else if(s.equals("lstAddMents")){
                                return  "4,1";
                            } else {
                                return "error";
                            }

                    } else if (ments[i][j].equals("?")){
                        if(s.equals("?AtFirst")){
                            return Integer.toString(i) + "," + Integer.toString(j);
                        } else if(s.equals("lstAddMents")){
                            return Integer.toString(i) + "," + Integer.toString(j-1);
                        }
                    }
                }
            }
        }
        return "error";
    }
}