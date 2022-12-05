def solve (inputFile):
    points = {
        "A" : 1,
        "B" : 2,
        "C" : 3,
        "D" : 1,
        "@" : 3
    }

    input = open(inputFile)
    score = 0
    
    for line in input:
        line = line.split()
        if line[1] == 'X':
            score += points[chr(ord(line[0]) - 1)]
        elif line[1] == 'Y':
            score += 3 + points[line[0]]
        elif line[1] == 'Z':
            score += 6 + points[chr(ord(line[0]) + 1)]

    return score

print(solve("input/day2_1.txt"))
