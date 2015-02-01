package nl.raspen0.Materia.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIConfig implements IConfigureNEI{

	@Override
	public void loadConfig() {
        API.registerUsageHandler(new CrusherHandler());
        API.registerRecipeHandler(new CrusherHandler());
	}

	@Override
	public String getName() {
		return "materia_nei_plugin";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

}
