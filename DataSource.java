import java.util.*;

public class DataSource {

    public enum Enums {

        KEYWORD_1(DictionaryTerms.arrow), KEYWORD_2(DictionaryTerms.book), KEYWORD_3(DictionaryTerms.distinct),

        KEYWORD_4(DictionaryTerms.placeholder), KEYWORD_5(DictionaryTerms.reverse), KEYWORD_6(DictionaryTerms.snow),

        KEYWORD_7(DictionaryTerms.green), KEYWORD_8(DictionaryTerms.earth), KEYWORD_9(DictionaryTerms.pepper),

        KEYWORD_10(DictionaryTerms.paper), KEYWORD_11(DictionaryTerms.wind), KEYWORD_12(DictionaryTerms.pencil),

        KEYWORD_13(DictionaryTerms.water), KEYWORD_14(DictionaryTerms.sprinkle), KEYWORD_15(DictionaryTerms.leaf),

        KEYWORD_16(DictionaryTerms.soil), KEYWORD_17(DictionaryTerms.ocean), KEYWORD_18(DictionaryTerms.cloud),

        KEYWORD_19(DictionaryTerms.trunk);




        private ArrayList<String[]> entry;

        public ArrayList<String[]> getEntry(){
            return entry;
        }

        public void setEntry(ArrayList<String[]> newEntry){
            this.entry = newEntry;
        }

        Enums(ArrayList<String[]> entry) {
            this.entry = entry;
        }




        static TreeMap<String, ArrayList<String[]>> addWordsToDatabase() {

            TreeMap<String, ArrayList<String[]>> database = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

            /* This 'for' loop stores our enum data into a map, with the key being the keyword, and the value being
               an ArrayList of String arrays */
            for (Enums enu : Enums.values()) {

                database.put(enu.entry.get(0)[0], enu.entry);

            }

            return database;
        }
    }
}
