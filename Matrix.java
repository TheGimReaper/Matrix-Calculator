public class Matrix
{
	int rows;
	int cols;
	float vals[];
	float matrix[][];

	/* Default constructor: greats a 2 x 2 matrix filled with 0s */
	public Matrix()
	{
		rows = 2;
		cols = 2;
		vals =  new float[4];
		matrix = new float[2][2];
	}
	
	/* Takes row dimension r, column dimension c, and an array of float values */
	public Matrix(int r, int c, float v[])
	{
		rows = r;
		cols = c;
		vals = v;
		matrix = new float[r][c];
	}
	
	/* Prints matrix in terminal  */
	public void printMatrix()
	{
		String ret = "";
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				ret = ret + matrix[i][j] + "\t";
			}
			// if(i + 1 != rows) ret += "\n";
			ret += "\n";
		}
		System.out.println(ret);
	}
		
	/*  If dimensions of the matrix matches the number of values, fills the matrix with the values. Otherwise, prints and error message */
	public void fillMatrix()
	{
		if(vals.length != rows * cols)
		{
			System.out.println("Number of values does not match matrix dimensions.");
			return;
		}
		else
		{
			for(int i = 0; i < rows; i++)
			{
				for(int j = 0; j < cols; j++)
				{
					matrix[i][j] = vals[rows * i + j];
				}
			}
		}
	}
	
	/* **Elementary Row Operations** */

	/* Switch row x with row y */
	public void switchRows(int x, int y)
	{
		for(int i = 0; i < cols; i++)
		{
			float temp = matrix[x][i];
			matrix[x][i] = matrix[y][i];
			matrix[y][i] = temp;
		}
	}
	
	/* Multiply row x by y */
	public void multiplyRow(int x, float y)
	{
		if(y == 0)
		{
			System.out.println("You must multiply by a non-zero number");
			return;
		}
		for(int i = 0; i < cols; i++)
		{
			matrix[x][i] *= y;
		}
	}

	/* Add product of z and row y to x */
	public void addRowMultiple(int x, int y, float z)
	{
		for(int i = 0; i < cols; i++)
		{
			matrix[x][i] = matrix[x][i] + z*matrix[y][i];
		}
	}

	public void rowEchelon()
	{
		for(int j = 0, i = 0; j < cols && i < rows; j++, i++)
		{
			int count = rows - 1;
			// Put 0 rows on the bottom of the matrix
			for(int k = i; k < rows; k++)
			{
				if(matrix[k][j] == 0)
				{
					while(matrix[count][j] == 0) count--;
					if(matrix[count][j] != 0 && count > k)
					{
						switchRows(k, count);
					}
				}
			}
			// Creates leading rows
			for(int k = i; k < rows && matrix[k][j] != 0; k++)
			{
				multiplyRow(k, (float)(Math.pow(matrix[k][j], -1)));
			}
			// Removes lower 1s
			for(int k = i + 1; k < rows && matrix[k][j] != 0; k++)
			{
				addRowMultiple(k, i, -1);
			}
		}
		
	}
		/*
		1 1 1
		2 0 0
		2 0 2
	
		1 1 1
		*/

	/* **Getter and Setter Methods** */
	public int getRows()
	{
		return rows;
	}

	public int getCols()
	{
		return cols;
	}

	public float[] getVals()
	{
		return vals;
	}

	public float[][] getMatrix()
	{
		return matrix;
	}

	public void setRows(int r)
	{
		rows = r;
	}

	public void setCols(int c)
	{
		cols = c;
	}

	public void setVals(float v[])
	{
		vals = v;
	}

	public void setMatrix(float m[][])
	{
		matrix = m;
	}

	public static void main(String args[])
	{
		float[] y = {0, 0, 0, 1, 0, 1, 2, 1, 1, 0, 0, 0};
		Matrix sand = new Matrix();
		Matrix witch = new Matrix(3, 4, y);
		witch.fillMatrix();
		sand.printMatrix();
		witch.printMatrix();
		witch.rowEchelon();
		witch.printMatrix();
		
	}
}
