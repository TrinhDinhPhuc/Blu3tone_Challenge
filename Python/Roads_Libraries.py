#!/bin/python3
import sys
def roadsAndLibraries(n, c_lib, c_road, cities):
    return ("Please implement me")

if __name__ == "__main__":
    data = open("../Res/sample_input.txt", "r")
    q = int(data.readline())
    for a0 in range(q):
        n, m, c_lib, c_road = data.readline().strip().split(' ')
        n, m, c_lib, c_road = [int(n), int(m), int(c_lib), int(c_road)]
        cities = []
        for cities_i in range(m):
            cities_t = [int(cities_temp) for cities_temp in data.readline().strip().split(' ')]
            cities.append(cities_t)
        result = roadsAndLibraries(n, c_lib, c_road, cities)
        print(result)