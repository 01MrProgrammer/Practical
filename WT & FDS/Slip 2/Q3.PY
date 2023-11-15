import matplotlib.pyplot as plt

# Q2B: Line Plot of Name vs. Salary
plt.plot(df['name'], df['salary'], marker='o', linestyle='-', color='b')
plt.xlabel('Name')
plt.ylabel('Salary')
plt.title('Name vs. Salary')
plt.xticks(rotation=90)
plt.show()
