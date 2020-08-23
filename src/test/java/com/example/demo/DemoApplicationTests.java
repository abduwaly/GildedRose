package com.example.demo;

import com.example.demo.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testCreateProduct() {
		Product product = new Product("test", 23, 40.0);
		Assertions.assertThat(product.getName()).isEqualTo("test");
		Assertions.assertThat(product.getQuality()).isEqualTo(40.0);
		Assertions.assertThat(product.getSellIn()).isEqualTo(23);
	}


}
