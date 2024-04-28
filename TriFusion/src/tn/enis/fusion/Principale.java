package tn.enis.fusion;

import java.util.Scanner;

public class Principale {
	// declaration des attributs:
	// static int[]tab = {0,2,7,1,3,9}; //le tab est static pour que chaque fois on
	// fait instancier la classe il reste inchangé
	static int n = 6;
	static int[] tab = new int[n];

	// fonction pour entrer le tableau
	void saisir() {
		@SuppressWarnings("resource")
		Scanner Sc = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			tab[i] = Sc.nextInt();
		}
	}

	void fusion() {
	    int i=0; //pour itérer sur la 1ere partie du tab
	    int milieu = n/2;
	    int j = milieu;
	    int k = 0; //pour itérer sur le nouveau tableau
	    int[]w=new int [n];  //le nouveau tableau trié
	    while((i<milieu) && (j<n)) {
	        if(tab[i]<tab[j]) {
	            w[k]=tab[i];
	            i++;
	            k++;
	            if(i == milieu) {  //lorsque on atteint la fin du 1er tableau sans que la 2eme partie atteint sa fin
	                for(int p=j;p<n;p++) {
	                    w[k]=tab[p];
	                    k++;
	                }
	            }
	        }
	        else {
	            w[k]=tab[j];
	            k++;
	            j++;
	            if(j==n) {  //lorsque on atteint la fin du 2eme tableau sans que la 1ere partie atteint sa fin
	                for(int p=i;p<milieu;p++) {
	                    w[k]=tab[p];
	                    k++;
	                }
	            }
	        }
	        
	    }
	    tab = w; //rendre le contenu de tableau trié dans tab pour qu'on peut lafficher car w est une variable locale de la fct fusion 
	}

	void affichage() {
		for (int i=0;i<n;i++) {
		    System.out.println(tab[i]);
		}
	}
	    

	public static void main(String args[]) {
	         Principale p = new Principale();
	         p.saisir();
	         Trieur t1=new Trieur(0,n/2);
	         Trieur t2=new Trieur(n/2,n);
	         t1.start();
	         t2.start();
	         
        	 try {
				t1.join();
				t2.join();
				p.fusion();
	            p.affichage();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	     }
}

