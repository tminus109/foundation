Create a function called secondLargestPerimeter that
takes an array of triangles as an input
(a triangle is represented by an array with 3 integers which are the length of its sides),
returns the index of the triangle which has the second-largest perimeter.
It should return -1 if the size of the array is less than 2.

Note: you don't have to create a Triangle class, and you might assume that all
triangles are valid.

Example cases:

secondLargestPerimeter([[2, 3, 4], [7, 8, 9], [4, 5, 6], [10, 11, 12]]);
It should return 2, because the [7, 8, 9] triangle has the second-largest perimeter.

secondLargestPerimeter([[2, 3, 4], [4, 5, 6]]);
It should return 0, because the [2, 3, 4] triangle has the second-largest perimeter.

secondLargestPerimeter([]);
It should return -1.
