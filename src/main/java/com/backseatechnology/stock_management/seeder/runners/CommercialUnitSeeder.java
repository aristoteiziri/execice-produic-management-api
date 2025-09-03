package com.backseatechnology.stock_management.seeder.runners;

import com.backseatechnology.stock_management.entity.CommercialUnit;
import com.backseatechnology.stock_management.repository.CommercialUnitRepository;
import com.backseatechnology.stock_management.utils.enums.commercial_unit.CommercialUnitTypeEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CommercialUnitSeeder {
    private final CommercialUnitRepository unitRepository;

    public void seed() {
        if (unitRepository.count() == 0) {
            log.info("Seeding CommercialUnit data...");

            List<CommercialUnit> units = List.of(
                    // Unités de base
                    unit("Pièce", "Unité simple", "pce", CommercialUnitTypeEnum.UNIT),
                    unit("Unité", "Unité simple", "u", CommercialUnitTypeEnum.UNIT),
                    unit("Kilogramme", "Unité de masse", "kg", CommercialUnitTypeEnum.UNIT),
                    unit("Gramme", "Unité de masse", "g", CommercialUnitTypeEnum.UNIT),
                    unit("Litre", "Unité de volume", "L", CommercialUnitTypeEnum.UNIT),
                    unit("Millilitre", "Unité de volume", "mL", CommercialUnitTypeEnum.UNIT),
                    unit("Mètre", "Unité de longueur", "m", CommercialUnitTypeEnum.UNIT),
                    unit("Centimètre", "Unité de longueur", "cm", CommercialUnitTypeEnum.UNIT),
                    unit("Mètre Carré", "Unité de surface", "m²", CommercialUnitTypeEnum.UNIT),
                    unit("Mètre Cube", "Unité de volume", "m³", CommercialUnitTypeEnum.UNIT),
                    unit("Paire", "Ensemble de deux", "paire", CommercialUnitTypeEnum.UNIT),
                    unit("Bouteille", "Contenant de liquide", "bout", CommercialUnitTypeEnum.UNIT),
                    unit("Canette", "Contenant métallique", "can", CommercialUnitTypeEnum.UNIT),
                    unit("Rouleau", "Produit enroulé", "roul", CommercialUnitTypeEnum.UNIT),
                    unit("Sachet", "Petit sac", "sachet", CommercialUnitTypeEnum.UNIT),

                    // Emballages (Packages)
                    pkg("Carton", "Emballage en carton", "carton"),
                    pkg("Boîte", "Emballage rigide", "boîte"),
                    pkg("Pack", "Regroupement de produits", "pack"),
                    pkg("Caisse", "Emballage en bois ou plastique", "caisse"),
                    pkg("Sac", "Emballage souple", "sac"),
                    pkg("Palette", "Support de manutention", "pal"),
                    pkg("Fardeau", "Lot de bouteilles filmé", "fd"),
                    pkg("Barquette", "Contenant plat", "barq"),
                    pkg("Bidon", "Contenant plastique", "bidon"),
                    pkg("Tonnes", "Unité de masse (1000kg)", "t"),

                    // Emballages spécifiques
                    pkg("Pack de 6", "Regroupement de 6 unités"),
                    pkg("Pack de 8", "Regroupement de 8 unités"),
                    pkg("Pack de 12", "Regroupement de 12 unités"),
                    pkg("Pack de 24", "Regroupement de 24 unités"),
                    pkg("Carton de 6", "Carton contenant 6 unités"),
                    pkg("Carton de 10", "Carton contenant 10 unités"),
                    pkg("Carton de 12", "Carton contenant 12 unités"),
                    pkg("Carton de 24", "Carton contenant 24 unités"),
                    pkg("Carton de 36", "Carton contenant 36 unités"),
                    pkg("Carton de 48", "Carton contenant 48 unités"),
                    pkg("Caisse de 12", "Caisse contenant 12 unités"),
                    pkg("Caisse de 24", "Caisse contenant 24 unités"),
                    pkg("Sac de 1kg", "Sac contenant 1kg de produit"),
                    pkg("Sac de 5kg", "Sac contenant 5kg de produit"),
                    pkg("Sac de 10kg", "Sac contenant 10kg de produit"),
                    pkg("Sac de 25kg", "Sac contenant 25kg de produit"),
                    pkg("Sac de 50kg", "Sac contenant 50kg de produit"),
                    pkg("Boîte de 10", "Boîte contenant 10 unités"),
                    pkg("Boîte de 20", "Boîte contenant 20 unités"),
                    pkg("Boîte de 50", "Boîte contenant 50 unités"),
                    pkg("Boîte de 100", "Boîte contenant 100 unités"),
                    pkg("Fardeau de 6", "Fardeau de 6 bouteilles"),
                    pkg("Fardeau de 8", "Fardeau de 8 bouteilles"),
                    pkg("Palette de 20 sacs", "Palette de 20 sacs"),
                    pkg("Palette de 40 cartons", "Palette de 40 cartons"),
                    pkg("Palette de 50 caisses", "Palette de 50 caisses"),

                    // Unités diverses
                    unit("Douzaine", "Ensemble de douze", "dz", CommercialUnitTypeEnum.UNIT),
                    unit("Centaine", "Ensemble de cent", "ct", CommercialUnitTypeEnum.UNIT),
                    unit("Ramette", "Pour le papier", "ram", CommercialUnitTypeEnum.UNIT),
                    unit("Gallon", "Unité de volume", "gal", CommercialUnitTypeEnum.UNIT),
                    unit("Pied", "Unité de longueur", "pi", CommercialUnitTypeEnum.UNIT),
                    unit("Pouce", "Unité de longueur", "po", CommercialUnitTypeEnum.UNIT),
                    unit("Lot", "Ensemble de produits", "lot", CommercialUnitTypeEnum.UNIT),
                    unit("Heure", "Unité de temps/service", "h", CommercialUnitTypeEnum.UNIT),
                    unit("Jour", "Unité de temps/service", "j", CommercialUnitTypeEnum.UNIT),

                    unit("Millimètre", "Unité de longueur", "mm", CommercialUnitTypeEnum.UNIT),
                    unit("Kilomètre", "Unité de longueur", "km", CommercialUnitTypeEnum.UNIT),
                    unit("Pied carré", "Unité de surface", "pi²", CommercialUnitTypeEnum.UNIT),
                    unit("Pied cube", "Unité de volume", "pi³", CommercialUnitTypeEnum.UNIT),
                    unit("Yard", "Unité de longueur", "yd", CommercialUnitTypeEnum.UNIT),
                    unit("Once", "Unité de masse", "oz", CommercialUnitTypeEnum.UNIT),
                    unit("Livre", "Unité de masse", "lb", CommercialUnitTypeEnum.UNIT),
                    unit("Gallon US", "Unité de volume", "gal US", CommercialUnitTypeEnum.UNIT),
                    unit("Baril", "Unité de volume pétrolier", "bl", CommercialUnitTypeEnum.UNIT),
                    unit("Volt", "Unité de tension électrique", "V", CommercialUnitTypeEnum.UNIT),
                    unit("Watt", "Unité de puissance", "W", CommercialUnitTypeEnum.UNIT),
                    unit("Ampère", "Unité de courant électrique", "A", CommercialUnitTypeEnum.UNIT),
                    unit("Ohm", "Unité de résistance électrique", "Ω", CommercialUnitTypeEnum.UNIT),
                    unit("Hertz", "Unité de fréquence", "Hz", CommercialUnitTypeEnum.UNIT),
                    unit("Celsius", "Unité de température", "°C", CommercialUnitTypeEnum.UNIT),
                    unit("Fahrenheit", "Unité de température", "°F", CommercialUnitTypeEnum.UNIT),
                    unit("Kelvin", "Unité de température", "K", CommercialUnitTypeEnum.UNIT),
                    unit("Joule", "Unité d'énergie", "J", CommercialUnitTypeEnum.UNIT),
                    unit("Calorie", "Unité d'énergie thermique", "cal", CommercialUnitTypeEnum.UNIT),
                    unit("Newton", "Unité de force", "N", CommercialUnitTypeEnum.UNIT),
                    unit("Pascal", "Unité de pression", "Pa", CommercialUnitTypeEnum.UNIT),
                    unit("Bit", "Unité de donnée binaire", "bit", CommercialUnitTypeEnum.UNIT),
                    unit("Octet", "Unité de donnée", "o", CommercialUnitTypeEnum.UNIT),
                    unit("Kilooctet", "Unité de stockage numérique", "Ko", CommercialUnitTypeEnum.UNIT),
                    unit("Mégaoctet", "Unité de stockage numérique", "Mo", CommercialUnitTypeEnum.UNIT),
                    unit("Gigaoctet", "Unité de stockage numérique", "Go", CommercialUnitTypeEnum.UNIT),
                    unit("Téraoctet", "Unité de stockage numérique", "To", CommercialUnitTypeEnum.UNIT),
                    unit("Pourcentage", "Proportion pour cent", "%", CommercialUnitTypeEnum.UNIT),
                    unit("Partie par million", "Unité de concentration", "ppm", CommercialUnitTypeEnum.UNIT),

                    // Nouveaux emballages
                    pkg("Pack de 4", "Regroupement de 4 unités"),
                    pkg("Pack de 30", "Regroupement de 30 unités"),
                    pkg("Carton de 4", "Carton contenant 4 unités"),
                    pkg("Carton de 8", "Carton contenant 8 unités"),
                    pkg("Carton de 18", "Carton contenant 18 unités"),
                    pkg("Carton de 30", "Carton contenant 30 unités"),
                    pkg("Caisse de 6", "Caisse contenant 6 unités"),
                    pkg("Caisse de 30", "Caisse contenant 30 unités"),
                    pkg("Caisse de 50", "Caisse contenant 50 unités"),
                    pkg("Fardeau de 12", "Fardeau de 12 bouteilles"),
                    pkg("Palette de 100 cartons", "Palette de 100 cartons"),
                    pkg("Boîte de 200", "Boîte contenant 200 unités"),
                    pkg("Boîte de 500", "Boîte contenant 500 unités"),
                    pkg("Sac de 2kg", "Sac contenant 2kg de produit"),
                    pkg("Sac de 20kg", "Sac contenant 20kg de produit"),
                    pkg("Sac de 40kg", "Sac contenant 40kg de produit"),
                    pkg("Bidon de 5L", "Contenant de 5 litres", "bidon 5L"),
                    pkg("Bidon de 20L", "Contenant de 20 litres", "bidon 20L"),
                    pkg("Bidon de 200L", "Contenant de 200 litres", "bidon 200L"),
                    pkg("Baril de 50L", "Baril de 50 litres", "baril 50L"),
                    pkg("Baril de 100L", "Baril de 100 litres", "baril 100L")
            );

            unitRepository.saveAll(units);
            log.info("✅ {} CommercialUnit data seeded successfully.", units.size());
        } else {
            log.warn("CommercialUnit data already exists. Skipping seeding.");
        }
    }

    // Méthodes utilitaires pour créer les objets plus rapidement
    private CommercialUnit unit(String name, String desc, String abbr, CommercialUnitTypeEnum type) {
        return CommercialUnit.builder().name(name).description(desc).abbreviation(abbr).type(type).build();
    }

    private CommercialUnit pkg(String name, String desc, String abbr) {
        return CommercialUnit.builder().name(name).description(desc).abbreviation(abbr).type(CommercialUnitTypeEnum.PACKAGE).build();
    }
    private CommercialUnit pkg(String name, String desc) {
        return CommercialUnit.builder().name(name).description(desc).abbreviation(null).type(CommercialUnitTypeEnum.PACKAGE).build();
    }
}
