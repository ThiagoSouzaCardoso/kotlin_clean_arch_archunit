package com.example.students

import com.example.students.CleanArchitectureTest.Companion.PACKAGE_NAME
import com.tngtech.archunit.core.domain.JavaClass
import com.tngtech.archunit.core.domain.JavaMethod
import com.tngtech.archunit.core.domain.JavaModifier
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchCondition
import com.tngtech.archunit.lang.ConditionEvents
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import com.tngtech.archunit.library.Architectures
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition
import javax.persistence.Entity
import javax.persistence.Table
import org.springframework.stereotype.Component;


@AnalyzeClasses(packages = [PACKAGE_NAME])
class CleanArchitectureTest {

    companion object{
        const val PACKAGE_NAME: String = "com.example.students"
        const val USE_CASES_PUBLIC_METHODS_LIMIT = 1
    }

    @ArchTest
    val useCasesCanBeAcessedByExternalWorld = Architectures.layeredArchitecture()
        .`as`("Use Case External World Access.")
        .layer("UseCases")
        .definedBy("..core.usecases..")
        .layer("Gateways")
        .definedBy("..gateway..")
        .layer("Configuration")
        .definedBy("..configuration..")
        .whereLayer("UseCases")
        .mayOnlyBeAccessedByLayers("UseCases", "Gateways", "Configuration")
        .because("It's ok for Use Cases to be accessed by external world.")

    @ArchTest
    val useCasesImplCannotBeAcessedByExternalWorld = Architectures.layeredArchitecture()
        .`as`("")
        .layer("UseCases")
        .definedBy("..core.usecases..")
        .layer("UseCasesImpl")
        .definedBy("..core.usecases.impl..")
        .whereLayer("UseCasesImpl")
        .mayOnlyBeAccessedByLayers("UseCases")

    @ArchTest
   val useCasesShouldResideInsideCore = ArchRuleDefinition.classes()
        .that()
        .resideInAPackage("..core.usecases")
        .should()
        .haveSimpleNameEndingWith("UseCase")
        .because("UseCases are the core of our business, hence they should stay inside core.");

    @ArchTest
    val usecasesGatewaysBelongToUsecases = Architectures.layeredArchitecture()
        .`as`("UseCase Gateways Access.")
        .layer("UseCases")
        .definedBy("..core.usecases..")
        .layer("Ports")
        .definedBy("..core.ports..")
        .layer("Gateways")
        .definedBy("..gateway..")
        .layer("Configuration")
        .definedBy("..configuration..")
        .whereLayer("Ports")
        .mayOnlyBeAccessedByLayers("UseCases", "Gateways")
        .allowEmptyShould(true)
        .because("UseCases gateway interfaces should not leak.")

    @ArchTest
    val usecasesShouldHaveOnlyOnePublicMethod =  ArchRuleDefinition.classes()
        .that()
        .haveSimpleNameEndingWith("UseCase")
        .should(containOnlyOnePublicMethod())
        .because("Use Cases should have only one business responsibility.");

    @ArchTest
    val dataProvidersShouldHaveNameEndingWithDataProvider = ArchRuleDefinition.classes()
        .that().
        resideInAPackage("..gateway.dataproviders").should().
        haveSimpleNameEndingWith("DataProvider")
        .andShould().beAnnotatedWith(Component::class.java)
        .because("Dataproviders are need to ending with DataProvider.");


    @ArchTest
    val portsShouldHaveNameEndingWithPort = ArchRuleDefinition.classes()
        .that().
        resideInAPackage("..core.ports..").should().
        haveSimpleNameEndingWith("Port").andShould().beInterfaces()
        .because("Ports are need to ending with Port and be an interface.");

    @ArchTest
    val eventsShouldHaveNameEndingWithEvent = ArchRuleDefinition.classes()
        .that().
        resideInAPackage("..core.events..").should().
        haveSimpleNameEndingWith("Event")
        .because("Events are need to ending with Event");

    @ArchTest
    val commandsShouldHaveNameEndingWithCommand = ArchRuleDefinition.classes()
        .that().
        resideInAPackage("..core.commands..").should().
        haveSimpleNameEndingWith("Command")
        .because("Commands are need to ending with Command");

    @ArchTest
    val controllerShouldHaveNameEndingWithController = ArchRuleDefinition.classes()
        .that().
        resideInAPackage("..entrypoints.rest").should().
        haveSimpleNameEndingWith("Controller")
        .because("Controllers are need to ending with Controller");


    @ArchTest
    val gatewaysCantBeAcessed = Architectures.layeredArchitecture()
        .`as`("Gateways access control.")
        .layer("Core")
        .definedBy("..core..")
        .layer("Gateways")
        .definedBy("..gateway..")
        .layer("Configuration")
        .definedBy("..configuration..")
        .whereLayer("Gateways")
        .mayNotBeAccessedByAnyLayer()
        .because("Gateways should not be accesed by other layers.")

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
    val tablesShouldHaveNameEndingWithCollection =   ArchRuleDefinition.classes()
        .that().
        resideInAPackage("..dataproviders.databases.collections..").should().
        haveSimpleNameEndingWith("Collection")
        .allowEmptyShould(true)
        .because("Entities collections are need to ending with Collection");

    @ArchTest
    val inputIntegrationShouldHaveNameEndingWithRequest =   ArchRuleDefinition.classes()
        .that().
        resideInAPackage("..dataproviders.integrations.*.inputs").should().
        haveSimpleNameEndingWith("Request")
        .allowEmptyShould(true)
        .because("Integration inputs are need to ending with Request");

    @ArchTest
    val inputRestShouldHaveNameEndingWithRequest =   ArchRuleDefinition.classes()
        .that().
        resideInAPackage("..entrypoints.rest.inputs").should().
        haveSimpleNameEndingWith("Request")
        .allowEmptyShould(true)
        .because("Rest inputs are need to ending with Request");

    val outputRestShouldHaveNameEndingWithResponse =   ArchRuleDefinition.classes()
        .that().
        resideInAPackage("..entrypoints.rest.outputs").should().
        haveSimpleNameEndingWith("Response")
        .allowEmptyShould(true)
        .because("Integration outputs are need to ending with Response");

    @ArchTest
    val outputIntegrationShouldHaveNameEndingWithResponse =   ArchRuleDefinition.classes()
        .that().
        resideInAPackage("..dataproviders.integrations.*.outputs").should().
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

    @ArchTest
    val configurationCantBeAcessedByAnyLayer = Architectures.layeredArchitecture()
        .layer("Core")
        .definedBy("..core..")
        .layer("Gateways")
        .definedBy("..gateway..")
        .layer("Configuration")
        .definedBy("..configuration..")
        .whereLayer("Configuration")
        .mayNotBeAccessedByAnyLayer()
        .because("Configuration is our last external layer and should not be accessed by other layers.");

    private fun containOnlyOnePublicMethod(): ArchCondition<JavaClass> {
        return object : ArchCondition<JavaClass>("Only one public method") {
            override fun check(clazz: JavaClass, events: ConditionEvents) {
                val name: String = clazz.name
                val methodsSet: Set<JavaMethod> = clazz.methods
                var publicMethodsCount = 0
                for (javaMethod in methodsSet) {
                    if (javaMethod.modifiers
                            .contains(JavaModifier.PUBLIC)
                    ) {
                        publicMethodsCount += 1
                    }
                }
                if (publicMethodsCount > USE_CASES_PUBLIC_METHODS_LIMIT) {
                    throw AssertionError(
                        java.lang.String.format(
                            "Class %s contains %d public methods, when limit is %d",
                            name, publicMethodsCount, USE_CASES_PUBLIC_METHODS_LIMIT
                        )
                    )
                }
            }
        }
    }

}