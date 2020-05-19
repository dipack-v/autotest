package com.autotest;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:features" }, plugin = { "pretty", "json:target/cucumber/cucumber.json" })
public class RunCucumberTest extends AbstractTestNGCucumberTests{
}
