#include <bits/stdc++.h>

using namespace std;

const int TOTAL_TRANSACTIONS = 100;

vector<pair<pair<char, int>, string>> transactions;
set<int> adjacencyList[TOTAL_TRANSACTIONS];
set<int> allTransactions;

string visited[TOTAL_TRANSACTIONS] = {"white"};
int parent = 0;
bool hasCycle = true;

void dfs(int x)
{
    if (visited[x] == "grey")
    {
        hasCycle = false;
        cout << "\nCycle found\n";
        cout<<"T"<< parent << " --> " <<"T" << x << " ";
        return;
    }
    if (visited[x] == "black")
    {
        return;
    }

    visited[x] = "grey";
    parent = x;

    for (int child : adjacencyList[x])
    {
        dfs(child);
    }

    visited[x] = "black";
    return;
}

// Function to print the graph
void printGraph()
{
    cout << "Graph:\n";
    for (int i = 0; i < TOTAL_TRANSACTIONS; ++i)
    {
        if (!adjacencyList[i].empty())
        {
            cout<<"T"<< i << " -> ";
            for (int child : adjacencyList[i])
            {
                cout<<"T"<< child << " ";
            }
            cout << endl;
        }
    }
}

int main()
{

    fstream file;
    int N = 0;

    file.open("input.txt", ios::in);

    if (file.is_open())
    {
        string line;
        char operationType;
        int transactionNumber;
        string variable;

        while (getline(file, line))
        {
            operationType = line[0];
            transactionNumber = line[1] - '0'; // Convert char to int
            variable = line.substr(2);

            pair<pair<char, int>, string> operation;
            operation.first.first = operationType;
            operation.first.second = transactionNumber;
            operation.second = variable;
            transactions.push_back(operation);
        }
        file.close();
    }
    else
    {
        cout << "File not found!!!!\n";
    }

    for (int i = 0; i < transactions.size(); i++)
    {
        char currentOperationType = transactions[i].first.first;
        int currentTransactionNumber = transactions[i].first.second;
        string currentVariable = transactions[i].second;

        allTransactions.insert(currentTransactionNumber);
        for (int j = i + 1; j < transactions.size(); j++)
        {
            char nextOperationType = transactions[j].first.first;
            int nextTransactionNumber = transactions[j].first.second;
            string nextVariable = transactions[j].second;

            if (tolower(currentOperationType) == 'w' || (tolower(currentOperationType) == 'r' && tolower(nextOperationType) == 'w'))
            {
                if (currentVariable == nextVariable && currentTransactionNumber != nextTransactionNumber)
                {
                    adjacencyList[currentTransactionNumber].insert(nextTransactionNumber);
                }
            }
        }
    }

    printGraph();

    for (auto it = allTransactions.begin(); it != allTransactions.end(); ++it)
    {
        int tr = *it;
        dfs(tr);
    }

    if (hasCycle)
        cout << "\n\nConflict Serializable\n";
    else
        cout << "\n\nNot Conflict Serializable\n";
}
