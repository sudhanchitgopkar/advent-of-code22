def solve(filename):
    f = open(filename)

    chars = [c for c in f.read().strip()]
    seen = set()
    l = 0

    for r in range(len(chars)):
        while chars[r] in seen or len(seen) > 4:
            seen.remove(chars[l])
            l += 1
        seen.add(chars[r])
        r += 1
        if (len(seen) == 4):
            return r

print(solve("input/day6_1.txt"))
