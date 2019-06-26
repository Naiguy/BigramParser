# BigramParser

Intakes a file and counts all bigrams within and presents the information. A bigram being a set of two subsequent, in-order words.

In hindsight, there are some structural changes I could make to make future features easier to implement.
I would rather Implement an arrayList of two-cell arrays, one for the unique bigram object and the other for its occurences.
This is all stored in the "histogram" object, which is meant to be used for presentation and culmination of the bigrams in the file.
