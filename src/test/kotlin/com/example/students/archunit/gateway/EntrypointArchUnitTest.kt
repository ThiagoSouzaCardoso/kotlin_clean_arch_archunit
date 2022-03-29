package com.example.students.archunit.gateway

import  com.example.students.archunit.CleanArchitectureTest.*
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@AnalyzeClasses(packages = [Companion.PACKAGE_NAME])
class EntrypointArchUnitTest {


    @ArchTest
    val controllerShouldHaveNameEndingWithController = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(Companion.ENTRYPOINT_REST_PACKAGE).should().
        haveSimpleNameEndingWith("Controller")
        .because("Controllers are need to ending with Controller");

    @ArchTest
    val controllerShouldHaveAnnotationRestControllerAndRequestMapping = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(Companion.ENTRYPOINT_REST_PACKAGE).should().
        beAnnotatedWith(RestController::class.java).andShould().
        beAnnotatedWith(RequestMapping::class.java)
        .because("Controllers are need to ending with Controller");


    @ArchTest
    val controllersShouldAccessUseCaseAndCommandAndDomain = ArchRuleDefinition.classes()
        .that().resideInAPackage(Companion.ENTRYPOINT_REST_PACKAGE)
        .should().onlyAccessClassesThat().resideInAnyPackage(
            Companion.COMMANDS_PACKAGE,
            Companion.DOMAINS_PACKAGE,
            Companion.USE_CASES_PACKAGE,
            Companion.ENTRYPOINT_REST_PACKAGE,
            Companion.ENTRYPOINT_REST_INPUTS_PACKAGE,
            Companion.ENTRYPOINT_REST_OUTPUTS_PACKAGE,
            Companion.JAVA_PACKAGE,
            Companion.KOTLIN_PACKAGE,
            Companion.SPRING_PACKAGE,
            Companion.LOG_PACKAGE
            )


    @ArchTest
    val inputsRestShouldHaveNameEndingWithRequest =   ArchRuleDefinition.classes()
        .that().
        resideInAPackage(Companion.ENTRYPOINT_REST_INPUTS_PACKAGE).should().
        haveSimpleNameEndingWith("Request")
        .allowEmptyShould(true)
        .because("Rest inputs are need to ending with Request");

    val outputsRestShouldHaveNameEndingWithResponse =   ArchRuleDefinition.classes()
        .that().
        resideInAPackage(Companion.ENTRYPOINT_REST_OUTPUTS_PACKAGE).should().
        haveSimpleNameEndingWith("Response")
        .allowEmptyShould(true)
        .because("Integration outputs are need to ending with Response");



}