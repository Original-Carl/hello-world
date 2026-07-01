package com.example.demo.creational.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AbstractFactoryTest {

    @Test
    void fantasyFactory_createCharacter_returnsWizard() {
        GameThemeFactory factory = new FantasyThemeFactory();
        Character c = factory.createCharacter();
        assertThat(c).isInstanceOf(WizardCharacter.class);
        assertThat(c.name()).isEqualTo("Serverack the Wizard");
    }

    @Test
    void sciFiFactory_createCharacter_returnsCyborg() {
        GameThemeFactory factory = new SciFiThemeFactory();
        Character c = factory.createCharacter();
        assertThat(c).isInstanceOf(CyborgCharacter.class);
        assertThat(c.name()).isEqualTo("Unit-6.7 Cyborg");
    }

    @Test
    void modernFactory_createCharacter_returnsDetective() {
        GameThemeFactory factory = new ModernThemeFactory();
        Character c = factory.createCharacter();
        assertThat(c).isInstanceOf(DetectiveCharacter.class);
        assertThat(c.name()).isEqualTo("Detective Morg Filner");
    }

    @Test
    void fantasyFactory_createItem_returnsMagicStaffItem() {
        GameThemeFactory factory = new FantasyThemeFactory();
        Item item = factory.createItem();
        assertThat(item).isInstanceOf(MagicStaffItem.class);
        assertThat(item.name()).isEqualTo("Staff of Quinctus");
    }

    @Test
    void sciFiFactory_createItem_returnsLaserRifle() {
        GameThemeFactory factory = new SciFiThemeFactory();
        Item item = factory.createItem();
        assertThat(item).isInstanceOf(LaserRifleItem.class);
        assertThat(item.name()).isEqualTo("Plasma Rifle MK-IV");
    }

    @Test
    void modernFactory_createItem_returnsSmartPhone() {
        GameThemeFactory factory = new ModernThemeFactory();
        Item item = factory.createItem();
        assertThat(item).isInstanceOf(SmartPhoneItem.class);
        assertThat(item.name()).isEqualTo("Doom Rectangle");
    }

    @Test
    void fantasyFactory_createLocation_returnsEnchantedForest() {
        GameThemeFactory factory = new FantasyThemeFactory();
        Location loc = factory.createLocation();
        assertThat(loc).isInstanceOf(EnchantedForestLocation.class);
        assertThat(loc.name()).isEqualTo("Whispering Woods");
    }

    @Test
    void sciFiFactory_createLocation_returnsSpaceStation() {
        GameThemeFactory factory = new SciFiThemeFactory();
        Location loc = factory.createLocation();
        assertThat(loc).isInstanceOf(SpaceStationLocation.class);
        assertThat(loc.name()).isEqualTo("Orbital Station Alpha");
    }

    @Test
    void modernFactory_createLocation_returnsCityAlley() {
        GameThemeFactory factory = new ModernThemeFactory();
        Location loc = factory.createLocation();
        assertThat(loc).isInstanceOf(CityAlleyLocation.class);
        assertThat(loc.name()).isEqualTo("Downtown Alley");
    }

    @Test
    void fantasyFactory_neverReturnsSciFiProducts() {
        GameThemeFactory factory = new FantasyThemeFactory();
        assertThat(factory.createCharacter()).isNotInstanceOf(CyborgCharacter.class);
        assertThat(factory.createItem()).isNotInstanceOf(LaserRifleItem.class);
        assertThat(factory.createLocation()).isNotInstanceOf(SpaceStationLocation.class);
    }

    @Test
    void swappingFactory_switchesEntireFamily() {
        GameThemeFactory fantasy = new FantasyThemeFactory();
        GameThemeFactory sciFi  = new SciFiThemeFactory();

        assertThat(fantasy.createCharacter().getClass()).isNotEqualTo(sciFi.createCharacter().getClass());
        assertThat(fantasy.createItem().getClass()).isNotEqualTo(sciFi.createItem().getClass());
        assertThat(fantasy.createLocation().getClass()).isNotEqualTo(sciFi.createLocation().getClass());
    }
}
