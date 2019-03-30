
package mazeproject;

/**
 *
 * @author DEVON
 */
public class Maze
{
    //Attributes
    private int rows;//total number of rows
    private int columns;//total number of columns
    private char[][] maze;//the maze
    private int solutions;//number of solutions
    private int bx;//begining  x
    private int by;//beginning y
    private int ex;//exit x
    private int ey;//exit y
    public Maze(int r,int c, char m[][])
    {
        rows=r;
        columns=c;
        maze=m;
        solutions =0;
    }
    /** Finds the row and column for both the beginning and ending characters
     * @param marker the character being searched for
     */
    private void findStart(char marker)
    {
        int x=0, y=0;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if(maze[i][j] == marker)
                {
                    x=i;
                    y=j;
                }
            }
        }
        //if the character ar maze[i][j]== 'b', the bx and by are set 
        //to the x and y
        if(marker == 'b')//b is the character for enterance
        {
            bx=x;
            by=y;
            System.out.println(bx + "  " + by);
        }
        //if the character ar maze[i][j]== 'e', the ex and ey are set 
        //to the x and y
        else if(marker == 'e')//e is the character for exit
        {
            ex=x;
            ey=y;
            System.out.println(ex + "  aaa  " + ey);
        }
    }    
    /**
     * @param x
     * @param y
     * @return
     */
    public boolean checkRight(int x, int y)
    {
        //return !(x+1 >= rows || maze[x+1][y] == '1' ||maze[x+1][y]=='p');
        if(x+1 >= rows)return false;
        else if(maze[x+1][y]=='1')return false;
        else if(maze[x+1][y]=='p')return false;
        else return true;
    }
    public boolean checkUp(int x, int y)
    {
        //return !(y-1 < 0 || maze[x][y-1] == '1' ||maze[x][y-1]=='p');
        if(y+1 >= columns)return false;
        else if(maze[x][y+1]=='1')return false;
        else if(maze[x][y+1]=='p')return false;
        else return true;
    }
    public boolean checkLeft(int x, int y)
    {
        //return !(x-1 < 0 || maze[x-1][y] == '1' ||maze[x-1][y]=='p');
        if(x-1 < 0)return false;
        else if(maze[x-1][y]=='1')return false;
        else if(maze[x-1][y]=='p')return false;
        else return true;
    }    
    public boolean checkDown(int x, int y)
    {
        //return !(y+1 < 0 || maze[x][y+1] == '1' ||maze[x][y+1]=='p');
        if(y-1 < 0)return false;
        else if(maze[x][y-1]=='1')return false;
        else if(maze[x][y-1]=='p')return false;
        else return true;
    }
    public void path(int x, int y)
    {
        char holder = maze[x][y];
        if(maze[x][y] == 'p')
            maze[x][y]='1';
        
        maze[x][y]='p';
        //Recursive
        if(checkRight(x,y))
            path(x+1,y);
        if(checkUp(x,y))
            path(x,y+1);
        if (checkLeft(x,y))
            path(x-1,y);
        if(checkDown(x,y))
            path(x,y-1);
        if(x==ex && y==ey)
        {
            solutions++;
            print();
        }
        maze[x][y]=holder;
    }
    
    public void solve()
    {
        findStart('b');
        findStart('e');
        path(bx,by);
        
        
    }
    
    public void print()
    {
        System.out.println("Solution Number : " + solutions);
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                
                if((i==bx)&&(j==by))
                    System.out.print("b");
                else if((i==ex)&&(j==ey))
                    System.out.print("e");
                else
                   System.out.print(maze[i][j]); 
//                else if(maze[i][j]=='1')
//                    System.out.print('1');
//                else if(maze[i][j] == '0')
//                    System.out.print('0');
//                else
//                    System.out.print('p');
            }
            System.out.println();  
        }
    }
}
