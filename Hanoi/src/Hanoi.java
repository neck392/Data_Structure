import java.util.Scanner;

public class Hanoi {
	
	static int c=1;
	static int count=0;
	static void move(int n, char from, char to, char tmp)
	{
		if (n == 1) {
			System.out.println(c+" : "+ n+" move : from "+from+" to "+to);
			c++;
		} else {
			count++;
			move (n - 1, from, tmp, to);
			System.out.println(c+" : "+ n+" move : from "+from+" to "+to);
			c++;
			move (n - 1, tmp, to, from);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		move(4, 'A', 'C', 'B');

	}

}
