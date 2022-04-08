Create a POST /arrays endpoint that receives a relatively complex json object:

{
"what": "sum",
"numbers": [1, 2, 5, 10]
}

"what" can be 3 things: sum, multiply, double
and responds with sum or multiplication of all elements in the numbers
or with another array with the doubled elements:

e.g.: /arrays with {"what": "sum", "numbers": [1,2,5,10]} will respond {"result": 18}
e.g.: /arrays with {"what": "multiply", "numbers": [1,2,5,10]} will respond {"result": 100}
e.g.: /arrays with {"what": "double", "numbers": [1,2,5,10]} will respond {"result": 36}

if no "what" (or numbers) provided:

{
"error": "Please provide what to do with the numbers!"
}
