package com.example.students.archunit.gateway

import com.example.students.archunit.CleanArchitectureConstantes.ENTRYPOINT_REST_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.ENTRYPOINT_KAFKA_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.ENTRYPOINT_REST_INPUTS_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.ENTRYPOINT_REST_OUTPUTS_PACKAGE
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


class EntrypointRules {


    @ArchTest
    val controllerShouldHaveNameEndingWithController = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(ENTRYPOINT_REST_PACKAGE).should().
        haveSimpleNameEndingWith("Controller")
        .allowEmptyShould(true)
        .because("Controllers are need to ending with Controller");

    @ArchTest
    val controllerShouldHaveAnnotationRestControllerAndRequestMapping = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(ENTRYPOINT_REST_PACKAGE).should().
        beAnnotatedWith(RestController::class.java).andShould().
        beAnnotatedWith(RequestMapping::class.java)
        .allowEmptyShould(true)
        .because("Controllers are need to be annotated with @RestController and @RequestMapping");


    @ArchTest
    val inputsRestShouldHaveNameEndingWithRequest =   ArchRuleDefinition.classes()
        .that().
        resideInAPackage(ENTRYPOINT_REST_INPUTS_PACKAGE).should().
        haveSimpleNameEndingWith("Request")
        .allowEmptyShould(true)
        .because("Rest inputs are need to ending with Request");

    val outputsRestShouldHaveNameEndingWithResponse =   ArchRuleDefinition.classes()
        .that().
        resideInAPackage(ENTRYPOINT_REST_OUTPUTS_PACKAGE).should().
        haveSimpleNameEndingWith("Response")
        .allowEmptyShould(true)
        .because("Integration outputs are need to ending with Response");


    @ArchTest
    val consumerkafkaShouldHaveNameEndingWithConsumer = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(ENTRYPOINT_KAFKA_PACKAGE).should().
        haveSimpleNameEndingWith("Consumer")
        .allowEmptyShould(true)
        .because("Consumers Kafka are need to ending with Consumer");


    @ArchTest
    val consumerKafkaShouldHaveAnnotationController = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(ENTRYPOINT_KAFKA_PACKAGE).should().
        beAnnotatedWith(Controller::class.java)
        .allowEmptyShould(true)
        .because("Consumers Kafka are need to be annotaded with @Controller")

}