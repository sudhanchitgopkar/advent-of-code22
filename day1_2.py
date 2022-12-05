import heapq

def solve (fileName):
    input = open(fileName)

    heap = []
    curr = 0
    
    for line in input:
        if line == "\n":
            if len(heap) == 3:
                heapq.heappushpop(heap,curr)
            else:
                heapq.heappush(heap,curr)
            curr = 0
        else:
            curr = curr + int(line)

    return sum(heap)
    
print(solve("input/day1_1.txt"))
