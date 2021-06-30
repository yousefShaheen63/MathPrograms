import java.util.Scanner;
public class MatrixDemo {

    static public int oneMatricesOperations()
    {
        Scanner input=new Scanner(System.in);

        System.out.println("Choose an operation : ");
        System.out.println("1 : Scalar Multiplication");
        System.out.println("2 : Transpose");
        System.out.println("3 : Trace");
        System.out.println("4 : Power");

        int operation;
        operation = input.nextInt();

        return operation;
    }
    static public int twoMatricesOperations()
    {
        Scanner input=new Scanner(System.in);

        System.out.println("Choose an operation : ");
        System.out.println("1 : Addition");
        System.out.println("2 : Subtraction");
        System.out.println("3 : Multiplication");

        int operation;
        operation = input.nextInt();

        return operation;
    }


    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        Matrix m1;
        Matrix m2;
        int rows1=0,rows2=0,columns1=0,columns2=0;

        System.out.println("How many matrices would you like to enter : 1 or 2");
        int numOfMatrices;
        numOfMatrices=input.nextInt();

        //reading the matrices sizes
        switch(numOfMatrices)
        {
            case 1:
                System.out.println("Enter the rows : ");
                rows1=input.nextInt();
                System.out.println("Enter the number of columns : ");
                columns1=input.nextInt();
                m1=new Matrix(rows1,columns1);
                m2=new Matrix(rows2,columns2);
                break;
            case 2:
                System.out.println("Enter the number of rows for the first matrix");
                rows1=input.nextInt();
                System.out.println("Enter the number of columns for the first matrix");
                columns1=input.nextInt();
                m1=new Matrix(rows1,columns1);

                System.out.println("Enter the number of rows for the second matrix");
                rows2=input.nextInt();
                System.out.println("Enter the number of columns for the second matrix");
                columns2=input.nextInt();
                m2=new Matrix(rows2,columns2);
                break;
            default:
                System.out.println("Invalid option");
                m1=new Matrix(rows1,columns1);
                m2=new Matrix(rows2,columns2);
        }//switch

        //the smallest possible size of a matrix is 1x1
        if(m1.getRows()<=0||m1.getColumns()<=0){
            System.out.println("Invalid size");
            System.exit(0);}
        if(m2.getRows()<=0||m2.getColumns()<=0){
            m2=null;}

        //reading the elements of the matrices
        System.out.println("Give values for the elements in the matrix : ");
        m1.readMatrixElement();
        if(m2!=null)
        {
            System.out.println("Give values for the elements in the second matrix : ");
            m2.readMatrixElement();
        }

        //printing the matrices
        System.out.println("A = ");
        System.out.print(m1);
        if(m2!=null)
        {
            System.out.println("B = ");
            System.out.print(m2);
        }

        //choosing one of the available operations
        if (m2 == null) {
            switch (oneMatricesOperations()) {
                case 1:
                    int multiplication;
                    System.out.println("Enter the number you'd like to multiply the matrix with");
                    multiplication = input.nextInt();
                    m1.printMatrix(m1.scalarMultiplication(multiplication));
                    break;
                case 2:
                    System.out.println(m1.transpose());
                    break;
                case 3:
                    System.out.println("The sum of the elements in the diagonal : "+ m1.trace());
                    break;
                case 4:
                    System.out.println("Enter the power you'd like to apply on the matrix");
                    int power;
                    power = input.nextInt();
                    m1.printMatrix(m1.power(power));
                    break;
                default:
                    System.out.println("Invalid option");
            }//switch


        }//if
        else
        {
            switch (twoMatricesOperations()) {
                case 1:
                    System.out.println(m1.add(m2));
                    break;
                case 2:
                    System.out.println(m1.subtract(m2));
                    break;
                case 3:
                    System.out.println(m1.multiplication(m2));
                    break;
                default:
                    System.out.println("Invalid option");

            }//switch
        }//else



    }

    }
