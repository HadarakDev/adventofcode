if __name__ == "__main__":

    count = 0
    with open("input.txt", "r") as f:
        data = f.readlines()

    int_data = [int(i) for i in data]
    print(int_data)
    for i in range(1, len(int_data)):
        if int_data[i] > int_data[i - 1]:
            count += 1
    print(count)
