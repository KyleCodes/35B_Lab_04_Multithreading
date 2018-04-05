package driver;

import adapter.*;
import model.Automobile;
import scale.EditOptionSets;
import scale.EditOptions;
import scale.PrintUpdate;

public class Driver {
	public static void main(String[] args) {		
		/*
		 * load car from file 
		 * 
		 * grab metadata
		 * 
		 * add choices to the LHM database
		 * 
		 * edit the database using multithreading
		 */
		
		/////////////////////////////////////////
		// LOOKUP / CHANGE VARIABLES
		String modelName = "ford_focus_wgn_ztw_2010";			// FOR LOADING FILE
		String fileName = modelName + ".txt";
		String name = "Kyle Muldoon";

		/////////////////////////////////////////
		// CREATEAUTO
		CreateAuto a1 = new BuildAuto();						// INSTANTIATE AUTOMOBILE
		a1.buildAuto(fileName);
		//a1.printAuto(modelName);
		
		/////////////////////////////////////////
		// CHOOSEAUTO
		ChooseAuto a2 = new BuildAuto();						// GET MAKE MODEL YEAR
		a2.setOwner(name);
		String MMY = a2.getMakeModelYear();
		
		/////////////////////////////////////////
		// DATABASEAUTO
		DataBaseAuto a3 = new BuildAuto();					// PRINT CARS IN LHM
		a3.addAuto(MMY, name);
		System.out.println("=========================================");
		System.out.println("");
		System.out.println("\t DATABASE LIST:");
		System.out.println("");
		a3.printList();
		
		/////////////////////////////////////////
		// MULTITHREADING
		EditOptions edit = new EditOptions("Black", 50, "Color", "Infra-Red Clearcoat", a3.retrieveAuto(MMY));
		PrintUpdate up = new PrintUpdate(a3.retrieveAuto(MMY));
		EditOptionSets edit2 = new EditOptionSets("Paint", "Color", a3.retrieveAuto(MMY));
		
		MultiThreadUpdate a4 = new BuildAuto();
		a4.printUpdate(a3.retrieveAuto(MMY));
		a4.editOptionSets("Color", "Paint", a3.retrieveAuto(MMY));
		a4.editOptions("Black", 50, "Color", "Infra-Red Clearcoat", a3.retrieveAuto(MMY));

	}
}
