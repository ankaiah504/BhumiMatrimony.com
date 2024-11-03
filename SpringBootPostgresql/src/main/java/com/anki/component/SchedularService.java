package com.anki.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedularService {

	@Scheduled(cron = "* * * * * *")
	public void scheduleTask()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
            "dd-MM-yyyy HH:mm:ss.SSS");

        String strDate = dateFormat.format(new Date());

        System.out.println(
            "Cron job Scheduler: Job running at - "
            + strDate);
    } 
}
