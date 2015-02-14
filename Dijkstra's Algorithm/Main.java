

public class Main {

 /**
  * @param arg1s
  */
 public static void main(String[] arg1s) 
 {

  //Lets create nodes as g1iven as an example in the article
  Node nA=new Node('A');
  Node nB=new Node('B');
  Node nC=new Node('C');
  Node nD=new Node('D');
  Node nE=new Node('E');
  Node nF=new Node('F');

  //Create the g1raph, add nodes, create edg1es between nodes
  Graph g1 = new Graph();
  g1.addNode(nA);
  g1.addNode(nB);
  g1.addNode(nC);
  g1.addNode(nD);
  g1.addNode(nE);
  g1.addNode(nF);
  g1.setRootNode(nA);

  g1.connectNode(nA,nB);
  g1.connectNode(nA,nC);
  g1.connectNode(nA,nD);

  g1.connectNode(nB,nE);
  g1.connectNode(nB,nF);
  g1.connectNode(nC,nF);

  //Create a new g1raph, add nodes, connect nodes
  Graph g2 = new Graph();
  g2.addNode(nA);
  g2.addNode(nB);
  g2.addNode(nC);
  g2.addNode(nD);
  g2.addNode(nE);
  g2.addNode(nF);
  g2.setRootNode(nA);

  g2.connectNode(nA, nB);

  g2.connectNode(nB, nC);
  g2.connectNode(nB, nE);

  g2.connectNode(nC, nD);

  g2.connectNode(nE, nF);

  //Create a new graph, add nodes, connect nodes
  Graph g3 = new Graph();
  g3.addNode(nA);
  g3.addNode(nB);
  g3.addNode(nC);
  g3.addNode(nD);
  g3.addNode(nE);
  g3.addNode(nF);
  g3.setRootNode(nA);

  g3.connectNode(nA, nB);
  g3.connectNode(nB, nC);
  g3.connectNode(nC, nD);
  g3.connectNode(nD, nE);
  g3.connectNode(nE, nF);

  //Create additional nodes, create a new graph, add nodes, connect nodes
  Node nG = new Node('G');
  Node nH = new Node('H');
  Node nI = new Node('I');
  Node nJ = new Node('J');
  Node nK = new Node('K');
  
  Graph g4 = new Graph();
  g4.addNode(nA);
  g4.addNode(nB);
  g4.addNode(nC);
  g4.addNode(nD);
  g4.addNode(nE);
  g4.addNode(nF);
  g4.addNode(nG);
  g4.addNode(nH);
  g4.addNode(nI);
  g4.addNode(nJ);
  g4.addNode(nK);
  g4.setRootNode(nA);

  g4.connectNode(nA, nB);
  g4.connectNode(nA, nH);
  
  g4.connectNode(nB, nC);
  g4.connectNode(nB, nE);
  g4.connectNode(nB, nG);
  
  g4.connectNode(nC, nD);
  g4.connectNode(nC, nG);
  
  g4.connectNode(nD, nE);
  
  g4.connectNode(nE, nF);
  
  g4.connectNode(nG, nE);
  g4.connectNode(nG, nH);
  
  g4.connectNode(nH, nI);
  
  g4.connectNode(nI, nJ);
  
  g4.connectNode(nJ, nK);


  //Perform the traversal of the graph
  System.out.println("DFS Traversal of a tree is ------------->");
  g1.dfs();

  System.out.println("\nBFS Traversal of a tree is ------------->");
  g1.bfs();

  System.out.println();
  g1.dijkstra();

  System.out.println();
  g2.dijkstra();

  System.out.println();
  g3.dijkstra();
  
  System.out.println();
  g4.dijkstra();
 }

}
