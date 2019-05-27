 import java.net.*;
 import java.io.*;

public class SearchSub{
	public static void main(String [] args){
		try{
			String name = args[0];
			URL url = new URL("https://socialblade.com/youtube/user/" + args[0]);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			String cleanLine;
			while((line = reader.readLine()) != null){
				cleanLine=line.replaceAll("\\<.*?\\>", "");
				if (cleanLine.contains("Subscribers")){
					String veryClose = reader.readLine();
					String finalClean = veryClose.replaceAll("\\<.*?\\>", "");
					System.out.println(name +" has " + finalClean + " subscribers!");
					break;
				}
			}
		}
		catch(Exception err){
			System.out.println("Hmm that wasn't quite right. Make sure you entered valid credentials and retry");
			System.out.println("Remember! Some youtuber's actual handles are different than what can appear\n on their Youtube Channel!");
		}
	}
}
