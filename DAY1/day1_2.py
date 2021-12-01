if __name__ == "__main__":

    count = 0
    with open("input.txt", "r") as f:
        data = f.readlines()

    data = [int(i) for i in data]
    for i in range(len(data)):
        if sum(data[i:i+3]) < sum(data[i+1:i+4]):
            count += 1
    print(count)