

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class Graph 
{
 public Node rootNode;
 public ArrayList nodes = new ArrayList();
 public int[][] adjMatrix;//Edges will be represented as adjacency Matrix
 int size;

 public ArrayList childArray = new ArrayList();

 public void setRootNode(Node n)
 {
  this.rootNode = n;
 }

 public Node getRootNode()
 {
  return this.rootNode;
 }

 public void addNode(Node n)
 {
  nodes.add(n);
 }

 //This method will be called to make connect two nodes
 public void connectNode(Node start,Node end)
 {
  if(adjMatrix == null)
  {
   size = nodes.size();
   adjMatrix = new int[size][size];
  }

  int startIndex = nodes.indexOf(start);
  int endIndex = nodes.indexOf(end);
  adjMatrix[startIndex][endIndex] = 1;
  adjMatrix[endIndex][startIndex] = 1;
 }

 private Node getUnvisitedChildNode(Node n)
 {

  int index=nodes.indexOf(n);
  int j=0;
  while(j<size)
  {
   if(adjMatrix[index][j]==1 && ((Node)nodes.get(j)).visited==false)
   {
    return (Node)nodes.get(j);
   }
   j++;
  }
  return null;
 }

 //BFS traversal of a tree is performed by the bfs() function
 public void bfs()
 {

  //BFS uses Queue data structure
  Queue q=new LinkedList();
  q.add(this.rootNode);
  printNode(this.rootNode);
  rootNode.visited=true;
  while(!q.isEmpty())
  {
   Node n=(Node)q.remove();
   Node child=null;
   while((child=getUnvisitedChildNode(n))!=null)
   {
    child.visited=true;
    printNode(child);
    q.add(child);
   }
  }
  //Clear visited property of nodes
  clearNodes();
 }

 //DFS traversal of a tree is performed by the dfs() function
 public void dfs()
 {
  //DFS uses Stack data structure
  Stack s=new Stack();
  s.push(this.rootNode);
  rootNode.visited=true;
  printNode(rootNode);
  while(!s.isEmpty())
  {
   Node n=(Node)s.peek();
   Node child=getUnvisitedChildNode(n);
   if(child!=null)
   {
    child.visited=true;
    printNode(child);
    s.push(child);
   }
   else
   {
    s.pop();
   }
  }
  //Clear visited property of nodes
  clearNodes();
 }


 //Utility methods for clearing visited property of node
 private void clearNodes()
 {
  int i=0;
  while(i<size)
  {
   Node n=(Node)nodes.get(i);
   n.visited=false;
   i++;
  }
 }

 //Utility methods for printing the node's label
 private void printNode(Node n)
 {
  System.out.print(n.label+" ");
 }

 /**
  * Method: childSearch
  * Adds all child nodes of a given node to an array list
  * @param n the specified node
  */
 private void childSearch(Node n)
 {
  Node child = getUnvisitedChildNode(n);

  if(child != null)
  {
   if(child == rootNode)
   {
    child.visited = true;
    childSearch(n);
   }

   else
   {
    childArray.add(child);
    child.visited = true;
    childSearch(n);
   }
  }
 }

 /**
  * Method: clearChildArray
  * Clears the child array to allow for new child searches
  */
 private void clearChildArray()
 {
  childArray.clear();
 }

 /**
  * Method: dijkstra
  * Performs a Dijkstra search for the shortest path from the root node to all other nodes
  * in a graph and prints the results to the console
  */
 public void dijkstra()
 {
  // array to hold the shortest path values for each vertex/node
  final double[] shortestPaths = new double[nodes.size()];

  // initializes the root node path value to 0 and all other path values to infinity 
  for(int i = 0; i < shortestPaths.length; i++)
  {
   if (i == 0)
    shortestPaths[i] = 0f;
   else
    shortestPaths[i] = Double.POSITIVE_INFINITY;
  }

  // adds all vertices/nodes to a queue
  Queue vertices = new LinkedList();
  vertices.addAll(nodes);

  // performs the search for the shortest path until the queue is empty
  while(!vertices.isEmpty())
  {
   // removes node from queue to use for each search
   Node n = (Node) vertices.remove();

   // finds all the adjacent nodes of the given node and adds them to an array list
   childSearch(n);

   // loops through the adjacent nodes array and updates the values in the array that holds the shortest path values for each node
   for (int i = 0; i < childArray.size(); i++)
   {
    Node child = (Node) childArray.get(i);

    if (shortestPaths[nodes.indexOf(child)] > (shortestPaths[nodes.indexOf(n)] + adjMatrix[nodes.indexOf(n)][nodes.indexOf(child)]))
    {
     shortestPaths[nodes.indexOf(child)] = shortestPaths[nodes.indexOf(n)] + adjMatrix[nodes.indexOf(n)][nodes.indexOf(child)];
    }
   }

   // Empties the child array to allow new child search
   clearChildArray();
  }

  // Clears visited property of nodes
  clearNodes();

  // Prints out shortest path from root to each node
  for (int i = 0; i < shortestPaths.length; i++)
  {
   Node temp = (Node) nodes.get(i);
   System.out.print("Shortest Path from " + rootNode.label + " to ");
   System.out.println(temp.label + " = " + shortestPaths[i]);
  }
 }

}



