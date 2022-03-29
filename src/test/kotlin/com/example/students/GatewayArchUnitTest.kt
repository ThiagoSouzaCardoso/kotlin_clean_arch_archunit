package com.example.students

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import com.tngtech.archunit.library.Architectures
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition
import org.springframework.stereotype.Component
import javax.persistence.Entity
import javax.persistence.Table

@AnalyzeClasses(packages = [CleanArchitectureTest.PACKAGE_NAME])
class GatewayArchUnitTest {

    @ArchTest
    val dataProvidersShouldHaveNameEndingWithDataProvider = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(CleanArchitectureTest.DATA_PROVIDERS_PACKAGE).should().
        haveSimpleNameEndingWith("DataProvider")
        .andShould().beAnnotatedWith(Component::class.java)
        .because("Dataproviders are need to ending with DataProvider.");

    @ArchTest
    val controllerShouldHaveNameEndingWithController = ArchRuleDefinition.classes()
        .that().
        resideInAPackage(CleanArchitectureTest.ENTRYPOINT_REST_PACKAGE).should().
        haveSimpleNameEndingWith("Controller")
        .because("Controllers are need to ending with Controller");

    @ArchTest
    val gatewaysCantBeAcessedByOthersLayers = Architectures.layeredArchitecture()
        .`as`("Gateways access control.")
        .layer("Core")
        .definedBy(CleanArchitectureTest.CORE_PACKAGE)
        .layer("Gateways")
        .definedBy(CleanArchitectureTest.GATEWAY_PACKAGE)
        .layer("Configuration")
        .definedBy(CleanArchitectureTest.CONFIGURATION_PACKAGE)
        .whereLayer("Gateways")
        .mayNotBeAccessedByAnyLayer()
        .because("Gateways should not be accessed by other layers.")

    @ArchTest
    val tablesShouldBeAnnotatedByEntityOrTable = ArchRuleDefinition.classes()
        .that()
        .haveSimpleNameEndingWith("Table")
        .should()
        .beAnnotatedWith(Entity::class.java)
        .andShould()
        .beAnnotatedWith(Table::class.java)
        .allowEmptyShould(true)
        .because("Table entities belong to the Dataprovider layer, and those annotations are required to use JPA" +
                "in our architecture.")

    @ArchTest
    val collectionsShouldHaveNameEndingWithCollection =   ArchRuleDefinition.classes()
        .that().
        resideInAPackage(CleanArchitectureTest.DATA_PROVIDERS_DATABASES_COLLECTIONS_PACKAGE).should().
        haveSimpleNameEndingWith("Collection")
        .allowEmptyShould(true)
        .because("Entities collections are need to ending with Collection");

    @ArchTest
    val inputsIntegrationShouldHaveNameEndingWithRequest =   ArchRuleDefinition.classes()
        .that().
        resideInAPackage(CleanArchitectureTest.DATA_PROVIDERS_INTEGRATIONS_INPUTS_PACKAGE).should().
        haveSimpleNameEndingWith("Request")
        .allowEmptyShould(true)
        .because("Integration inputs are need to ending with Request");

    @ArchTest
    val outputsIntegrationShouldHaveNameEndingWithResponse =   ArchRuleDefinition.classes()
        .that().
        resideInAPackage(CleanArchitectureTest.DATA_PROVIDERS_INTEGRATIONS_OUTPUTS_PACKAGE).should().
        haveSimpleNameEndingWith("Response")
        .allowEmptyShould(true)
        .because("Integration outputs are need to ending with Response");

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

    @ArchTest
    val tablesShouldHaveNameEndingWithTable =   ArchRuleDefinition.classes()
        .that().
        resideInAPackage("..dataproviders.databases.entities..").should().
        haveSimpleNameEndingWith("Table")
        .allowEmptyShould(true)
        .because("Entities tables are need to ending with Table");

    @ArchTest
    val entitiesShouldBeFreeOfCycles = SlicesRuleDefinition.slices()
        .matching("..entity.(*)..")
        .should()
        .beFreeOfCycles()
        .allowEmptyShould(true)
        .because("We should not have entities with cyclical dependencies.");

}