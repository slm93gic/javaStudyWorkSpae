package stream;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {

    private Trader trader;
    private Integer year;
    private Integer value;

}
