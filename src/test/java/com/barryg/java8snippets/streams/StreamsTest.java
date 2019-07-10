package com.barryg.java8snippets.streams;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.barryg.java8snippets.Relationship;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StreamsTest {

  @Test
  public void javaSevenTest_GroupedIntoASingleMappedEntry() {
    StreamRels streamRels = new StreamRels();
    
    Relationship rel1 = new Relationship("J68578", "DO NOT MIGRATE", LocalDate.of(1996, Month.FEBRUARY, 21), LocalDate.of(1996, Month.FEBRUARY, 21), 22, 44);
    Relationship rel2 = new Relationship("J210792", "WSS", LocalDate.of(2001, Month.APRIL, 30), LocalDate.of(2001, Month.DECEMBER, 11), 22, 44);
    Relationship rel3 = new Relationship("J440908", "WSS", LocalDate.of(2001, Month.NOVEMBER, 13), LocalDate.of(2002, Month.NOVEMBER, 3), 22, 44);
    Relationship rel4 = new Relationship("J964898", "WSS", LocalDate.of(2001, Month.NOVEMBER, 13), LocalDate.of(2003, Month.OCTOBER, 9), 22, 44);

    List<Relationship> relationships = new ArrayList<Relationship>();
    relationships.add(rel1);
    relationships.add(rel2);
    relationships.add(rel3);
    relationships.add(rel4);

    Map<String, List<Relationship>> results = streamRels.javaSevenRemoveDoNotMigrateRelationshipsAndGroupByRelType(relationships);
    assertNotNull("No relationships relationships", results);
    assertThat("Incorrect size of map", results.size(), is(1));
    assertThat("Incorrect Key", results.keySet().iterator().next(), is("WSS||::||22||::||44"));
    assertThat("Incorrect number of relationships returned", results.values().iterator().next().size(), is (3));
  }
  
  @Test
  public void javaSevenTest_GroupedIntoADoubleMappedEntry() {
    StreamRels streamRels = new StreamRels();
    
    Relationship rel1 = new Relationship("J68578", "DO NOT MIGRATE", LocalDate.of(1996, Month.FEBRUARY, 21), LocalDate.of(1996, Month.FEBRUARY, 21), 22, 44);
    Relationship rel2 = new Relationship("J210792", "WSS", LocalDate.of(2001, Month.APRIL, 30), LocalDate.of(2001, Month.DECEMBER, 11), 22, 44);
    Relationship rel3 = new Relationship("J440908", "WSS", LocalDate.of(2001, Month.NOVEMBER, 13), LocalDate.of(2002, Month.NOVEMBER, 3), 22, 55);
    Relationship rel4 = new Relationship("J964898", "WSS", LocalDate.of(2001, Month.NOVEMBER, 13), LocalDate.of(2003, Month.OCTOBER, 9), 22, 55);

    List<Relationship> relationships = new ArrayList<Relationship>();
    relationships.add(rel1);
    relationships.add(rel2);
    relationships.add(rel3);
    relationships.add(rel4);

    Map<String, List<Relationship>> results = streamRels.javaSevenRemoveDoNotMigrateRelationshipsAndGroupByRelType(relationships);
    assertNotNull("No relationships relationships", results);
    assertThat("Incorrect size of map", results.size(), is(2));
    assertTrue("Incorrect Key", results.keySet().contains("WSS||::||22||::||44"));
    assertTrue("Incorrect Key", results.keySet().contains("WSS||::||22||::||55"));
    
    assertThat(results.get("WSS||::||22||::||44").size(), is(1));
    assertThat(results.get("WSS||::||22||::||55").size(), is(2));
  }
  
  @Test
  public void javaEightTest_GroupedIntoASingleMappedEntry() {
    StreamRels streamRels = new StreamRels();
    
    Relationship rel1 = new Relationship("J68578", "DO NOT MIGRATE", LocalDate.of(1996, Month.FEBRUARY, 21), LocalDate.of(1996, Month.FEBRUARY, 21), 22, 44);
    Relationship rel2 = new Relationship("J210792", "WSS", LocalDate.of(2001, Month.APRIL, 30), LocalDate.of(2001, Month.DECEMBER, 11), 22, 44);
    Relationship rel3 = new Relationship("J440908", "WSS", LocalDate.of(2001, Month.NOVEMBER, 13), LocalDate.of(2002, Month.NOVEMBER, 3), 22, 44);
    Relationship rel4 = new Relationship("J964898", "WSS", LocalDate.of(2001, Month.NOVEMBER, 13), LocalDate.of(2003, Month.OCTOBER, 9), 22, 44);

    List<Relationship> relationships = new ArrayList<Relationship>();
    relationships.add(rel1);
    relationships.add(rel2);
    relationships.add(rel3);
    relationships.add(rel4);

    Map<String, List<Relationship>> results = streamRels.javaEightRemoveDoNotMigrateRelationshipsAndGroupByRelType(relationships);
    assertNotNull("No relationships relationships", results);
    assertThat("Incorrect size of map", results.size(), is(1));
    assertThat("Incorrect Key", results.keySet().iterator().next(), is("WSS||::||22||::||44"));
    assertThat("Incorrect number of relationships returned", results.values().iterator().next().size(), is (3));
  }
  
  @Test
  public void javaEightTest_GroupedIntoADoubleMappedEntryJavaEight() {
    StreamRels streamRels = new StreamRels();
    
    Relationship rel1 = new Relationship("J68578", "DO NOT MIGRATE", LocalDate.of(1996, Month.FEBRUARY, 21), LocalDate.of(1996, Month.FEBRUARY, 21), 22, 44);
    Relationship rel2 = new Relationship("J210792", "WSS", LocalDate.of(2001, Month.APRIL, 30), LocalDate.of(2001, Month.DECEMBER, 11), 22, 44);
    Relationship rel3 = new Relationship("J440908", "WSS", LocalDate.of(2001, Month.NOVEMBER, 13), LocalDate.of(2002, Month.NOVEMBER, 3), 22, 55);
    Relationship rel4 = new Relationship("J964898", "WSS", LocalDate.of(2001, Month.NOVEMBER, 13), LocalDate.of(2003, Month.OCTOBER, 9), 22, 55);

    List<Relationship> relationships = new ArrayList<Relationship>();
    relationships.add(rel1);
    relationships.add(rel2);
    relationships.add(rel3);
    relationships.add(rel4);

    Map<String, List<Relationship>> results = streamRels.javaEightRemoveDoNotMigrateRelationshipsAndGroupByRelType(relationships);
    assertNotNull("No relationships relationships", results);
    assertThat("Incorrect size of map", results.size(), is(2));
    assertTrue("Incorrect Key", results.keySet().contains("WSS||::||22||::||44"));
    assertTrue("Incorrect Key", results.keySet().contains("WSS||::||22||::||55"));
    
    assertThat(results.get("WSS||::||22||::||44").size(), is(1));
    assertThat(results.get("WSS||::||22||::||55").size(), is(2));
  }
  
}
