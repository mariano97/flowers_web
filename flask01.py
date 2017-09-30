# -*- coding: utf-8 -*-





from flask import Flask
import pickle
  
import sys
import scipy
import numpy
import matplotlib
import pandas
import sklearn
 
    
app = Flask(__name__)

#@app.route("/<username>")
#def home(username):
    
@app.route("/<sl>/<sw>/<pl>/<pw>")
def home(sl,sw,pl,pw):
    #la direccion acontinuacion se cambia por la direccion nueva del "ejemplo_modelo.mod"
    filename = "C:\Users\MARIO\Documents\python-iot\ejemplo_modelo.mod"
    modelo_svm = pickle.load(open(filename, 'rb'))
    
    
    """
    sepal_length = 5.0
    sepal_width = 3.5
    petal_length = 1.3
    petal_width = 0.3
    5.0/3.5/1.3/0.3
    """
    sepal_length = sl
    sepal_width = sw
    petal_length = pl
    petal_width = pw
    
    clase = modelo_svm.predict([[sepal_length, sepal_width, petal_length, petal_width]])
    #print(clase)
    #return "Hello Guest! " + username
    return str(clase)
    
    return filename    


if __name__ == "__main__":
    app.run()

