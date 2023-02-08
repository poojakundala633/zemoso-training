import heapq
def dijkstra(graph, start, end):
    distances = {node: float('inf') for node in graph}
    distances[start] = 0
    heap = [(0, start)]
    while heap:
        (distance, current) = heapq.heappop(heap)
        if current == end:
            break
        for neighbor in graph[current]:
            new_distance = distance + graph[current][neighbor]
            if new_distance < distances[neighbor]:
                distances[neighbor] = new_distance
                heapq.heappush(heap, (new_distance, neighbor))
    return distances[end]


##############################################################################

def construct_graph(routes, costs):
    graph = {}
    for i, route in enumerate(routes):
        if route[0] not in graph:
            graph[route[0]] = {}
        if route[1] not in graph:
            graph[route[1]] = {}
        graph[route[0]][route[1]] = costs[i]
        graph[route[1]][route[0]] = costs[i]
    return graph


###############################################################################
print("BUS ROUTING SYSTEM")
print("-"*20)
print("Enter the number of Routes")
r=int(input())
routes=[]
cost=[]
for i in range(r):
    t=[]
    print("-"*20)
    print("enter the cites which having routes:-",i+1)
    print("enter the city from")
    t.append(input())
    print("enter the city to")
    t.append(input())
    routes.append(tuple(t))
    print("enter the cost between those cities:")
    cost.append(int(input()))
    print("-"*20)
print("-------GRAPH FOR THE ABOVE DATA-----")
graph = construct_graph(routes, cost)

print(graph)
#########################################
print("Taking the start and end destination from the user:")
print("Naina starting destination :")
start=input()
print("Naina ending destination :")
end=input()
print("Shortest distance between {} and {} is {}".format(start, end, dijkstra(graph, start, end)))
print("end")