package data_encryption;
import java.util.Scanner;
public class Encryption
{
	private static Scanner sc;
	void cipher(String str, String pass)
	{
		sc = new Scanner(System.in);
		char alpha[] = str.toCharArray();
		for(int i=0;i<str.length();i++)
		{
			alpha[i]=(char)(alpha[i]+3);
		}
		System.out.print(alpha);
		System.out.println(" is encrypted.");
		check(alpha,pass);
	}
	void check(char alpha[], String pass)
	{
		String checkpass;
		int i,count=0,len;
		double percent;
		System.out.println("For checking the secret message just get 75% password right: ");
		System.out.println("Enter the password: ");
		checkpass = sc.next();
		len = pass.length();
		for(i=0;i<checkpass.length();i++)
		{
			if(checkpass.charAt(i)==pass.charAt(i))
			{
				count++;
			}
		}
		percent = (count*100)/len;
		if(percent>=75)
		{
			for(i=0;i<alpha.length;i++)
			{
				alpha[i]=(char) (alpha[i]-3);
			}
			System.out.println("You got the password: "+ percent + "% right");
			System.out.print(alpha);
			System.out.println(" is the message for you");
		}
		else
		{
			System.out.println("Try Again...Your message is "+percent+"% matched");
			check(alpha,pass);
		}
	}
	

	public static void main(String[] args) 
	{
		String str,pass;
		sc = new Scanner(System.in);
		System.out.println("Enter the sceret message: ");
		str = sc.next();
		System.out.println("Enter the password: ");
		pass = sc.next();
		Encryption ob = new Encryption();
		ob.cipher(str,pass);
		
	}

}
