package programmers.level2;

import java.util.LinkedList;

public class _003 {
	/*
     * Level2 - 프린터
     *
     * Description : 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
	 * 				 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
	 * 				 3. 그렇지 않으면 J를 인쇄합니다.
     * Input : 문서 대기목록 = {2,1,3,2}, 출력 순번를 알고 싶은 문서 위치 = 2(즉, 3)
     * Output : 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return, 1
     *
     * */
	
	class Document {
		private int idx;
		private int priority;

		Document(int idx, int priority) {
			this.idx = idx;
			this.priority = priority;
		}
	}

	private int solution(int[] priority, int location) {
		int answer = 1;
		LinkedList<Document> list = new LinkedList<>();
		for (int i = 0; i < priority.length; i++) {
			list.add(new Document(i, priority[i]));
		}
		Document document = null;
		while (list.size() > 1) {
			document = list.getFirst();
			for (int i = 1; i < list.size(); i++) {
				if (document.priority < list.get(i).priority) {
					list.addLast(document);
					list.removeFirst();
					break;
				}

				if (i == list.size() - 1) {
					if (document.idx == location)
						return answer;
					list.removeFirst();
					answer++;
				}
			}

		}

		return answer;
	}
}
