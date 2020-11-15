package com.joeaouad.tracker.configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
public class ReactiveMongoConfig extends AbstractReactiveMongoConfiguration {
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create();
    }

    @Override
    protected @NotNull String getDatabaseName() {
        return "workouts";
    }
}
