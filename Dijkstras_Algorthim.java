package dijkstras_algorthim;

import java.util.Scanner;

//package dijkstras_algorthim;

public class Dijkstras_Algorthim 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        
        int [][] Graph = new int [5][5];//ammount of nodes
        int [] distance = new int [5];
        int [] visited = new int [5];
        int [] preD = new int [5];
        int min;
        int next=0;
        
        System.out.println("Enter numbers for the graph");
        
        for (int i =0; i<5; i++)
        {
            visited[i] =0;
            
            preD[i] =0;
            for (int j =0; j<5; j++)
            {
                Graph[i][j] = scan.nextInt();
                
                if (Graph[i][j]==0)
                {
                Graph[i][j] = 999;
                }
            }
        }
        distance = Graph[0];
        distance[0] = 0;
        visited [0] = 1;
        
        for (int i =0; i< 5; i++ )
        {
            min = 999;
            
            for (int j = 0; j<5; j++)
            {
                if (min > distance[j] && visited [j] !=1)
                {
                    min = distance[j];
                    next =j;
                }
                
            }
            
            visited[next] =1;
            
            for (int c =0; c< 5; c++)
            {
                if (visited [c]!=1)
                {
                    if (min+Graph [next] [c] < distance[c] )
                    {
                        distance[c] = min+Graph [next] [c];
                        preD [c] = next;
                    }
                }
            } 
        }
        
        // path finding for the algrthim 
        
        for (int i =0; i< 5; i++)
        {
            System.out.print("| " + distance[i]);
            
        }
        System.out.print("| \n");
        
        for (int i = 0; i<5; i++)
        {
            int j;
            
           System.out.print("Path =" + i);
           
           j=i;// j now has i's node
           
           do 
           {
               j= preD[j];
               System.out.print("<-" +j);
           }while (j!=0);
           
           System.out.println("");
        }
        
        
    }
    
}