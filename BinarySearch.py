sortedArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 19]
low = 0
high = len(sortedArray)-1
mid = int((high+low)/2)
found = False
searchItem = 4
while low <= high and sortedArray[mid] != searchItem:
    if (sortedArray[mid] > searchItem):
        high = mid-1
    else:
        low = mid+1
    mid = int((high+low)/2)
if sortedArray[mid] == searchItem:
    print(sortedArray[mid])
else:
    print(None)    
