package com.knoxor.graph.config;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories("com.knoxor.graph.repository")
@EnableTransactionManagement
@ComponentScan("com.knoxor.graph")
public class Neo4jConfig {

    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory("com.knoxor.graph.model");
    }

//    @Bean
//    public Session getSession() {
//        Driver driver = GraphDatabase.driver( "", AuthTokens.basic( "neo4j", "neo4j"));
//        return driver.session();
//    }

    @Bean
    public Neo4jTransactionManager transactionManager() throws Exception {
        return new Neo4jTransactionManager(getSessionFactory());
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        return new org.neo4j.ogm.config.Configuration.Builder()
                .uri("bolt://localhost")
                .build();
    }

}