#Q.2 A) Write a Python program to create a Pie plot to get the frequency of the three species of 
#the Iris data (Use iris.csv)

import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt


plt.figure(figsize=(8, 8))
plt.pie(species_counts, labels=species_counts.index, autopct='%1.1f%%', startangle=140)
plt.title('Frequency of Iris Species (Pie Chart)')
plt.axis('equal')

plt.show()