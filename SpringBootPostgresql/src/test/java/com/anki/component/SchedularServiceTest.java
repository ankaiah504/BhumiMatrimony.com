package com.anki.component;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class SchedularServiceTest {

	@Autowired
    private SchedularService schedularService;
	 @Test
	    public void testScheduleTask() throws InterruptedException {
	        // Capture the output
	        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	        PrintStream originalOut = System.out;
	        System.setOut(new PrintStream(outContent));

	        // Call the method directly
	        schedularService.scheduleTask();

	        // Restore the original output
	        System.setOut(originalOut);

	        // Check the output
	        String expectedOutput = "Cron job Scheduler: Job running at - ";
	        assertTrue(outContent.toString().startsWith(expectedOutput));
	    }
	
}
