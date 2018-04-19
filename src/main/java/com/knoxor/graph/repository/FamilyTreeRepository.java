package com.knoxor.graph.repository;

import com.knoxor.graph.model.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface FamilyTreeRepository extends Neo4jRepository<Person, Long> {

    /**
     *  Scripts work in neo4j db
     create(a:Grandfather {name:"edward",age:"88",surname:"murphy",hoby:"poetry"})
     create(b:Mother {name:"anne",age:"58",surname:"sharapova",hoby:"reading"})
     create(c:Father {name:"edward",age:"55",surname:"whatever",hoby:"running"})


     MATCH (a:Grandfather),(b:Mother),(c:Father)
     WHERE a.name = 'edward' AND b.name = 'anne' AND c.name="edward"
     CREATE (a)-[:DAUGHTER]->(b)
     CREATE (a)-[:SON]->(c)
     CREATE (b)-[:FATHER]->(a)
     CREATE (c)-[:FATHER]->(a)
     RETURN a, b, c

     */


}
