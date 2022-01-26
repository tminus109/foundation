The task is to create a garden application,
so in your main method you should create a garden with flowers and trees.
The program should demonstrate an example garden with two flowers
(yellow and blue) and two trees (purple and orange).
After creating these plants, you should show the user how the garden looks like.
After that, the program should water the garden twice
first, with the amount of 40 then with 70.
After every watering, the user should see the state of the garden
as you can see in the output below:

The yellow Flower needs water
The blue Flower needs water
The purple Tree needs water
The orange Tree needs water

Watering with 40:

The yellow Flower doesn't need water
The blue Flower doesn't need water
The purple Tree needs water
The orange Tree needs water

Watering with 70:

The yellow Flower doesn't need water
The blue Flower doesn't need water
The purple Tree doesn't need water
The orange Tree doesn't need water

Information on the elements:

The Garden:

Is able to hold unlimited amount of flowers and trees.
When watering, it should only water those plants that need water
with equally divided amount amongst them.
E.g.: watering with 40 and 4 of them need water then each gets watered with 10.

The Flower:

Needs water if its current water amount is less than 5.
When watered, the flower can only absorb 75% of the water.
E.g.: watering with 10, the flower's amount of water should only increase by 7.5.

The Tree:

Needs water if its current water amount is less than 10.
When watered, the tree can only absorb the 40% of the water.
E.g.: watering with 10, the tree's amount of water should only increase by 4.
