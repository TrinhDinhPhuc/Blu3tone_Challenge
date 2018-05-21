#!/bin/python3
import sys
class Roads_and_Libs():
    cities = []
    visited=[]
    count = 0

    @staticmethod
    def dfs(ral,i):
        ral.visited[i] = True
        ral.count += 1
        list = []
        list = ral.cities[i]
        for j in range(0, len(list), 1):
            if (not ral.visited[list[j]]):
                ral.dfs(ral,list[j])

    @staticmethod
    def roadsAndLibraries(ral,c_lib, c_road):
        cost = 0
        for i in range(0, len(ral.cities), 1):
            if (not ral.visited[i]):
                ral.count = 0
                ral.dfs(ral,i)
                if (c_lib > c_road):
                    cost += c_lib + c_road * (ral.count - 1)
                else:
                    cost += c_lib * ral.count
        return cost

def main():
    exam = Roads_and_Libs()
    data = open("../Res/input.txt", "r")
    q = int(data.readline())
    for a0 in range(q):
        n, m, c_lib, c_road = data.readline().strip().split(' ')
        n, m, c_lib, c_road = [int(n), int(m), int(c_lib), int(c_road)]
        exam.cities=[]
        for cities_i in range(m):
            cities_t = [int(cities_temp) for cities_temp in data.readline().strip().split(' ')]
            exam.cities.append(cities_t)
        for i in range(1, len(exam.cities), 1):
            exam.cities[i][0]= abs((exam.cities[i-1][0]+exam.cities[i-1][1]) - exam.cities[i][0])
            exam.cities[i][1]= abs((exam.cities[i-1][0]+exam.cities[i-1][1])- exam.cities[i][1])
        exam.visited = [False] * n
        result = exam.roadsAndLibraries(exam,c_lib, c_road)
        print("Result = ",result)
if __name__=="__main__":
    main()
