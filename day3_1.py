def solve(inputFile):
    input = open(inputFile)
    sum = 0
    
    for line in input:
        line = line.strip()
        beg = line[0:len(line)//2]
        end = line[len(line)//2:]

        begDict = {}
        endDict = {}

        for c in beg:
            if c in begDict.keys():
                begDict[c] += 1
            else:
                begDict[c] = 1

        for c in end:
            if c in endDict.keys():
                endDict[c] += 1
            else:
                endDict[c] = 1

        for key in begDict:
            if key in endDict:
                sum += ord(key) - ord('a')  + 1 if key.islower() else ord(key) - ord('A') + 27
                
    return sum

print(solve("input/day3_1.txt"))
