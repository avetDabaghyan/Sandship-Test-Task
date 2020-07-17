

public class Warehouse{

    //for unique warehouses. Unused for now!
    //Will be useful when we create a data structure for tracking all warehouses.
    //Could also be useful if warehouses have unique features (one has more max_cap than the others)
        //that would require changing max_cap from within each Material. Not a big deal, but the design could be different.
    String house_id;

    //Whenever the list of materials has to be updated, it should also be updated here.
    //(Or list_1 could be taken from another file.)
    //This list is important for keeping the ORDER of the materials.
    //and the order is important because saving it will let us skip 2nd look-up whenever trading in between 2 warehouses.
        //I didn't have time to do that.
    static String[] list_1 = {"iron", "bolt", "copper", "steel", "coal", "diamond"};

    Material[] list = initMaterials(list_1);

    //initialize Materials
    //With this, we convert the String listing of materials into a useable list of Materials.
    Material[] initMaterials(String[] list_1){
        Material[] list_2 = new Material[list_1.length];
        for(int i = 0; i < list_1.length; i++){
            //Creates a new Material, with type taken from list_1.
            list_2[i] = new Material(list_1[i]);
        }
        return list_2;
    }//end initMaterials


    Warehouse(int id){
        house_id = "house_" + Integer.toString(id);
        System.out.println("\nCreated a new warehouse - " + house_id + "\n");
    }//end constructor

    //Prints all materials. Names and capacities, current and max.
    void printMaterials(){
        System.out.println("Warehouse ID: " + house_id);
        for(Material mat : list){
            System.out.println(mat.name+"\t--- "+Integer.toString(mat.cap)+" / "+Integer.toString(mat.max_cap));
        }
        System.out.println("\n");
    }//end printMaterials


//--------------------------------------------------------------------
    Material findMaterial(String type){
        int i = 0;
        while(type != list[i].name){
            i++;
        }
        Material mat = list[i]; //extra step for readability
        return mat;
    }//end findMaterial

    // int transaction(String action, int amount, String type){
    //     //First, find the material type.
    //     Material mat = findMaterial(type);
    //     if(action == "add"){
    //
    //     }else if(action == "remove"){
    //
    //     }else if(action == "remove"){
    //
    //     }else if(action == "take"){
    //
    //     }
    // }//end transaction

    int addMaterials(int amount, String type){
        //First, find the material type.
        Material mat = findMaterial(type);
        //Then, add.
        mat.cap += amount;
        int remainder = 0;

        //If adding over the max capacity, save the remainder, then set it back to max cap.
        if(mat.max_cap < mat.cap){
            remainder = mat.cap - mat.max_cap;
            mat.cap = mat.max_cap;
        }

        //Notification if there is a remainder.
        if(remainder != 0){
            System.out.println("\tRemainder: " + Integer.toString(remainder));
        }
        //Return remainder, to use it during send and take methods.
        return remainder;
    }//end addMaterials

    int removeMaterials(int amount, String type){
        //First, find the material type.
        Material mat = findMaterial(type);
        //Then, subtract.

        if(mat.cap > amount){
            mat.cap -= amount;//deducted from warehouse.
        }else{ //If removing below the current capacity, change the amount to that capacity.
            amount = mat.cap;
            mat.cap = 0;
        }
        return amount;
    }//end int removeMaterials

//--------------------------------------------------------------------
    int sendMaterials(int amount, String type, Warehouse target){
        //we remove materials first, in case of running out.
        int package_1 = removeMaterials(amount, type);
        int remainder = target.addMaterials(package_1, type);
        return remainder;
    }//end sendMaterials


    int takeMaterials(int amount, String type, Warehouse target){
        int package_1 = target.removeMaterials(amount, type);
        int remainder = addMaterials(package_1, type);
        return 0;
    }//end takeMaterials


}//end class Warehouse
