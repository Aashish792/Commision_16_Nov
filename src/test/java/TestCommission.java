import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestCommission {

    @Mock
    private Lock lock = Mockito.mock(Lock.class);

    @Mock
    private Stock stock = Mockito.mock(Stock.class);

    @Mock
    private Barrel barrel = Mockito.mock(Barrel.class);

    @InjectMocks
    private CalculateCommission calculateCommission = new CalculateCommission();

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCommissionSkipWhileLoop() {
        when(lock.getCount()).thenReturn(-1);
        Assertions.assertEquals(0.0, calculateCommission.getCommission(lock, stock, barrel));
    }

    @Test
    public void testGetCommissionEnterWhileLoop() {
        when(lock.getCount()).thenReturn(5);
        when(stock.getCount()).thenReturn(5);
        when(barrel.getCount()).thenReturn(5);
        Assertions.assertEquals(520.0, calculateCommission.getCommission(lock, stock, barrel));
    }
}