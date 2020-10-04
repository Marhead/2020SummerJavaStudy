/*
* Name: Kim Hyun Bae
* Student ID#: 2017145086
*/

/* 
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class Cafe implements ICafe {
    int currenttime;
    int[][] counter;
    boolean[] counterempty;
    int totalwaiting;
    int[][] cafeline;
    int linefirst;
    int linelast;
    
    public Cafe() {
        currenttime = 0;
        totalwaiting = 0;
        counterempty = new boolean[]{true, true};
        counter = new int[2][3];
        cafeline = new int[10000][3];
        linefirst = 0;
        linelast = 0;
    }  

    @Override
    public void arrive(int Id, int arrivaltime, int coffee) {
        if(counterempty[0]){
            counter[0] = new int[]{Id, arrivaltime, arrivaltime+coffee};
            counterempty[0] = false; 
        } else if(counterempty[1]){
            counter[1] = new int[]{Id, arrivaltime, arrivaltime+coffee};
            counterempty[1] = false;
        } else {
            cafeline[linelast] = new int[]{Id, arrivaltime, coffee};
            linelast ++;
        }

    }

    @Override
    public int serve() {
        
        int whichcounter = 0;
        int serveid;

        if(counterempty[0]){
            whichcounter = 1;
        } else if(!counterempty[1]){
            if(counter[0][2]>counter[1][2]){
                whichcounter = 1;
            }
        }

        serveid = counter[whichcounter][0];
        currenttime = counter[whichcounter][2];
        totalwaiting += currenttime - counter[whichcounter][1];
        counterempty[whichcounter] = true;

        if(linelast>linefirst){
            counterempty[whichcounter] = false;
            counter[whichcounter] = new int[]{cafeline[linefirst][0],cafeline[linefirst][1],currenttime+cafeline[linefirst][2]};
            linefirst++; 
        }
        
        return serveid;
    }

    @Override
    public int stat() {
        return totalwaiting;
    }
}
