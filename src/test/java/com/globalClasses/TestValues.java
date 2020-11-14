package com.globalClasses;

import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TestValues {
	Faker faker = new Faker();
	DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate currentDate = LocalDate.now(ZoneId.of("GMT-5"));
	int startRandomPlus = (int)(Math.random()*(3-0)+1)+0;
	int dueRandomPlus = (int)(Math.random()*(9-3)+1)+3;

	public String randomName() {
		String name = faker.name().title();
		return name;
	}
	public String randomString() {
		String string = faker.lorem().fixedString(99);
		return string;
	}
	public String randomStartDate() {
		String date = LocalDate.parse(currentDate.format(formater)).plusDays(startRandomPlus).toString();
		String startDate = date.substring(7) + date.substring(4, 7) + date.substring(0, 4);
		return startDate.replaceAll("[-]*", "");
	}
	public String randomDueDate() {
		String date = LocalDate.parse(currentDate.format(formater)).plusDays(dueRandomPlus).toString();
		String dueDate = date.substring(7) + date.substring(4, 7) + date.substring(0, 4);
		return dueDate.replaceAll("[-]*", "");
	}
}