Create a function that takes a number and an array of integers as parameters.
It returns the indices of the integers of the array which contain the given number 
or returns an empty array (if the number is not part of the integers in the array)

Examples:

System.out.println(Arrays.toString(findMatchingIndexes(1, new int[] {1, 11, 34, 52, 61})));
should print: `[0, 1, 4]`
System.out.println(Arrays.toString(findMatchingIndexes(9, new int[] {1, 11, 34, 52, 61})));
should print: '[]'

Note: We are using Arrays.toString() function to print the array returned.
You could just as well iterate over the array and print its items one by one.
