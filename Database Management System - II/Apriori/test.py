from itertools import combinations

def load_data(filename):
    data = []
    with open(filename, 'r') as file:
        for line in file:
            transaction = line.strip().split(',')
            data.append(set(transaction))
    return data

def get_unique_items(data):
    unique_items = set()
    for transaction in data:
        unique_items.update(transaction)
    return sorted(list(unique_items))

def generate_candidates(prev_itemsets, k):
    candidates = set()  # Initialize an empty set to store candidate itemsets
    for i in range(len(prev_itemsets)):  # Iterate over the indices of previous itemsets
        for j in range(i + 1, len(prev_itemsets)):  # Iterate over subsequent indices for combinations
            union_set = prev_itemsets[i].union(prev_itemsets[j])  # Union of two itemsets
            if len(union_set) == k:  # Check if the size of the union set equals k
                candidates.add(union_set)  # Add the union set to the candidates set
    return list(candidates)  # Convert the set of candidates to a list and return it

def prune_candidates(candidates, prev_frequent_itemsets):
    pruned_candidates = []  # Initialize an empty list to store pruned candidate itemsets
    for candidate in candidates:  # Iterate over each candidate itemset
        subsets = list(combinations(candidate, len(candidate) - 1))  # Generate all subsets of the candidate itemset
        is_valid = all(set(subset) in prev_frequent_itemsets for subset in subsets)  # Check if all subsets are frequent
        if is_valid:  # If all subsets are frequent
            pruned_candidates.append(candidate) 
        
    # print("prune_candidates \n",prune_candidates) # Add the candidate itemset to the pruned list
    return pruned_candidates  # Return the pruned list of candidate itemsets

def apriori(data, min_support):
    unique_items = get_unique_items(data)  # Extract unique items from the transaction data
    frequent_itemsets = []  # Initialize list to store frequent itemsets

    # Initialization: Generate 1-itemsets
    itemsets = [frozenset([item]) for item in unique_items]  # Create 1-itemsets from unique items
    k = 2  # Initialize the size of itemsets to 2 for the next iteration
    # print(itemsets)
    # print("\n")
    while itemsets:  # Continue the loop until no more itemsets can be generated
        # Count support for each itemset
        itemset_counts = {itemset: 0 for itemset in itemsets}
        # print(itemset_counts)  # Initialize counts for each itemset to 0
        for transaction in data:  # Iterate over each transaction in the data
            for itemset in itemsets:  # Check if the itemset is contained in the transaction
                if itemset.issubset(transaction):  # If the itemset is contained in the transaction
                    itemset_counts[itemset] += 1  # Increment the count for the itemset

        # Prune itemsets based on minimum support
        frequent_itemsets_k = [itemset for itemset, count in itemset_counts.items() if count >= min_support]
        # Select itemsets with support count greater than or equal to min_support
        frequent_itemsets.extend(frequent_itemsets_k)  # Add frequent itemsets to the list

        # print("\n frequent_itemsets : " ,frequent_itemsets)
        # print("\n frequent_itemsets_k : ",frequent_itemsets_k )
        # Generate candidates for the next iteration
        candidates_k = generate_candidates(frequent_itemsets_k, k)  # Generate candidate itemsets of size k
        candidates_k = prune_candidates(candidates_k, frequent_itemsets_k)  # Prune the candidate itemsets

        itemsets = candidates_k  # Update itemsets for the next iteration
        k += 1  # Increment the size of itemsets for the next iteration

    return frequent_itemsets  # Return the list of frequent itemsets

if __name__ == "__main__":
    filename = "input.txt"
    min_support = int(input("Enter the minimum support count: "))
    
    data = load_data(filename)
    result = apriori(data, min_support)
    
    # Group the frequent itemsets by their lengths
    grouped_itemsets = {}
    for itemset in result:
        length = len(itemset)
        if length not in grouped_itemsets:
            grouped_itemsets[length] = []
        grouped_itemsets[length].append(itemset)
    
    output_filename = "output.txt"  # Specific output filename

    # Write output to a file
    with open(output_filename, 'w') as output_file:
        for length, itemsets in sorted(grouped_itemsets.items()):
            output_file.write(f"for {length} length:\n")
            for itemset in itemsets:
                output_file.write(f"{set(itemset)}\n")

    print("Frequent Itemsets have been written to", output_filename)