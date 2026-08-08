# Infernos Dragon Eyes

**Mod id:** `infernos_dragon_eyes`  
**MC / loader:** 1.21.1 NeoForge  
**Depends on:** [Ice and Fire Community Edition](https://modrinth.com/mod/iceandfire-ce) 2.x  

Lore-friendly eyes of ender that point toward nearby **wild, living** dragons. Craft with an ender pearl + dragon blood (fire / ice / lightning).

This is an **Infernos** 1.21.1 port of the Eyes of Ice and Fire CE idea — **new mod id and branding** so it is not confused with (and does not replace) upstream Eyes of Ice and Fire / CE.

## Crafting

| Result | Ingredients |
|--------|-------------|
| Eye of Fire Dragon | Ender Pearl + `iceandfire:fire_dragon_blood` |
| Eye of Ice Dragon | Ender Pearl + `iceandfire:ice_dragon_blood` |
| Eye of Lightning Dragon | Ender Pearl + `iceandfire:lightning_dragon_blood` |

## Build

```bash
# libs/: iceandfire + uranus + jupiter + geckolib (see libs/README.md)
export JAVA_HOME="/c/Program Files/Eclipse Adoptium/jdk-21.0.9.10-hotspot"
./gradlew.bat build
```

Jar: `build/libs/infernos_dragon_eyes-1.21.1-neoforge-1.0.0.jar`

## License

LGPL-3.0 (upstream lineage). Credits: MKuckert (Eye of Dragons), LucianoWayand, Groupix05 (CE fork), Infernos/Imbavirus (1.21.1 NeoForge rebrand/port).
