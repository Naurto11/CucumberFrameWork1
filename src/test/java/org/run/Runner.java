package org.run;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Admin\\eclipse-workspace\\CucumberFrameWork1\\src\\test\\resources\\FeatureFile",glue="org.step",strict=true)//,plugin= {"pretty", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"})
public class Runner {

}
