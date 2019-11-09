package baza.slodycz.JBehave;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;

import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;

import java.util.List;

public class BazaSlodyczyStoryTest extends JUnitStory {

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                // where to find the stories
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                // CONSOLE and TXT reporting
                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(StoryReporterBuilder.Format.STATS,
                        StoryReporterBuilder.Format.TXT, StoryReporterBuilder.Format.HTML, StoryReporterBuilder.Format.XML));
    }

    // Here we specify the steps classes
    @Override
    public List<CandidateSteps> candidateSteps() {
        // varargs, can have more that one steps classes
        return new InstanceStepsFactory(configuration(), new BazaStepsTest()).createCandidateSteps();
    }

    @Override
    @Test
    public void run() {
        super.run();
    }
}
