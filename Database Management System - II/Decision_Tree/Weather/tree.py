import numpy as np
import pandas as pd
from sklearn.metrics import confusion_matrix
import seaborn as sns
import matplotlib.pyplot as plt

class Node:
    def __init__(self, feature=None, value=None, result=None):
        self.feature = feature  # Feature to split on
        self.value = value      # Value of the feature to split on
        self.result = result    # Result if node is a leaf node
        self.children = {}      # Children nodes

def entropy(data):
    target = data[:, -1]
    elements, counts = np.unique(target, return_counts=True)
    probabilities = counts / counts.sum()
    entropy = -np.sum(probabilities * np.log2(probabilities))
    return entropy

def information_gain(parent, children):
    parent_entropy = entropy(parent)
    total_children_instances = sum(len(child) for child in children)
    children_entropy = sum(len(child) / total_children_instances * entropy(child) for child in children)
    return parent_entropy - children_entropy

def split_data(data, feature_index, value):
    data_below = data[data[:, feature_index] <= value]
    data_above = data[data[:, feature_index] > value]
    return data_below, data_above

def find_best_split(data):
    best_gain = 0
    best_feature = None
    best_value = None
    n_features = data.shape[1] - 1

    for feature_index in range(n_features):
        feature_values = np.unique(data[:, feature_index])
        for value in feature_values:
            data_below, data_above = split_data(data, feature_index, value)
            children = [data_below, data_above]
            gain = information_gain(data, children)
            if gain > best_gain:
                best_gain = gain
                best_feature = feature_index
                best_value = value

    return best_feature, best_value

def get_most_common_label(data):
    target = data[:, -1]
    return np.bincount(target.astype(int)).argmax()

def build_tree(data):
    if len(data) == 0:
        return Node()

    if len(np.unique(data[:, -1])) == 1:
        return Node(result=data[0, -1])

    best_feature, best_value = find_best_split(data)
    data_below, data_above = split_data(data, best_feature, best_value)

    if len(data_below) == 0 or len(data_above) == 0:
        return Node(result=get_most_common_label(data))

    node = Node(feature=best_feature, value=best_value)

    node.children["<= " + str(best_value)] = build_tree(data_below)
    node.children["> " + str(best_value)] = build_tree(data_above)

    return node

def predict(tree, sample):
    if tree.result is not None:
        return tree.result
    value = sample[tree.feature]
    if value <= tree.value:
        return predict(tree.children["<= " + str(tree.value)], sample)
    else:
        return predict(tree.children["> " + str(tree.value)], sample)

def print_tree(node, depth=0):
    if node.result is not None:
        print(" " * depth, "Predict", node.result)
        return
    print(" " * depth, "Feature", node.feature, "<=", node.value)
    for key, value in node.children.items():
        print_tree(value, depth + 2)

# Read the CSV file
data = pd.read_csv("weather.csv").values

# Build the decision tree
tree = build_tree(data)

# Print the decision tree
print_tree(tree)

# Read the input data
input_data = pd.read_csv("in.csv").values

# Predict the species for input data
output = []
for sample in input_data:
    prediction = predict(tree, sample)
    output.append(prediction)

# Save the output to out.txt file
with open("out.txt", "w") as f:
    for prediction in output:
        f.write(prediction + "\n")
        
# Read the actual labels
with open("actual.txt", "r") as f:
    actual_labels = f.readlines()

# Read the predicted labels
with open("out.txt", "r") as f:
    predicted_labels = f.readlines()

# Remove newline characters from labels
actual_labels = [label.strip() for label in actual_labels]
predicted_labels = [label.strip() for label in predicted_labels]

# Calculate accuracy
correct_predictions = sum(1 for actual, predicted in zip(actual_labels, predicted_labels) if actual == predicted)
total_samples = len(actual_labels)
accuracy = correct_predictions / total_samples * 100

print("Accuracy:", accuracy, "%")

# Print confusion matrix
conf_matrix = confusion_matrix(actual_labels, predicted_labels, labels=["Yes", "No"])
plt.figure(figsize=(8, 6))
sns.heatmap(conf_matrix, annot=True, fmt="d", cmap="Blues", xticklabels=["Yes", "No"], yticklabels=["Yes", "No"])
plt.xlabel('Predicted labels')
plt.ylabel('True labels')
plt.title('Confusion Matrix')
plt.show()

