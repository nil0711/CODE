package knapsack;

import java.util.*;

class Item {
    int weight;
    int value;
    double valuePerWeight;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.valuePerWeight = (double) value / weight;
    }
}

public class KnapsackGreedy {
    // Function to solve the Knapsack problem using Greedy technique
    public static int knapsack(Item[] items, int weightLimit) {
        // Step 1: Sort items in decreasing order of value-to-weight ratio
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                return Double.compare(b.valuePerWeight, a.valuePerWeight);
            }
        });

        // Step 2: Initialize the total value and remaining weight of the knapsack
        int totalValue = 0;
        int remainingWeight = weightLimit;

        // Step 3: Add items to the knapsack until the weight limit is reached
        for (int i = 0; i < items.length; i++) {
            if (remainingWeight >= items[i].weight) {
                totalValue += items[i].value;
                remainingWeight -= items[i].weight;
            } else {
                // Add a fractional amount of the item to the knapsack
                totalValue += (int) (items[i].valuePerWeight * remainingWeight);
                break;
            }
        }

        // Step 4: Return the total value of items in the knapsack
        return totalValue;
    }

    // Example usage
    public static void main(String[] args) {
        Item[] items = {new Item(10, 60), new Item(20, 100), new Item(30, 120)};
        int weightLimit = 50;
        int totalValue = knapsack(items, weightLimit);
        System.out.println("Total value of items in the knapsack: " + totalValue);
    }
}

