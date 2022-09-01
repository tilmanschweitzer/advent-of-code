package de.tilmanschweitzer.archunit;

import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;

@AnalyzeClasses(packages = "de.tilmanschweitzer.adventofcode")
public class ArchitectureTests {

	@ArchTest
	public void noCyclesTest(JavaClasses importedClasses) {
		slices().matching("de.tilmanschweitzer.adventofcode.(*)..")
				.should().beFreeOfCycles()
				.check(importedClasses);
	}

}
