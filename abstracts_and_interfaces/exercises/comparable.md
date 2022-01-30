Check out what is the Comparable interface.

Get your Domino class. Implement the Comparable interface on the Domino.
Why? We want to compare based on the result of Domino.compareTo().
First compare the first value and then the second.

List<Domino> dominoes = new ArrayList<>();

dominoes.add(new Domino(5, 2));
dominoes.add(new Domino(4, 6));
dominoes.add(new Domino(1, 5));
dominoes.add(new Domino(6, 7));
dominoes.add(new Domino(2, 4));
dominoes.add(new Domino(7, 1));

Collections.sort(dominoes);

The order of your dominoes should look like this: [[1,5], [2,4], [4,6], [5,2], [6,7], [7,1]].
