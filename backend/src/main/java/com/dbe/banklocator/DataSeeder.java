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
                // Addis Ababa branches
                repository.save(new BankBranch("DBE Head Office", "Africa Avenue, Kazanchis", "Addis Ababa", "1000", "+251 11 551 7000", "info@dbe.com.et", 9.0227, 38.7469, "Corporate Banking,International Banking,Investment Banking"));
                repository.save(new BankBranch("DBE Bole Branch", "Bole Road", "Addis Ababa", "1000", "+251 11 551 7200", "bole@dbe.com.et", 9.0326, 38.7616, "Retail Banking,Corporate Banking"));
                repository.save(new BankBranch("DBE Mercato Branch", "Mercato Main Road", "Addis Ababa", "1000", "+251 11 551 7300", "mercato@dbe.com.et", 9.0365, 38.7483, "Retail Banking,SME Banking"));
                repository.save(new BankBranch("DBE Piazza Branch", "Piazza Road", "Addis Ababa", "1000", "+251 11 551 7400", "piazza@dbe.com.et", 9.0384, 38.7589, "Retail Banking,Personal Banking"));
                repository.save(new BankBranch("DBE Megenagna Branch", "Megenagna Square", "Addis Ababa", "1000", "+251 11 551 7500", "megenagna@dbe.com.et", 9.0263, 38.7802, "Corporate Banking,International Banking"));
                repository.save(new BankBranch("DBE CMC Branch", "CMC Road", "Addis Ababa", "1000", "+251 11 551 7600", "cmc@dbe.com.et", 9.0450, 38.7700, "Retail Banking,Corporate Banking"));
                repository.save(new BankBranch("DBE Sar Bet Branch", "Sar Bet Area", "Addis Ababa", "1000", "+251 11 551 7700", "sarbet@dbe.com.et", 9.0100, 38.7400, "SME Banking,Personal Banking"));
                repository.save(new BankBranch("DBE Kality Branch", "Kality Industrial Zone", "Addis Ababa", "1000", "+251 11 551 7800", "kality@dbe.com.et", 8.9444, 38.7800, "Corporate Banking,Industrial Banking"));
                repository.save(new BankBranch("DBE Gurd Shola Branch", "Gurd Shola Area", "Addis Ababa", "1000", "+251 11 551 7900", "gurdshola@dbe.com.et", 9.0050, 38.7500, "Retail Banking,Personal Banking"));
                repository.save(new BankBranch("DBE Bole Airport Branch", "Bole International Airport", "Addis Ababa", "1000", "+251 11 551 8000", "airport@dbe.com.et", 9.0056, 38.7678, "International Banking,Foreign Exchange"));
                repository.save(new BankBranch("DBE Adama Branch", "Batu Road", "Adama", "2000", "+251 222 111 000", "adama@dbe.com.et", 8.5410, 39.2710, "Corporate Banking,SME Banking"));
                repository.save(new BankBranch("DBE Adama 2 Branch", "Ethiopia Street", "Adama", "2000", "+251 222 111 001", "adama2@dbe.com.et", 8.5510, 39.2810, "Retail Banking,Personal Banking"));                
                repository.save(new BankBranch("DBE Bahir Dar Branch", "Tana Road", "Bahir Dar", "3000", "+251 582 111 000", "bahirdar@dbe.com.et", 11.6000, 37.3833, "Retail Banking,Corporate Banking"));
                repository.save(new BankBranch("DBE Bahir Dar 2 Branch", "Gondar Road", "Bahir Dar", "3000", "+251 582 111 001", "bahirdar2@dbe.com.et", 11.6100, 37.3933, "SME Banking,Agricultural Banking"));
                repository.save(new BankBranch("DBE Dire Dawa Branch", "Ethio Road", "Dire Dawa", "4000", "+251 251 111 000", "diredawa@dbe.com.et", 9.6000, 41.8667, "Corporate Banking,International Banking"));
                repository.save(new BankBranch("DBE Dire Dawa 2 Branch", "Kebera Meda", "Dire Dawa", "4000", "+251 251 111 001", "diredawa2@dbe.com.et", 9.6100, 41.8767, "Retail Banking,Personal Banking"));              
                repository.save(new BankBranch("DBE Hawassa Branch", "Hawassa Main Road", "Hawassa", "5000", "+251 462 111 000", "hawassa@dbe.com.et", 7.0620, 38.4770, "Retail Banking,SME Banking"));
                repository.save(new BankBranch("DBE Hawassa 2 Branch", "Piazza Area", "Hawassa", "5000", "+251 462 111 001", "hawassa2@dbe.com.et", 7.0720, 38.4870, "Corporate Banking,Investment Banking"));
                
                repository.save(new BankBranch("DBE Mekelle Branch", "Mekelle Main Street", "Mekelle", "6000", "+251 344 111 000", "mekelle@dbe.com.et", 13.4960, 39.4750, "Corporate Banking,Personal Banking"));
                repository.save(new BankBranch("DBE Mekelle 2 Branch", "Adi Haki Area", "Mekelle", "6000", "+251 344 111 001", "mekelle2@dbe.com.et", 13.5060, 39.4850, "SME Banking,Retail Banking"));
                
                repository.save(new BankBranch("DBE Gondar Branch", "Gondar Road", "Gondar", "7000", "+251 582 211 000", "gondar@dbe.com.et", 12.6030, 37.4710, "Retail Banking,SME Banking"));
                repository.save(new BankBranch("DBE Gondar 2 Branch", "Azezo Road", "Gondar", "7000", "+251 582 211 001", "gondar2@dbe.com.et", 12.6130, 37.4810, "Corporate Banking,Historical Tourism Banking"));
                
                repository.save(new BankBranch("DBE Jimma Branch", "Jimma Road", "Jimma", "8000", "+251 472 111 000", "jimma@dbe.com.et", 7.6760, 36.8360, "Corporate Banking,International Banking"));
                repository.save(new BankBranch("DBE Jimma 2 Branch", "Agaro Road", "Jimma", "8000", "+251 472 111 001", "jimma2@dbe.com.et", 7.6860, 36.8460, "Agricultural Banking,Coffee Export Banking"));
                
                repository.save(new BankBranch("DBE Dessie Branch", "Dessie Main Street", "Dessie", "9000", "+251 335 111 000", "dessie@dbe.com.et", 11.1300, 39.6300, "Retail Banking,Corporate Banking"));
                repository.save(new BankBranch("DBE Dessie 2 Branch", "Kombolcha Road", "Dessie", "9000", "+251 335 111 001", "dessie2@dbe.com.et", 11.1400, 39.6400, "SME Banking,Industrial Banking"));
                
                repository.save(new BankBranch("DBE Harar Branch", "Harar Road", "Harar", "9200", "+251 255 111 000", "harar@dbe.com.et", 9.3120, 42.1190, "SME Banking,Personal Banking"));
                repository.save(new BankBranch("DBE Harar 2 Branch", "Jegol Wall Area", "Harar", "9200", "+251 255 111 001", "harar2@dbe.com.et", 9.3220, 42.1290, "Tourism Banking,Cultural Heritage Banking"));
                repository.save(new BankBranch("DBE Awassa Branch", "Lake Awassa Road", "Awassa", "5000", "+251 462 211 000", "awassa@dbe.com.et", 7.0520, 38.4670, "Retail Banking,Fisheries Banking"));
                repository.save(new BankBranch("DBE Arba Minch Branch", "Sawla Road", "Arba Minch", "5100", "+251 468 111 000", "arbaminch@dbe.com.et", 6.0333, 37.5500, "Tourism Banking,Agricultural Banking"));
                repository.save(new BankBranch("DBE Jijiga Branch", "Jijiga Main Road", "Jijiga", "5200", "+251 257 111 000", "jijiga@dbe.com.et", 9.3500, 42.8000, "Cross-border Trade Banking,SME Banking"));
                repository.save(new BankBranch("DBE Shashemene Branch", "Shashemene Main Road", "Shashemene", "5300", "+251 466 111 000", "shashemene@dbe.com.et", 7.2000, 38.6000, "Agricultural Banking,Retail Banking"));
                repository.save(new BankBranch("DBE Nekemte Branch", "Nekemte Main Road", "Nekemte", "5400", "+251 575 111 000", "nekemte@dbe.com.et", 9.0833, 36.5500, "Coffee Banking,Agricultural Banking"));
                repository.save(new BankBranch("DBE Assosa Branch", "Assosa Main Road", "Assosa", "5500", "+251 577 111 000", "assosa@dbe.com.et", 10.0667, 34.5333, "Mining Banking,Cross-border Banking"));
                repository.save(new BankBranch("DBE Gambella Branch", "Gambella Main Road", "Gambella", "5600", "+251 478 111 000", "gambella@dbe.com.et", 8.2500, 34.5833, "Agricultural Banking,Refugee Banking"));
                repository.save(new BankBranch("DBE Semera Branch", "Semera Main Road", "Semera", "5700", "+251 333 111 000", "semera@dbe.com.et", 11.7833, 41.0000, "Infrastructure Banking,Development Banking"));
                repository.save(new BankBranch("DBE Dilla Branch", "Dilla Main Road", "Dilla", "5800", "+251 465 111 000", "dilla@dbe.com.et", 6.4167, 38.3167, "Coffee Banking,Agricultural Banking"));
                repository.save(new BankBranch("DBE Debre Markos Branch", "Debre Markos Main Road", "Debre Markos", "5900", "+251 583 111 000", "debremarkos@dbe.com.et", 10.3333, 37.7333, "Agricultural Banking,SME Banking"));
                repository.save(new BankBranch("DBE Sodo Branch", "Sodo Main Road", "Sodo", "6000", "+251 467 111 000", "sodo@dbe.com.et", 6.9000, 37.7500, "Agricultural Banking,Retail Banking"));
                repository.save(new BankBranch("DBE Wolaita Branch", "Wolaita Main Road", "Wolaita", "6100", "+251 468 211 000", "wolaita@dbe.com.et", 6.8333, 37.7667, "Agricultural Banking,SME Banking"));
                repository.save(new BankBranch("DBE Hosaena Branch", "Hosaena Main Road", "Hosaena", "6200", "+251 469 111 000", "hosaena@dbe.com.et", 7.5500, 37.8500, "Agricultural Banking,Retail Banking"));
                repository.save(new BankBranch("DBE Bishoftu Branch", "Bishoftu Main Road", "Bishoftu", "6300", "+251 111 111 000", "bishoftu@dbe.com.et", 8.7500, 38.9833, "Aviation Banking,Industrial Banking"));
                repository.save(new BankBranch("DBE Debre Birhan Branch", "Debre Birhan Main Road", "Debre Birhan", "6400", "+251 112 111 000", "debrebirhan@dbe.com.et", 9.6833, 39.5333, "Agricultural Banking,SME Banking"));
                repository.save(new BankBranch("DBE Ambo Branch", "Ambo Main Road", "Ambo", "6500", "+251 112 211 000", "ambo@dbe.com.et", 8.9833, 37.8500, "Agricultural Banking,Mineral Water Banking"));
                repository.save(new BankBranch("DBE Adigrat Branch", "Adigrat Main Road", "Adigrat", "6600", "+251 344 211 000", "adigrat@dbe.com.et", 14.2833, 39.4667, "Cross-border Trade Banking,SME Banking"));
                repository.save(new BankBranch("DBE Axum Branch", "Axum Main Road", "Axum", "6700", "+251 344 311 000", "axum@dbe.com.et", 14.1333, 38.7167, "Tourism Banking,Cultural Heritage Banking"));
                repository.save(new BankBranch("DBE Lalibela Branch", "Lalibela Main Road", "Lalibela", "6800", "+251 333 211 000", "lalibela@dbe.com.et", 12.0333, 39.0333, "Tourism Banking,Religious Tourism Banking"));
                repository.save(new BankBranch("DBE Bahir Dar 3 Branch", "Lake Tana Area", "Bahir Dar", "3000", "+251 582 111 002", "bahirdar3@dbe.com.et", 11.6200, 37.4033, "Fisheries Banking,Tourism Banking"));

                System.out.println("Sample data loaded successfully! Total branches: " + repository.count());
            }
        };
    }
}