package com.github.dockerjava.client.command;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.lang.reflect.Method;

import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.client.AbstractDockerClientTest;
import com.github.dockerjava.client.DockerException;

public class TagImageCmdTest extends AbstractDockerClientTest {

	public static final Logger LOG = LoggerFactory
			.getLogger(TagImageCmdTest.class);

	@BeforeTest
	public void beforeTest() throws DockerException {
		super.beforeTest();
	}
	@AfterTest
	public void afterTest() {
		super.afterTest();
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
	    super.beforeMethod(method);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		super.afterMethod(result);
	}

	@Test
	public void testTagImage() throws DockerException, InterruptedException {
		String tag = String.valueOf(RandomUtils.nextInt(Integer.MAX_VALUE));

		Integer result = dockerClient.tagImageCmd("busybox:latest", "docker-java/busybox", tag).exec();
		assertThat(result, equalTo(Integer.valueOf(201)));

		dockerClient.removeImageCmd("docker-java/busybox:" + tag).exec();
	}

}

