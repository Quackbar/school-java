#FahrenheitToCelcius
#Bernard Kintzing
#9/15/2016

tempF = input('Enter the teperature in Fahernheit: ')
tempF = float(tempF)
tempC = (tempF - 32) * (5/9)
tempK = (tempC + 273.15)
tempK = float(tempK)
print(str(tempF) + '°F is ' + str(tempC) + '°C and is ' + str(tempK) + '°K')
