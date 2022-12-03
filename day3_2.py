def solve(inputFile):
    input = open(inputFile)
    sum = 0
    
    while True:
        l1 = { c for c in input.readline().strip() }
        l2 = { c for c in input.readline().strip() }
        l3 = { c for c in input.readline().strip() }

        if len(l1) == 0 or len(l2) == 0 or len(l3) == 0:
            break
        
        for c in l1:
            if c in l2 and c in l3:
                sum += (ord(c) - ord('a')  + 1 if c.islower() else ord(c) - ord('A') + 27)
                break
            
    return sum

print(solve("input/day3_1.txt"))
