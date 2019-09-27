package com.uiFramework;

import java.util.Scanner;

public class Patterns {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan =new Scanner(System.in);
		int n=scan.nextInt();
		System.out.println("*********** RightAngle Right Side Triangle*************");
		
		for (int i =0;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
			System.out.print("*"+ " ");
			}
			System.out.println();
		}
		
	
		System.out.println("*********** RightAngle Left Side Triangle*************");
	
	for (int k =0;k<=n;k++)
	{
		for (int x=2*(n-k);x>0;x--)
		{
			System.out.print(" ");
		}
		for(int l=1;l<=k;l++)
		{
		System.out.print("*"+ " ");
		}
		System.out.println();
	}
	


	
	System.out.println("*********** Equilateral Triangle*************");
	for (int p =0;p<=n;p++)
	{
		for (int q=1*(n-p);q>0;q--)
		{
			System.out.print(" ");
		}
		for(int r=1;r<=p;r++)
		{
		System.out.print("*"+ " ");
		}
		System.out.println();
	}
	
}
	
}
