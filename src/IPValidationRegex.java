import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class IPValidationRegex 
{

	public static void main(String[] args) throws IOException 
	{
		
		// Read the file containing IP addresses
		
		File actualFile = new File("C:\\Users\\noman\\Desktop\\IPAddresses.txt.txt");
		BufferedReader in = new BufferedReader(new FileReader(actualFile));
		
		
		// Construct a new file which will be later renamed to original 
		
		File tempFile = new File("C:\\Users\\noman\\Desktop\\IPtemp.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

		String line;
		while((line = in.readLine()) != null)
		{
            if (line.matches(new checkIP().pattern))
            {
			pw.println(line);
            pw.flush();
            }
		}
		in.close();
        pw.close();
        
        // Delete the original file
        if (!actualFile.delete()) {
            System.out.println("Could not delete file");
            return;
        }

        // Rename the new file to the filename the original file had.
        if (!tempFile.renameTo(actualFile))
            System.out.println("Could not rename file");    

	} 
	
}

class checkIP 
{
	public String pattern = "\\b(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b";
}