# In case of missing package: $ pip3 install pandas
import pandas as pd
import numpy as np

values = pd.Series([1, 3, 5, np.random.rand(1), 6, 8])

# Print summary statistics in next line
values.describe()

# Fill in the line below to read the file into a variable home_data
# home_data = pd.read_csv(iowa_file_path)

# Print summary statistics in next line
# home_data.describe()

# Call line below with no argument to check that you've loaded the data correctly
# step_1.check()