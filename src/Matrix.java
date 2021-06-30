import java.util.Scanner;

public class Matrix {
    private final int rows;
    private final int columns;
    private int[][] matrix;
    Scanner input;

    Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new int[rows][columns];
        input = new Scanner(System.in);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    /*checks if the index entered is out of bounds */
    public boolean checkElementIndex(int rows, int columns) {
        return (rows < getRows() && columns < getColumns() &&
                rows >= 0 && columns >= 0);
    }


    public void setMatrixElement(int rows, int columns, int value) {
        if (checkElementIndex(rows, columns)) {
            matrix[rows][columns] = value;
        }
    }

    public int getMatrixElement(int rows, int columns) {
        if (checkElementIndex(rows, columns)) {
            return matrix[rows][columns];
        }
        return -1;
    }

    public void readMatrixElement() {
        for (int rows = 0; rows < getRows(); rows++) {
            for (int columns = 0; columns < getColumns(); columns++) {
                int value = input.nextInt();
                setMatrixElement(rows, columns, value);
            }
        }
    }
    /* some matrices operations can't be done unless the two matrices have the same size */
    public boolean checkMatrixSize(Matrix matrix2)
    {
        if(matrix2==null)
        {
            return false;
        }

        return (matrix2.getRows() == getRows() && matrix2.getColumns() == getColumns());
    }

    public void printMatrix(int[][] matrix) {
        for (int rows = 0; rows < getRows(); rows++) {
            System.out.print("|");
            for (int columns = 0; columns < getColumns(); columns++) {
                System.out.print(" " + getMatrixElement(rows,columns) + " ");
            }
            System.out.print("|\n");
        }
    }

    public String toString() {
        String s = "";

        for (int row = 0; row < getRows(); row++) {
            s += "|";

            for (int column = 0; column < getColumns(); column++) {
                s += (" " + matrix[row][column] + " ");
            }

            s += ("|\n");
        }

        return s;
    }

    //matrices operations

    //Two matrices operations

    //addition
    public Matrix add(Matrix matrix2)
    {
        Matrix additionMatrix=new Matrix(getRows(),getColumns());

        if(checkMatrixSize(matrix2))
        {
            for(int rows=0;rows<getRows();rows++)
            {
                for(int columns=0;columns<getColumns();columns++)
                {
                    int value=getMatrixElement(rows,columns)+matrix2.getMatrixElement(rows,columns);
                    additionMatrix.setMatrixElement(rows,columns,value);
                }//inner loop
            }//outer loop

            return additionMatrix;
        }//if
        return null;
    }

    //subtraction
    public Matrix subtract(Matrix matrix2)
    {
        Matrix additionMatrix=new Matrix(getRows(),getColumns());

        if(checkMatrixSize(matrix2))
        {
            for(int rows=0;rows<getRows();rows++)
            {
                for(int columns=0;columns<getColumns();columns++)
                {
                    int value=getMatrixElement(rows,columns)-matrix2.getMatrixElement(rows,columns);
                    additionMatrix.setMatrixElement(rows,columns,value);
                }//inner loop
            }//outer loop

            return additionMatrix;
        }//if
        return null;
    }

    //multiplication
    public Matrix multiplication(Matrix matrix2)
    {
        Matrix multiplicationMatrix=new Matrix(getRows(),matrix2.getColumns());
        int sum=0;
        if(getColumns()==matrix2.getRows())//matrix columns should equal matrix2 rows
        {
            for(int m2columns=0;m2columns<matrix2.getColumns();m2columns++)//matrix2 columns
            {
                for(int m1rows=0;m1rows<getRows();m1rows++)//matrix rows
                {
                    for(int z=0;z<getColumns();z++)//matrix columns and matrix2 rows
                    {
                        sum+=matrix[m1rows][z] * matrix2.getMatrixElement(z,m2columns);
                    }
                    multiplicationMatrix.setMatrixElement(m1rows,m2columns,sum);
                    sum=0;
                }
            }

            return multiplicationMatrix;
        }
        return null;
    }

    //one matrix operations

    //scalar multiplication
    public int[][] scalarMultiplication(int value)
    {

        for (int rows=0;rows<getRows();rows++)
        {
            for (int columns=0;columns<getColumns();columns++)
            {
                setMatrixElement(rows , columns ,getMatrixElement(rows,columns)*value);
            }
        }
        return getMatrix();
    }

    //transpose
    public Matrix transpose()
    {
        Matrix matrix2=new Matrix(getColumns(),getRows());

        for(int rows=0;rows<getRows();rows++)
        {
            for(int columns=0;columns<getColumns();columns++)
            {
                matrix2.setMatrixElement(columns,rows,getMatrixElement(rows,columns));
            }
        }
        return matrix2;
    }

    //trace  /  sum of the diagonal elements
    public int trace()
    {
        if(getRows()==getColumns())
        {
            int sum = 0;
            for (int rowsAndColumns = 0; rowsAndColumns < getRows(); rowsAndColumns++) {
                getMatrixElement(rowsAndColumns, rowsAndColumns);
                sum += getMatrixElement(rowsAndColumns, rowsAndColumns);
            }

            return sum;
        }
        return -1;
    }

    //power of matrix
    public int[][] power(int power)
    {
        Matrix duplicate=new Matrix(getRows(),getColumns());
        Matrix powerMatrix=new Matrix(getRows(),getColumns());

        for(int rows=0;rows<getRows();rows++)//setting values to the elements in duplicate and power matrices
        {
            for(int columns=0;columns<getColumns();columns++)
            {
                duplicate.setMatrixElement(rows,columns,getMatrixElement(rows,columns));
                powerMatrix.setMatrixElement(rows,columns,getMatrixElement(rows,columns));

            }
        }
        if(getRows()==getColumns()) //in order to multiply a matrix by itself it should be a square matrix
        {
            int sum=0;

            for(int x=0;x<power-1;x++)//power
            {
                //multiplication
                for(int columns=0;columns< duplicate.getColumns();columns++)//duplicate columns
                {
                    for(int rows=0;rows<getRows();rows++)//matrix rows
                    {
                        for(int z=0;z<getColumns();z++)//matrix columns and duplicate rows
                        {
                            sum+=matrix[rows][z]*duplicate.matrix[z][columns];
                        }
                        powerMatrix.matrix[rows][columns] = sum;
                        sum=0;
                    }
                }
                //setting matrix elements after the multiplication
                for(int rows=0;rows<getRows();rows++)
                {
                    for(int columns=0;columns<getColumns();columns++)
                    {
                        matrix[rows][columns]=powerMatrix.matrix[rows][columns];
                    }
                }
            }//power loop
            return matrix;
        } //if
        return null;

    }
    
}
