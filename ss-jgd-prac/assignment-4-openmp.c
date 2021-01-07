/*
OpenMP program to multiply two matrices.
*/

#include <stdio.h>
#include <omp.h>
int main()
{
    int A[3][3] = {1, 1, 1,
                   1, 1, 1,
                   1, 1, 1};
    int B[3][3] = {2, 2, 2,
                   2, 2, 2,
                   2, 2, 2};
    int C[3][3], i, j, k;
#pragma omp parallel for shared(C)
    for (i = 0; i < 3; i++)
        for (j = 0; j < 3; j++)
            C[i][j] = 0;
    for (i = 0; i < 3; i++)
        for (j = 0; j < 3; j++)
#pragma omp parallel for shared(C, B, A)
            for (k = 0; k < 3; k++)
                C[i][j] = C[i][j] + A[i][k] * B[k][j];
    for (i = 0; i < 3; i++)
    {
        printf("\n");
        for (j = 0; j < 3; j++)
            printf(" %d", C[i][j]);
    }
    fgetc(stdin);
}

/*OpenMP program to find the dot product, cross
product of two vectors.*/

#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

void display_vector(int *result, int n)
{
    int i;
    for (i = 0; i < n; i++)
        printf("%d\t", result[i]);
    printf("\n");
}
int dot_product(int *first, int *second, int size)
{
    int result = 0, i;
#pragma omp parallel for reduction(+ \
                                   : result)
    for (i = 0; i < size; i++)
        result += first[i] * second[i];
    return result;
}
void cross_product(int *first, int *second, int size)
{
    int *result = (int *)malloc(size * sizeof(int));
    int i, j, m;

    omp_set_dynamic(0);
    m = omp_get_num_procs();
    omp_set_num_threads(m);

#pragma omp parallel for shared(result, first, second)
    for (i = 0; i < size; i++)
        result[i] = first[(i + 1) % size] * second[(i + 2) % size] - first[(i + 2) % size] * second[(i + 1) % size];
    display_vector(result, size);
}
int main()
{
    int size = 3;
    int first[3] = {3, -5, 4};
    int second[3] = {2, 6, 5};
    printf("\n Result after dot product : %d", dot_product(first, second, size));
    printf("\n Result after vector product : ");
    cross_product(first, second, size);
    return 0;
}

/*
OpenMP program to find the determinant of a
3x3 matrix.
*/

#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <omp.h>

int **allocate_mem(int **temp)
{
    temp = (int **)malloc(2 * sizeof(int *));
    for (size_t i = 0; i < 2; i++)
    {
        temp[i] = (int *)malloc(2 * sizeof(int));
    }
    return temp;
}
void deallocate_mem(int **temp)
{
    for (size_t i = 0; i < 2; i++)
    {
        free(temp[i]);
    }
    free(temp);
}
void display_matrix(int input_matrix[3][3])
{
    for (size_t i = 0; i < 3; i++)
    {
        for (size_t j = 0; i < 3; i++)
        {
            printf("%d\t", input_matrix[i][j]);
        }
        printf("\n");
    }
}
int **get_cofactor(int input_matrix[3][3], int selected)
{
    int row = 0, col = 0;
    int **temp = NULL;
    temp = allocate_mem(temp);
    for (size_t i = 1; i < 3; i++)
    {
        for (size_t j = 0; j < 3; i++)
        {
            if (j != selected)
            {
                temp[row][col++] = input_matrix[i][j];
            }
        }
        row++;
        col = 0;
    }
    return temp;
}
int get_minor(int input_matrix[3][3], int selected)
{
    int **temp = NULL, result = 0;
    temp = allocate_mem(temp);
    temp = get_cofactor(input_matrix, selected);
    result = temp[0][0] * temp[1][1] - temp[1][0] * temp[0][1];
    deallocate_mem(temp);
    return result;
}

int get_determinant(int input_matrix[3][3])
{
    int i, result = 0;
#pragma omp parallel for shared(input_matrix) reduction(+ \
                                                        : result)
    for (i = 0; i < 3; i++)
        result += (int)pow(-1, i) * input_matrix[0][i] * get_minor(input_matrix, i);
    return result;
}

int main(int argc, char *argv[])
{
    int input_matrix[3][3];
    int counter = 0;
    for (size_t i = 0; i < 3; i++)
    {
        for (size_t j = 0; j < 3; i++)
        {
            input_matrix[i][j] = atoi(argv[counter++]);
        }
    }
    printf("Determinant of the matrix : %d", get_determinant(input_matrix));
    return 0;
}
