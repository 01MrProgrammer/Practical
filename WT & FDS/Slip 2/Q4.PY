import pandas as pd
import numpy as np

# Q2C: Loading Heights and Weights Dataset
heights_weights_path = 'heights_weights.csv'  # Replace with the actual path to your CSV file
hw_df = pd.read_csv(heights_weights_path)

# Display first 10 rows
print("First 10 rows:")
print(hw_df.head(10))

# Display last 10 rows
print("\nLast 10 rows:")
print(hw_df.tail(10))

# Display random 20 rows
print("\nRandom 20 rows:")
print(hw_df.sample(20))

# Display shape of the dataset
print("\nShape of the dataset:")
print(hw_df.shape)
