public class Matrix
{
	int rows;
	int cols;
	int vals[];
	int matrix[][];
	public Matrix()
	{
		rows = 2;
		cols = 2;
		vals =  new int[4];
		matrix = new int[2][2];
	}
	
	public Matrix(int r, int c, int v[])
	{
		rows = r;
		cols = c;
		vals = v;
		matrix = new int[r][c];
	}
	
	public void printMatrix()
	{
		String ret = "";
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				ret = ret + matrix[i][j] + "\t";
			}
			if(i + 1 != rows) ret += "\n";
		}
		System.out.println(ret);
	}

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

	public int getRows()
	{
		return rows;
	}

	public int getCols()
	{
		return cols;
	}

	public int[] getVals()
	{
		return vals;
	}

	public int[][] getMatrix()
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

	public void setVals(int v[])
	{
		vals = v;
	}

	public void setMatrix(int m[][])
	{
		matrix = m;
	}

	public static void main(String args[])
	{
		int[] y = {1, 2, 3, 4};
		Matrix sand = new Matrix();
		Matrix witch = new Matrix(2, 2, y);
		witch.fillMatrix();
		sand.printMatrix();
		witch.printMatrix();
		
	}
}
