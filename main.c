#include <stdio.h>
#include <stdlib.h>
#include <stddef.h>
#include <limits.h>
#define false 0
#define true 1
#define nbLigne 3
typedef int bool;
typedef struct List List;
typedef struct TreeNode TreeNode;
typedef struct ListNode ListNode;
struct ListNode
{
   TreeNode* value;
   ListNode* nextNode;

};

struct List
{
    ListNode* head;
    ListNode* end;
};


struct TreeNode
{
    int idNode;
    int * idNodes;
    bool visited;
    int orderNumber;
    List* neighbourList;
    int idInitOrder;

};

typedef struct Tree Tree;
struct Tree
{
    TreeNode* root;
    List* nodeslist;


};
int** ordersAndReturnsTable;
int orderNumber;
int** graphMatrix;
// A structure to represent a stack
/*typedef struct Stack Stack;
struct Stack
{
    int top;
    ListNode* valuesHead;
    ListNode* stackTop;
};


// function to create a stack of given capacity. It initializes size of
// stack as 0
Stack* createStack()
{
    Stack* stack = (Stack*) malloc(sizeof(Stack));
    stack->top = -1;
    Stack->valuesHead=NULL;
    //stack->array = (int*) malloc(stack->capacity * sizeof(int));
    return stack;
}


// Stack is empty when top is equal to -1
int isEmpty(Stack* stack)
{   return stack->top == -1;  }

// Function to add an item to stack.  It increases top by 1
void push(Stack* stack, TreeNode* treeNode)
{
    ListNode newNode = malloc(sizeof(ListNode));
    if(stack->valuesHead==NULL)
    {
        top=1;
        stack->valuesHead=newNode;
        stack->stackTop;
    }
    else
    {

    }

    stack->array[++stack->top] = item;
    printf("%d pushed to stack\n", item);
}

// Function to remove an item from stack.  It decreases top by 1
int pop(struct Stack* stack)
{
    if (isEmpty(stack))
        return INT_MIN;
    return stack->array[stack->top--];
}*/


Tree* createTree()
{
    Tree* tree= ((Tree*)malloc(sizeof(Tree)));
    tree->root=NULL;
    tree->nodeslist=(List*)malloc(sizeof(List));
    tree->nodeslist->head=tree->nodeslist->end=NULL;
    return tree;

}
ListNode* createListNode(TreeNode* treeNode)
{
    ListNode* listNode = (ListNode*) malloc(sizeof(ListNode));
    listNode->value=treeNode;
    listNode->nextNode=NULL;
    return listNode;
}
void addListNode(List* list, ListNode* listNode)
{
    if((list==NULL)||(listNode==NULL)) return;
    if(list->head==NULL)
    {
        list->head=listNode;
        list->end=listNode;
    }
    else
    {

        list->end->nextNode=listNode;
        list->end=listNode;
        //printf("\ninsertion new node end %p head %p endend %p",list->end,list->head,list->end->nextNode);
    }


}
TreeNode* createTreeNode(Tree*tree,int idNode,int idInitOrder,int* idNodes)
{
    TreeNode* treeNode =(TreeNode*) malloc(sizeof(TreeNode));
    if(tree->root==NULL)
    {
        tree->root=treeNode;

    }
    treeNode->idNodes=idNodes;
    treeNode->idNode=idNode;
    treeNode->visited=false;
    treeNode->idInitOrder=idInitOrder;
    treeNode->orderNumber=-1;
    treeNode->neighbourList=(List*)malloc(sizeof(List));
    treeNode->neighbourList->head=treeNode->neighbourList->end=NULL;
    ListNode* treeNodeList=createListNode(treeNode);
    addListNode(tree->nodeslist,treeNodeList);
    return treeNode;
}

void addNeighbour(Tree* tree,TreeNode* node,TreeNode* nodeToAdd)
{
    if((tree==NULL)||(node==NULL)) return;
    //TreeNode* nodeToAdd=createTreeNode(tree,idNodeToAdd);
    addListNode(node->neighbourList,createListNode(nodeToAdd));
}
TreeNode* doesItExist(List* nodesListe,int idNode)
{
    int found=0;
    ListNode* pointer=nodesListe->head;
    ListNode* pointerStore=nodesListe->head;
    while((found==0)&&(pointer!=NULL))
    {
        if(pointer->value->idNode == idNode)
        {
            found=1;
            nodesListe->head=pointerStore;
            return pointer->value;
        }
        else
        {
            pointer=pointer->nextNode;
        }

    }
    nodesListe->head=pointerStore;
    return NULL;
}
long int facto (int n)
{
    int i, res=1;
    for(i=2;i<=n;i++)
    {
        res = res * i;
    }
    return res;
}
void parcourEnProfondeurVoisins(TreeNode* node,TreeNode* ParentNode)
{
    orderNumber++;
    int nodeColSucc;
    int nodeColNode=node->idInitOrder;
    //printf("order number %d id node %d",orderNumber,node->idNode);
    ListNode* pointer;
    ordersAndReturnsTable[0][nodeColNode]=node->idNode;
    ordersAndReturnsTable[1][nodeColNode]=orderNumber;
    for(pointer = node->neighbourList->head;pointer!=NULL;pointer=pointer->nextNode)
    {
        nodeColSucc=pointer->value->idInitOrder;
        if(ordersAndReturnsTable[1][nodeColSucc]==0)
        {
            printf("Arbre %d -->  %d\n",node->idNode,pointer->value->idNode);
            parcourEnProfondeurVoisins(pointer->value,node);
        }
        else if((ordersAndReturnsTable[1][nodeColSucc]<ordersAndReturnsTable[1][nodeColNode])&&((pointer->value->idNode)!=ParentNode->idNode))
        {
            ordersAndReturnsTable[2][nodeColSucc]=ParentNode->idNode;
            printf("Retour %d -->  %d\n",node->idNode,pointer->value->idNode);
        }
    }

}
void parcourProfondeur(Tree* tree)
{
    ListNode* nodesList=tree->nodeslist->head;

    orderNumber=0;
    TreeNode* node;
    parcourEnProfondeurVoisins(tree->root,tree->root);
}
int min(int a,int b)
{
    if(a<b) return(a);
    return b;
}
/*void permuter(int* a, int* b)
{
    int s = a;
    *a = b;
    *b = s;
}*/
int calculerPoids(int** graphMatrix,int* indexMatrix, int grapheNodesNumber)
{
    int i,j;
    int poids = 0;
    for(i=0;i<grapheNodesNumber;i++)
    {
        j = i + 1;
        if(j==grapheNodesNumber) j = 0;
        poids += graphMatrix[indexMatrix[i]][indexMatrix[j]];
    }
    return poids;

}

int main()
{
    int nodeID,neighboursNumber,grapheNodesNumber,cptTreeNodes,cptNodeNeighbours;
    TreeNode* foundNode;
    printf("\n********* CREATION DE LA MATRICE DU GRAPHE **********\n\n");
    printf("Donner le nombre de sommets du graphe :");
    scanf("%d",&grapheNodesNumber);
    //création de la matrice du graphe
    int i,j,poids,debutCol;
    int* indexMatrix = (int*)malloc(sizeof(int)*grapheNodesNumber);
    graphMatrix=(int**)malloc(sizeof(int*)*grapheNodesNumber);
    for(i=0;i<grapheNodesNumber;i++)
    {
        graphMatrix[i]=(int*)malloc(sizeof(int)*grapheNodesNumber);
    }
    //Remplir la matrice des poids
    for(i=0;i<grapheNodesNumber;i++)
    {
        indexMatrix[i]=i;
        for(j=i;j<grapheNodesNumber;j++)
        {
            if(i==j) graphMatrix[i][j]=0;
            else
            {
                printf("\nDonner le poids de l'arete [%d - %d]",i,j);
                scanf("%d",&poids);
                graphMatrix[i][j] = graphMatrix[j][i] = poids;
            }
        }
    }
    //Afficher la matrice des poids
    for(i=0;i<grapheNodesNumber;i++)
    {
        printf("\n");
        for(j=0;j<grapheNodesNumber;j++)
        {
            printf("%d  ",graphMatrix[i][j]);
        }
    }
    Tree* testTree = createTree();
    int currentIndex =1; //l'indice de lequel on doit commencer
    int idNode=0;
    TreeNode* createdNode =createTreeNode(testTree,idNode,idNode,indexMatrix);
    TreeNode* newNode;

    TreeNode* minNode = createdNode;
    int minPoids = calculerPoids(graphMatrix,indexMatrix,grapheNodesNumber);
    int currentPoids,indexIteration;
    List* niveau = (List*)malloc(sizeof(List));
    niveau->head=niveau->end=NULL;
    ListNode* currentListNode = createListNode(createdNode);
    addListNode(niveau,currentListNode);
    ListNode* newLevelHead;
    bool newLevel = false;
    long int permutationNumber = facto(grapheNodesNumber-1)-1;
    while(permutationNumber>0)
    {
        indexIteration = 0;
        permutationNumber--;
        while(newLevel==false)
        {

            for(i=(currentIndex+1);i<grapheNodesNumber;i++)
            {
            indexMatrix=niveau->head->value->idNodes;
            printf("Permut current avant == %d\n",indexMatrix[currentIndex]);
            printf("i avant == %d\n",indexMatrix[i]);
            //permuter(&indexMatrix[currentIndex],&indexMatrix[i]);
            int s = indexMatrix[currentIndex];
            indexMatrix[currentIndex] = indexMatrix[i];
            indexMatrix[i] = s;
            printf("Permut current apreé == %d\n",indexMatrix[currentIndex]);
            printf("i aprées == %d\n",indexMatrix[i]);
            currentPoids = calculerPoids(graphMatrix,indexMatrix,grapheNodesNumber);idNode++;
            newNode = createTreeNode(testTree,idNode,idNode,indexMatrix);
            if(currentPoids<minPoids)
            {
                minNode = newNode;
                minPoids = currentPoids;
            }
            currentListNode = createListNode(newNode);
            addListNode(niveau,currentListNode);
            if(indexIteration==0)
            {
                newLevelHead=currentListNode;
                indexIteration++;
            }

            if(niveau->head==newLevelHead)
            {
                newLevel=true;

            }
        }
        niveau->head=niveau->head->nextNode;

        }

    }
    printf("min Poids == %d\n",minPoids);
    for(i=0;i<grapheNodesNumber;i++)
    {
        printf("%d",minNode->idNodes[i]);
    }
    return 0;
}
