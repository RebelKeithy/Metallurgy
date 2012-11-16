package shadow.mods.metallurgy;

import java.util.Map;

import javax.swing.JOptionPane;

import cpw.mods.fml.relauncher.FMLRelaunchLog;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

public class Crasher implements IFMLLoadingPlugin
{
	@SuppressWarnings("null")
	public Crasher()
	{
		JOptionPane.showMessageDialog(
				null,
				"Do not put Metallurgy in the coremods folder, move it to the mods folder!",
				"Error",
				JOptionPane.INFORMATION_MESSAGE);
		FMLRelaunchLog.severe("Do NOT put Metallurgy in the coremods folder!");
		Object obj = null;
		obj.toString();
		
	}
	
	@Override
	public String[] getLibraryRequestClass() 
	{
		return null;
	}

	@Override
	public String[] getASMTransformerClass() 
	{
		return null;
	}

	@Override
	public String getModContainerClass() 
	{
		return null;
	}

	@Override
	public String getSetupClass() 
	{
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) 
	{
		
	}

}
