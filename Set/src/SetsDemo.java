import java.util.*;
public class SetsDemo {
    public static void main(String[] args){
        Scanner input =new Scanner (System.in);
        int numOfSets;
        Sets set1=null;
        Sets set2 = null;

        System.out.println("Would you like to enter 1 or 2 sets");
        numOfSets=input.nextInt();

        //setting size of the set
        if(numOfSets==1){
            System.out.println("Enter the size of the set");
            int size= input.nextInt();
            set1=new Sets(size);
        }
        else if(numOfSets==2){
            System.out.println("Enter the size of the first set");
            int size= input.nextInt();
            set1=new Sets(size);
            System.out.println("Enter the size of the second set");
            size=input.nextInt();
            set2=new Sets(size);
        }
        else
            return ;

        //setting elements of the set
        if(numOfSets==1){
            System.out.println("Enter the elements of the set");
            set1.setSet();
        }
        else{
            System.out.println("Enter the elements of the first set");
            set1.setSet();
            System.out.println("Enter the elements of the second set");
            set2.setSet();
        }

        //choosing operation
        Menu menu=new Menu(set1,set2,numOfSets);
        menu.getMenu();//*/
    }
}
