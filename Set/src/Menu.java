import java.util.*;
public class Menu {

    private Scanner input=new Scanner(System.in);
    private int numOfSets;
    private Sets set1;
    private Sets set2;
    Menu(Sets set1,Sets set2,int numOFSets){
        this.numOfSets=numOFSets;
        this.set1=new Sets(set1.getNumOfELements());
        set1.duplicateSetElemnts(this.set1);

        this.set2=new Sets(set2.getNumOfELements());
        set2.duplicateSetElemnts(this.set2);
    }

    void getMenu() {
        boolean repeat=true;
        while(repeat){
        System.out.println("Enter the number of the operation");
        int operation = 0;
        if (numOfSets == 1) {
            System.out.println("1 : Cardinality");
        } else {
            System.out.println("1 : Cartesian Product");
            System.out.println("2 : Union");
            System.out.println("3 : Intersection");
            System.out.println("4 : Difference");
            System.out.println("5 : Cardinality of the union of two sets");
            System.out.println("6 : Symmetric Difference");
        }
        System.out.println("0 : exit");
        operation = input.nextInt();


        switch (operation) {
            case 1:
                if (numOfSets == 1)
                    System.out.println("Cardinalitiy = " + set1.getCardinality());
                else {
                    System.out.println("Cartesian Product : ");
                    set1.printCartesianProduct(set1.getCartesianProduct(set2));
                }
                break;
            case 2:
                System.out.println("Union : ");
                set1.printSet(set1.getUnion(set2));
                break;
            case 3:
                System.out.println("Intersection : ");
                set1.printSet(set1.getIntersiction(set2));
                break;
            case 4:
                System.out.println("Difference : ");
                set1.printSet(set1.getDifference(set2));
                break;
            case 5:
                System.out.println("Cardinality of the union of two sets : ");
                System.out.println(set1.getCardinalityOfTheUnionOfTwoSets(set2));
                break;
            case 6:
                System.out.println("Symmetric Difference");
                set1.printSet(set1.getSymmetricDifference(set2));
                break;
            case 0:
                repeat=false;
                break;
            default:
                System.out.println("Invalid option");

            }
        }
    }
}
