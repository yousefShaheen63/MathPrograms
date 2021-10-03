import java.util.*;
public class Sets {

    private Scanner input=new Scanner(System.in);
    private int numOfELements;
    private int[] set;

   Sets(int numOfElements){
       this.numOfELements=numOfElements;
        set=new int[numOfElements];
    }

    int[] getSet(){
       return set;
    }

    void setSet(){
       for(int i=0;i<getCardinality();i++){
           getSet()[i]=input.nextInt();
       }
    }

    int getNumOfELements(){
       return numOfELements;
    }

    void printSet(Sets set){
        System.out.print("(");
       for(int i=0;i<set.getCardinality();i++){
           System.out.print(set.getSet()[i]);
           if(i!=set.getCardinality()-1) //so there wouldn't be a column after the last element
               System.out.print(" , ");
       }
        System.out.println(")");

    }
    //print cartesian product
    void printCartesianProduct(Pair []pair){
        System.out.print("{ ");
        for(int i=0;i< pair.length;i++){
            System.out.print(pair[i]);
            if(i!=pair.length-1)//so there wouldn't be a column after the last bracket
                System.out.print(",");
        }
        System.out.println("}");
    }

    //for menu class
    void duplicateSetElemnts(Sets set){
       for(int i=0;i<set.getCardinality();i++){
           set.getSet()[i]=getSet()[i];
       }
    }

    ///////////////////set operations///////////////////

    //cardinality
    int getCardinality(){
        return set.length;
    }

    //cartesian product
    Pair[] getCartesianProduct(Sets set) {
        Pair[] result = new Pair[getCardinality()*set.getCardinality()];
        int resultIndex = 0;

        for(int i=0;i<getCardinality();i++){
            for(int j=0;j<set.getCardinality();j++){
                Pair pair=new Pair(getSet()[i],set.getSet()[j]);
                result[resultIndex]=pair;
                resultIndex++;
            }
        }

        return result;
    }

    //union
    Sets getUnion(Sets set){
        //setting the result size
        int resultSize=getCardinality()+set.getCardinality();
        for(int i=0;i<getCardinality();i++){
            for(int j=0;j<set.getCardinality();j++){
                if(getSet()[i]==set.getSet()[j])
                    resultSize--;
            }
        }
        Sets result =new Sets(resultSize);

        //setting the result elements
        for(int i=0;i<getCardinality();i++){
            result.getSet()[i]=getSet()[i];
        }

        int x=getCardinality();
        int check=0;
        for(int i=0;i<set.getCardinality();i++){
            for(int j=0;j<getCardinality();j++){
                if(set.getSet()[i]==getSet()[j]){
                    check++;
                }//if
            }//inner loop
            if(check==0){
                result.getSet()[x]=set.getSet()[i];
                x++;
            }
            check=0;
        }//outer loop
        Arrays.sort(result.getSet());

        return result;
    }

    //intersection
    Sets getIntersiction(Sets set){
        //setting the result size
        int resultSize=0;
        for(int i=0;i<getCardinality();i++){
            for(int j=0;j<set.getCardinality();j++){
                if(getSet()[i]==set.getSet()[j])
                    resultSize++;
            }
        }
        Sets result=new Sets (resultSize);

        //setting result elements
        int resultIndex=0;
        for(int i=0;i<getCardinality();i++){
            for(int j=0;j<set.getCardinality();j++){
                if(getSet()[i]==set.getSet()[j]){
                    result.getSet()[resultIndex]=getSet()[i];
                    resultIndex++;
                }//if
            }//inner loop
        }//outer loop

        Arrays.sort(result.getSet());
        return result;
    }

    //difference
    Sets getDifference(Sets set){
        //setting the result size
        int resultSize=getCardinality();
        for(int i=0;i<getCardinality();i++){
            for(int j=0;j<set.getCardinality();j++){
                if(getSet()[i]==set.getSet()[j])
                    resultSize--;
            }
        }
        Sets result=new Sets(resultSize);

        //setting result elements
        int resultIndex=0;
        int check=0;
        for(int i=0;i<getCardinality();i++){
            for(int j=0;j<set.getCardinality();j++){
                if(getSet()[i]==set.getSet()[j]){
                    check++;
                }//if
            }//inner loop
            if(check==0){
                result.getSet()[resultIndex]=getSet()[i];
                resultIndex++;
            }
            check=0;
        }//outer loop

        Arrays.sort(result.getSet());
        return result;
    }

    //cardinality of the union of two sets
    int getCardinalityOfTheUnionOfTwoSets(Sets set){
       return getUnion(set).getCardinality();
    }

    //symmetric difference
    Sets getSymmetricDifference(Sets set){
        //setting the result size
        int resultSize=getCardinality()+set.getCardinality();
        for(int i=0;i<getCardinality();i++){
            for(int j=0;j<set.getCardinality();j++){
                if(getSet()[i]==set.getSet()[j])
                    resultSize-=2;
            }
        }
        Sets result=new Sets(resultSize);

        //setting result elements
        boolean check=true;
        int resultIndex=0;
        for(int i=0;i<getCardinality();i++){
            for(int j=0;j<set.getCardinality();j++){
                if(getSet()[i]==set.getSet()[j])
                    check=false;
            }//inner loop
            if(check){
                result.getSet()[resultIndex]=getSet()[i];
                resultIndex++;
            }
            check=true;
        }//outer loop

        for(int i=0;i<set.getCardinality();i++){
            for(int j=0;j<getCardinality();j++){
                if(set.getSet()[i]==getSet()[j])
                    check=false;
            }//inner loop
            if(check){
                result.getSet()[resultIndex]=set.getSet()[i];
                resultIndex++;
            }
            check=true;
        }//outer loop

        Arrays.sort(result.getSet());
        return result;
    }


}
