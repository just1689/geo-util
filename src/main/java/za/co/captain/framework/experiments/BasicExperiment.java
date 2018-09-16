package za.co.captain.framework.experiments;

import org.springframework.stereotype.Component;
import za.co.captain.exception.CaptainException;
import za.co.captain.framework.model.TransactionRST;
import za.co.captain.framework.model.TransactionRSTScore;
import za.co.captain.framework.repoository.TransactionRSTRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Logger;

@Component
public class BasicExperiment {

    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    public ArrayList<TransactionRST> getMostPopular(Integer count, BigDecimal accuracy) {

        ArrayList<TransactionRST> results = new ArrayList<>();
        ArrayList<TransactionRSTScore> scores = new ArrayList<>();

        try {

            TransactionRSTRepository helper = new TransactionRSTRepository();
            ArrayList<TransactionRST> all = helper.getRepository().getAll();

            LOG.info("Read table: " + helper.getRepository().getTableUrl());

            for (TransactionRST item : all) {
                int i = item.countClosest(all, accuracy);
                scores.add(TransactionRSTScore.builder().score(i).transaction(item).build());
                LOG.info("Scored row: " + item.getId());
            }

            Collections.sort(scores, Comparator.comparingInt(TransactionRSTScore::getScore));

            int c = 0;
            for (TransactionRSTScore s : scores) {
                results.add(s.getTransaction());
                c++;
                if (c >= count) {
                    break;
                }
            }

            return results;


        } catch (CaptainException e) {
            System.out.println(e.getHint());
            e.getException().printStackTrace();
        }



        return new ArrayList<>();


    }


}
