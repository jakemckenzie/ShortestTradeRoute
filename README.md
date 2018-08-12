# ShortestTradeRoute
There are n trading posts numbered 1 to n as you travel downstream. 
At any trading post i you can rent a canoe to be returned at any of the downstream trading posts j>i. 
You are given a cost array R(i,j) giving the cost of these rentals for all 1≤i<j≤n. 
We can assume that R(i,i)=0, and that you can't go upriver (so perhaps R(i,j)= ∞ if i>j).
For example, one cost array with n=4 might be the following.

0237

-024

--02

---0

The problem is to find a dynamic programming algorithm that computes the cheapest sequence of rental taking you from post 1 all the way down to post n. 
In this example, the cheapest way is to rent canoes from post 1 to post 3, and then from post 3 to post 4 for a total cost of 5. 
The second problem is to find the least cost associated with this sequence. 
You are to design a dynamic programming algorithm for both the problems.
