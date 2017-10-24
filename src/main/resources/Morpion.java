package jeux;

public class Morpion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char tabMorpion[][] = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
		char check;
		int pos[] = new int [2];
		boolean end_partie = false;
		boolean end_joueur = false;
		Display.displayEmptyGrid();
		do {
			end_joueur = false;
			do {			
				pos = Display.displayQuestion();
				if (tabMorpion[pos[0]][pos[1]]==' ') {
					tabMorpion[pos[0]][pos[1]]='X';
					end_joueur=true;
				}
				else {
					Display.displayError();
				}
			}
			while (!end_joueur);
			Display.displayGrid(tabMorpion);
			Display.displayEnd(check=la.gameStateCheck(tabMorpion));
			if(check=='d'||check=='X') {
				end_partie = true;
			}
			else {
				Display.displaylaPlay();
				la.iaPlay(tabMorpion);
				Display.displayGrid(tabMorpion);
				Display.displayEnd(check=la.gameStateCheck(tabMorpion));
				if(check=='d'||check=='O') end_partie = true;
			}
			
		}
		while (!end_partie);
		System.out.println("Fin de partie");
	}
}
