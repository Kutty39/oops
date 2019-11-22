package com.blbz.jsoninventory.tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.blbz.jsoninventory.Service.InventoryManagement;
import com.blbz.jsoninventory.ServiceImplementation.InventoryImplementation;

class TestInventory {

	
	InventoryManagement invm;

	@BeforeEach
	public void TestJson() {
		invm = new InventoryImplementation();
	}
	
	@ParameterizedTest
	@CsvSource( {"All,45640.0", "Rice,10500.0", "wheat,18640.0", "pulses,16500"})
	@DisplayName("test for calculation")
	void Testcalculation(String choice, double expected) {
		double result = invm.readInventory(choice);
		assertEquals(expected, result);
	
	}

	}


	
	

