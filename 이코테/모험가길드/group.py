n = int(input())
data = list(map(int, input().split()))
data.sort()

count =0
group =0
for i in data:
  count += 1
  if count>=i:
    group +=1
    count =0

print(group)
