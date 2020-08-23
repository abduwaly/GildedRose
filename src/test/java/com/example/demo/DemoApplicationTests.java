package com.example.demo;

import com.example.demo.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;

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

	@Test
	void testIsQualityValid() {
		Product product = new Product("test", 23, 40.0);
		Assertions.assertThat(product.isQualityValid()).isEqualTo(true);

		product.setQuality(51);
		Assertions.assertThat(product.isQualityValid()).isEqualTo(false);

		product.setQuality(-1);
		Assertions.assertThat(product.isQualityValid()).isEqualTo(false);
	}

	@Test
	void testGetQuality() {
		Product product = new Product("test", 23, 40.0);
		Date mockDate1 = new Date(product.getCreationDate().getTime() + 86400000);
		Assertions.assertThat(product.getQuality(mockDate1)).isEqualTo(39);

		Date mockDate2 = new Date(product.getCreationDate().getTime() + 86400000*5);
		Assertions.assertThat(product.getQuality(mockDate2)).isEqualTo(35);
	}
}
