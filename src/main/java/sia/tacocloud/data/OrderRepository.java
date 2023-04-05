package sia.tacocloud.data;

import sia.tacocloud.TacoOrder;
import java.util.Optional;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
