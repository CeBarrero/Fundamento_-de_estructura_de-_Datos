import java.io.*; // Imports of java 

public class SearchMotif // Class
{
	public int max_ocurrences = Integer.MIN_VALUE; // Greater occurrences
	public String motif_winner= ""; // Winning sequence
	
	public int countOcurrences(String motif_candidate) // Occurrence counter
	{
		int counter = 0; //Start at 0
		
		try
		{
			FileReader file = new FileReader("sequences.txt"); //Creation file 
			BufferedReader br = new BufferedReader(file); // Reading the file
			
			String sequence = br.readLine(); 
			int length = motif_candidate.length(); // Number of candidates in the motif
			
			while(sequence != null) //Number of time that will be repeated 
			{
				for (int i = 0; i < sequence.length() - length + 1; i++) /* Times that the
					sequence will be repeated*/
				{
					if (sequence.subSequence(i, i + length).equals(motif_candidate))
						// It is repeated as long as it meets the conditions
					{
						counter += 1; // Counter increases by 1
						i += length - 1; // Decrease 1 along the sequence
					}
				}
				sequence = br.readLine();				
			}
		}
		catch (Exception ex) // Error block 
		{
			ex.printStackTrace(); // Error line 
		}
		return counter; // Returns the counter
	}
	
	public void verifyCandidate(String motif) // Candidate verification
	{
		int temp = countOcurrences(motif);
		if (temp > max_ocurrences)
		{
			this.motif_winner = motif;
			this.max_ocurrences = temp;
		}
	}
	
	public void getCombinations(String sebsequence, int size) // Combinations options 
	{
		String tempSequenece;
		
		if (size == 1) // It is repeated as long as it meets the conditions
		{
			tempSequenece = sebsequence + "A"; // Candidate	
			verifyCandidate(tempSequenece);
			
			tempSequenece = sebsequence + "C"; // Candidate
			verifyCandidate(tempSequenece);
			
			tempSequenece = sebsequence + "G"; // Candidate 
			verifyCandidate(tempSequenece);
			
			tempSequenece = sebsequence + "T"; // Candidate
			verifyCandidate(tempSequenece);
		}
		else
		{
			getCombinations(sebsequence + "A", size - 1); 
			// The sequence is finishes and it removed 1
			getCombinations(sebsequence + "C", size - 1);
			// The sequence is finishes and it removed 1
			getCombinations(sebsequence + "G", size - 1);
			// The sequence is finishes and it removed 1
			getCombinations(sebsequence + "T", size - 1);
			// The sequence is finishes and it removed 1
		}
	}
}