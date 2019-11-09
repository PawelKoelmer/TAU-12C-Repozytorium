package baza.slodycz;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.*;

import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class SlodyczMockTest {

    private static final LocalDateTime TIME = LocalDateTime.of(2019,10,22,15,10,0);

    @InjectMocks
    private Slodycz slodycz1;

    @InjectMocks
    private Slodycz slodycz2;

    @Mock
    private Clock clock;

    private BazaSlodyczy baza = new BazaSlodyczy();

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void init(){
    slodycz1 = new Slodycz(1,"Czekolada","Gorzka");
    slodycz2 = new Slodycz(2,"Baton","Grzesiek");
    }


    @Test
    public void insert_slodycz_with_timestamp_test(){

            mockTime(TIME);

            baza.insert(slodycz1);

            Assertions.assertThat(baza.getSingle(1).getCreateTimestamp()).isEqualTo(TIME);
    }



    @Test
    public void checkTimeofUpdateTest(){
        mockTime(TIME);

        baza.insert(slodycz1);

        baza.changeDescription(1,"Mleczna");

        Assertions.assertThat(baza.getSingle(1).getUpdateTimestamp()).isEqualTo(TIME);

    }

    @Test
    public void checkLastReadTimeforSingle(){
        mockTime(TIME);

        baza.insert(slodycz1);

        Assertions.assertThat(baza.getSingle(1).getReadTimestamp()).isEqualTo(TIME);
    }

    @Test
    public void checkLastReadTimeForAll(){
        mockTime(TIME);

        baza.insert(slodycz1);
        baza.insert(slodycz2);

        baza.getAll();

        Assertions.assertThat(slodycz1.getReadTimestamp()).isEqualTo(TIME);
        Assertions.assertThat(slodycz2.getReadTimestamp()).isEqualTo(TIME);
    }
    private void mockTime(LocalDateTime fixedTime) {
        Clock fixedClock = Clock.fixed(fixedTime.atZone(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        doReturn(fixedClock.instant()).when(clock).instant();
        doReturn(fixedClock.getZone()).when(clock).getZone();
    }

}
