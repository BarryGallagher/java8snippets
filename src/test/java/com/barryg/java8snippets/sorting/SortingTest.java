package com.barryg.java8snippets.sorting;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.barryg.java8snippets.Relationship;
import com.barryg.java8snippets.sort.Sorting;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortingTest {

  @Test
  public void javaSevenTest_SortingListWithMixed() {
    LinkedList<Relationship> relationships = new LinkedList<>();
    Relationship rel1 = new Relationship("REL_1", "Oldest", LocalDate.of(2019, Month.FEBRUARY, 21), LocalDate.of(1996, Month.FEBRUARY, 21), 22, 44);
    Relationship rel2 = new Relationship("REL_2", "Second youngest", LocalDate.of(2001, Month.NOVEMBER, 13), LocalDate.of(2001, Month.DECEMBER, 11), 22, 44);
    Relationship rel3 = new Relationship("REL_3", "Youngest", LocalDate.of(2001, Month.APRIL, 05), LocalDate.of(2002, Month.NOVEMBER, 3), 22, 44);
    Relationship rel4 = new Relationship("REL_4", "Second oldest", LocalDate.of(2001, Month.NOVEMBER, 14), LocalDate.of(2003, Month.OCTOBER, 9), 22, 44);
    relationships.add(rel1);
    relationships.add(rel2);
    relationships.add(rel3);
    relationships.add(rel4);
    
    Sorting sort = new Sorting();
    sort.javaSevenSort(relationships);
    
    assertThat(relationships.get(0).getRelationshipType(), is("Youngest"));
    assertThat(relationships.get(1).getRelationshipType(), is("Second youngest"));
    assertThat(relationships.get(2).getRelationshipType(), is("Second oldest"));
    assertThat(relationships.get(3).getRelationshipType(), is("Oldest"));
  }
  
  @Test
  public void javaEightTest_SortingListWithMixed() {
    Relationship rel1 = new Relationship("REL_1", "Oldest", LocalDate.of(2019, Month.FEBRUARY, 21), LocalDate.of(1996, Month.FEBRUARY, 21), 22, 44);
    Relationship rel2 = new Relationship("REL_2", "Second youngest", LocalDate.of(2001, Month.NOVEMBER, 13), LocalDate.of(2001, Month.DECEMBER, 11), 22, 44);
    Relationship rel3 = new Relationship("REL_3", "Youngest", LocalDate.of(2001, Month.APRIL, 05), LocalDate.of(2002, Month.NOVEMBER, 3), 22, 44);
    Relationship rel4 = new Relationship("REL_4", "Second oldest", LocalDate.of(2001, Month.NOVEMBER, 14), LocalDate.of(2003, Month.OCTOBER, 9), 22, 44);
    
    List<Relationship> relationships = Arrays.asList(rel1, rel2, rel3, rel4);
    
    Sorting sort = new Sorting();
    sort.javaEightSortWithLambdaAndComparatorAndMethodReference(relationships);
    
    assertThat(relationships.get(0).getRelationshipType(), is("Youngest"));
    assertThat(relationships.get(1).getRelationshipType(), is("Second youngest"));
    assertThat(relationships.get(2).getRelationshipType(), is("Second oldest"));
    assertThat(relationships.get(3).getRelationshipType(), is("Oldest"));
  }
}
