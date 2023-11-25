#S1Q2
import pandas as pd

path = r'Height.csv'
data = pd.read_csv(path)
df = pd.DataFrame(data)
print(df)
print(df.describe())