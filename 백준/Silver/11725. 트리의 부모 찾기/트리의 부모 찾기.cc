#include <iostream>

typedef struct adjlists
{
    int data;
    adjlists* LINK;
};

int parent[100001];
adjlists list[100001]; 

void addNode(adjlists* list1, adjlists* list2)
{

    while(list1->LINK != NULL)
    {
        list1 = list1->LINK;
    }
    list1->LINK = list2;
}

void find_parent(int v)
{
    adjlists* w = (list[v].LINK);
    for(; w != NULL; w = w->LINK )
    {
        if(!parent[w->data])
        {
            parent[w->data] = v; 
            find_parent(w->data);
        }   
    } 
}


int main()
{
    int num;
    scanf("%d", &num);
    for(int i = 0; i < num - 1 ; i++)
    {
        int left, right;
        scanf("%d%d", &left, &right);

        adjlists* node1 = new adjlists;
        node1->data = right;
        node1->LINK = NULL;
        addNode(&list[left], node1);

        adjlists* node2 = new adjlists;
        node2->data = left;
        node2->LINK = NULL;
        addNode(&list[right], node2);        
    }
    find_parent(1);
    for(int i=2;i<num+1;i++)
    {
        printf("%d\n", parent[i]);
    }

}