interface recheck {
    public void setHaiCounter(int i, int j);
    public void removeHiCounter(int i, int j);
    public boolean isHaiCounter4(int i, int j);
    public boolean canAddMents(String[][] args);
    public boolean canRemoveMents(String[][] args);
    public boolean isFullMents();
    public boolean isFullInputs();
}

class ReCheckMini{
    int[][] haiCounter = {{0,0,0,0,0,0,0,0,0},
                          {0,0,0,0,0,0,0,0,0},
                          {0,0,0,0,0,0,0,0,0},
                          {0,0,0,0,0,0,0}
                         };

    public void setHaiCounter(int i, int j){
        haiCounter[i][j]++;
    }

    public void removeHiCounter(int i, int j){
        haiCounter[i][j]--;
    }

    public boolean isHaiCounter4(int i, int j){
        if(haiCounter[i][j] >= 4){
            return false;
        } else {
            return true;
        }
    }

    public boolean canAddMents(String[][] args){
        if(!(args[4][1].equals("?"))){
            return false;
        } else {
            return true;
        }
    }
    
    public boolean canRemoveMents(String[][] args){
        if(args[0][0].equals("?")){
            return false;
        } else {
            return true;
        }
    }

    public boolean isFullMents(String[][] args){
        for(int i = 0; i < 5; i++){
            if(i != 4){
                for(int j = 0; j < 3; j++){    
                    if(args[i][j].equals("?")){
                        return false;
                    }
                }
            } else {
                for(int j = 0; j < 2; j++){    
                    if(args[i][j].equals("?")){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isFullInputs(String s1, String s2, String s3){
        if(s1 == null || s2 == null || s3 == null){
            return false;
        } else {
            return true;
        }
    }
}