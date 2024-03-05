package com.teachmeskills.lesson14.service;

import java.io.FileWriter;
import java.io.IOException;

/**
 * method for reading documents
 */
public class DocReader {
    public static void docReader( String s, String s1, String s2, String PATH_TO_ERROR_LOGS, String PATH_TO_DOCNUM, String PATH_TO_CONTRACT) throws IOException {

        FileWriter docWriter = new FileWriter(PATH_TO_DOCNUM, true);
        FileWriter contrWriter = new FileWriter(PATH_TO_CONTRACT, true);
        FileWriter errorDocWriter = new FileWriter(PATH_TO_ERROR_LOGS, true);
        try {
            if (s.length() != 15) {
                System.out.println("There must be mistake. Check your data please. ");
                errorDocWriter.write("String is to short or long. The string must be equals 15. Your string  " + s + " length is  " + s.length() + ".\n");
                return;
            }
            char[] chars;
            chars = s.toCharArray();
            if (!s.startsWith(s1) && !s.startsWith(s2)) {
                errorDocWriter.write("invalid data. Wrong symbols  ");
            } else if (s.startsWith(s1)) {
                for (int i = 0; i < s.length(); i++) {
                    if (!Character.isDigit(chars[i]) && !Character.isLetter(chars[i])) {
                        errorDocWriter.write("String " + s + " is invalid. there should be no service characters in the line ");
                        return;
                    }
                }

                docWriter.write("The number of your document is: " + s + "\n");
            } else if (s.startsWith(s2)) {
                for (int i = 0; i < s.length(); i++) {
                    if (!Character.isDigit(chars[i]) && !Character.isLetter(chars[i])) {
                        errorDocWriter.write("String " + s + " is invalid. there should be no service characters in the line");
                        return;
                    }
                }
                contrWriter.write("The number of your contract is: " + s + "\n");
            }

        } catch(IOException e)
            {
                errorDocWriter.write("when processing a string " + s + "an unexpected error occurred ");
                System.out.println("Something goes wrong...  ");
            } catch(Exception e){
                errorDocWriter.write("when processing a string " + s + "an unexpected error occurred ");
                System.out.println("Something goes wrong... I really don't know what happened. Can't help u. Sorry. ");
            }
        finally{
                errorDocWriter.close();
                docWriter.close();
                contrWriter.close();
            }
        }
    }