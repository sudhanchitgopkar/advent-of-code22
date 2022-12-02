

def solve (inputFile):
    input = open(inputFile)
    
    max = 0
    curr = 0
    
    for line in input:
        if line == "\n":
            curr = 0
        else:
            curr = curr + int(line)
            max = curr if curr > max else max
            
    return max

print(solve("input/day1_1.txt"))

