package com.barryg.java8snippets.streams;


import com.barryg.java8snippets.Relationship;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamRels {
  private static final String OVER_LAPPING_SEPARATOR = "||::||";

  /**
   * Original Java 7 implementation
   * Take a list and iterate over each value in that list by passing it to a private method 
   * Also, mutate the second parameter map
   * 
   *  
   * @param relationshipList
   * @return
   */
  public final Map<String, List<Relationship>> javaSevenRemoveDoNotMigrateRelationshipsAndGroupByRelType(List<Relationship> relationshipList) {
    final Map<String, List<Relationship>> relationshipsMap = new HashMap<>();

    for (final Relationship rel : relationshipList) {
      removeDoNotMigratePerOrgRelationshipsAndGroupByRelType(rel, relationshipsMap);
    }

    return relationshipsMap;
  }

  /**
   * For each relationship passed, see if it is a type that can be migrated.
   * If so, create a key
   * Check if Key exists
   * If, then add to existing value
   * If not, then create new key value pair 
   * 
   * @param newRelationshipVO
   * @param relationshipsMap
   */
  private void removeDoNotMigratePerOrgRelationshipsAndGroupByRelType(final Relationship newRelationshipVO,
      final Map<String, List<Relationship>> relationshipsMap) {
    if (shouldBeMigrated(newRelationshipVO.getRelationshipType())) {
      final String key = new StringBuilder(newRelationshipVO.getRelationshipType().toString())
          .append(OVER_LAPPING_SEPARATOR)
          .append(newRelationshipVO.getPersonId())
          .append(OVER_LAPPING_SEPARATOR)
          .append(newRelationshipVO.getOrganisationId()).toString();

      if(relationshipsMap.containsKey(key)) {
        List<Relationship> existingRels = relationshipsMap.get(key);
        existingRels.add(newRelationshipVO);
      }else {
        LinkedList<Relationship> newList = new LinkedList<>();
        newList.add(newRelationshipVO);
        relationshipsMap.put(key, newList);
      }
    }
  }

  /**
   * Here we have a number of steps that leverage java 8
   * (1) Using streams and filter to filter those relationships that we can migrate
   *     - relationshipList.stream().filter(rel -> shouldBeMigrated(rel.getRelationshipType()))
   *     - filer is an operation like sorted and map which can be connected together to form a pipeline
   * (2) Then we use the collect to accumulate the elements, in our case relationships, into a summary result.
   *     The argument passed to collect is an object of type java.util.stream.Collector
   *     Collector object essentially describes a recipe for accumulating the elements of a stream into a final result.
   *     Here we are using the simplest Grouping by a single attribute.
   *     the relationshipKeyBuilder is the _classification function_ becomes the key and any relationship that matches the key is added to the List value of the pair
   *     - .collect(Collectors.groupingBy(this::relationshipKeyBuilder))
   *     - collect is an operation like findFirst and allMatch which terminate the pipeline and return a result
   * 
   * 
   * @param relationshipList
   * @return
   */
  public final Map<String, List<Relationship>> javaEightRemoveDoNotMigrateRelationshipsAndGroupByRelType(List<Relationship> relationshipList) {
     Map<String, List<Relationship>> mapOfRelationships = relationshipList.stream()
         .filter(rel -> shouldBeMigrated(rel.getRelationshipType()))
         .collect(Collectors.groupingBy(this::relationshipKeyBuilder));
    return mapOfRelationships;
  }
  
  private String relationshipKeyBuilder(Relationship rel) {
    return new StringBuilder(rel.getRelationshipType().toString())
    .append(OVER_LAPPING_SEPARATOR)
    .append(rel.getPersonId())
    .append(OVER_LAPPING_SEPARATOR)
    .append(rel.getOrganisationId()).toString();
  }
  
  private static boolean shouldBeMigrated(final String relationshipType) {
    return !StringUtils.equals(relationshipType, "DO NOT MIGRATE");
  }
}
