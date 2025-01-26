package com.example.hex_modulith;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class HexModulithApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void verifyModuleStructure() {
		var modules = ApplicationModules.of(HexModulithApplication.class).verify();
		new Documenter(modules)
			.writeAggregatingDocument()
			.writeModuleCanvases()
			.writeModulesAsPlantUml()
			.writeDocumentation();
	}

}
