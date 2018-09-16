package za.co.captain.framework.repoository;

import lombok.Data;
import za.co.captain.UsefulRepository;
import za.co.captain.framework.model.TransactionRST;
import za.co.captain.model.Database;
import za.co.captain.model.Table;

@Data
public class TransactionRSTRepository {

    private UsefulRepository<TransactionRST> repository = new UsefulRepository<TransactionRST>(
            Database.builder()
                    .url(Global.URL)
                    .build(),
            Table.builder()
                    .tableName("transactions_rs_time")
                    .clazz(TransactionRST.class)
                    .build()
    );


}
