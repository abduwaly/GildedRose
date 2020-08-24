package com.example.demo;

import com.example.demo.entity.BackstagePass;
import com.example.demo.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
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
		Assertions.assertThat(product.getQuality(LocalDate.now())).isEqualTo(40.0);
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

		LocalDate mockDate1 = LocalDate.now().plusDays(1);
		Assertions.assertThat(product.getQuality(mockDate1)).isEqualTo(39.0);

		LocalDate mockDate2 = LocalDate.now().plusDays(5);
		Assertions.assertThat(product.getQuality(mockDate2)).isEqualTo(35.0);

		LocalDate mockDate3 = LocalDate.now().plusDays(25);
		Assertions.assertThat(product.getQuality(mockDate3)).isEqualTo(13);

		LocalDate mockDate4 = LocalDate.now().plusDays(55);
		Assertions.assertThat(product.getQuality(mockDate4)).isEqualTo(0);
	}

	@Test
	void testCreateBackstagePass() {
		BackstagePass bp = new BackstagePass("testBP", 15, 25);
		Assertions.assertThat(bp.getName()).isEqualTo("testBP");
	}

	@Test
	void testBackstagePassQuality() {
		BackstagePass bp = new BackstagePass("testBP", 15, 5);

		LocalDate mockDate1 = LocalDate.now().plusDays(2);
		Assertions.assertThat(bp.getQuality(mockDate1)).isEqualTo(9);

		LocalDate mockDate2 = LocalDate.now().plusDays(7);
		Assertions.assertThat(bp.getQuality(mockDate2)).isEqualTo(19);

	}
}
