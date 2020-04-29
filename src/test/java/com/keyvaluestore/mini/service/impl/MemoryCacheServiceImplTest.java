package com.keyvaluestore.mini.service.impl;

import com.keyvaluestore.mini.model.Request;
import com.keyvaluestore.mini.service.CachService;
import com.keyvaluestore.mini.util.Constants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MemoryCacheServiceImplTest {


	private CachService cachService;

	@BeforeEach
	void setUp() {
		cachService = new MemoryCacheServiceImpl();

		Request request = new Request("delhi", "pollution_level", "very high");
		cachService.insertKey(request);
	}

	@Test
	void should_pass_single_result_for_primary_insert() {

		Map<String, Object> result = cachService.search("delhi");
		Assertions.assertThat(result).hasSize(1);
	}

	@Test
	void should_pass_single_result_for_secondary_insert() {
		List<String> list = cachService.searchSecondary("pollution_level", "very high");
		Assertions.assertThat(list).hasSize(1);
	}

	@Test
	void should_fail_when_trying_to_insert_other_data_type(){
		Request request = new Request("delhi", "pollution_level", 1000);
		try{
			cachService.insertKey(request);
		}catch (Exception e){
			Assertions.assertThat(e).isInstanceOf(IllegalArgumentException.class);
			Assertions.assertThat(e).hasMessage(Constants.INVALID_DATATYPE);
		}
	}
}