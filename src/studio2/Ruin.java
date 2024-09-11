package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the amount of money you start with: ");
		int startAmount=in.nextInt();
		int currentAmount=startAmount;
		
		System.out.println("Set a win probability in a single play: ");
		double winChance=in.nextDouble();
		
		System.out.println("Set a limit to successfully leave: ");
		int winLimit=in.nextInt();
		
		System.out.println("Enter total simulations: ");
		int totalSimulations=in.nextInt();
		
		int simDays=0;
		int loseAmount=0;
		String WoL="LOSE";
		
		while(currentAmount>0 && currentAmount<winLimit) {
			if(Math.random()<winChance) {
				currentAmount++;
				WoL="WIN";
			}
			else {
				currentAmount--;
				loseAmount++;
			}
			simDays++;
			System.out.println("Simulations "+simDays+": "+WoL);
			WoL="LOSE";
		}
		System.out.println("Losses: "+loseAmount+" Simulatons: "+simDays);
		double simRuinRate=((double)loseAmount)/((double)simDays);
		double expRuinRate;
		if(winChance==0.5) {
			expRuinRate=1-startAmount/winLimit;
		}
		else {
			double alpha=(1-winChance)/winChance;
			expRuinRate=(Math.pow(alpha,startAmount)-Math.pow(alpha,winLimit))/(1-Math.pow(alpha,winLimit));
		}
		System.out.println("Ruin Rate from Simulation: "+Math.round(simRuinRate*100)/100.0+" Expected Ruin Rate: "+expRuinRate);
	}

}
