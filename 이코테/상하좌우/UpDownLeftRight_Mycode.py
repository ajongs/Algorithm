n = int(input())
data = list(input().split())

x,y = 1,1
#     D   U  R   L
dx = [1, -1, 0,  0]
dy = [0,  0, 1, -1]

for i in data:
  if i=='D' and x+1<=n:
    x = x+1
  elif i=='U' and x-1>=1:
    x = x-1
  elif i=='R' and y+1<=n:
    y = y+1
  elif i=='L' and y-1>=1:
    y = y-1
  
print(x,', ', y)
