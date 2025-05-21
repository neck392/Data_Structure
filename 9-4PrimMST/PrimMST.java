import java.util.List;
public class PrimMST {
	int N; // �׷��� ������ ��
	List<Edge>[] graph;
	
	public PrimMST(List<Edge>[] adjList) { // ������
		N = adjList.length;
		graph = adjList;
	}

	public int[] mst (int s) { // Prim �˰���,s�� ��������
		boolean[] visited = new boolean[N]; // �湮�� ������ true��
		int[] D = new int[N];
		int[] previous = new int[N]; // �ּҽ���Ʈ���� �������� Ȯ���� �� ������ �ٸ� �� (Ʈ����)����
		for(int i = 0; i < N; i++){  // �ʱ�ȭ
			visited[i] = false;
			previous[i] = -1;
			D[i] = Integer.MAX_VALUE;  // D[i]�� �ִ����� �ʱ�ȭ
		}
		previous[s] = 0;  //�������� s�� ���� ���� �ʱ�ȭ
        D[s] = 0;
        
		for(int k = 0; k < N; k++){ // �湮�ȵ� �������� D ���ҵ��� ���� �ּڰ����� ���� minVertex ã��			
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for(int j=0;j<N;j++){
				if ((!visited[j])&&(D[j] < min)){
					min = D[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true;
			for (Edge i : graph[minVertex]){ // minVertex�� ������ �� ������ D�� ���� ����			 
				if (!visited[i.adjvertex]){  // Ʈ���� ���� ���� �ȵ� �����̸�
					int currentDist = D[i.adjvertex];
					int newDist = i.weight;
					if (newDist < currentDist){	 		
						D[i.adjvertex] = newDist; // minVertex�� ����� �������� D ���� ����
						previous[i.adjvertex] = minVertex; // Ʈ�� ���� ������ ���� 
					}
				}
			}
		}   
		return previous; // �ּҽ���Ʈ�� ���� ���� ����
	}
}

