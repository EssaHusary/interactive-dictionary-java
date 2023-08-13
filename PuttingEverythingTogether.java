import java.util.*;

public class PuttingEverythingTogether {


    // This method brings everything together from all of our other classes. Will be called in main to run the program.
    public static void finalProduct() {
        DataOperations key = new DataOperations();


        System.out.println("! Loading data...");


        // Database from our enum class is deep copied
        TreeMap<String, ArrayList<String[]>> dictionaryData = new TreeMap<>(DataSource.Enums.addWordsToDatabase());


        System.out.println("! Loading completed...");
        System.out.println();
        System.out.println("==== Dictionary 340 Java ====");
        System.out.println("---- Keywords: " + dictionaryData.size());
        System.out.println("---- Definitions: 61");
        System.out.println();


        int search = 1;   // Variable that will be incremented as the user performs more searches
        String word = "";
        Scanner enter = new Scanner(System.in);



        while(!word.equalsIgnoreCase("!q")){
            System.out.print("Search ["+ search++ + "]: ");   // Search variable is incremented every search

            String[] keyWords = enter.nextLine().split(" ");    // String array of user inputted keys

            ArrayList<String> previousResults;  // Will be used to perform back-to-back operations


            if (keyWords[0].equalsIgnoreCase("!q")){

                break;

            } else if (keyWords[0].isEmpty() || keyWords[0].equalsIgnoreCase("!help")){

                key.sendInstructions();

            } else if (!dictionaryData.containsKey(keyWords[0])){    /* Informs the user that the word doesn't have a
                                                                        definition yet. */

                System.out.println("   |\n" +
                        "    <NOT FOUND> To be considered for the next release. Thank you.\n" +
                        "   |");
                key.sendInstructions();

            } else if (keyWords.length == 1) {   // Displays initial search results without "search modifiers", ie reverse

                key.displayResults(key.sortInAlphabeticalOrder(keyWords[0], dictionaryData));
            }


            if (keyWords.length>=5){

                key.sendInstructions();

            } else if (keyWords.length>=2) {



                /* Uses displayed/previous results to perform first operation on keyword. The
                   "key.sortInAlphabeticalOrder(keyWords[0], dictionaryData)" is a "previousResult"  */
                previousResults = key.defineEntry(key.sortInAlphabeticalOrder(keyWords[0], dictionaryData), keyWords[1]);


                if(keyWords.length>=3) {   // Second operation on keyword


                    previousResults = key.defineEntry(previousResults, keyWords[2]);


                    if(keyWords.length>=4) {  // Third operation on keyword


                        previousResults = key.defineEntry(previousResults, keyWords[3]);


                    }
                }

                key.displayResults(previousResults);    // Displays results of search

            }

        }

        System.out.println();
        System.out.println("-----THANK YOU-----");

    }
}
