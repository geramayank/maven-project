package com.example;

/**
 * This is a class.
 */
public class Greeter {

  /**
   * This is a constructor.
   */
  public Greeter() {

  }  
  /**
   * @param someone name of person
   * @return greeting string
   */
  public final String greet(final String someone) {
	  /* returing string */
    return String.format("Hello, %s!", someone);
  }
}
