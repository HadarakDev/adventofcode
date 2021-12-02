#include<stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    char *line = NULL;
    int x = 0;
    int y = 0;
    size_t size;
    char *order;
    char *number;

    while (getline(&line, &size, stdin) != -1)
    {
        order = strtok(line, " ");
        number = strtok(NULL, " ");
        if (strcmp(order, "forward") == 0)
            x += atoi(number);
        if (strcmp(order, "up") == 0)
            y -= atoi(number);
        if (strcmp(order, "down") == 0)
            y += atoi(number);
    }
    printf("%d", x * y);
}