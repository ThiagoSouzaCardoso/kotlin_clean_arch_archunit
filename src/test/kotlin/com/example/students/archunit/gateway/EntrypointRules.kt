package com.example.students.archunit.gateway

import com.example.students.archunit.CleanArchitectureConstantes.ENTRYPOINT_REST_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.COMMANDS_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.DOMAINS_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.ENTRYPOINT_REST_INPUTS_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.ENTRYPOINT_REST_OUTPUTS_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.JAVA_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.KOTLIN_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.LOG_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.SPRING_PACKAGE
import com.example.students.archunit.CleanArchitectureConstantes.USE_CASES_PACKAGE
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


class EntrypointRules {


    @ArchTest
    val controllerShouldHaveNameEndingWithController = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(ENTRYPOINT_REST_PACKAGE).should().
        haveSimpleNameEndingWith("Controller")
        .because("Controllers are need to ending with Controller");

    @ArchTest
    val controllerShouldHaveAnnotationRestControllerAndRequestMapping = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(ENTRYPOINT_REST_PACKAGE).should().
        beAnnotatedWith(RestController::class.java).andShould().
        beAnnotatedWith(RequestMapping::class.java)
        .because("Controllers are need to ending with Controller");


    @ArchTest
    val controllersShouldAccessUseCaseAndCommandAndDomain = ArchRuleDefinition.classes()
        .that().resideInAPackage(ENTRYPOINT_REST_PACKAGE)
        .should().onlyAccessClassesThat().resideInAnyPackage(
            COMMANDS_PACKAGE,
            DOMAINS_PACKAGE,
            USE_CASES_PACKAGE,
            ENTRYPOINT_REST_PACKAGE,
            ENTRYPOINT_REST_INPUTS_PACKAGE,
            ENTRYPOINT_REST_OUTPUTS_PACKAGE,
            JAVA_PACKAGE,
            KOTLIN_PACKAGE,
            SPRING_PACKAGE,
            LOG_PACKAGE
            )


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



}