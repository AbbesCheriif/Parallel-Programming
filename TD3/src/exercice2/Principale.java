package exercice2;

import java.util.ArrayList;

class Principale {
	
	public static void main(String[] args) {
		int n = 30; 
        //1 pipeline
        static ArrayList<Prime> pipeline = new ArrayList<Prime>();
        
        //2 cannaux
        SynchrounousQueue<Integer> I = new SynchrounousQueue<Integer>();
        SynchrounousQueue<Integer> O = new SynchrounousQueue<Integer>();
        pipeline.add(new Prime(0,I,O));
	}
}
