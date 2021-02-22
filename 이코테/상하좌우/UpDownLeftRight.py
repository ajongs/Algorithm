n = int(input())
datas = input().split()

x,y = 1,1
#     D   U  R   L
dx = [1, -1, 0,  0]
dy = [0,  0, 1, -1]
moveTypes = ['D', 'U', 'R', 'L']

for data in datas:
  #이동 후 좌표구하기
  for i in range(len(moveTypes)):
    if data == moveTypes[i]:
      nx = x + dx[i]
      ny = y + dy[i]
  #이동 후 좌표가 공간을 벗어나면 무시
  if nx<1 or nx>n or ny<1 or ny>n:
    continue
  #실제로 좌표 이동
  x, y = nx, ny

#좌표 출력
print(x, y)
