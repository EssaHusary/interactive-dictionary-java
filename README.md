# Interactive Dictionary, Java version
This is the Java version of an interactive dictionary I created where users can look up the definitions of words and apply search filters to their searches. Unlike the C++ version of this project, there isn't a text file the program needs to process; therefore, the user doesn't need to specify a text file. 

I did the following. I created a separate file for dictionary words called "DataSource" that can be amended in the future (Enums were used). This file works in tandem with another class called "DictionaryTerms" in which words can have multiple definitions in the form of a list of definitions (specifically, a list of String arrays). Operations are performed on these entries in a class called "DataOperations" where these operations include sorting definitions in alphabetical order, sorting definitions in reverse alphabetical order, and filtering out repeat definitions. Everything is put together in a function called finalProduct() in a class called "PuttingEverythingTogether", where the user is prompted to request dictionary definitions. This function, "finalProduct", is called in the class, "InteractiveDictionaryDriver", where main() is located.

Here is how it works from the perspective of the user:

1) After where it says "Search [X]: ", four parameters are possible:
   - The first parameter must be the word you'd like the definition of.
   - The second parameter can be left blank or must be either a part of speech, the key 'distinct', which filters out duplicate definitions, or the key 'reverse', which reverses the display from A-Z (alphabetical order) to Z-A.
   - The third parameter can be left blank or must be either 'distinct' or 'reverse'.
   - The fourth and final parameter can be left blank or must be the key 'reverse'.
2) The words that are part of the vocabulary of this dictionary are the following: arrow, book, distinct, placeholder, reverse, snow, green, earth, pepper, paper, wind, pencil, water, sprinkle, leaf, soil, ocean, cloud, and trunk. 
This is how it will look when you run it:

![image](https://github.com/user-attachments/assets/441b7815-c987-4478-a174-d2177eabac44)


Here is us looking up the definition of "reverse": 
![image](https://github.com/user-attachments/assets/2b508659-b8d1-4d16-bf99-ccd2c1ea1d11)


Here is an example of looking up the definition of "reverse", specifying that we want to see the noun definitions and that we do not want duplicate definitions: 
![image](https://github.com/user-attachments/assets/51821fb0-e7dc-42ff-ac83-b54ee4889613)


Finally, here is an example of reversing the results (reverse alphabetical order) of our previous inquiry: 
![image](https://github.com/user-attachments/assets/54aa116a-ceae-4a47-b611-62537736484c)
