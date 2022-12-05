def solve (inputFile):
    input = open(inputFile)
    sol = 0
    
    for line in input:
        line = line.strip().split(",")
        r1 = line[0].split("-")
        r2 = line[1].split("-")

        if (len(r1) == 1):
            r1.append(r1[0])
        if (len(r2) == 1):
            r2.append(r2[0])

        if (int(r1[0]) <= int(r2[1]) and int(r1[1]) >= int(r2[0])) or (int(r2[0]) <= int(r1[1]) and int(r2[1]) >= int(r1[1])):
            sol += 1
        elif (int(r2[0]) <= int(r1[1]) and int(r2[1]) >= int(r1[0])) or (int(r1[0]) <= int(r2[1]) and int(r1[1]) >= int(r2[1])):
            sol += 1

    return sol

print(solve("input/day4_1.txt"));
