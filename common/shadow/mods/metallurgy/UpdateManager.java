package shadow.mods.metallurgy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UpdateManager {
	public String version;
	public String latest;
	public String name;
	public String url;
	
	public UpdateManager(String version, String name, String url)
	{
		this.version = version;
		this.name = name;
		this.url = url;
		
		System.out.println("starting thread");
		Thread thread = new VersionCheckThread(this);
		thread.start();
		
		/*if(!isUpToDate())
		{
			MetallurgyCore.needsUpdate(name, latest);
		}*/
	}
	
	public boolean isUpToDate()
	{		
		String[] versionTokens = version.trim().split("\\.");
		String[] latestTokens = latest.trim().split("\\.");
		
		int num = Math.max(versionTokens.length, latestTokens.length);
		
		int v = 0;
		int l = 0;
		for(int n = 0; n < num; n++)
		{
			if(n > versionTokens.length - 1)
				v = 0;
			else
				v = Integer.valueOf(versionTokens[n]);

			if(n > latestTokens.length - 1)
				l = 0;
			else
				l = Integer.valueOf(latestTokens[n]);
			
			if(v < l)
				return false;
			if(v > l)
				return true;
		}
		return true;
	}
	
	private static class VersionCheckThread extends Thread {
		
		public UpdateManager um;
		
		public VersionCheckThread(UpdateManager um)
		{
			this.um = um;
		}
		
        @Override
        public void run() {
 
            try 
            {
                URL versionFile = new URL(um.url);
 
                BufferedReader reader = new BufferedReader(new InputStreamReader(versionFile.openStream()));
                um.latest = reader.readLine();
                reader.close();
 
                
                if (!um.isUpToDate()) {
                    //System.out.println("Metallurgy " + um.name + " Update Avaliable");
                    MetallurgyCore.updateNeeded.add(um.name);
                } else {
                    //System.out.println("Metallurgy " + um.name + " is up to date");
                }
                
 
            } catch (Exception e) {
                //System.out.println("Metallurgy " + um.name + ": Could not check version, reason " + e);
            }
 
            //VersionUtils.versionCheckComplete = true;
        }
    }
}
