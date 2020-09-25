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
    int[][] copyboard;
    int[][] movement = new int[][]{{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
    int[] solution;

    @Override
    public int[] solve(Board board) {
        
        boardwidth = board.getWidth();
        boardheight = board.getHeight();
        copyboard = CopyBoard(board);
        objective = SetObjective(copyboard);

        for(int i=0; i<boardwidth; i++){
            for(int j=0; j<boardheight; j++){
                if(isSpace(i,j)){
                    copyboard[i][j] = 0;
                    if(MoveRecursion(i,j,1)){
                        solution = SequenceMaker(copyboard);
                        return solution;
                    } else {
                        copyboard[i][j] = -1;
                    }
                }
            }
        }

        solution = new int[]{};
        return solution;     
    }


    public int[] SequenceMaker(int[][] arr){
        
        int[] savezone = new int[objective];
        for(int i=0;i<boardwidth; i++){
            for(int j=0; j<boardheight; j++){
                if(arr[i][j]>=0){
                    savezone[arr[i][j]] = i*boardheight + j;
                }
            }
        }
        return savezone;
    }

    public boolean MoveRecursion(int i, int j, int n) { 
        if (n == objective){
            return true;
        }

        for(int[] mov : movement){
            if(isSpace(i+mov[0],j+mov[1])){
                copyboard[i+mov[0]][j+mov[1]] = n;
                
                if(MoveRecursion(i+mov[0],j+mov[1],n+1)){
                    return true;
                } else {
                    copyboard[i+mov[0]][j+mov[1]] = -1;
                }
            }
        }
         
        return false; 
    }

    public boolean isSpace(int i, int j){
          
        if(i<0 || i >= boardwidth || j <0 || j >= boardheight || copyboard[i][j] != -1){
            return false;
        } else {
            return true;
        }
    }


    public int[][] CopyBoard(Board board){
        int[][] tmpcopyboard = new int[boardwidth][boardheight];

        for(int i=0; i<boardwidth; i++){
            for(int j=0; j<boardheight; j++){
                if(board.isMissing(i,j)){
                    tmpcopyboard[i][j] = -2;
                } else {
                    tmpcopyboard[i][j] = -1;
                }
            }
        }
        return tmpcopyboard;
    }
   
    public int SetObjective(int[][] somecopyboard){
        int count = 0;
        for(int i=0; i<boardwidth; i++){
            for(int j=0; j<boardheight; j++){
                if(somecopyboard[i][j] == -1){
                    count++;
                } 
            }
        }
        return count;
    }


}
