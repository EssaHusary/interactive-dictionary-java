import java.util.*;

public class DataOperations{


    public static String toString(Integer loopIndex, String userInput) {

        return DataSource.Enums.addWordsToDatabase().get(userInput).get(loopIndex)[0] + " [" +
                DataSource.Enums.addWordsToDatabase().get(userInput).get(loopIndex)[1]
                + "] " +  ": " +  DataSource.Enums.addWordsToDatabase().get(userInput).get(loopIndex)[2];

    }




    public void sendInstructions(){
        System.out.println("   |");
        System.out.println("    PARAMETER HOW-TO, please enter: ");
        System.out.println("    1. A search key -then 2. An optional part of speech -then");
        System.out.println("    3. An optional 'distinct' -then 4. An optional 'reverse'");
        System.out.println("   |");
    }





    /* This method takes in user input to determine what operation to perform. It uses previous results to perform such
       operations since we're doing back-to-back operations (hence the name of the variable). */
    public ArrayList<String> defineEntry(ArrayList<String> previousResults, String key){

        if(key.equalsIgnoreCase("noun") || key.equalsIgnoreCase("verb") || key.equalsIgnoreCase("adjective") ||
                key.equalsIgnoreCase("adverb") || key.equalsIgnoreCase("pronoun") || key.equalsIgnoreCase("preposition")
                || key.equalsIgnoreCase("conjunction") || key.equalsIgnoreCase("interjection") ||
                key.equalsIgnoreCase("article")){

            return partOfSpeech(key, previousResults);

        } else if (key.equalsIgnoreCase("distinct")){

            return distinct(previousResults);

        } else if (key.equalsIgnoreCase("reverse")){

            return displayResultsInReverse(previousResults);

        } else {

            System.out.println("   |\n" +
                    "    <The entered parameter '" + key + "' is NOT a part of speech.>\n" +
                    "    <The entered parameter '" + key + "' is NOT 'distinct'.>\n" +
                    "    <The entered parameter '" + key + "' is NOT 'reverse'.>\n" +
                    "    <The entered parameter '" + key + "' was disregarded.>\n" +
                    "    <The parameter should be a part of speech or 'distinct' or 'reverse'.>\n" +
                    "   |\n");

            return previousResults;
        }
    }






    /* This method turns our arrays from our deep-copied database map into Strings, stores those Strings in an
       ArrayList, and then returns this ArrayList of Strings. The returned value will be used as the first
       "previousResults" variable in the "DictionarySetUp" class to perform operations such as "distinct", "reverse",
       and specifying a part of speech */
    public ArrayList<String> sortInAlphabeticalOrder(String key, TreeMap<String, ArrayList<String[]>> entries){

        ArrayList<String> stringsToBeCompared = new ArrayList<>();

        for (int i = 0; i < entries.get(key).size(); i++){

            stringsToBeCompared.add(toString(i, key));
        }

        for (int i = 0; i < stringsToBeCompared.size(); i++) {

            for (int j = 0; j < stringsToBeCompared.size(); j++){

                if (stringsToBeCompared.get(i).compareTo(stringsToBeCompared.get(j)) < 0){
                    Collections.swap(stringsToBeCompared, i, j);
                }
            }
        }

        return stringsToBeCompared;
    }





    /* Displays our results after doing all of the operations we want to do to a dictionary entry (this uses the final
       "previousResults" variable in the "DictionarySetUp" class */
    public void displayResults(ArrayList<String> previousResults){

        System.out.println("   |");


        for (String entry: previousResults) {

            System.out.println("    " + entry);

        }

        System.out.println("   |");
    }





    public ArrayList<String> displayResultsInReverse(ArrayList<String> previousResults){


        for (int i = 0; i < previousResults.size(); i++) {

            for (int j = 0; j < previousResults.size(); j++){

                if (previousResults.get(i).compareTo(previousResults.get(j)) > 0){
                    Collections.swap(previousResults, i, j);
                }

            }
        }

        return previousResults;
    }





    /* Uses a counter variable where everytime we match two Strings, the variable increases in value (and the duplicate
       gets removed). Counter variable gets reset in the outer 'for' loop so that we can check if the next String has
       duplicates */
    public ArrayList<String> distinct(ArrayList<String> previousResults){

        int stringAppearanceCount = 0;

        for (int i = 0; i < previousResults.size(); i++){

            for (int j = 0; j < previousResults.size(); j++){

                if (previousResults.get(i).equalsIgnoreCase(previousResults.get(j))){

                    stringAppearanceCount++;

                    if (stringAppearanceCount >= 2){

                        previousResults.remove(previousResults.get(j));

                    }
                }
            }

            stringAppearanceCount = 0;

        }

        return previousResults;

    }





    /* Uses the removeif() method to remove Strings (comprised of a keyword, part of speech, and definition) that do
       contain the specified part of speech */
    public ArrayList<String> partOfSpeech(String key, ArrayList<String> previousResults){

        previousResults.removeIf(e -> !e.contains(key));

        return previousResults;

    }
}

