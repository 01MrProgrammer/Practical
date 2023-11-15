import pandas as pd

# Q2A: Handling Missing Values
file_path = 'Data.csv'  # Update with the actual path to your CSV file
df = pd.read_csv(file_path)

# Replace missing values with the mean of the respective columns
df['salary'].fillna(df['salary'].mean(), inplace=True)
df['age'].fillna(df['age'].mean(), inplace=True)

# Display the DataFrame after handling missing values
print("DataFrame after handling missing values:")
print(df)
