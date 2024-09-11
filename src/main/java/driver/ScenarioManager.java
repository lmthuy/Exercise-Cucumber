package driver;


import io.cucumber.java.Scenario;
import utils.LogUtils;

public class ScenarioManager {

    private static Scenario scenario;

    public static Scenario getScenario() {
        LogUtils.info("Scenario in ScenarioManager: " + scenario);
        return scenario;
    }

    public static void setScenario(Scenario scenario) {
        ScenarioManager.scenario = scenario;
    }
}
