package com.example.students.archunit

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition


@AnalyzeClasses(packages = [CleanArchitectureTest.PACKAGE_NAME])
class EntrypointArchUnitTest {


    @ArchTest
    val controllerShouldHaveNameEndingWithController = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(CleanArchitectureTest.ENTRYPOINT_REST_PACKAGE).should().
        haveSimpleNameEndingWith("Controller")
        .because("Controllers are need to ending with Controller");


    @ArchTest
    val inputsRestShouldHaveNameEndingWithRequest =   ArchRuleDefinition.classes()
        .that().
        resideInAPackage(CleanArchitectureTest.ENTRYPOINT_REST_INPUTS_PACKAGE).should().
        haveSimpleNameEndingWith("Request")
        .allowEmptyShould(true)
        .because("Rest inputs are need to ending with Request");

    val outputsRestShouldHaveNameEndingWithResponse =   ArchRuleDefinition.classes()
        .that().
        resideInAPackage(CleanArchitectureTest.ENTRYPOINT_REST_OUTPUTS_PACKAGE).should().
        haveSimpleNameEndingWith("Response")
        .allowEmptyShould(true)
        .because("Integration outputs are need to ending with Response");



}