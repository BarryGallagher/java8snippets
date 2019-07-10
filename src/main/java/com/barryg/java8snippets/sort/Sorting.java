package com.barryg.java8snippets.sort;

import com.barryg.java8snippets.Relationship;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {

  //Java 7 sort
  public List<Relationship> javaSevenSort(List<Relationship> relationships) {
    Collections.sort(relationships, new Comparator<Relationship>() {
      public int compare(final Relationship r1,
          final Relationship r2) {
        return r1.getStartDate().compareTo(r2.getStartDate());
      }
    });
    
    return relationships;
  }

  /**
   * Comparator is a functional interface because it only declares a single abstract method called compare,
   * which takes two objects of the same type and returns an integer.
   * This is an ideal situation for a lambda expression
   * 
   * @param relationships
   * @return
   */
  public List<Relationship> javaEightSortWithLambda(List<Relationship> relationships) {

    Collections.sort(relationships,
        (Relationship r1, Relationship r2) -> r1.getStartDate().compareTo(r2.getStartDate()));

    return relationships;
  }

  /**
   * In Java 8, the List interface supports the sort method, so you can use that instead of Collections.sort
   * 
   * @param relationships
   * @return
   */
  public List<Relationship> javaEightSortWithLambdaAndListInterface(List<Relationship> relationships) {

    relationships.sort((Relationship r1, Relationship r2) -> r1.getStartDate().compareTo(r2.getStartDate()));

    return relationships;
  }

  /**
   * Next, Java 8 introduces a static helper, Comparator.comparing,
   * which takes as argument a lambda to extract a comparable key.
   * It then generates a Comparator object for you. You can use it as follows
   * 
   * @param relationships
   * @return
   */
  public List<Relationship> javaEightSortWithLambdaAndComparator(List<Relationship> relationships) {

    Comparator<Relationship> byStartDate = Comparator.comparing((Relationship rel) -> rel.getStartDate());
    relationships.sort(byStartDate);

    return relationships;
  }

  /**
   * You may notice that the more concise method reference Relationship::getStartDate can simply replace the lambda (Relationship rel) -> rel.getStartDate():
   * 
   * @param relationships
   * @return
   */
  public List<Relationship> javaEightSortWithLambdaAndComparatorAndMethodReference(List<Relationship> relationships) {

    Comparator<Relationship> byStartDate2 = Comparator.comparing(Relationship::getStartDate);
    relationships.sort(byStartDate2);

    return relationships;
  }
}
