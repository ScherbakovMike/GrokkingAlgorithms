""" 
Binary search

Algoritm:
Introduce 3 variables:
    - low
    - high
    - mid
While low<=high and array[mid]!=desiredValue:
    mid = (high-low)/2

    if array[mid] > desiredValue then
        high = mid-1
    else
        low = mid+1
"""

def binarySearch(sortedArray, searchItem):
    low = 0
    high = len(sortedArray)-1
    mid = int((high+low)/2)
    while low <= high and sortedArray[mid] != searchItem:
        if (sortedArray[mid] > searchItem):
            high = mid-1
        else:
            low = mid+1
        mid = int((high+low)/2)
    if sortedArray[mid] == searchItem:
        return sortedArray[mid]
    else:
        return None

sortedArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 19]
searchItem = 4

print(binarySearch(sortedArray, searchItem))