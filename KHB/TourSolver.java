/*
 * Name: Kim Hyun Bae
 * Student ID #: 2017145086
 */

/* 
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class TourSolver implements ITourSolver {
    
    int objective;
    int boardwidth;
    int boardheight;
    boolean[][] copyboard;
    int[][] movement = new int[][]{{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
    int[] savezone;

    @Override
    public int[] solve(Board board) {
        
        boardwidth = board.getWidth();
        boardheight = board.getHeight();
        copyboard = CopyBoard(board);
        objective = SetObjective(copyboard);
        savezone = new int[objective];

        for(int i=0; i<boardwidth; i++){
            for(int j=0; j<boardheight; j++){
                if(isSpace(i,j)){
                    copyboard[i][j] = true;
                    savezone[0]=i*boardheight + j;
                    if(MoveRecursion(i,j,1)){
                        return savezone;
                    } else {
                        copyboard[i][j] = false;
                    }
                }
            }
        }

        savezone = new int[]{};
        return savezone;     
    }

    public boolean MoveRecursion(int i, int j, int n) { 
        if (n == objective){
            return true;
        }

        for(int[] mov : movement){
            if(isSpace(i+mov[0],j+mov[1])){
                copyboard[i+mov[0]][j+mov[1]] = true;
                savezone[n]=(i+mov[0])*boardheight + j+mov[1];
                if(MoveRecursion(i+mov[0],j+mov[1],n+1)){
                    return true;
                } else {
                    copyboard[i+mov[0]][j+mov[1]] = false;
                }
            }
        }
         
        return false; 
    }

    public boolean isSpace(int i, int j){
          
        if(i<0 || i >= boardwidth || j <0 || j >= boardheight || copyboard[i][j]){
            return false;
        } else {
            return true;
        }
    }


    public boolean[][] CopyBoard(Board board){
        boolean[][] tmpcopyboard = new boolean[boardwidth][boardheight];

        for(int i=0; i<boardwidth; i++){
            for(int j=0; j<boardheight; j++){
                if(board.isMissing(i,j)){
                    tmpcopyboard[i][j] = true;
                } else {
                    tmpcopyboard[i][j] = false;
                }
            }
        }
        return tmpcopyboard;
    }
   
    public int SetObjective(boolean[][] somecopyboard){
        int count = 0;
        for(int i=0; i<boardwidth; i++){
            for(int j=0; j<boardheight; j++){
                if(!somecopyboard[i][j]){
                    count++;
                } 
            }
        }
        return count;
    }


}
