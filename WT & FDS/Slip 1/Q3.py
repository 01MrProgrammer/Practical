import pandas as pd
import numpy as np
from sklearn import preprocessing
import scipy.stats as s
df=pd.read_csv(r"winequality-red.csv")
df

import scipy.stats as s
print("min max scale data")
ds=preprocessing.MinMaxScaler(feature_range=(0,1))
ds1=ds.fit_transform(df)
print(ds1.round(2))
print("---------------------------------------------")
print("normalizded data")
dn=preprocessing.normalize(df,norm='l1')
print(dn.round(2))
print("---------------------------------------------")
print("binarized data")
db=preprocessing.Binarizer(threshold=5).transform(df)
print(db)
print("---------------------------------------------")
print("standardized data")
print("initial mean:",s.tmean(df).round(2))
print("initial sd:",round(df.std(),2))


x_s=preprocessing.scale(df)
x_s.mean(axis=0)
x_s.std(axis=0)
print("sd data:")
print("scaled mean:",s.tmean(x_s).round(2))
print("scaled sd:",round(x_s.std(),2))
