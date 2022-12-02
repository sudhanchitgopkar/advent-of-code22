def solve (inputFile):
    outcomes = {
        "AX" : 4,
        "AY" : 8,
        "AZ" : 3,

        "BX" : 1,
        "BY" : 5,
        "BZ" : 9,
        
        "CX" : 7,
        "CY" : 2,
        "CZ" : 6
    }

    input = open(inputFile)
    score = 0
    
    for line in input:
        score = score + outcomes["".join(line.strip().split())]

    return score

print(solve("input/day2_1.txt"))
