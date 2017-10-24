package jeux;

public class la {
	public static char isGameWin(char tabMorpion[][]) {
		for (int i=0;i<tabMorpion.length;i++) {
			if((tabMorpion[i][0]=='X')&&(tabMorpion[i][1]=='X')&&(tabMorpion[i][2]=='X')) return 'X';
			if((tabMorpion[i][0]=='O')&&(tabMorpion[i][1]=='O')&&(tabMorpion[i][2]=='O')) return 'O';			
		}
		for (int j=0;j<tabMorpion[0].length;j++) {
			if((tabMorpion[0][j]=='X')&&(tabMorpion[1][j]=='X')&&(tabMorpion[2][j]=='X')) return 'X';
			if((tabMorpion[0][j]=='O')&&(tabMorpion[1][j]=='O')&&(tabMorpion[2][j]=='O')) return 'O';			
		}
		if((tabMorpion[0][0]=='X')&&(tabMorpion[1][1]=='X')&&(tabMorpion[2][2]=='X')) return 'X';
		if((tabMorpion[0][0]=='O')&&(tabMorpion[1][1]=='O')&&(tabMorpion[2][2]=='O')) return 'O';			
		if((tabMorpion[0][2]=='X')&&(tabMorpion[1][1]=='X')&&(tabMorpion[2][0]=='X')) return 'X';
		if((tabMorpion[0][2]=='O')&&(tabMorpion[1][1]=='O')&&(tabMorpion[2][0]=='O')) return 'O';			
		
		return 'c';
	}
	public static boolean isGameOver(char tabMorpion[][]) {
		for (int i=0;i<tabMorpion.length;i++) {
			for (int j=0;j<tabMorpion.length;j++) {
				if(tabMorpion[i][j]==' ') return false;
			}
		}
		return true; 
	}
	public static char gameStateCheck(char tabMorpion[][]) {
		if (isGameOver(tabMorpion)==false && isGameWin(tabMorpion)=='c') return 'c';
		if (isGameOver(tabMorpion)==false && isGameWin(tabMorpion)=='X') return 'X';
		if (isGameOver(tabMorpion)==false && isGameWin(tabMorpion)=='O') return 'O';
		
		if (isGameOver(tabMorpion)==true && isGameWin(tabMorpion)=='c') return 'd';
		if (isGameOver(tabMorpion)==true && isGameWin(tabMorpion)=='X') return 'X';
		if (isGameOver(tabMorpion)==true && isGameWin(tabMorpion)=='O') return 'O';
		return 'c';
		
		
	}
	public static boolean isCenterFree(char tabMorpion[][]) {
		if(tabMorpion[1][1]==' ') { tabMorpion[1][1]='O';return true;}
		return false;
	}
	public static int randomBox(int low,int high) {
		int random =(int)(Math.random()*(high-low))+low;
		return random;
	}
	public static void iaRandomPlay(char tabMorpion[][]) {
		boolean end = false;
		int a,b;
		do {
			a = randomBox(0,3);
			b = randomBox(0,3);
			if(tabMorpion[a][b]==' ') {
				tabMorpion[a][b]='O';
				end=true;
			}
		} while(!end);
		
	}
	public static boolean iaPlayToWin(char tabMorpion[][]) {
		for (int i=0;i<tabMorpion.length;i++) {
			if((tabMorpion[i][0]=='O')&&(tabMorpion[i][1]=='O')&&(tabMorpion[i][2]==' ')) {tabMorpion[i][2]='O';return true;}
			if((tabMorpion[i][1]=='O')&&(tabMorpion[i][2]=='O')&&(tabMorpion[i][0]==' ')) {tabMorpion[i][0]='O';return true;}
			if((tabMorpion[i][0]=='O')&&(tabMorpion[i][2]=='O')&&(tabMorpion[i][1]==' ')) {tabMorpion[i][1]='O';return true;}
		}
		for (int j=0;j<tabMorpion[0].length;j++) {
			if((tabMorpion[0][j]=='O')&&(tabMorpion[1][j]=='O')&&(tabMorpion[2][j]==' ')) {tabMorpion[2][j]='O';return true;}
			if((tabMorpion[1][j]=='O')&&(tabMorpion[2][j]=='O')&&(tabMorpion[0][j]==' ')) {tabMorpion[0][j]='O';return true;}
			if((tabMorpion[0][j]=='O')&&(tabMorpion[2][j]=='O')&&(tabMorpion[1][j]==' ')) {tabMorpion[1][j]='O';return true;}
		}
		if((tabMorpion[0][0]=='O')&&(tabMorpion[1][1]=='O')&&(tabMorpion[2][2]==' ')) {tabMorpion[2][2]='O';return true;} 
		if((tabMorpion[2][2]=='O')&&(tabMorpion[1][1]=='O')&&(tabMorpion[0][0]==' ')) {tabMorpion[0][0]='O';return true;}
		if((tabMorpion[0][0]=='O')&&(tabMorpion[0][0]=='O')&&(tabMorpion[1][1]==' ')) {tabMorpion[1][1]='O';return true;}
		
		if((tabMorpion[0][2]=='O')&&(tabMorpion[1][1]=='O')&&(tabMorpion[2][0]==' ')) {tabMorpion[2][0]='O';return true;}
		if((tabMorpion[2][0]=='O')&&(tabMorpion[1][1]=='O')&&(tabMorpion[0][2]==' ')) {tabMorpion[0][2]='O';return true;}
		if((tabMorpion[2][0]=='O')&&(tabMorpion[0][2]=='O')&&(tabMorpion[1][1]==' ')) {tabMorpion[1][1]='O';return true;}
		return false;
	}
	public static boolean iaPlayToDefend(char tabMorpion[][]) {
		for (int i=0;i<tabMorpion.length;i++) {
			if((tabMorpion[i][0]=='X')&&(tabMorpion[i][1]=='X')&&(tabMorpion[i][2]==' ')) {tabMorpion[i][2]='O';return true;}
			if((tabMorpion[i][1]=='X')&&(tabMorpion[i][2]=='X')&&(tabMorpion[i][0]==' ')) {tabMorpion[i][0]='O';return true;}
			if((tabMorpion[i][0]=='X')&&(tabMorpion[i][2]=='X')&&(tabMorpion[i][1]==' ')) {tabMorpion[i][1]='O';return true;}
		}
		for (int j=0;j<tabMorpion[0].length;j++) {
			if((tabMorpion[0][j]=='X')&&(tabMorpion[1][j]=='X')&&(tabMorpion[2][j]==' ')) {tabMorpion[2][j]='O';return true;}
			if((tabMorpion[1][j]=='X')&&(tabMorpion[2][j]=='X')&&(tabMorpion[0][j]==' ')) {tabMorpion[0][j]='O';return true;}
			if((tabMorpion[0][j]=='X')&&(tabMorpion[2][j]=='X')&&(tabMorpion[1][j]==' ')) {tabMorpion[1][j]='O';return true;}
		}
		if((tabMorpion[0][0]=='X')&&(tabMorpion[1][1]=='X')&&(tabMorpion[2][2]==' ')) {tabMorpion[2][2]='O';return true;} 
		if((tabMorpion[2][2]=='X')&&(tabMorpion[1][1]=='X')&&(tabMorpion[0][0]==' ')) {tabMorpion[0][0]='O';return true;}
		if((tabMorpion[0][0]=='X')&&(tabMorpion[0][0]=='X')&&(tabMorpion[1][1]==' ')) {tabMorpion[1][1]='O';return true;}
		
		if((tabMorpion[0][2]=='X')&&(tabMorpion[1][1]=='X')&&(tabMorpion[2][0]==' ')) {tabMorpion[2][0]='O';return true;}
		if((tabMorpion[2][0]=='X')&&(tabMorpion[1][1]=='X')&&(tabMorpion[0][2]==' ')) {tabMorpion[0][2]='O';return true;}
		if((tabMorpion[2][0]=='X')&&(tabMorpion[0][2]=='X')&&(tabMorpion[1][1]==' ')) {tabMorpion[1][1]='O';return true;}
		return false;
	}
	
	
	public static void iaPlay(char tabMorpion[][]) {
		if(iaPlayToWin(tabMorpion)==true) return;
		if(iaPlayToDefend(tabMorpion)==true) return;
		if(isCenterFree(tabMorpion)==true) return;
		iaOpti(tabMorpion);
		//iaRandomPlay(tabMorpion);
		
	}
		
	public static void iaOpti(char tabMorpion[][]) {
		int tour = 0;
		int r = 0;
		boolean danger_diago_1,danger_diago_2;
		for(int i =0;i<3;i++) {
			for(int j =0;j<3;j++){
		  		if (tabMorpion[i][j]=='X') tour++;
			}
		}	
		if ((tour == 2)&&(tabMorpion[1][1]=='O')) {		
			danger_diago_1 = (tabMorpion[0][0]=='X')&&(tabMorpion[2][2]=='X');
		    danger_diago_2 = (tabMorpion[0][2]=='X')&&(tabMorpion[2][0]=='X');
		 	if(danger_diago_1||danger_diago_2) {
		 			r = randomBox(0,4);
		 			switch (r) {
		 				case (0) : tabMorpion[0][1]='O'; break;
		 				case (1) : tabMorpion[1][0]='O'; break;
		 				case (2) : tabMorpion[1][2]='O'; break;
		 				case (3) : tabMorpion[2][1]='O'; break;
		  			}
		  	}
		 	else {
		 		iaRandomPlay(tabMorpion);
		  	
		  	}
		}
		if ((tour==1)&&(tabMorpion[1][1]=='X')) {
			r = randomBox(0,4);
 			switch (r) {
 				case (0) : tabMorpion[0][0]='O'; break;
 				case (1) : tabMorpion[0][2]='O'; break;
 				case (2) : tabMorpion[2][0]='O'; break;
 				case (3) : tabMorpion[2][2]='O'; break;
  			} 
		}
		if (tour>2) iaRandomPlay(tabMorpion);
	}
}
	
	

