package za.co.captain.framework.repoository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.captain.UsefulRepository;
import za.co.captain.framework.model.TransactionRST;
import za.co.captain.model.Database;
import za.co.captain.model.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TransactionRSTExperimentRepository {

    private UsefulRepository<TransactionRST> repository
            = new UsefulRepository<>(
            Database.builder().url(Global.URL).build(),
            Table.builder()
                    .tableName("transactions_rst_exp")
                    .clazz(TransactionRST.class)
                    .build()
    );

}
