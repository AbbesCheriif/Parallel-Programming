package exercice2;

import java.util.ArrayList;

public class Prime extends Thread{
	static ArrayList<Integer> res = new ArrayList<Integer>();
    static int index = 0;
    
    Prime(int index, SynchrounousQueue I,SynchrounousQueue O){
        this.index =index ;
        this.I = I;
        this.O = O;
    }
    
    @Override 
    public void run(){
        // 1 thread
        if ( index == 0 ){
          res.add(2);
            for (int i=3;i<=n;i++){
                if ( i%2 != 0 ){
                    O.put(i);
                    I = O;
                    O = new SynchrounousQueue<Integer>();
                    pipeline.add(new Prime(1, I, O));
                    index++;
                    pipeline[index].start();
                }
        }   
        } 
        
        //inetrmediaire
        else if ( index > 0 ){
            x = I.take();
            res.add(x);
            for (int i=x;i<=n;i++){
                if ( i%x != 0 ){
                    I = O;
                    O = new SynchrounousQueue<Integer>();
                    O.put(i);
                    index++;
                    pipeline.add(new Prime(index, I, O));
                    pipeline[index].start();
                }
            } 
        }
            
    }
}
