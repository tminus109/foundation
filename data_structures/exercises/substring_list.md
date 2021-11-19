Create a function that takes a string and a list of strings as parameters
and returns the index of the string (in the list) which contains the first string.
You only need to find the first occurrence and return the index of that.
Return `-1` if none of the items in the list contain the first string.
    
Examples:

String[] searchArr = new String[] {"this", "is", "what", "I'm", "searching"};

System.out.println(findIndex("ching", searchArr));
should print: `4`

System.out.println(findIndex("not", searchArr));
should print: `-1`
