5.
ANS:
a) #include<stdio.h>
#include <omp.h>
#include <sys/types.h>

int main(void)
{
    int i, n, m, R;
    printf(“\n Enter any value
           : “);
    scanf(“% d” , &n);
    omp_set_dynamic(0);
    m = omp_get_num_procs();
    omp_set_num_threads(m);
#pragma omp parallel for reduction(+ \
                                   : R)
    for (i = 1; i <= n; i++)
    {
        R += i * i;
    }
    printf(“\n Sum of the given series till % d is % d\n”, n, R);
    return 0;
}

b)   Write a C program using Linux System calls to display the contents of a text file, “sample.txt”.
ANS:
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/errno.h>
#include <unistd.h>
int main(int argc, char *argv[])
{

    char *args = {"sample.txt", NULL};
    int fd;
    int status;
    fd = open(args, O_RDONLY); //opening the file sample.txt
                               //if file open is successful, reading the file content and displaying it
    if (fd != -1)
    {
        while ((read(fd, &read_byte, sizeof(read_byte))) > 0)
        {
            write(STDOUT_FILENO, &read_byte, sizeof(read_byte));
        }
        write(STDOUT_FILENO, "File content read successfully.\n", 32);
        close(fd);
    }
    else
    {
        write(STDOUT_FILENO, &errno, sizeof(errno));
        perror("File couldnt be opened.");
        exit(errno);
    }
    exit(1);
}
}
----------------------------------------------------------------------------------------------------

7.a) Write a C program using Linux System calls to open a text file, “sample.txt”. The program should
then count the number of vowels present in the file along with its size and display the same.
ANS:
#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>

int main(int argc, char *argv[])
{
    char buf;
    int size, fd;
    int count = 0;
    fd = open("sample.txt", O_RDONLY); //opening the file in read only mode.
    size = lseek(fd, -1, SEEK_END);    //capturing the size of the file
    printf("The size of the file is:%d", size);

    reading the file in reverse and checking if there is any vowel or not while (size-- >= 0)
    {
        ch = read(fd, &buf, 1);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            count += 1;          //counting the number of vowels
        lseek(fd, -2, SEEK_CUR); //pointer is moved back by two positions
    }
    printf("The number of vowels present are:%d", count);
    return 0;
}

b) Write a C program using OpenMP features to create two parallel threads. One thread should insert an
element into a queue, whereas the other should remove an element from the same queue.
ANS:
#include <stdio.h>
#include <omp.h>
#include <sched.h>
//PROBLEM MAY BE IMPLEMENTED AS PRODUCER CONSUMER PROBLEM WHERE PRODUCES ADDS ELEMENTS INTO THE QUEUE AND CONSUMER REMOVES
int main()
{
    int Q[50], front = 0, rear = -1, count = 0;
    int id, d, ins = 0;
    omp_set_dynamic(0);
#pragma omp parallel num_threads(2)
    {
        id = omp_get_thread_num();
        if (id == 0) /*Producer*/
            while (1)
            {
#pragma omp critical
                {
                    if (count < 50)
                    {
                        rear = (rear + 1) % 50;
                        ins++;
                        Q[rear] = ins;
                        printf("Inserting element thread %d\n", ins);
                        count++;
                    }
                    else
                    {
                        sched_yield();
                        printf("Queue overflow : max size reached\n");
                    }
                    fgetc(stdin);
                }
            }
        else
        {
            while (1) /*Consumer*/
            {
#pragma omp critical
                {
                    if (count != 0)
                    {
                        d = Q[front];
                        front = (front + 1) % 50;
                        printf("Deleting item thread %d\n", d);
                        count--;
                    }
                    else
                    {
                        sched_yield();
                        printf("Queue underflow : no item to remove\n");
                    }
                    fgetc(stdin);
                }
            }
        }
    }
}
----------------------------------------------------------------------------------------------------

8.a) Write a C program using Linux System calls to create a child process. The child process should create
a text file, “sample.txt” by accepting input from the user. The parent should display the contents of the
file, “sample.txt” created by the child.
ANS:
//child process to create a text file by accepting characters from the user.
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/errno.h>
int main(int argc, char *argv[])
{
    int fd;
    char read_byte;
    fd = open("sample.txt", O_WRONLY | O_CREAT | O_EXCL, 0777);
    //if file opened successfully, writing into the file
    if (fd != -1)
    {
        write(STDOUT_FILENO, "Enter the content of the file:\n", 31);
        while ((read(STDIN_FILENO, &read_byte, sizeof(read_byte))) > 0)
        {
            //else writing into the file
            write(fd, &read_byte, sizeof(read_byte));
        }

        write(STDOUT_FILENO, "File creation done!", 20);
        close(fd);
    }
    else
    {
        write(STDOUT_FILENO, &errno, sizeof(errno));
        perror("File open error);
		exit(errno);
    }
    exit(1);
}

//parent process to display the contents of the file

#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/errno.h>
#include <unistd.h>

int main(int argc, char *argv[])
{
    pid_t pid;
    char *args = {"sample.txt", NULL};
    int fd;
    int status;
    fd = open(args, O_RDONLY); //opening the file sample.txt
    pid = fork();
    if (pid == 0) //child process successfully created
    {
        printf("Entered in child process.Process id:%d,Parent Process ID:%d", getpid(), getppid());
        execv("./child1.c", args);
        perror("Failed to replace child process image\n");
        exit(errno);
    }
    else if (pid > 0)
    {
        printf("Returned in parent process.Process id:%d,Child Process:%d", getpid(), pid);
        //if file open is successful, reading the file content and displaying it
        if (fd != -1)
        {
            while ((read(fd, &read_byte, sizeof(read_byte))) > 0)
            {
                write(STDOUT_FILENO, &read_byte, sizeof(read_byte));
            }
            write(STDOUT_FILENO, "File content read successfully.\n", 32);
            close(fd);
        }
        else
        {
            write(STDOUT_FILENO, &errno, sizeof(errno));
            perror("File couldnt be opened.");
            exit(errno);
        }
        exit(1);
    }
}

b)Write a C program using OpenMP features to find the sum of two matrices in linear time.
ANS:
#include <stdlib.h>
#include <stdio.h>
#include <omp.h>
void display(int **mat, int order_of_matrix)
{
    int i, j;
    for (i = 0; i < order_of_matrix; i++)
    {
        for (j = 0; j < order_of_matrix; j++)
        {
            printf("%3d ", mat[i][j]);
        }
        printf("\n");
    }
}
void deallocate_mem(int **mat, int order_of_matrix)
{
    int i;
#pragma omp parallel for shared(mat) private(i)
    for (i = 0; i < order_of_matrix; i++)
    {
        free(mat[i]);
    }
    free(mat);
}
int **sum_of_matrices(int **matrix_1, int **matrix_2, int order_of_matrix)
{
    int **result = NULL;
    int i;
    result = (int **)calloc(order_of_matrix, sizeof(int *));
#pragma omp parallel for shared(result) private(i)
    for (i = 0; i < order_of_matrix; i++)
    {
        result[i] = (int *)calloc(order_of_matrix, sizeof(int));
    }
    for (size_t i = 0; i < order_of_matrix; i++)
    {
#pragma omp parallel for shared(result, matrix_1, matrix_2)
        for (size_t j = 0; j < order_of_matrix; j++)
        {
            result[i][j] = matrix_1[i][j] + matrix_2[i][j];
        }
    }
    return result;
}

int main()
{
    int order_of_matrix_1, order_of_matrix_2;
    int **matrix_1 = NULL;
    int **matrix_2 = NULL;
    int **result = NULL;
    int i, j;
    printf("Enter the order of first matrix : \n");
    scanf("%d", &order_of_matrix_1);
    printf("Enter the order of second matrix : \n");
    scanf("%d", &order_of_matrix_2);
    if (order_of_matrix_1 == order_of_matrix_2)
    {
        omp_set_dynamic(0);
        omp_set_num_threads(order_of_matrix_1);

        matrix_1 = (int **)calloc(order_of_matrix_1, sizeof(int *));
#pragma omp parallel for shared(matrix_1) private(i)
        for (i = 0; i < order_of_matrix_1; i++)
        {
            matrix_1[i] = (int *)calloc(order_of_matrix_1, sizeof(int));
        }
        for (i = 0; i < order_of_matrix_1; i++)
        {
            for (j = 0; j < order_of_matrix_1; j++)
            {
                printf("matrix[%d][%d] = ", i + 1, j + 1);
                scanf("%d", &matrix_1[i][j]);
            }
        }
        matrix_2 = (int **)calloc(order_of_matrix_2, sizeof(int *));
#pragma omp parallel for shared(matrix_2) private(i)
        for (i = 0; i < order_of_matrix_2; i++)
        {
            matrix_2[i] = (int *)calloc(order_of_matrix_2, sizeof(int));
        }
        for (i = 0; i < order_of_matrix_2; i++)
        {
            for (j = 0; j < order_of_matrix_2; j++)
            {
                printf("matrix[%d][%d] = ", i + 1, j + 1);
                scanf("%d", &matrix_2[i][j]);
            }
        }
        result = sum_of_matrices(matrix_1, matrix_2, order_of_matrix_1);
        printf("\nMatrix 1:- \n\n");
        display(matrix_1, order_of_matrix_1);
        printf("\nMatrix 2:- \n\n");
        display(matrix_2, order_of_matrix_1);
        printf("\nMatrix after summation:- \n\n");
        display(result, order_of_matrix_1);

        deallocate_mem(result, order_of_matrix_1);
        deallocate_mem(matrix_1, order_of_matrix_1);
        deallocate_mem(matrix_2, order_of_matrix_1);
    }
    else
    {
        printf("summation can't be done\n");
    }
    return 0;
}