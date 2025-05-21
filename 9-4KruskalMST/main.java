import java.util.*;
public class main {
	public static void main(String[] args) {
		int[][] weight = {  // [�׸� 9-4-2](a)�� �׷���
				{0, 15, 7, 9, 4, 0, 0},
	            {15, 0, 10, 3, 0, 0, 6}, 
	            {7, 10, 0, 0, 0, 0, 0}, 
	            {9, 3, 0, 0, 8, 1, 7}, 
	            {4, 0, 0, 8, 0, 13, 0},  
	            {0, 0, 0, 1, 13, 0, 5}, 
	            {0, 6, 0, 7, 0, 5, 0},  
		};
		int N = weight.length;
		int M = 0;  // �׷��� ������ ��
		List<Edge>[] adjList = new List[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new LinkedList<>();
			for (int j = 0; j < N; j++) {
				if (weight[i][j] != 0) {
					Edge e = new Edge(i,j, weight[i][j]);
					adjList[i].add(e);
					M++;
				}
			}
		}
		KruskalMST k = new KruskalMST(adjList, M);  // KruskalMST ��ü ����
		Edge[] tree = new Edge[N-1];                // �ּҽ���Ʈ���� ������ ����ϱ� ����
		
		System.out.print("�ּҽ���Ʈ�� ����: ");
		tree = k.mst();	   // mst() �޼ҵ� ȣ��
		
		int sum = 0;
		for (int i = 0; i < tree.length; i++) {
			System.out.print("("+tree[i].vertex + "," +tree[i].adjvertex+ ") ");
			sum += tree[i].weight;
		}
		System.out.printf("\n\n");
		System.out.println("�ּҽ���Ʈ���� ���� ����ġ �� = "+sum);
	}
}