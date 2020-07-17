//Decided to use this as a default (static) property in Warehouse.

//----------------
//  The purpose of this class is to simply keep track of all the materials and their IDs.

//  By definition, this will be an array. Having a fixed size of possible material types
//lets me skip looking up the same material when trading between 2 warehouses.
public class MaterialsList{

    String[] list = {"iron", "bolt", "copper", "steel", "coal", "diamond"};

}//end class MaterialsList
