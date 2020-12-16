/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc104proj;

/**
 *
 * @author Mark Gregor Miguel
 */
import java.util.LinkedList;
import java.util.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FindNearestTaxi {
    public static BuildingBlock findTaxi(int [][] buildings, int start_row, int start_col) {
        int distance = 0;

        if (buildings[start_row][start_col] == 1) {
            return new BuildingBlock(start_row,start_col,distance);
        }
        int length = buildings.length;

        
        boolean[][] visited = new boolean[length][length];
        visited[start_row][start_col] = true;
       
        Queue<BuildingBlock> queue = new LinkedList<>();
        
        BuildingBlock buildingBlock = new BuildingBlock(start_row,start_col,distance);
       
        queue.add(buildingBlock);

        while (queue.isEmpty() == false) {
            BuildingBlock BB = queue.poll();
            int row = BB.row;
            int col = BB.col;
            int dist = BB.distance;
            dist = dist + 1;
           

            //go up
            int dest_row = row - 1;
            int dest_col = col;
            if (dest_col >= 0 && dest_col < length
                    && dest_row >= 0 && dest_row < length && !visited[dest_row][dest_col]) {
               
                BuildingBlock b1 = new BuildingBlock(dest_row,dest_col,dist);
                if (buildings[dest_row][dest_col] == 1)
                    return b1;
                queue.add(b1);
                visited[dest_row][dest_col] = true;
            }
          
            dest_row = row + 1;
            dest_col = col;
            
            if (dest_col >= 0 && dest_col < length
                    && dest_row >= 0 && dest_row < length && !visited[dest_row][dest_col]) {
                
                BuildingBlock b1 = new BuildingBlock(dest_row,dest_col,dist);
                if (buildings[dest_row][dest_col] == 1)
                    return b1;
                queue.add(b1);
                visited[dest_row][dest_col] = true;
            }
           
            dest_row = row;
            dest_col = col - 1;
            if (dest_col >= 0 && dest_col < length
                    && dest_row >= 0 && dest_row < length && !visited[dest_row][dest_col]) {
                
                BuildingBlock b1 = new BuildingBlock(dest_row,dest_col,dist);
                if (buildings[dest_row][dest_col] == 1)
                    return b1;
                queue.add(b1);
                visited[dest_row][dest_col] = true;
            }
           
            dest_row = row;
            dest_col = col + 1;
            if (dest_col >= 0 && dest_col < length
                    && dest_row >= 0 && dest_row < length && !visited[dest_row][dest_col]) {
                
                BuildingBlock b1 = new BuildingBlock(dest_row,dest_col,dist);
                if (buildings[dest_row][dest_col] == 1)
                    return b1;
                queue.add(b1);
                visited[dest_row][dest_col] = true;
            }
        }
       
        return null;
    }

    public static void main(String[] args) {
        int [][] buildings = {  {0, 0, 1, 0, 0},
                                {0, 0, 0, 0, 0},
                                {1, 0, 0, 0, 0},
                                {0, 0, 0, 0, 1},
                                {1, 0, 1, 0, 0}
                             };
        int start_building_row = 1;
        int start_building_col = 3;
        BuildingBlock result = findTaxi(buildings, start_building_row, start_building_col);
        if(result!=null) {
            int distance = result.distance;
            int dest_row = result.row;
            int dest_col = result.col;
            String buildingNo = start_building_row + "," + start_building_col;
            String destinationBuilding = dest_row + "," + dest_col;
            System.out.println("Source building No: " + buildingNo +"\n Nearest building " +
                    "where taxi is available is: "+ destinationBuilding + "\n" +
                    " at distance: " + distance);
        }else{
            System.out.println("No taxi is present in the any community");
        }
    }
}
