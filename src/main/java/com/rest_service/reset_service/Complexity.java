import java.io.*;
import java.util.*;


class CyclomaticComplexity {

	
	public int check() {
		int complexity = 1;
		String[] keywords = {"for","switch","continue","break","if","else","do","while","case","catch","finally","throw","throws","default","return","&&","||","?",":","catch",};
		String words = "";
		String fileName;
		String line = null;
		
		try {
			fileName = "GetFiles.java";
			BufferedReader br = new BufferedReader(fr);			
			FileReader fr = new FileReader(fileName);
			line = br.readLine();
			
			while (line != null)
			{
				StringTokenizer stTer = new StringTokenizer(line);
				while (stTer.hasMoreTokens())
				{
					words = stTer.nextToken();
					
					for(int i=0; i<keywords.length; i++)
					{
						if (keywords[i].equals(words))
						{
							complexity++;
						}
					}
				}
				line = br.readLine();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return (complexity);
	}

	public void showCyclomaticComplexity(int ccValue) {
		System.out.println("\nCyclomatic Complexity is : "+ccValue);
		System.out.print("\nResult : ");
		if (ccValue> 50){
			System.out.print("Most complex");
		}
		else if(ccValue>= 21 && ccValue<=50)
			System.out.print("High risk");
		else if(ccValue>= 11 && ccValue<=20)
			System.out.print("Modest risk");
		else
			System.out.print("Low risk");
	}
	
	public static void main(String ss[])
	{
		CyclomaticComplexity cc = new CyclomaticComplexity();
		cc.showCyclomaticComplexity(cc.check());
	}
}