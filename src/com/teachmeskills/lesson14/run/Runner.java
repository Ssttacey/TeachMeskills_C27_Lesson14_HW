package com.teachmeskills.lesson14.run;

import com.teachmeskills.lesson14.constant.PathConst;
import com.teachmeskills.lesson14.constant.RegexConstant;
import com.teachmeskills.lesson14.service.DocReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * the interface contains regular expressions to search for valid files
 */
public class Runner {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter your file way ");

        String path = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line = reader.readLine();
            while (line != null) {
                DocReader.docReader(line, RegexConstant.DOCNUM_REGEX, RegexConstant.CONTRACT_REGEX, PathConst.PATH_TO_ERROR_LOGS, PathConst.PATH_TO_DOCNUM, PathConst.PATH_TO_CONTRACT);
                line = reader.readLine();
            }
        }
    }
}

