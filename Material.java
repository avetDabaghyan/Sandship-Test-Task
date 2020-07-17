

public class Material{
    String name;
    String desc; //description
    String icon;

    int cap;    //We can count the capacity here.
    int max_cap = 1;  //maximum capacity per warehouse.

    //int type_id; //Necessary for skipping 2nd lookup.

    Material(String type){  //The type input will be used for the name and icon.
        name = type;
        icon = type + "_icon.jpg";

        //Using different cases, create templates for each type.
        if(type == "iron"){
            desc = "This is iron, this is strong";
            max_cap = 200;

        } else if (type == "bolt"){
            desc = "This is bolt, dzgum enq sranov";
            max_cap = 500;

        } //etc etc
    }//end constructor

}//end class Material
