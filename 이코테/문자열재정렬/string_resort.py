datas = input()

result=[]
num=0
for data in datas:
  if data.isalpha():
    result.append(data)
  else:
    num += int(data)

result.sort()

if num !=0:
  result.append(str(num))

print(''.join(result))
