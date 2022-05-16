package ru.job4j.quartz;

import org.quartz.*;

import java.io.IOException;
import java.util.Properties;
import org.quartz.impl.StdSchedulerFactory;
import java.io.InputStream;
import java.sql.*;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class AlertRabbit {

     public static void main(String[] args) {
         try (InputStream in = AlertRabbit.class
                 .getClassLoader().getResourceAsStream("app.properties")) {
             Properties config = new Properties();
             config.load(in);
             Class.forName(config.getProperty("driver-class-name"));
             try (Connection cn = DriverManager.getConnection(
                     config.getProperty("url"),
                     config.getProperty("username"),
                     config.getProperty("password"))) {
                 Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
                 scheduler.start();
                 JobDataMap data = new JobDataMap();
                 data.put("connection", cn);
                 JobDetail job = newJob(Rabbit.class)
                         .usingJobData(data)
                         .build();
                 SimpleScheduleBuilder times = simpleSchedule()
                         .withIntervalInSeconds(Integer.parseInt(config.getProperty("rabbit.interval")))
                         .repeatForever();
                 Trigger trigger = newTrigger()
                         .startNow()
                         .withSchedule(times)
                         .build();
                 scheduler.scheduleJob(job, trigger);
                 Thread.sleep(10000);
                 scheduler.shutdown();
             } catch (Exception e) {
                 e.printStackTrace();
             }
         } catch (IOException | ClassNotFoundException e) {
             e.printStackTrace();
         }
     }

    public static class Rabbit implements Job {

        public Rabbit() {
        }

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            try (PreparedStatement statement =
                         ((Connection) context.getJobDetail().getJobDataMap().get("connection"))
                                 .prepareStatement("insert into rabbit(created_date) values(?)")) {
                statement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                statement.execute();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }
}
