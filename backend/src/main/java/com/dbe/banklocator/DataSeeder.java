package com.dbe.banklocator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dbe.banklocator.model.BankBranch;
import com.dbe.banklocator.repository.BranchRepository;

@Configuration
public class DataSeeder {

    @SuppressWarnings("unused")
    @Bean
    CommandLineRunner initDatabase(BranchRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new BankBranch(
                        "DBE Head Office",
                        "Africa Avenue, Kazanchis",
                        "Addis Ababa",
                        "1000",
                        "+251 11 551 7000",
                        "info@dbe.com.et",
                        9.0227, 38.7469,
                        "Corporate Banking,International Banking,Investment Banking"
                ));

                repository.save(new BankBranch(
                        "DBE Bole Branch",
                        "Bole Road",
                        "Addis Ababa",
                        "1000",
                        "+251 11 551 7200",
                        "bole@dbe.com.et",
                        9.0326, 38.7616,
                        "Retail Banking,Corporate Banking"
                ));

                repository.save(new BankBranch(
                        "DBE Mercato Branch",
                        "Mercato Main Road",
                        "Addis Ababa",
                        "1000",
                        "+251 11 551 7300",
                        "mercato@dbe.com.et",
                        9.0365, 38.7483,
                        "Retail Banking,SME Banking"
                ));

                repository.save(new BankBranch(
                        "DBE Piazza Branch",
                        "Piazza Road",
                        "Addis Ababa",
                        "1000",
                        "+251 11 551 7400",
                        "piazza@dbe.com.et",
                        9.0384, 38.7589,
                        "Retail Banking,Personal Banking"
                ));

                repository.save(new BankBranch(
                        "DBE Megenagna Branch",
                        "Megenagna Square",
                        "Addis Ababa",
                        "1000",
                        "+251 11 551 7500",
                        "megenagna@dbe.com.et",
                        9.0263, 38.7802,
                        "Corporate Banking,International Banking"
                ));

                 repository.save(new BankBranch("DBE Adama Branch", "Batu Road", "Adama", "2000", "+251222111000", "adama@dbe.com.et", 8.5410, 39.2710, "Corporate Banking,SME Banking"));
                repository.save(new BankBranch("DBE Bahir Dar Branch", "Tana Road", "Bahir Dar", "3000", "+251582111000", "bahirdar@dbe.com.et", 11.6000, 37.3833, "Retail Banking,Corporate Banking"));
                repository.save(new BankBranch("DBE Dire Dawa Branch", "Ethio Road", "Dire Dawa", "4000", "+251251111000", "diredawa@dbe.com.et", 9.6000, 41.8667, "Corporate Banking,International Banking"));
                repository.save(new BankBranch("DBE Hawassa Branch", "Hawassa Main Road", "Hawassa", "5000", "+251462111000", "hawassa@dbe.com.et", 7.0620, 38.4770, "Retail Banking,SME Banking"));
                repository.save(new BankBranch("DBE Mekelle Branch", "Mekelle Main Street", "Mekelle", "6000", "+251344111000", "mekelle@dbe.com.et", 13.4960, 39.4750, "Corporate Banking,Personal Banking"));
                repository.save(new BankBranch("DBE Gondar Branch", "Gondar Road", "Gondar", "7000", "+251582211000", "gondar@dbe.com.et", 12.6030, 37.4710, "Retail Banking,SME Banking"));
                repository.save(new BankBranch("DBE Jimma Branch", "Jimma Road", "Jimma", "8000", "+251472111000", "jimma@dbe.com.et", 7.6760, 36.8360, "Corporate Banking,International Banking"));
                repository.save(new BankBranch("DBE Dessie Branch", "Dessie Main Street", "Dessie", "9000", "+251335111000", "dessie@dbe.com.et", 11.1300, 39.6300, "Retail Banking,Corporate Banking"));
                repository.save(new BankBranch("DBE Harar Branch", "Harar Road", "Harar", "9200", "+251255111000", "harar@dbe.com.et", 9.3120, 42.1190, "SME Banking,Personal Banking"));


            }
        };
    }
}
