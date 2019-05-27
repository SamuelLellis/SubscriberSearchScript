 import java.net.*;
 import java.io.*;

public class SearchSub{
	/*
		This was meant as a fun little practice to engage with writing code that engages with data that can be found on the internet.
		I figured I would write a little script that would return how many subscribers a Youtube content creator based on the updated 
		information that can be found on SocialBlade. First the user enters the name of the Youtuber's channel, which is then appended 
		to the Social Blade Url to direct the program right to that Youtuber's SocialBlade page. Then the page is read down, all the while
		being converted from HTML till it comes to that person's subsriber count. It is then recorded and printed. There is exception handling 
		if the user does not enter correct credentials or no credentials, which might involve some research on the person's behalf. However if they 
		have to do research then they might as well just look up the person's subscribers themself, so this needs to be improved to allow versatility 
		to have any viable time saving usage. But for now just a fun little afternoon coding experience.
	
	
	*/
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
