def dfs(x,y):
  # 정해진 범위 넘어가면 실행 false
  if x<0 or x>=n or y<0 or y>=m:
    return False
  # 해당 위치가 0이라면
  if graph[x][y] == 0:
    # 1로 바꾸어줘서 방문체크
    graph[x][y] = 1
    #주변 0체크 후 모드 1로 바꿔주기
    dfs(x-1, y)
    dfs(x+1, y)
    dfs(x, y-1)
    dfs(x, y+1)
    # 주변 0이 없으면 True 리턴
    return True
  # 두 if문에 해당하지않는 예외는 false리턴
  return False


n,m = map(int, input().split())

graph= []
for i in range(n):
  graph.append(list(map(int, input())))

result =0
for i in range(n):
  for j in range(m):
    # dfs(i,j)가 True 라면 한 위치를 중점으로 모든 0을 찾아서 1로 바꾸는 작업을 했음
    # 따라서 하나의 집합이 형성된걸 확인할 수 있음
    # result 를 하나 추가해줌
    if dfs(i,j) == True:
      result += 1

print(result)
