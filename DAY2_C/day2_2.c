#include<stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    char *line = NULL;
    int x = 0;
    int y = 0;
    int aim = 0;
    char *order;
    char *number;
    size_t size;
    
    while (getline(&line, &size, stdin) != -1)
    {
        order = strtok(line, " ");
        number = strtok(NULL, " ");
        if (strcmp(order, "forward") == 0)
        {
            x += atoi(number);
            y += atoi(number) *  aim;
        }
        if (strcmp(order, "up") == 0)
            aim -= atoi(number);
        if (strcmp(order, "down") == 0)
            aim += atoi(number);
    }
    printf("%d", x * y);
}