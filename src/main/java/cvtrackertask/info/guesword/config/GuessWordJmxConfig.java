package cvtrackertask.info.guesword.config;

import cvtrackertask.info.guesword.service.GuessWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class GuessWordJmxConfig {

    @Autowired
    private GuessWordService guessWordService;

    @Bean
    public MBeanExporter mBeanExporter()
    {
        MBeanExporter mBeanExporter = new MBeanExporter();
        mBeanExporter.setBeans(beansToExport());
        return mBeanExporter;
    }

    public Map<String, Object> beansToExport()
    {
        Map<String,Object > beansMap = new HashMap<>();
        beansMap.put("bean:name=guessWordService", guessWordService);
        return beansMap;
    }
}
