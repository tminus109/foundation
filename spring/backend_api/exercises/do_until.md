This is the continuation of the previous Frontend exercise,
you should extend that with a new endpoint.

You should create a logic that can do an operation until a specific number.

Create a dynamic POST /dountil/{operation} endpoint
That receives a number in a json object:

{
"until": 15
}

and responds with the sum or multiplication of all elements until that number:

e.g.: /dountil/sum with {"until": 5} will respond {"result": 15}
e.g.: /dountil/factor with {"until": 5} will respond {"result": 120}

If no number is provided:

{
"error": "Please provide a number!"
}

Check your application in the browser and click on the "Try dountil" endpoint button.
