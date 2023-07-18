def findSmallest(array, startingIndex):
    smallestIndex = startingIndex
    for i in range(startingIndex, len(array)):
        if array[i] < array[smallestIndex]:
            smallestIndex = i
    return smallestIndex


array = [22, 45, 2, 78, 56, 99, 1]
for i in range(0, len(array)-1):
    smallestIndex = findSmallest(array, i+1)
    buf = array[i]
    array[i] = array[smallestIndex]
    array[smallestIndex] = buf

for elem in array:
    print(elem)