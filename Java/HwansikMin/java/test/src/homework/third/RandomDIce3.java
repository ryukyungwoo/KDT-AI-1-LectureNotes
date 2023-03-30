package homework.third;

// 주사위 문제 [3]
// 친구와 1:1 게임
// 주사위 3개를 굴립니다.
// 첫번째 추사위가 짝수라면, 두번째 세번째 주사위도 굴릴 수 있습니다.
// 두번째 주사위는 특수기능이 없습니다.
// 세번째 주사위가 1이면 상대에게 점수를 3점 뺏을 수 있습니다.
// 세번째 주사위가 3인 경우에는 자신에게 점수를 2점 가산합니다.
// 세번째 주사위가 4인 경우에는 무조건 패배합니다.
// 친구와 함께 플레이하는 주사위게임을 만듭니다.

// <대충 계획 작성>
// 친구 A, B로 정의
// 게임 실행 전에 for나 Array? 등을 이용해 각 변수마다 반복하도록 설정
// Random을 사용해 각 주사위 값 도출에 대한 설정
// 주사위 세개 각 실행조건에 대한 코딩 if(첫번째 주사위 짝수, %2 = 0 활용하면 될 듯),
// else if(두번째 주사위 값 + 세번째 주사위 값이 3인 경우와 4인 경우),
// else~(세번째 주사위 3인 경우 자신에게 +2점, 4인 경우 무조건 패배) 활용
// 마지막 합산 sum 결과값 비교하여 if else로 승리 패배 결과 도출

public class RandomDIce3 {

}