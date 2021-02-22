#현재 위치 가져오기
pos = input()  #input ex : c1 

#pos값을 행렬(row, column)로 매핑
row = int(pos[1])
column = int(ord(pos[0])) - int(ord('a')) + 1  #+1 해주는 이유는 우리는 1,1부터 행렬시작
#ord()는 아스키코드 값 리턴

#경우의 수
count = 0

#나이트가 이동할 수 있는 8가지 방향 정의
#moves = ['RRD', 'RRU', 'LLD','LLU', 'DDR', 'DDL', 'UUR', 'UUL']
moves = [(2, 1), (2, -1), (-2,1),(-2,-1),(1,2),(-1,2),(1,-2),(-1,-2)]

for move in moves:
  next_row = row + moves[1]
  next_column = column + moves[0]
  
  if next_row >= 1 and next_row <-= 8 and next_column >= 1 and next_column <= 8:
    count += 1

print(count)
