package za.co.captain.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import za.co.captain.framework.experiments.BasicExperiment;
import za.co.captain.framework.model.TransactionRST;

import java.math.BigDecimal;
import java.util.ArrayList;

@RestController
public class MyController {

    @Autowired
    private BasicExperiment basicExperiment;

    @GetMapping(value = "/getPopular/{count}/{accuracy}")
    public ArrayList<TransactionRST> getHi(@PathVariable Integer count, @PathVariable BigDecimal accuracy) {
        return basicExperiment.getMostPopular(count, accuracy);

    }

}
