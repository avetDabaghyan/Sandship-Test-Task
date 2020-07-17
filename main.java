

public class main{
    public static void main(String[] args) {

        Warehouse house0 = new Warehouse(0);
        house0.addMaterials(80, "iron");
        house0.printMaterials();

        Warehouse house1 = new Warehouse(1);
        house1.addMaterials(110, "iron");
        house1.removeMaterials(100, "iron");
        // house1.removeMaterials(100, "iron");
        house1.printMaterials();

        // house0.sendMaterials(50, "iron", house1);
        // house0.printMaterials();
        // house1.printMaterials();

        house0.takeMaterials(20, "iron", house1);
        house0.printMaterials();
        house1.printMaterials();
    }
}
