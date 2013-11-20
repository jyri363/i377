package listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.SetupDao;

public class InitDatabaseListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        SetupDao setupDao = new SetupDao();
        if(!databaseExists()) {
	        setupDao.createSchema();
	        setupDao.insertSampleData();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }

    private boolean databaseExists() {
        return new File(System.getProperty("user.home") + "/data/jyri363/dbtest.script").exists();
     }
}
