import java.io.*; // Imports of java 
import java.util.*;

public class CreateFile //Class
{
	public String getNucleotide(int random) // Chance generation 
	{
		switch(random) // the different cases
		{
		case 0: return "A"; 
		case 1: return "C";
		case 2: return "G";
		case 3: return "T";
		default : return "";
		}
	}
	
	public String Sequence(int length) // Generation of the sequences 
	{
		Random rd = new Random(); // Random generation
		if (length == 1) 
		{
			return getNucleotide(rd.nextInt(4)); // Recursion
		}
		else
		{
			return getNucleotide(rd.nextInt(4)) + Sequence(length - 1); // Invoke recursion
		}
	}
	
	public String getChromosome() // Visualize chromosome 
	{
		Random rd = new Random();
		return " chr " + (rd.nextInt(23)+1); // Chromosome 
	}
	
	public CreateFile(int j) // Creation of the file and terms
	{
		try 
		{
			FileWriter file = new FileWriter("sequences.txt"); //Creation file
			BufferedWriter bw = new BufferedWriter(file); // Write in the file
			
			Random rd = new Random(); // Random
			
			int length = rd.nextInt(50) + 1;
			int Start = rd.nextInt(1000) + 1;
			
			for (int i = 0; i < j; i++) // Generation string of the file
			{
				length = rd.nextInt(50) + 1;
				Start = rd.nextInt(1000) + 1;
				
				bw.write(Sequence(length) + "," + getChromosome() + "," 
				+ Start + "," + (Start + length) + "," + ""); // Get chromosome
			}
			bw.write(Sequence(length)+ "," + getChromosome()); // Invoke the get chromosome
		}
		catch (Exception ex) // Error block 
		{
			ex.printStackTrace(); // Error line 
		}
	}

	public static void main (String [] args) // Main
	{
		CreateFile cd = new CreateFile(1000); // Creation of the object
		SearchMotif sm = new SearchMotif(); // Called another class
		sm.getCombinations("", 5); // Chromosome combination 
		
		System.out.println(sm.max_ocurrences + " - " + sm.motif_winner); /*Print the most
		recurrence and the chain*/
	}
}