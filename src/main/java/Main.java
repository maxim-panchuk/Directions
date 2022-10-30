import algorithms.*;
import io.DistancesGraphBuilder;
import io.GraphBuilder;


public class Main {

    public static void main(String[] args) {
        GraphBuilder graphBuilder = new GraphBuilder();
        DistancesGraphBuilder distancesGraphBuilder = new DistancesGraphBuilder();

        BreadthFirstSearch bfs = new BreadthFirstSearch("Рига", "Уфа", graphBuilder.getNodes());
        DepthFirstSearch dfs = new DepthFirstSearch("Рига", "Уфа", graphBuilder.getNodes());
        IterativeDepthSearch ids = new IterativeDepthSearch("Рига", "Уфа", graphBuilder.getNodes());
        BidirectionalSearch bds = new BidirectionalSearch("Рига", "Уфа", graphBuilder.getNodes());
        InformGreedySearch igs = new InformGreedySearch("Рига", "Уфа", graphBuilder.getNodes()
                , distancesGraphBuilder.getMap(), graphBuilder.getRefs());
        AStarTraversal ast = new AStarTraversal("Рига", "Уфа", graphBuilder.getNodes(), distancesGraphBuilder.getMap(),
                graphBuilder.getRefs());


        int ans1 = bfs.find();
        System.out.println("BFS:   " + ans1);

        dfs.find();
        System.out.println("DFS:   " + dfs.getAns());

        int ans = ids.find();
        System.out.println("IDS:   " + ans);

        int ans2 = bds.find();
        System.out.println("BDS:   " + ans2);

        int ans3 = igs.find();
        System.out.println("IGS    " + ans3 + " км");

        int ans4 = ast.find();
        System.out.println("AST    " + ans4 + " км");
    }
}
