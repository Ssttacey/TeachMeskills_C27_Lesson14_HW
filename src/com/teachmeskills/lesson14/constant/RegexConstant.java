package com.teachmeskills.lesson14.constant;

/**
 * the interface contains regular expressions to search for valid files
 */

public interface RegexConstant {
    String DOCNUM_REGEX = "^docnum[\\w]{9}$";
    String CONTRACT_REGEX = "^contract[\\w]{7}$";

}
